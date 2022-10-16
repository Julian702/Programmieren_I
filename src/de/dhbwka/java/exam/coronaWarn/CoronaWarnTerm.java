package de.dhbwka.java.exam.coronaWarn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoronaWarnTerm extends JFrame implements CoronaWarnClient {

    private JPhone jPhone;
    private WarnStatus warnStatus = WarnStatus.UNKNOWN;
    private Token currentToken;
    private List<Token> allTokens = new ArrayList<>();
    private List<Token> allSeenTokens = new ArrayList<>();

    private JLabel warnLabel = new JLabel();
    private JPanel btnPanel = new JPanel();
    private JButton newTokenBtn = new JButton("New Token");
    private JButton checkBtn = new JButton("Check for infections");
    private JButton clearTokensBtn = new JButton("Clear tokens");
    private JButton reportBtn = new JButton("Report infection");
    private JLabel infoLabel = new JLabel();

    public CoronaWarnTerm(JPhone jPhone) {

        this.jPhone = jPhone;
        this.allTokens = CoronaWarn.loadTokens(jPhone);

        this.setTitle(jPhone.getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(240, 350);
        this.setLayout(new BorderLayout(5, 5));

        this.warnLabel.setOpaque(true);
        this.warnLabel.setPreferredSize(new Dimension(0, 100));
        this.warnLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(this.warnLabel, BorderLayout.NORTH);

        this.newTokenBtn.addActionListener((e) -> newToken());
        this.btnPanel.add(newTokenBtn);
        btnPanel.setLayout(new GridLayout(4, 1, 5, 5));
        this.checkBtn.addActionListener((e) -> checkInfection());
        this.btnPanel.add(checkBtn);
        this.clearTokensBtn.addActionListener((e) -> clearTokens());
        this.btnPanel.add(clearTokensBtn);
        this.reportBtn.addActionListener((e) -> reportInfection());
        this.btnPanel.add(reportBtn);
        this.add(btnPanel, BorderLayout.CENTER);

        infoLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(infoLabel, BorderLayout.SOUTH);

        this.checkInfection();

        this.setVisible(true);

        new Thread(new Runnable() {
            public void run() {
                while (warnStatus != WarnStatus.INFECTED) {
                    newToken();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }

    private void newToken() {
        if (currentToken != null) {
            allTokens.add(currentToken);
        }
        this.currentToken = new Token();
        CoronaWarnAPI.sendToken(this);
        CoronaWarn.saveToken(this.jPhone, this.currentToken);
        this.infoLabel.setToolTipText(this.currentToken.toString());
    }

    private void checkInfection() {
        this.warnStatus = CoronaWarnAPI.checkInfection(this) ? WarnStatus.ALARM : WarnStatus.OK;
        this.updateWarnLabel();
    }

    private void clearTokens() {
        this.newToken();
        this.allTokens.clear();
        this.allSeenTokens.clear();
        CoronaWarn.clearTokenStore(jPhone);
        this.updateInfoLabel();
    }

    private void reportInfection() {
        CoronaWarnAPI.reportInfection(this);
        this.newTokenBtn.setEnabled(false);
        this.checkBtn.setEnabled(false);
        this.clearTokensBtn.setEnabled(false);
        this.reportBtn.setEnabled(false);
        this.warnStatus = WarnStatus.INFECTED;
        updateWarnLabel();
    }

    private void updateWarnLabel() {
        this.warnLabel.setText(warnStatus.getText());
        this.warnLabel.setBackground(warnStatus.getColor());
    }

    private void updateInfoLabel() {
        this.infoLabel.setText("Seen Tokens: " + this.allSeenTokens.size());
    }

    @Override
    public Token getCurrentToken() {
        // TODO Auto-generated method stub
        return this.currentToken;
    }

    @Override
    public List<Token> getAllTokens() {
        // TODO Auto-generated method stub
        return this.allTokens;
    }

    @Override
    public List<Token> getAllSeenTokens() {
        // TODO Auto-generated method stub
        return this.allSeenTokens;
    }

    @Override
    public void tokenReceived(Token token) {
        // TODO Auto-generated method stub
        this.allSeenTokens.add(token);
        this.updateInfoLabel();
    }
}
