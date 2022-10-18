package de.dhbwka.java.exam.FakeTalk;

import java.awt.Color;

import javax.swing.ImageIcon;

public enum QuoteType {
    UNKNOWN("Unknown", FakeTalkIcons.ICON_UNKNOWN, Color.LIGHT_GRAY),
    HOT_SHIT("Hot shit", FakeTalkIcons.ICON_HOT_SHIT, Color.GREEN),
    BULLSHIT("Bullshit", FakeTalkIcons.ICON_BULLSHIT, new Color(74, 65, 42));
    
    private final String label;
    private final ImageIcon icon;
    private final Color color;

    private QuoteType(String label, ImageIcon icon, Color color){
        this.label = label;
        this.icon = icon;
        this.color = color;
    }

    public String getLabel() {
        return this.label;
    }
    public ImageIcon getIcon() {
        return this.icon;
    }
    public Color getColor() {
        return this.color;
    }
}