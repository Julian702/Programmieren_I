package de.dhbwka.java.exercise.collections.gas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GasStations extends JFrame{

    private final Map<String, GasPrices> stations = new HashMap<>();

    private JTextField nameField= new JTextField();
    private JTextField dieselField = new JTextField();
    private JTextField e5Field = new JTextField();
    private JTextField e10Field = new JTextField();

    public static void main(String[] args) {
        GasStations gs = new GasStations();
        gs.setVisible(true);
    }

    public GasStations(){
        super("Gas Stations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(4,2,5,5));
        inputPanel.add(new JLabel("Station Name"));
        inputPanel.add(this.nameField);
        inputPanel.add(new JLabel("Diesel"));
        inputPanel.add(this.dieselField);
        inputPanel.add(new JLabel("Super E5"));
        inputPanel.add(this.e5Field);
        inputPanel.add(new JLabel("Super E10"));
        inputPanel.add(this.e10Field);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this::save);
        buttonPanel.add(saveButton);
        JButton showButton = new JButton("Show all");
        showButton.addActionListener(this::show);
        buttonPanel.add(showButton);
        
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
    }

    private double getValue(JTextField field){
        String val = field.getText();
        if(!val.isEmpty()){
            val = val.replace(",", ".");
        }
        try {
            return Double.parseDouble(val);
        } catch(Exception e){
            return -1;
        }
    }

    private void save(ActionEvent e){
        String station = this.nameField.getText();
        if(station.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please provide a station name");
            return;
        }
        GasPrices gp = new GasPrices();
        gp.setDiesel(this.getValue(this.dieselField));
        gp.setSuperE5(this.getValue(this.e5Field));
        gp.setSuperE10(this.getValue(this.e10Field));

        this.nameField.setText("");
        this.dieselField.setText("");
        this.e5Field.setText("");
        this.e10Field.setText("");

        this.stations.put(station, gp);

        JOptionPane.showMessageDialog(this, "Saved: " + station + " (" + gp + ")");
    }

    private void show(ActionEvent e){
        StringBuilder sb = new StringBuilder();
        for (Entry<String, GasPrices> s : this.stations.entrySet()) {
            sb.append(s.getKey() + ": " + s.getValue() + "\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString().trim());
    }
}
