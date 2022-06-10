package de.dhbwka.java.exercise.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CurrencyCalculator {
    
    private JFrame f = new JFrame("Currency converter");
    private JPanel p = new JPanel(new BorderLayout(10, 10));
    private JTextField textField = new JTextField("Please enter amount to convert!");
    private JButton eur2usd = new JButton("EUR -> USD");
    private JButton usd2eur = new JButton("USD -> EUR");
    private JButton btnCancel = new JButton("Cancel");

    public static void main(String[] args) {
        new CurrencyCalculator(500, 100);
    }

    public CurrencyCalculator(int width, int height){

        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(10,10));
        f.add(textField, BorderLayout.NORTH);
        f.add(p, BorderLayout.SOUTH);
        p.add(eur2usd, BorderLayout.WEST);
        p.add(usd2eur, BorderLayout.CENTER);
        p.add(btnCancel, BorderLayout.EAST);

        textField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
                textField.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
            }
            @Override
            public void focusLost(FocusEvent e) {                
            }
        });
        ActionListener calculate = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                textField.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                try {
                    if(e.getSource() == eur2usd){
                        textField.setText(Double.parseDouble(textField.getText().replace("€", "")) * 1.09 + "$");
                    }else{
                        textField.setText(Double.parseDouble(textField.getText().replace("$", "")) / 1.09 + "€");
                    }
                } catch (Exception NumberFormatExeception) {
                    textField.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }    
        };
        eur2usd.addActionListener(calculate);
        usd2eur.addActionListener(calculate);
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        f.setVisible(true);
    }
}
