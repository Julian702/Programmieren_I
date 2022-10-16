package de.dhbwka.java.exam.coronaWarn;

import java.util.Date;
import java.util.UUID;

public class Token {
    
    private String value;
    private Date date;

    public Token(){
        this.value = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public Token(String value, Date date){
        this.value = value;
        this.date = date;
    }

    public String getValue() {
        return value;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s @ %s", value, date.toString());
    }

}
