package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;

public class FileExperiments {

    public static void main(String[] args) {
        File myDir = new File("myDir");
        myDir.mkdir();
        File[] f = new File[3];
        for (int i = 0; i < f.length; i++) {
            f[i] = new File(myDir, "foo" + i);
            try {
                f[i].createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(f[i].getAbsolutePath());
            f[i].delete();
        }
        myDir.delete();
    }
}
