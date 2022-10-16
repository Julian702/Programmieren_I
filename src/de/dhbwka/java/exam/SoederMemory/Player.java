package de.dhbwka.java.exam.SoederMemory;

public class Player {
    
    private String name;
    private int points;
    private PlayerStatus playerStatus;

    public Player(String name){
        this.name = name;
        this.points = 0;
        this.playerStatus = PlayerStatus.WAITING;
    }

    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public void addPoint(){
        this.points++;
    }
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
    @Override
    public String toString() {
        return String.format("%s (%d)", this.getName(), this.getPoints());
    }
}
