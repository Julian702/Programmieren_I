package de.dhbwka.java.exercise.ui.editor;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;

public class Editor extends JFrame{

	private File file;

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
    private JMenuItem saveMenuItem;

    protected JTextPane editPane = new JTextPane();
    private JScrollPane scrollPane = new JScrollPane(editPane,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public static void main(String[] args) {
		new Editor().setVisible(true);
	}

	public Editor(){
		this(640, 480);
	}

	public Editor(int width, int height) {
		super("Editor");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(mb);
        mb.add(fileMenu);
        mb.add(editMenu);
        this.add(scrollPane);
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
                case "Speichern":
                    saveMenuItem = createMenuItem(arr[i], false, KeyEvent.VK_S,
                            KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
                    menu.add(saveMenuItem);
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
        item.addActionListener(this::actionPerformed);
        return item;
    }

    private JMenuItem createMenuItem(String s, boolean enabled, int mnemonic, KeyStroke accelerator) {
        JMenuItem item = createMenuItem(s);
        item.setEnabled(enabled);
        item.setMnemonic(mnemonic);
        item.setAccelerator(accelerator);
        return item;
    }

	protected void actionPerformed(final ActionEvent event) {
		switch (((JMenuItem) event.getSource()).getText()) {
			case "Neu":
				if(JOptionPane.showConfirmDialog(this, "Your unsaved changes will be lost!", "Are you sure?", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
					editPane.setText("");
					file = null; update();
				}
				break;
			case "Öffnen":
				JFileChooser fileChooser = new JFileChooser("C:\\Users\\Julian\\Documents\\Studium\\DHBW\\Semester_II\\Programmieren\\Programmieren_I\\src\\de\\dhbwka\\java\\exercise\\ui");
				fileChooser.setFileFilter(new FileFilter() {
					@Override
					public boolean accept(File f) {
						return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt") || f.getName().toLowerCase().endsWith(".java");
					}
					@Override
					public String getDescription() {
						return "Text Files";
					}
				});
				int choice = fileChooser.showOpenDialog(null);
				if(choice == JFileChooser.APPROVE_OPTION){
					this.file = fileChooser.getSelectedFile();
					editPane.setText(readFile(file));
				}
				update();
				break;
			case "Speichern":
				try (Writer fWriter = new FileWriter(file, StandardCharsets.UTF_8)) {
					fWriter.write(editPane.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Keine Datei eingelesen!");
				}
				break;
			case "Beenden":
				if(JOptionPane.showConfirmDialog(this, "Your unsaved changes will be lost!", "Are you sure?", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			case "Kopieren":
				String content = this.editPane.getSelectedText();
				if(content != null){
					StringSelection selection = new StringSelection(content);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selection, selection);				
				}
				break;
			case "Einfügen":
				try {
					String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
					if(data != null) {
						this.editPane.getDocument().insertString(this.editPane.getCaretPosition(), data, null);
					}
				} catch (Exception e) {
					//TODO: handle exception
				}
				break;
		}
	}

	private void update(){
		saveMenuItem.setEnabled(file != null);
		this.setTitle(file != null ? file.getName() : "Editor");
	}

	private static String readFile(File file){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
			sb.append(br.readLine());
			while(br.ready()){
                sb.append(System.lineSeparator()).append(br.readLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }
}
