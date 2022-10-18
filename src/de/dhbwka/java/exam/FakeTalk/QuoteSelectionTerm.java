package de.dhbwka.java.exam.FakeTalk;

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
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuoteSelectionTerm extends JFrame {

    private final List<Quote> quotes;
    private List<QuoteButton> quoteButtons = new LinkedList<>();
    private QuoteButton currQuoteButton;

    private List<FakeTalkClient> clients = new LinkedList<>();
    private FakeTalkClient currentClient;

    private final int rows;
    private final int cols;
    private boolean gameStarted = false;
    private boolean timer = false;
    private int points;

    private final JLabel headerLabel = new JLabel("Pick a quote:");
    private final JLabel footerLabel = new JLabel("X Points");

    public QuoteSelectionTerm(List<Quote> quotes, int rows, int cols) throws FakeNewsException {

        super("FakeTalk");

        if (rows * cols > quotes.size()) {
            throw new FakeNewsException("Provided quote catalog does not contain enough (hot|bull)shit!");
        }
        Collections.shuffle(quotes);
        this.quotes = quotes.subList(0, rows * cols);
        this.rows = rows;
        this.cols = cols;

        this.initUI();

        this.setVisible(true);
    }

    private void initUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        this.add(headerLabel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(this.rows, this.cols, 5, 5));
        for (Quote q : this.quotes) {
            QuoteButton btn = new QuoteButton();
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    QuoteSelectionTerm.this.currQuoteButton = btn;
                    QuoteSelectionTerm.this.getCurrentClient().setQuote(q);
                    for (QuoteButton btn : quoteButtons) {
                        btn.setEnabled(false);
                    }
                    QuoteSelectionTerm.this.timer = true;
                    QuoteSelectionTerm.this.pointCountdownThread();
                }
            });
            this.quoteButtons.add(btn);
            gridPanel.add(btn);
        }
        this.add(gridPanel, BorderLayout.CENTER);

        this.add(footerLabel, BorderLayout.SOUTH);

        this.pack();
    }

    public void register(FakeTalkClient client) throws FakeNewsException {
        if (!this.gameStarted) {
            this.clients.add(client);
        } else {
            throw new FakeNewsException("Game already started!");
        }
    }

    public void start() throws FakeNewsException {
        if (!this.gameStarted) {
            if (this.clients.size() < 2) {
                throw new FakeNewsException("Two players needed!");
            }
            this.gameStarted = true;
            this.nextPlayer();
        }
    }

    public void answerSelected(FakeTalkClient client, Quote q, QuoteType selectedQuoteType) {

        this.timer = false;
        if (q.getQuoteType() == selectedQuoteType) {
            client.addPoints(this.points);
        } else {
            client.addPoints(this.points * (-1));
        }

        this.currQuoteButton.setQuoteType(q.getQuoteType());

        String message = String.format("This quote is %s! \n%s", q.getQuoteType().getLabel(), q.getCitation());
        JOptionPane.showMessageDialog(this, message, "Meldung", JOptionPane.INFORMATION_MESSAGE);
        
        boolean gameFinished = true;
        for (QuoteButton btn : quoteButtons) {
            if (btn.getQuoteType() == QuoteType.UNKNOWN) {
                btn.setEnabled(true);
                gameFinished = false;
            }
        }

        String msg = "Game finished. Score:";
        for (FakeTalkClient cl : clients) {
            msg = msg + String.format(" %s (%s)", cl.getPlayerName(), cl.getPlayerName());
        }
        if (gameFinished) {
            JOptionPane.showMessageDialog(this, msg, "Game finished!", JOptionPane.INFORMATION_MESSAGE);
            Path path = Paths.get("src/de/dhbwka/java/exam/FakeTalk/fake-score.txt");
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                Files.writeString(path, msg+"\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.nextPlayer();
    }

    public void nextPlayer() {
        this.points = 10;
        int i = this.getClients().indexOf(this.getCurrentClient());
        i = ++i % this.getClients().size();
        this.setCurrentClient(this.getClients().get(i));
        this.updateUI();
    }

    private void updateUI() {
        headerLabel.setText("Pick a quote: " + this.getCurrentClient().getPlayerName());
        footerLabel.setText(points + " Points");
    }

    public List<FakeTalkClient> getClients() {
        return clients;
    }

    public FakeTalkClient getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(FakeTalkClient currentClient) {
        this.currentClient = currentClient;
    }

    private void pointCountdownThread() {
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                while (points>1 && QuoteSelectionTerm.this.timer) {
                    try {
                        Thread.sleep(2000);
                        QuoteSelectionTerm.this.footerLabel.setText(--points + " Points");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r, "CountdownThread").start();
    }
}