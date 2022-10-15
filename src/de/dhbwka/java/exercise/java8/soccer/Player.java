package de.dhbwka.java.exercise.java8.soccer;

public class Player {
    
    private int trikotnummer; 
    private String name;
    private String position;
    private String birthday;
    private String club;
    private int games;
    private int goals;

    Player(int trikotnummer, String name, String position, String birthday, String club, int games, int goals){
        this.trikotnummer = trikotnummer;
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.club = club;
        this.games = games;
        this.goals = goals;
    }

    public int getTrikotnummer() {
        return trikotnummer;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getClub() {
        return club;
    }
    public int getGames() {
        return games;
    }
    public int getGoals() {
        return goals;
    }

    @Override
    public String toString() {
        return String.format("%2d | %s, %s, %s, %s, %d games, %d goals", this.getTrikotnummer(), this.getName(), this.getPosition(), this.getBirthday(), this.getClub(), this.getGames(), this.getGoals());
    }
}
