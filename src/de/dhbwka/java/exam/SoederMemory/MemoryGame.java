package de.dhbwka.java.exam.SoederMemory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.dhbwka.java.exam.SoederMemory.MemoryImages.MemoryImage;

public class MemoryGame {
    
    private final int rows;
    private final int cols;

    private List<MemoryImage> images = new LinkedList<>();
    private List<Player> players = new LinkedList<>(); 

    private Player currentPlayer;

    public MemoryGame(List<Player> players, List<MemoryImage> images, int rows, int cols) throws MemoryException{
        
        if(players == null || players.size() < 2) {
            throw new MemoryException("At least two players required");
        } 
        this.players = players;
        this.nextPlayer();
        
        int requireedPairs = rows*cols/2;
        if(requireedPairs > images.size()){
            throw new MemoryException("Too few Images available");
        }
        Collections.shuffle(images);
        this.images = images.subList(0, requireedPairs);

        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public int getGameSize(){
        return getRows()*getCols();
    }
    public List<MemoryImage> getImages() {
        return images;
    }
    public boolean isBlankRequired(){
        return rows*cols % 2 == 1;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.currentPlayer.setPlayerStatus(PlayerStatus.ACTIVE);
    }
    public void nextPlayer(){
        int i = this.getPlayers().indexOf(this.getCurrentPlayer());
        i = ++i % this.getPlayers().size();
        for (Player player : this.getPlayers()) {
            player.setPlayerStatus(PlayerStatus.WAITING);
        }
        this.setCurrentPlayer(this.getPlayers().get(i));
    }
}
