package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankViewer extends JFrame {

    JPanel topPanel;
    JLabel bankName;

    public BankViewer() {

        // Sets the characteristics of the JFrame
        this.getContentPane().setBackground(new Color(7, 63, 120));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        topPanel = new JPanel();
        topPanel.setBounds(0, 0, this.getWidth(), this.getHeight() / 6);
        topPanel.setSize(this.getWidth(), this.getHeight() / 6);
        topPanel.setLayout(null);

        bankName = new JLabel("Bank Name");
        bankName.setFont(new Font("Sans Serif", Font.BOLD, 50));
        bankName.setBounds(this.getX() + 10, this.getY() - 30, this.getWidth() / 4, this.getHeight() / 6);
        bankName.setBackground(new Color(160, 212, 226));
        bankName.setForeground(Color.WHITE);
        bankName.setHorizontalAlignment(SwingConstants.LEFT);
        bankName.setVerticalAlignment(SwingConstants.BOTTOM);
        bankName.setVisible(true);

        topPanel.add(bankName);
        topPanel.setBackground(new Color(160, 212, 226));
        topPanel.setVisible(true);

        this.add(topPanel);

        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addAccountName() {
        JLabel accountName = new JLabel("Account Name");
        accountName.setFont(new Font("Sans Serif", Font.BOLD, 30));
        accountName.setBounds(3 * (this.getWidth() / 4), this.getY() - 20, (this.getWidth() / 4) - 10, this.getHeight() / 6);
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

        topPanel.add(accountName);
    }

    public void addHomeActionListener() {
        bankName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                BankViewer.this.dispose();
                new HomeViewer();
            }
        });
    }

    public void signOut() {
        int input = JOptionPane.showConfirmDialog(null, "Do you wish to sign out?", "Sign Out", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            this.dispose();
            new LoginViewer();
        }
        // else, do nothing
    }
}
