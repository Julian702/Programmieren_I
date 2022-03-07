package de.dhbwka.java.exercise.classes.periodic;

public class Element {
    private String name; 
    private String symbol;
    private int ordinal;
    private char shell;
    private int phase;
    private boolean main;

    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean main){
        setName(name);
        setSymbol(symbol);
        setOrdinal(ordinal);
        setShell(shell);
        setPhase(phase);
        setMain(main);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
    public int getOrdinal() {
        return ordinal;
    }
    public void setShell(char shell) {
        this.shell = shell;
    }
    public char getShell() {
        return shell;
    }
    public void setPhase(int phase) {
        this.phase = phase;
    }
    public int getPhase() {
        return phase;
    }
    public void setMain(boolean main) {
        this.main = main;
    }
    public boolean getMain(){
        return main;
    }
    @Override
    public String toString() {
        return String.format("%s (%s, %d) Shell: %c, %s, %s", getName(), getSymbol(), getOrdinal(), getShell(), getPhase() == 1 ? "Solid" : getPhase() == 2 ? "Liquid" : getPhase() == 3 ? "Gas" : "Fehler", getMain() ? "Maingroup" : "Sidegroup");
    }
    public boolean equals(Element e) {
        return getOrdinal() == e.getOrdinal() ? true : false;
    }
}
