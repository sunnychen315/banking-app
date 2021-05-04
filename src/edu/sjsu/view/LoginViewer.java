package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class LoginViewer extends BankViewer {

    // instance variables
    JTextField loginUsername;
    JTextField loginPassword;
    JButton loginButton;

    public LoginViewer() {

        // Sets the characteristics of the JFrame
        super();
        this.setTitle("Login Page");

        addLoginPanel();
        this.setVisible(true);
    }

    public void addLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(this.getWidth() / 8, this.getHeight() / 3, this.getWidth() / 4, this.getHeight() / 2);
        loginPanel.setSize(this.getWidth() / 4, this.getHeight() / 2);
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;

        JLabel loginText = new JLabel("Login");
        loginText.setFont(new Font("Sans Serif", Font.BOLD, 25));
        loginText.setForeground(Color.WHITE);
        JLabel userText = new JLabel("Username: ");
        JLabel userPass = new JLabel("Password: ");
        JTextField loginUsername = new JTextField(15);
        JPasswordField loginPassword = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

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
        c.gridy = 4;
        loginPanel.add(loginButton, c);

        loginPanel.setBackground(new Color(160, 212, 226));

        loginPanel.setVisible(true);
        this.add(loginPanel);

        this.setLayout(null);
    }
}
