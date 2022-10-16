package de.dhbwka.java.exam.darts;

public class Visit {

    private Field[] fields;

    public Visit(Field[] fields){
        if(fields.length <= 3){
            this.fields = fields;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public Field[] getFields(){
        return fields;
    }
    public int getValue(){
        int sum = 0;
        for (int i = 0; i < fields.length; i++) {
            sum += fields[i].getValue();
        }
        return sum;
    }
    public Field getLastField(){
        return fields[fields.length -1];
    }
}
