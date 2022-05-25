package de.dhbwka.java.exercise.ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class TextfileViewer {

    public static void main(String[] args) {
        new TextfileViewer(300, 600);
    }

    public TextfileViewer(int width, int height){
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\Julian\\Documents\\Studium\\DHBW\\Semester_II\\Programmieren\\Programmieren_I\\src\\de\\dhbwka\\java\\exercise\\ui");
        fileChooser.setFileFilter(new FileFilter() {
           @Override
           public boolean accept(File f) {
               return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt") || f.getName().toLowerCase().endsWith(".java");
           }
           @Override
               public String getDescription() {
                   return "Text and Java Files";
               }
        });
        int choice = fileChooser.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            TextFrame textFrame = new TextFrame(file, width, height);
            textFrame.setVisible(true);
        }
    }
}