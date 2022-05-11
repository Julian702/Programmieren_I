package de.dhbwka.java.exercise.ui;

import javax.swing.*;

public class ComponentFrame {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Several basic Swing components");
        frame.setSize(600, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label = new JLabel("JLabel");
        panel.add(label);

        JTextField textField = new JTextField("JTextField");
        panel.add(textField);
        JPasswordField passwordField = new JPasswordField("password");
        panel.add(passwordField);

        JButton button = new JButton("JButton");
        button.setToolTipText("Tooltip");
        panel.add(button);
        JToggleButton toggleButton = new JToggleButton("JToggleButton");
        panel.add(toggleButton);

        JCheckBox checkBox = new JCheckBox("JCheckBox");
        panel.add(checkBox);

        String[] itemList ={"Item 1","Item 2", "Item 3"};
        JComboBox comboBox = new JComboBox<String>(itemList);
        comboBox.addItem("Item 4");            
        panel.add(comboBox);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("JRadioButton1");
        radioButton1.setSelected(true);
        buttonGroup.add(radioButton1);
        panel.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("JRadioButton2");
        buttonGroup.add(radioButton2);
        panel.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton("JRadioButton3");
        buttonGroup.add(radioButton3);
        panel.add(radioButton3);

        frame.setVisible(true);   
    }
}
