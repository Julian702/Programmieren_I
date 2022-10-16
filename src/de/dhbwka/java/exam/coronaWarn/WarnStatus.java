package de.dhbwka.java.exam.coronaWarn;

import java.awt.Color;

public enum WarnStatus {
    UNKNOWN("Unknnown", new Color(175, 175, 175)),
    OK("ok", new Color(100, 200, 100)), 
    ALARM("Possible encounter", new Color(255,  100, 100)),
    INFECTED("In quarantine", new Color(150, 150, 255));

    private String text;
    private Color color;

    WarnStatus(String text, Color color){
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }
    public Color getColor() {
        return color;
    }
}
