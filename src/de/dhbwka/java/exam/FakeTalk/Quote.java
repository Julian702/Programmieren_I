package de.dhbwka.java.exam.FakeTalk;

public class Quote {
    
    private final String text;
    private final String person;
    private final String role;
    private final String source;
    private final QuoteType quoteType;

    public Quote(String text, String person, String role, String source, QuoteType quoteType){
        this.text = text;
        this.person = person;
        this.role = role;
        this.source = source;
        this.quoteType = quoteType;
    }

    public String getCitation(){
        return String.format("From: %s (%s, %s)", this.getPerson(), this.getRole(), this.getSource());
    }

    public String getText() {
        return this.text;
    }
    public String getPerson() {
        return this.person;
    }
    public String getRole() {
        return this.role;
    }
    public String getSource() {
        return this.source;
    }
    public QuoteType getQuoteType() {
        return this.quoteType;
    }

}
