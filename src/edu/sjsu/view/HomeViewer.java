package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class HomeViewer extends BankViewer {

    // instance variables

    public HomeViewer() {

        // Sets the characteristics of the JFrame
        super();
        this.setTitle("Home Page");

        addAccountName();

        JLabel accountText = new JLabel("My Accounts");
        accountText.setFont(new Font("Sans Serif", Font.BOLD, 20));
        accountText.setBounds(this.getX() + 10, topPanel.getHeight() + 30, this.getWidth() / 4, this.getHeight() / 10);
        accountText.setBackground(new Color(7, 63, 120));
        accountText.setForeground(Color.WHITE);
        accountText.setHorizontalAlignment(SwingConstants.LEFT);
        accountText.setVerticalAlignment(SwingConstants.BOTTOM);
        accountText.setVisible(true);

        this.add(accountText);

        addCheckingBox();
        addSavingsBox();
        addCreditBox();

        this.setVisible(true);
    }

    public void addCheckingBox() {
        JPanel checkingPanel = new JPanel();
        checkingPanel.setBounds(this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        checkingPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);
        checkingPanel.setLayout(new BorderLayout());

        JLabel checkingText = new JLabel("Checking");
        checkingText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        checkingText.setForeground(Color.WHITE);
        checkingText.setHorizontalAlignment(SwingConstants.CENTER);
        checkingText.setVerticalAlignment(SwingConstants.CENTER);
        checkingPanel.add(checkingText, BorderLayout.NORTH);

        checkingPanel.setBackground(new Color(160, 212, 226));
        checkingPanel.setVisible(true);
        this.add(checkingPanel);

        this.setLayout(null);
    }

    public void addSavingsBox() {
        JPanel savingsPanel = new JPanel();
        savingsPanel.setBounds(6 * this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        savingsPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);

        JLabel savingsText = new JLabel("Savings");
        savingsText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        savingsText.setForeground(Color.WHITE);
        savingsText.setHorizontalAlignment(SwingConstants.CENTER);
        savingsText.setVerticalAlignment(SwingConstants.CENTER);
        savingsPanel.add(savingsText, BorderLayout.NORTH);

        savingsPanel.setBackground(new Color(160, 212, 226));
        savingsPanel.setVisible(true);
        this.add(savingsPanel);

        this.setLayout(null);
    }

    public void addCreditBox() {
        JPanel creditPanel = new JPanel();
        creditPanel.setBounds(11 * this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        creditPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);

        JLabel creditText = new JLabel("Credit Card");
        creditText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        creditText.setForeground(Color.WHITE);
        creditText.setHorizontalAlignment(SwingConstants.CENTER);
        creditText.setVerticalAlignment(SwingConstants.CENTER);
        creditPanel.add(creditText, BorderLayout.NORTH);

        creditPanel.setBackground(new Color(160, 212, 226));
        creditPanel.setVisible(true);
        this.add(creditPanel);

        this.setLayout(null);
    }
}
