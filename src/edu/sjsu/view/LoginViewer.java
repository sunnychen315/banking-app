package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class LoginViewer extends BankViewer {

    // instance variables
    JTextField loginUsername;
    JPasswordField loginPassword;
    JButton loginButton;
    JTextField registerUsername;
    JPasswordField registerPassword;
    JPasswordField registerConfirmPassword;
    JButton registerButton;

    public LoginViewer() {

        // Sets the characteristics of the JFrame
        super();
        this.setTitle("Login Page");

        addLoginPanel();
        addRegisterPanel();
        
        this.setVisible(true);
    }

    public void addLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(this.getWidth() / 8, this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 2);
        loginPanel.setSize(this.getWidth() / 3, this.getHeight() / 2);
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;

        JLabel loginText = new JLabel("Login");
        loginText.setFont(new Font("Sans Serif", Font.BOLD, 25));
        loginText.setForeground(Color.WHITE);
        JLabel userText = new JLabel("Username:                 ");
        JLabel userPass = new JLabel("Password:                 ");
        loginUsername = new JTextField(15);
        loginPassword = new JPasswordField(15);
        loginButton = new JButton("Login");

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

        this.setLayout(null);
    }

    public void addRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setBounds((13 * this.getWidth() / 24), this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 2);
        registerPanel.setSize(this.getWidth() / 3, this.getHeight() / 2);
        registerPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.NONE;
        g.anchor = GridBagConstraints.WEST;

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

        this.setLayout(null);
    }
}
