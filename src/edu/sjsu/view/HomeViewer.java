package edu.sjsu.view;

import edu.sjsu.messages.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.BlockingQueue;

/**
 * This is the view for the home page that shows
 */
public class HomeViewer extends BankViewer {

    // instance variables
    JLabel checkingAmount;
    JLabel savingsAmount;
    JLabel creditAmount;

    public HomeViewer(BlockingQueue<Message> queue) {

        // Sets the characteristics of the JFrame
        super(queue);
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
        checkingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel checkingText = new JLabel("Checking");
        checkingText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        checkingText.setForeground(Color.WHITE);
        checkingText.setHorizontalAlignment(SwingConstants.CENTER);
        checkingText.setVerticalAlignment(SwingConstants.BOTTOM);

        JLabel checkingDetails = addDetails();

        checkingDetails.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new CheckingsViewer(queue);
            }
        });

        checkingAmount = new JLabel("$306");
        checkingAmount.setFont(new Font("Sans Serif", Font.BOLD, 75));
        checkingAmount.setForeground(Color.WHITE);
        checkingAmount.setHorizontalAlignment(SwingConstants.CENTER);
        checkingAmount.setVerticalAlignment(SwingConstants.CENTER);

        checkingPanel.add(checkingText, BorderLayout.NORTH);
        checkingPanel.add(checkingAmount, BorderLayout.CENTER);
        checkingPanel.add(checkingDetails, BorderLayout.SOUTH);

        checkingPanel.setBackground(new Color(160, 212, 226));
        checkingPanel.setVisible(true);
        this.add(checkingPanel);
    }

    public void addSavingsBox() {
        JPanel savingsPanel = new JPanel();
        savingsPanel.setBounds(6 * this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        savingsPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);
        savingsPanel.setLayout(new BorderLayout());
        savingsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel savingsText = new JLabel("Savings");
        savingsText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        savingsText.setForeground(Color.WHITE);
        savingsText.setHorizontalAlignment(SwingConstants.CENTER);
        savingsText.setVerticalAlignment(SwingConstants.BOTTOM);

        JLabel savingsDetails = addDetails();

        savingsAmount = new JLabel("$3402");
        savingsAmount.setFont(new Font("Sans Serif", Font.BOLD, 75));
        savingsAmount.setForeground(Color.WHITE);
        savingsAmount.setHorizontalAlignment(SwingConstants.CENTER);
        savingsAmount.setVerticalAlignment(SwingConstants.CENTER);

        savingsPanel.add(savingsText, BorderLayout.NORTH);
        savingsPanel.add(savingsAmount, BorderLayout.CENTER);
        savingsPanel.add(savingsDetails, BorderLayout.SOUTH);

        savingsPanel.setBackground(new Color(160, 212, 226));
        savingsPanel.setVisible(true);
        this.add(savingsPanel);
    }

    public void addCreditBox() {
        JPanel creditPanel = new JPanel();
        creditPanel.setBounds(11 * this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        creditPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);
        creditPanel.setLayout(new BorderLayout());
        creditPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel creditText = new JLabel("Credit Card");
        creditText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        creditText.setForeground(Color.WHITE);
        creditText.setHorizontalAlignment(SwingConstants.CENTER);
        creditText.setVerticalAlignment(SwingConstants.BOTTOM);

        JLabel creditDetails = addDetails();

        creditAmount = new JLabel("$12.50");
        creditAmount.setFont(new Font("Sans Serif", Font.BOLD, 75));
        creditAmount.setForeground(new Color(196, 30, 58));
        creditAmount.setHorizontalAlignment(SwingConstants.CENTER);
        creditAmount.setVerticalAlignment(SwingConstants.CENTER);

        creditPanel.add(creditText, BorderLayout.NORTH);
        creditPanel.add(creditAmount, BorderLayout.CENTER);
        creditPanel.add(creditDetails, BorderLayout.SOUTH);

        creditPanel.setBackground(new Color(160, 212, 226));
        creditPanel.setVisible(true);
        this.add(creditPanel);
    }

    public JLabel addDetails() {
        JLabel details = new JLabel("Details >");
        details.setFont(new Font("Sans Serif", Font.BOLD, 15));
        details.setForeground(Color.WHITE);
        details.setHorizontalAlignment(SwingConstants.CENTER);
        details.setVerticalAlignment(SwingConstants.TOP);
        return details;
    }
}
