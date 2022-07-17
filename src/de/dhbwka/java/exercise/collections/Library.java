package de.dhbwka.java.exercise.collections;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Library {

    private static final String[] orderCriteria = { "Title", "Author", "Year", "Publisher" };
    private JFrame frame;
    private File file = new File("src/de/dhbwka/java/exercise/collections/myBooks.txt");
    private JTextField[] inputFields;
    private List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        new Library();
    }

    public Library() {

        this.loadBooks();

        this.frame = new JFrame("Library");
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(500, 190);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));
        this.inputFields = new JTextField[Library.orderCriteria.length];
        for (int i = 0; i < inputFields.length; i++) {
            inputPanel.add(new JLabel(Library.orderCriteria[i]));
            this.inputFields[i] = new JTextField("");
            inputPanel.add(this.inputFields[i]);
        }
        this.frame.add(inputPanel, BorderLayout.NORTH);

        JButton saveBtn = new JButton("Save entry");
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Library.this.saveBook(Library.this.inputFields[0].getText(), Library.this.inputFields[1].getText(),
                        Integer.parseInt(Library.this.inputFields[2].getText()), Library.this.inputFields[3].getText());
                for (JTextField field : Library.this.inputFields) {
                    field.setText("");
                }
            }
        });
        this.frame.add(saveBtn, BorderLayout.CENTER);

        JPanel sortPanel = new JPanel(new FlowLayout());
        sortPanel.add(new JLabel("Ordered output:"));

        for (int i = 0; i < Library.orderCriteria.length; i++) {
            JButton btn = new JButton(Library.orderCriteria[i]);

            btn.setActionCommand(Integer.toString(Book.CRITERIA[i]));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Library.this.sort(Integer.parseInt(e.getActionCommand()));
                }

            });
            sortPanel.add(btn);
        }
        this.frame.add(sortPanel, BorderLayout.SOUTH);

        this.frame.setVisible(true);
    }

    public void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.file));) {
            while (br.ready()) {
                String[] parts = br.readLine().split(";");
                System.out.println(parts[0]);
                if (parts.length == 4) {
                    this.books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                }
            }
        } catch (Exception ex) {
            System.err.println("Read error: " + ex.getLocalizedMessage());
        }
        System.out.println(this.books);
    }

    public void saveBook(String title, String author, int year, String publisher) {
        Book book = new Book(title, author, year, publisher);
        this.books.add(book);
        try (PrintWriter pw = new PrintWriter(new FileWriter(this.file, true));) {
            pw.println(book);
        } catch (Exception ex) {
            System.err.println("Write error: " + ex.getLocalizedMessage());
        }
    }

    public void sort(int order) {
        Collections.sort(this.books, new BookComparator(order));
        JOptionPane.showMessageDialog(this.frame, this, "Books ordered by " + Library.orderCriteria[order],
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer("");
        for (Book book : this.books) {
            output.append(book + System.lineSeparator());
        }
        return output.toString();
    }
}
