package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccountViewer extends BankViewer {

    // instance variables

    public AccountViewer() {

        // Sets the characteristics of the JFrame
        super();
        this.setTitle("Account Page");

        JLabel accountName = new JLabel("Account Name");
        accountName.setFont(new Font("Sans Serif", Font.BOLD, 30));
        accountName.setBounds(3 * (this.getWidth() / 4), this.getY() - 30, (this.getWidth() / 4) - 10, this.getHeight() / 6);
        accountName.setBackground(new Color(160, 212, 226));
        accountName.setForeground(Color.WHITE);
        accountName.setHorizontalAlignment(SwingConstants.RIGHT);
        accountName.setVerticalAlignment(SwingConstants.BOTTOM);
        accountName.setVisible(true);

        accountName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                signOut();
            }
        });

        lp.add(accountName, 0);
    }

    public void signOut() {
        int input = JOptionPane.showConfirmDialog(null, "Do you wish to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            LoginViewer loginViewer = new LoginViewer();
        } else {
            // do nothing
        }
    }
}
