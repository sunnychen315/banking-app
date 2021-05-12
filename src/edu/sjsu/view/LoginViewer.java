package edu.sjsu.view;

import edu.sjsu.messages.LoginMessage;
import edu.sjsu.messages.Message;
import edu.sjsu.messages.RegisterMessage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * This is the class that displays the login screen
 */
public class LoginViewer extends BankViewer {

    // instance variables
    JTextField loginUsername;
    JPasswordField loginPassword;
    JButton loginButton;
    JTextField registerUsername;
    JPasswordField registerPassword;
    JPasswordField registerConfirmPassword;
    JButton registerButton;

    /**
     * This is the constructor for the LoginViewer class that will display the login screen
     *
     * @param queue blocking queue storing the messages to be executed
     */
    public LoginViewer(BlockingQueue<Message> queue) {

        // Calls the constructor of BankViewer to get the screen's basic layout
        super(queue);
        this.setTitle("Login Page");

        // adds the login and register panels to the JFrame
        addLoginPanel();
        addRegisterPanel();

        // adds the action listener to the login button to add a login message to the blocking queue
        loginButton.addActionListener(e -> {
            String username = loginUsername.getText();
            String pass = String.valueOf(loginPassword.getPassword());
            try {
                Message msg = new LoginMessage(username, pass);
                queue.put(msg);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        // adds the action listener to the register button to add a register message to the blocking queue
        registerButton.addActionListener(e -> {
            String username = registerUsername.getText();
            String pass = String.valueOf(registerPassword.getPassword());
            String confirmedPass = String.valueOf(registerConfirmPassword.getPassword());
            try {
                queue.put(new RegisterMessage(username, pass, confirmedPass));
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

        this.setVisible(true);
    }

    /**
     * This method adds a panel that manages the user's login information
     */
    public void addLoginPanel() {
        // creates the login panel and sets its characteristics
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(this.getWidth() / 8, this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 2);
        loginPanel.setSize(this.getWidth() / 3, this.getHeight() / 2);
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;

        // creates the components to be added into the login panel
        JLabel loginText = new JLabel("Login");
        loginText.setFont(new Font("Sans Serif", Font.BOLD, 25));
        loginText.setForeground(Color.WHITE);
        JLabel userText = new JLabel("Username:                 ");
        JLabel userPass = new JLabel("Password:                 ");
        loginUsername = new JTextField(15);
        loginPassword = new JPasswordField(15);
        loginButton = new JButton("Login");

        // modifies the coordinates of the GridBagLayout and adds the components accordingly
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1;
        loginPanel.add(loginText, c);
        c.gridy = 2;
        loginPanel.add(userText, c);
        c.gridx = 1;
        loginPanel.add(loginUsername, c);
        c.gridx = 0;
        c.gridy = 3;
        loginPanel.add(userPass, c);
        c.gridx = 1;
        loginPanel.add(loginPassword, c);
        c.gridx = 3;
        c.gridy = 5;
        loginPanel.add(loginButton, c);

        loginPanel.setBackground(new Color(160, 212, 226));

        loginPanel.setVisible(true);
        this.add(loginPanel);
    }

    /**
     * This method adds a panel that manages the user's registration information
     */
    public void addRegisterPanel() {
        // creates the register panel and sets its characteristics
        JPanel registerPanel = new JPanel();
        registerPanel.setBounds((13 * this.getWidth() / 24), this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 2);
        registerPanel.setSize(this.getWidth() / 3, this.getHeight() / 2);
        registerPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.NONE;
        g.anchor = GridBagConstraints.WEST;

        // creates the components to be added into the register panel
        JLabel registerText = new JLabel("Register");
        registerText.setFont(new Font("Sans Serif", Font.BOLD, 25));
        registerText.setForeground(Color.WHITE);
        JLabel userText = new JLabel("Username: ");
        JLabel userPass = new JLabel("Password: ");
        JLabel confirmPass = new JLabel("Confirm Password:    ");
        registerUsername = new JTextField(15);
        registerPassword = new JPasswordField(15);
        registerConfirmPassword = new JPasswordField(15);
        registerButton = new JButton("Register");

        // modifies the coordinates of the GridBagLayout and adds the components accordingly
        g.gridx = 0;
        g.gridy = 1;
        g.weighty = 1;
        registerPanel.add(registerText, g);
        g.gridy = 2;
        registerPanel.add(userText, g);
        g.gridx = 1;
        registerPanel.add(registerUsername, g);
        g.gridx = 0;
        g.gridy = 3;
        registerPanel.add(userPass, g);
        g.gridx = 1;
        registerPanel.add(registerPassword, g);
        g.gridx = 0;
        g.gridy = 4;
        registerPanel.add(confirmPass, g);
        g.gridx = 1;
        registerPanel.add(registerConfirmPassword, g);
        g.gridx = 3;
        g.gridy = 5;
        registerPanel.add(registerButton, g);

        registerPanel.setBackground(new Color(160, 212, 226));

        registerPanel.setVisible(true);
        this.add(registerPanel);
    }
}
