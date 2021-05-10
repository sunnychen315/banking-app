package edu.sjsu.view;

import edu.sjsu.messages.CheckingMessage;
import edu.sjsu.messages.CreditsMessage;
import edu.sjsu.messages.Message;
import edu.sjsu.messages.SavingsMessage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.BlockingQueue;

/**
 * This is the view for the home page that shows information on the user's various accounts
 */
public class HomeViewer extends BankViewer {

    // instance variables
    JLabel checkingAmount;
    JLabel savingsAmount;
    JLabel creditAmount;

    /**
     * This is the constructor for the HomeViewer class
     *
     * @param queue blocking queue storing the messages to be executed
     */
    public HomeViewer(BlockingQueue<Message> queue) {

        // Calls the constructor of BankViewer to get the screen's basic layout
        super(queue);
        this.setTitle("Home Page");

        // adds the login/logout message to the top of the screen
        addAccountName();

        // creates and adds a JLabel with the text "My Accounts"
        JLabel accountText = new JLabel("My Accounts");
        accountText.setFont(new Font("Sans Serif", Font.BOLD, 20));
        accountText.setBounds(this.getX() + 10, topPanel.getHeight() + 30, this.getWidth() / 4, this.getHeight() / 10);
        accountText.setBackground(new Color(7, 63, 120));
        accountText.setForeground(Color.WHITE);
        accountText.setHorizontalAlignment(SwingConstants.LEFT);
        accountText.setVerticalAlignment(SwingConstants.BOTTOM);
        accountText.setVisible(true);
        this.add(accountText);

        // adds a panel to the JFrame for each of the user's accounts
        addCheckingBox();
        addSavingsBox();
        addCreditBox();

        this.setVisible(true);
    }

    /**
     * This method adds a panel displaying information on the user's checking account
     */
    public void addCheckingBox() {
        // creates and sets the characteristics of the checking account panel
        JPanel checkingPanel = new JPanel();
        checkingPanel.setBounds(this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        checkingPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);
        checkingPanel.setLayout(new BorderLayout());
        checkingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // creates the JLabel with the "checking" text
        JLabel checkingText = new JLabel("Checking");
        checkingText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        checkingText.setForeground(Color.WHITE);
        checkingText.setHorizontalAlignment(SwingConstants.CENTER);
        checkingText.setVerticalAlignment(SwingConstants.BOTTOM);

        // creates a "details" text box
        JLabel checkingDetails = addDetails();

        // adds an action listener to create a new CheckingsViewer when "details" is clicked
        checkingDetails.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Message msg = new CheckingMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });

        // Sets the characteristics of the amount JLabel
        checkingAmount = new JLabel("$306");
        checkingAmount.setFont(new Font("Sans Serif", Font.BOLD, 75));
        checkingAmount.setForeground(Color.WHITE);
        checkingAmount.setHorizontalAlignment(SwingConstants.CENTER);
        checkingAmount.setVerticalAlignment(SwingConstants.CENTER);

        // adds all the components to the panel
        checkingPanel.add(checkingText, BorderLayout.NORTH);
        checkingPanel.add(checkingAmount, BorderLayout.CENTER);
        checkingPanel.add(checkingDetails, BorderLayout.SOUTH);

        // adds the panel to the JFrame
        checkingPanel.setBackground(new Color(160, 212, 226));
        checkingPanel.setVisible(true);
        this.add(checkingPanel);
    }

    /**
     * This method adds a panel displaying information on the user's savings account
     */
    public void addSavingsBox() {
        // creates and sets the characteristics of the savings account panel
        JPanel savingsPanel = new JPanel();
        savingsPanel.setBounds(6 * this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        savingsPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);
        savingsPanel.setLayout(new BorderLayout());
        savingsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // creates the JLabel with the "savings" text
        JLabel savingsText = new JLabel("Savings");
        savingsText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        savingsText.setForeground(Color.WHITE);
        savingsText.setHorizontalAlignment(SwingConstants.CENTER);
        savingsText.setVerticalAlignment(SwingConstants.BOTTOM);

        // creates a "details" text box
        JLabel savingsDetails = addDetails();

        // adds an action listener to create a new SavingsViewer when "details" is clicked
        savingsDetails.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Message msg = new SavingsMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });

        // Sets the characteristics of the amount JLabel
        savingsAmount = new JLabel("$3402");
        savingsAmount.setFont(new Font("Sans Serif", Font.BOLD, 75));
        savingsAmount.setForeground(Color.WHITE);
        savingsAmount.setHorizontalAlignment(SwingConstants.CENTER);
        savingsAmount.setVerticalAlignment(SwingConstants.CENTER);

        // adds all the components to the panel
        savingsPanel.add(savingsText, BorderLayout.NORTH);
        savingsPanel.add(savingsAmount, BorderLayout.CENTER);
        savingsPanel.add(savingsDetails, BorderLayout.SOUTH);

        // adds the panel to the JFrame
        savingsPanel.setBackground(new Color(160, 212, 226));
        savingsPanel.setVisible(true);
        this.add(savingsPanel);
    }

    /**
     * This method adds a panel displaying information on the user's credit card account
     */
    public void addCreditBox() {
        // creates and sets the characteristics of the credit card account panel
        JPanel creditPanel = new JPanel();
        creditPanel.setBounds(11 * this.getWidth() / 16, 5 * this.getHeight() / 12, this.getWidth() / 4, this.getHeight() / 3);
        creditPanel.setSize(this.getWidth() / 4, this.getHeight() / 3);
        creditPanel.setLayout(new BorderLayout());
        creditPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // creates the JLabel with the "credit card" text
        JLabel creditText = new JLabel("Credit Card");
        creditText.setFont(new Font("Sans Serif", Font.BOLD, 30));
        creditText.setForeground(Color.WHITE);
        creditText.setHorizontalAlignment(SwingConstants.CENTER);
        creditText.setVerticalAlignment(SwingConstants.BOTTOM);

        // creates a "details" text box
        JLabel creditDetails = addDetails();

        // adds an action listener to create a new CreditViewer when "details" is clicked
        creditDetails.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Message msg = new CreditsMessage();
                    queue.put(msg);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });

        // Sets the characteristics of the amount JLabel
        creditAmount = new JLabel("$12.50");
        creditAmount.setFont(new Font("Sans Serif", Font.BOLD, 75));
        creditAmount.setForeground(new Color(196, 30, 58));
        creditAmount.setHorizontalAlignment(SwingConstants.CENTER);
        creditAmount.setVerticalAlignment(SwingConstants.CENTER);

        // adds all the components to the panel
        creditPanel.add(creditText, BorderLayout.NORTH);
        creditPanel.add(creditAmount, BorderLayout.CENTER);
        creditPanel.add(creditDetails, BorderLayout.SOUTH);

        // adds the panel to the JFrame
        creditPanel.setBackground(new Color(160, 212, 226));
        creditPanel.setVisible(true);
        this.add(creditPanel);
    }

    /**
     * This method creates a "details" text box to be added to each of the panels
     *
     * @return JLabel with the text "Details >"
     */
    public JLabel addDetails() {
        // Creates and sets the characteristics of the details text box
        JLabel details = new JLabel("Details >");
        details.setFont(new Font("Sans Serif", Font.BOLD, 15));
        details.setForeground(Color.WHITE);
        details.setHorizontalAlignment(SwingConstants.CENTER);
        details.setVerticalAlignment(SwingConstants.TOP);
        return details;
    }
}
