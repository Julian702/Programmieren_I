package de.dhbwka.java.exercise.io.textfile;

import java.io.*;

public class TextFile {
    
    File myFile;
    String[] s;

    public static void main(String[] args) {
        TextFile tf;
        try {
            tf = new TextFile(new File("src/de/dhbwka/java/exercise/io/textfile/bla.txt"));
            tf.replaceAll("meine", "unsre");
            tf.setLine(1, "Alle deine Entchen");
            tf.write();
            System.out.println(tf.getLine(1));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (LineNumberOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public TextFile(File f) throws FileNotFoundException{
        myFile = f;
        read();
    }
    public TextFile(String filename) throws FileNotFoundException{
        this(new File(filename));
    }
    public void read() throws FileNotFoundException{
        int n = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
            while(br.readLine() != null){
                n++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        s = new String[n];
        try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
            for (int i = 0; i < s.length; i++) {
                s[i] = br.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void write(){
        if(s != null){
            try (PrintWriter pWriter = new PrintWriter(new FileWriter(myFile))) {
                for (int i = 0; i < s.length; i++) {
                    pWriter.println(s[i]);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public int availableLines(){
        if(s != null){
            return s.length;
        }else{
            return -1;
        }   
    }
    public String[] getLines(){
        return s;
    }
    public String getLine(int i) throws LineNumberOutOfBoundsException{
        if(s == null)
            return null;
        if(i > 0 && i <= s.length){
            return s[i-1]; 
        }else{
            throw new LineNumberOutOfBoundsException();
        }        
    }
    public void setLine(int i, String l) throws LineNumberOutOfBoundsException{
        if(s != null && i > 0 && i <= s.length){
            s[i-1] = l; 
        }else{
            throw new LineNumberOutOfBoundsException();
        } 
    }
    public void replaceAll(String regexp, String ersatz){
        if(s != null && regexp != null && ersatz != null){
            for (int i = 0; i < s.length; i++) {
                s[i] = s[i].replaceAll(regexp, ersatz);
            }
        }
    }
    public void close(){
        s = null;
        this.myFile = null;
    }
}
