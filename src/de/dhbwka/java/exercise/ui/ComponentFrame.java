package de.dhbwka.java.exercise.ui;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ComponentFrame extends JFrame{
    public static void main(String[] args) {
        ComponentFrame componentFrame = new ComponentFrame("Several basic Swing components", 512, 128);
        componentFrame.setVisible(true);
    }

    public ComponentFrame(String title, int width, int height){

        super(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel("JLabel");
        this.add(label);

        JTextField textField = new JTextField("JTextField");
        this.add(textField);
        JPasswordField passwordField = new JPasswordField("password");
        this.add(passwordField);

        JButton button = new JButton("JButton");
        button.setToolTipText("Tooltip");
        this.add(button);
        JToggleButton toggleButton = new JToggleButton("JToggleButton");
        this.add(toggleButton);

        JCheckBox checkBox = new JCheckBox("JCheckBox");
        this.add(checkBox);

        String[] itemList ={"Item 1","Item 2", "Item 3"};
        JComboBox<String> comboBox = new JComboBox<String>(itemList);
        comboBox.addItem("Item 4");            
        this.add(comboBox);

        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 1; i < 4; i++) {
            JRadioButton radioButton = new JRadioButton("JRadioButton"+i);
            buttonGroup.add(radioButton);
            this.add(radioButton);
        }
    }
}
