package de.dhbwka.java.exercise.ui.event;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class BMICalculator extends JFrame{

    private double weight;
    private double height;
    private double bmi;

    int[] male = {0, 20, 25, 30, 40};
    int[] female = {0, 19, 24, 30, 40};

    String[] classification = {
        "Short weight",
        "Nornal weight",
        "Overweight",
        "Adiposity",
        "Massive Adiposity"
    };

    private JPanel weightPanel = new JPanel();
    private JTextField weightTextField = new JTextField(4);
    private JPanel heightPanel = new JPanel();
    private JTextField heighTextField = new JTextField(4);
    private JPanel sexPanel =  new JPanel();
    private JRadioButton maleRadioButton = new JRadioButton("männlich");
    private JRadioButton femaleRadioButton = new JRadioButton("Weiblich");
    private JPanel buttoPanel = new JPanel();
    private JButton calcButton = new JButton("Calculate");
    private JPanel bmiPanel = new JPanel();
    private JLabel bmiLabel = new JLabel("BMI");
    private JPanel resPanel = new JPanel();
    private JLabel classLabel = new JLabel("Press calculate!");

    public static void main(String[] args) {
        new BMICalculator().setVisible(true);
    }

    public BMICalculator(){
        
        super("BMI Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6,1,5,5));

        weightPanel.add(new JLabel("Weight [kg]"));
        weightPanel.add(weightTextField);
        this.add(weightPanel);

        heightPanel.add(new JLabel("Body height [m]"));
        heightPanel.add(heighTextField);
        this.add(heightPanel);

        ButtonGroup g = new ButtonGroup();
        maleRadioButton.setSelected(true);
        g.add(maleRadioButton);
        sexPanel.add(maleRadioButton);
        g.add(femaleRadioButton);
        sexPanel.add(femaleRadioButton);
        this.add(sexPanel);

        buttoPanel.add(calcButton);
        this.add(buttoPanel);

        bmiPanel.add(new JLabel("BMI:"));
        
        bmiPanel.add(bmiLabel);
        this.add(bmiPanel);

        resPanel.add(classLabel);
        this.add(resPanel);

        FocusListener focusListener = new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                ((JTextField) e.getSource()).setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("Textfield.border"));
                ((JTextField) e.getSource()).setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

                if(e.getSource() == weightTextField){
                    try {
                        weight = Double.parseDouble(((JTextField) e.getSource()).getText());
                    } catch (Exception NumberFormatException) {
                        ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.RED));
                        weight = -1;
                    }
                }else if(e.getSource() == heighTextField){
                    try {
                        height = Double.parseDouble(((JTextField) e.getSource()).getText());
                    } catch (Exception NumberFormatException) {
                        ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.RED));
                        height = -1;
                    }
                }
            }
        };
        weightTextField.addFocusListener(focusListener);
        heighTextField.addFocusListener(focusListener);

        calcButton.addActionListener(this::update);

        this.pack();
    }

    private void update(final ActionEvent event){
        if(weight == -1 || height == -1){
            bmiLabel.setText("Error!");
            classLabel.setText("Enter valid information!");
        }else{
            bmi = Math.round(weight/(height*height)*100.0)/100.0;
            bmiLabel.setText(bmi + "");
            int[] sex = maleRadioButton.isSelected() ? male : female;
            for (int i = sex.length-1; i >= 0; i--) {
                if(bmi >= sex[i]){
                    classLabel.setText(classification[i]);
                    break;
                }
            }
        }
    }
}
