package de.dhbwka.java.exam.SoederMemory;

import java.util.List;

import javax.swing.JLabel;

public class PlayerLabel extends JLabel{
    
    private Player player;

    public PlayerLabel(Player p){
        super(p.getName());
        this.player = p;
    }

    public void updatePlayerLabel(){
        this.setText(player.getName() + "(" + player.getPoints() + ")");
        this.setForeground(player.getPlayerStatus().getColor());
    }
    public static void updatedAllPlayerLabel(List<PlayerLabel> l){
        for (PlayerLabel pl : l) {
            pl.updatePlayerLabel();
        }
    }
}
