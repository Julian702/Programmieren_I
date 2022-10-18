package de.dhbwka.java.exam.FakeTalk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuoteTerm extends JFrame implements FakeTalkClient {

    private final String person;
    private final QuoteSelectionTerm quoteSelectionTerm;
    private Quote quote;

    private int points = 0;

    private final QuoteDisplay quoteDisplay = new QuoteDisplay();
    private final JPanel btnPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    private final QuoteButton hotBtn = new QuoteButton();
    private final QuoteButton shitBtn = new QuoteButton();
    private final JLabel pointLabel = new JLabel("0 Points");

    public QuoteTerm(String person, QuoteSelectionTerm term) {

        super(person);

        this.person = person;
        this.quoteSelectionTerm = term;

        this.initUI();
        this.setVisible(true);
    }

    private void initUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));

        this.add(quoteDisplay, BorderLayout.NORTH);

        hotBtn.setEnabled(false);
        hotBtn.setQuoteType(QuoteType.HOT_SHIT);
        hotBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                QuoteTerm.this.quoteSelectionTerm.answerSelected(QuoteTerm.this, QuoteTerm.this.quote, QuoteType.HOT_SHIT);
                QuoteTerm.this.quoteDisplay.setText("");
                QuoteTerm.this.hotBtn.setEnabled(false);
                QuoteTerm.this.shitBtn.setEnabled(false);
            }
        });
        btnPanel.add(hotBtn);

        shitBtn.setEnabled(false);
        shitBtn.setQuoteType(QuoteType.BULLSHIT);
        shitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                QuoteTerm.this.quoteSelectionTerm.answerSelected(QuoteTerm.this, QuoteTerm.this.quote, QuoteType.BULLSHIT);
                QuoteTerm.this.quoteDisplay.setText("");
                QuoteTerm.this.hotBtn.setEnabled(false);
                QuoteTerm.this.shitBtn.setEnabled(false);
            }
        });
        btnPanel.add(shitBtn);

        this.add(btnPanel, BorderLayout.CENTER);

        pointLabel.setText(Integer.toString(points));
        this.add(pointLabel, BorderLayout.SOUTH);

        this.pack();
    }

    @Override
    public String getPlayerName() {
        return person;
    }

    @Override
    public void setQuote(Quote q) {
        this.quote = q;
        this.quoteDisplay.setText(this.quote.getText());
        this.hotBtn.setEnabled(true);
        this.shitBtn.setEnabled(true);
    }

    @Override
    public void addPoints(int points) {
        System.out.println(this.getPoints() + " + " + points + " = " + (this.getPoints()+points));
        this.points = (this.getPoints()+points);
        this.pointLabel.setText(Integer.toString(this.getPoints()));
    }

    @Override
    public int getPoints() {
        return points;
    }
}