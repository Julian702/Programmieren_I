package de.dhbwka.java.exam.darts;

public class Board {
    
    private Field[] board = new Field[63];

    public Board(){
        int n = 0;
        for (int i = 1; i <= 20; i++) {
            board[n++] = new Field("" + i, i, false);
            board[n++] = new Field("D" + i, 2*i, true);
            board[n++] = new Field("T" + i, 3*i, false);
        }
        board[n++] = new Field("Single Bull", 25, false);
        board[n++] = new Field("BULL", 50, true);
        board[n++] = new Field("x", 0, false);
    }

    public Field[] getBoard() {
        return board;
    }

    public Field parseField(String label){
        for (int i = 0; i < getBoard().length; i++) {
            if(label.equalsIgnoreCase(getBoard()[i].getLabel())){
                return getBoard()[i];
            }
        }
        return null;
    }
}
