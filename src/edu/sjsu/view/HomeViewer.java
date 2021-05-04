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
        accountText.setBounds(this.getX() + 10, topPanel.getHeight() - 30, this.getWidth() / 4, this.getHeight() / 10);
        accountText.setBackground(new Color(7, 63, 120));
        accountText.setForeground(Color.WHITE);
        accountText.setHorizontalAlignment(SwingConstants.LEFT);
        accountText.setVerticalAlignment(SwingConstants.BOTTOM);
        accountText.setVisible(true);

        this.add(accountText);

        this.setVisible(true);
    }
}
