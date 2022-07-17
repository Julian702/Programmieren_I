package de.dhbwka.java.exercise.collections;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class Book {

    public static final int TITLE = 0;
    public static final int AUTHOR = 1;
    public static final int YEAR = 2;
    public static final int PUBLISHER = 3;
    public static final int[] CRITERIA = { Book.TITLE, Book.AUTHOR, Book.YEAR, Book.PUBLISHER };
    private String title;
    private String author;
    private int year;
    private String publisher;

    public Book(String title, String author, int year, String publisher) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", this.getTitle(), this.getAuthor(),
                this.getYear(), this.getPublisher());
    }

    public void saveBook(File file) {
        try (Writer fWriter = new FileWriter(file, StandardCharsets.UTF_8, true)) {
            fWriter.write(this.toString());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
