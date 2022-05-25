package de.dhbwka.java.exercise.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextFrame extends JFrame {

    public static void main(String[] args) {

        File myFile = new File("src/de/dhbwka/java/exercise/ui/myfile.txt");

        TextFrame textFrame = new TextFrame(myFile, 250, 500);
        textFrame.setVisible(true);
    }

    public TextFrame(File file, int width, int height){
        
        super(file.getName());
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea(readFile(file));

        JScrollPane scrollPane = new JScrollPane (textArea, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
    }

    private static String readFile(File file){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            while(br.ready()){
                sb.append(br.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }
}