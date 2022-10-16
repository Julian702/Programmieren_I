package de.dhbwka.java.exam.darts;

public class Player {
    
    private String name;
    private int countDartsThrown;
    private Visit[] visits = new Visit[10];

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getCountDartsThrown() {
        return countDartsThrown;
    }
    public Visit[] getVisits() {
        return visits;
    }
    public int getVisitsLength(){
        int n = 0;
        for (int i = 0; i < visits.length; i++) {
            if(visits[i] != null){
                n++;
            }
        }
        return n;
    }

    public int getRemainingPoints(){
        int p = 501;
        for(Visit v: visits){
            if(v != null){
                p -= v.getValue();
            }
        }
        return p;
    }
    public boolean addVisit(Visit visit){
        countDartsThrown += visit.getFields().length;
        int remaining = getRemainingPoints();
        int value = visit.getValue();
        if(remaining < value || remaining-value == 1){
            return false;
        }
        if(value == remaining && !visit.getLastField().isDoubleField()){
            return false;
        }
        visits[getVisitsLength()] = visit;
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Player: %s, %d points remaining.", getName(), getRemainingPoints());
    }
}
