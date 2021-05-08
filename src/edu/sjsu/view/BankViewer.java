package edu.sjsu.view;

import edu.sjsu.messages.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.BlockingQueue;

/**
 * This is the main view that sets the background and connects to the different pages
 */
public class BankViewer extends JFrame {

    BlockingQueue<Message> queue;
    JPanel topPanel;
    JLabel bankName;

    /**
     * This is the constructor for the BankViewer class that will display the basic layout for every page
     *
     * @param queue blocking queue storing the messages to be executed
     */
    public BankViewer(BlockingQueue<Message> queue) {

        // Sets the state of the JFrame to full screen
        this.getContentPane().setBackground(new Color(7, 63, 120));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Sets the size of the JFrame to full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        // Creates a panel across the top of the frame and sets its size
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, this.getWidth(), this.getHeight() / 6);
        topPanel.setSize(this.getWidth(), this.getHeight() / 6);
        topPanel.setLayout(null);

        // Creates a JLabel for the bank's name and sets its characteristics
        bankName = new JLabel("Bank Name");
        bankName.setFont(new Font("Sans Serif", Font.BOLD, 50));
        bankName.setBounds(this.getX() + 10, this.getY() - 30, this.getWidth() / 4, this.getHeight() / 6);
        bankName.setBackground(new Color(160, 212, 226));
        bankName.setForeground(Color.WHITE);
        bankName.setHorizontalAlignment(SwingConstants.LEFT);
        bankName.setVerticalAlignment(SwingConstants.BOTTOM);
        bankName.setVisible(true);

        // adds the bankName JPanel to the topPanel
        topPanel.add(bankName);
        topPanel.setBackground(new Color(160, 212, 226));
        topPanel.setVisible(true);

        // adds the topPanel to the JFrame
        this.add(topPanel);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method adds a login/logout message in the top right corner of the screen and also adds an action listener
     * for when it is clicked
     */
    public void addAccountName() {
        // Creates a JLabel for the login/logout message and sets its characteristics
        JLabel accountName = new JLabel("Login/Logout");
        accountName.setFont(new Font("Sans Serif", Font.BOLD, 30));
        accountName.setBounds(3 * (this.getWidth() / 4), this.getY() - 20, (this.getWidth() / 4) - 10, this.getHeight() / 6);
        accountName.setBackground(new Color(160, 212, 226));
        accountName.setForeground(Color.WHITE);
        accountName.setHorizontalAlignment(SwingConstants.RIGHT);
        accountName.setVerticalAlignment(SwingConstants.BOTTOM);
        accountName.setVisible(true);

        // adds an action listener prompting the user to sign out
        accountName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                signOut();
            }
        });

        // adds the JLabel to the topPanel
        topPanel.add(accountName);
    }

    /**
     * This method adds an action listener that will take the user back to the home page if the
     * "bank name" message is clicked
     */
    public void addHomeActionListener() {
        bankName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                BankViewer.this.dispose();
                new HomeViewer(queue);
            }
        });
    }

    /**
     * This method brings up a message asking to confirm before signing out when the login/logout
     * message is clicked
     */
    public void signOut() {
        int input = JOptionPane.showConfirmDialog(null, "Do you wish to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            this.dispose();
            new LoginViewer(queue);
        }
        // else, do nothing
    }
}
