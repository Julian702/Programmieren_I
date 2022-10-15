package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Soccer {

    private List<Player> kader;

    public static void main(String[] args) {
        Soccer sc = new Soccer();
        sc.loadPlayer();
        System.out.println("Players sorted by number:");
        sc.getPlayer().stream().sorted((a, b) -> Soccer.comparePlayerByNumber(a, b)).forEach(p -> System.out.println(p));
        System.out.println("---");
        System.out.println("Players with more than 50 games, sorted by name:");
        sc.getPlayer().stream().filter(p -> p.getGames() > 50).sorted((a, b) -> Soccer.comparePlayerByName(a, b)).forEach(p -> System.out.println(p));
        System.out.println("---");
        System.out.println("All clubs of the players:");
        sc.getPlayer().stream().map(Player::getClub).distinct().forEach(s -> System.out.println(s));
        System.out.println("---");
        System.out.printf("Count of players with less than 5 goals: %d\n", sc.getPlayer().stream().filter(p -> p.getGoals() < 5).count());
        System.out.printf("Count of goals of all players: %d\n", sc.getPlayer().stream().map(p -> p.getGoals()).mapToInt(Integer::intValue).sum());

    }

    private List<Player> getPlayer(){
        return kader;
    }

    private void loadPlayer() {
        try {
            this.kader = Files.readAllLines(Paths.get("src/de/dhbwka/java/exercise/java8/soccer/kader.txt"))
                    .stream()
                    .map(this::parsePlayer)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Player parsePlayer(String line) {
        String[] p = line.split(";");
        if(p.length == 7){
            return new Player(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4], Integer.parseInt(p[5]),
                Integer.parseInt(p[6]));
        } else {
            System.out.println("error");
            return null;
        }
    }

    private static int comparePlayerByNumber(Player p1, Player p2){
        return p1.getTrikotnummer() - p2.getTrikotnummer();
    }

    private static int comparePlayerByName(Player p1, Player p2){
        return p1.getName().compareTo(p2.getName());
    }
}
