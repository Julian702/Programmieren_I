package de.dhbwka.java.exam.SoederMemory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import de.dhbwka.java.exam.SoederMemory.MemoryImages.MemoryImage;

public class MemoryGameTerm extends JFrame {

    private MemoryGame memoryGame;
    private int rounds;

    private final List<PlayerLabel> playerLabels = new LinkedList<>();
    private final List<JToggleButton> memoryCards = new LinkedList<>();

    public MemoryGameTerm(MemoryGame memoryGame) {

        super("Soeder Memory");

        this.memoryGame = memoryGame;

        this.initUI();

        this.setVisible(true);

        this.startDurationThread();
    }

    private void initUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        // create playerPanel
        JPanel playerPanel = new JPanel(new GridLayout(this.memoryGame.getPlayers().size(), 1));
        for (final Player p : this.memoryGame.getPlayers()) {
            final PlayerLabel playerLabel = new PlayerLabel(p);
            this.playerLabels.add(playerLabel);
            playerPanel.add(playerLabel);
        }
        PlayerLabel.updatedAllPlayerLabel(playerLabels);
        this.add(playerPanel, BorderLayout.NORTH);

        // create gamePanel
        final JPanel memoryPanel = new JPanel(new GridLayout(memoryGame.getRows(), memoryGame.getCols()));
        for (final MemoryImage memoryImage : this.memoryGame.getImages()) {
            memoryCards.add(createMemoryCard(memoryImage.getImage()));
            memoryCards.add(createMemoryCard(memoryImage.getImage()));
        }
        if (memoryGame.isBlankRequired())
            memoryCards.add(new JToggleButton(MemoryImages.getBlank()));
        Collections.shuffle(memoryCards);
        for (JToggleButton memoryCard : memoryCards) {
            memoryPanel.add(memoryCard);
        }
        this.add(memoryPanel, BorderLayout.CENTER);

        this.pack();
    }

    public JToggleButton createMemoryCard(ImageIcon memoryImage) {
        JToggleButton memoryCard = new JToggleButton();
        memoryCard.setIcon(MemoryImages.getBackside());
        memoryCard.setSelectedIcon(memoryImage);
        memoryCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final List<JToggleButton> selectedMemoryCards = MemoryGameTerm.this.getSelectedButtons();
                if (selectedMemoryCards.size() == 2) {
                    MemoryGameTerm.this.rounds++;
                    if (MemoryGameTerm.this.isPair(selectedMemoryCards)) {
                        MemoryGameTerm.this.handlePair(selectedMemoryCards);
                    } else {
                        MemoryGameTerm.this.handleNonPair(selectedMemoryCards);
                    }
                }
            }
        });
        return memoryCard;
    }

    private List<JToggleButton> getSelectedButtons() {
        List<JToggleButton> selectedButtons = new LinkedList<>();
        for (JToggleButton memoryCard : this.memoryCards) {
            if (memoryCard.isEnabled() && memoryCard.isSelected())
                selectedButtons.add(memoryCard);
        }
        return selectedButtons;
    }

    private boolean isPair(List<JToggleButton> selectedMemoryCards) {
        if (selectedMemoryCards == null || selectedMemoryCards.isEmpty() || selectedMemoryCards.size() != 2) {
            return false;
        }
        return selectedMemoryCards.get(0).getSelectedIcon() == selectedMemoryCards.get(1).getSelectedIcon();
    }

    private void handlePair(List<JToggleButton> selectedMemoryCards) {
        memoryGame.getCurrentPlayer().addPoint();
        for (JToggleButton memoryCard : selectedMemoryCards) {
            memoryCard.setEnabled(false);
        }
        if (this.isGameFinished()) {
            for (Player player : memoryGame.getPlayers()) {
                player.setPlayerStatus(PlayerStatus.FINISHED);
            }
            PlayerLabel.updatedAllPlayerLabel(playerLabels);
            Collections.sort(this.memoryGame.getPlayers(), new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    return Integer.compare(p2.getPoints(), p1.getPoints());
                }
            });
            final List<String> playerStrings = new LinkedList<>();
            for (final Player player : memoryGame.getPlayers()) {
                playerStrings.add(player.toString());
            }
            final String message = "Game ends after " + Integer.toString(this.rounds) + " rounds, scores: " + String.join(", ", playerStrings) + "\n";

            Path path = Paths.get("src/de/dhbwka/java/exam/SoederMemory/memory.txt");
            List<String> lastGames = new LinkedList<>();
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                lastGames = Files.readAllLines(path);
                Files.writeString(path, message, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, message + "\nLast Games:\n" + String.join("\n", lastGames), "Scores",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        PlayerLabel.updatedAllPlayerLabel(playerLabels);
    }

    private void handleNonPair(List<JToggleButton> selectedMemoryCards) {
        JOptionPane.showMessageDialog(this, "Sorry, those don't match", "Wrong", JOptionPane.ERROR_MESSAGE);
        for (JToggleButton memoryCard : selectedMemoryCards) {
            memoryCard.setSelected(false);
        }
        memoryGame.nextPlayer();
        PlayerLabel.updatedAllPlayerLabel(playerLabels);
    }

    private boolean isGameFinished() {
        int cards = 0;
        for (final JToggleButton memoryCard : this.memoryCards) {
            if (memoryCard.isEnabled()) {
                cards++;
            }
        }
        return cards <= 1;
    }

    private void startDurationThread() {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                int duration = 0;
                while (!MemoryGameTerm.this.isGameFinished()) {
                    MemoryGameTerm.this.setTitle("Soeder Memory (" + duration++ + ")");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r, "DurationThread").start();
    }
}
