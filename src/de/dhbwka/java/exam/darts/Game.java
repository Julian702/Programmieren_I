package de.dhbwka.java.exam.darts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private Player[] player;
    private List<String> checkouts;

    public Game(Board board, Player[] player) {
        this.board = board;
        this.player = player;
        this.checkouts = this.loadCheckouts();
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        for (int r = 0; r < 10; r++) {
            for (Player p : player) {
                int remaining = p.getRemainingPoints();
                System.out.println(p + (remaining <= 170 && checkouts.get(remaining-1) != "-" ? " Possible ckeckout: " + checkouts.get(remaining-1) : " No checkout possible."));
                System.out.print("Enter visit: ");
                String s = scan.nextLine();
                String[] v = s.split(" ");
                Field[] fields = new Field[v.length];
                for (int i = 0; i < v.length; i++) {
                    fields[i] = board.parseField(v[i]);
                }
                Visit visit = new Visit(fields);
                p.addVisit(visit);
                System.out.printf("Scored: %d \n", visit.getValue());
                System.out.println("================================");
                if (p.getRemainingPoints() == 0) {
                    System.out.printf("Game shot and the leg, %s!", p.getName());
                    this.saveScore(p);
                    return;
                } else if (player[0].getVisitsLength() == 10 && player[1].getVisitsLength() == 10) {
                    System.out.println("You are too bad for this game!");
                    return;
                }
            }
        }
    }

    public void saveScore(Player p) {
        Path path = Paths.get("src/de/dhbwka/java/exam/darts/highscore.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.writeString(path, p.getName() + " won with " + p.getCountDartsThrown() + " darts.\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private List<String> loadCheckouts() {
        List<String> checkouts = new LinkedList<>();
        Path path = Paths.get("src/de/dhbwka/java/exam/darts/checkouts.txt");
		try {
			if(Files.exists(path)){
				checkouts = Files.readAllLines(path);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return checkouts;
    }
}
