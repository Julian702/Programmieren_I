package de.dhbwka.java.exercise.ui.editor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class EditorSimple extends JFrame {

    private static String[] fileString = { "Datei", "Neu", "Öffnen", "|", "Schließen", "|", "Speichern",
            "Speichern unter...", "Als Webseite speichern", "Suchen", "|", "Versionen", "|", "Webseitenvorschau", "|",
            "Seite einrichten...", "Seitenansicht", "Drucken", "|", "send", "Eigenschaften", "|", "bilanz_2017.doc",
            "bericht_2018_01.doc", "ziele.doc", "|", "Beenden" };

    private String[] editString = { "Bearbeiten", "Rückgängig", "Wiederholen", "|", "Asschneiden", "Kopieren",
            "Office-Zwischenablage", "Einfügen", "Inhalte einfügen", "Als Hyperlink einfügen", "|", "Löschen",
            "Alles markieren", "Suchen...", "Ersetzen...", "Gehe zu...", "|", "Verknüpfungen", "Objekt" };

    private String[] sendString = { "Senden an", "E-Mail-Empfänger", "E-Mail-Empfänger (zur Überarbeitung)",
            "E-Mail-Empfänger (als Anlage)", "|", "Verteilerempfänger...", "Onlinebsprechungsteilnehmer",
            "Exchange-Ordner...", "Fax-Empfänger...", "|", "Microsoft PowerPoint" };

    private JMenuBar mb = new JMenuBar();
    private JMenu fileMenu = createMenu(fileString);
    private JMenu editMenu = createMenu(editString);

    public static void main(String[] args) {
        new EditorSimple(500, 500).setVisible(true);
    }

    public EditorSimple(int width, int height) {
        super("Editor");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(mb);
        mb.add(fileMenu);
        mb.add(editMenu);
    }

    private JMenu createMenu(String[] arr) {
        JMenu menu = new JMenu(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            switch (arr[i]) {
                case "|":
                    menu.add(new JSeparator());
                    break;
                case "send":
                    menu.add(createMenu(sendString));
                    break;
                default:
                    menu.add(createMenuItem(arr[i]));
                    break;
            }
        }
        return menu;
    }

    private JMenuItem createMenuItem(String s) {
        JMenuItem item = new JMenuItem(s);
        //item.addActionListener(Editor::actionPerformed);
        return item;
    }
}
