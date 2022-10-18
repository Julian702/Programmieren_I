package de.dhbwka.java.exam.FakeTalk;

import javax.swing.JButton;

public class QuoteButton extends JButton{
    
    private QuoteType quoteType;

    public QuoteButton(){
        this.quoteType = QuoteType.UNKNOWN;
        update(this);
    }

    public QuoteType getQuoteType() {
        return this.quoteType;
    }
    public void setQuoteType(QuoteType quoteType) {
        this.quoteType = quoteType;
        update(this);
    }

    public static void update(QuoteButton btn){
        btn.setBackground(btn.getQuoteType().getColor());
        btn.setIcon(btn.getQuoteType().getIcon());
    }

    public boolean isUnknown(){
        return this.getQuoteType() == QuoteType.UNKNOWN;
    }

}
