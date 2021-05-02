package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class BankViewer extends JFrame {
    JLabel topBar;


    public BankViewer() {

        // Sets the characteristics of the JFrame
        this.getContentPane().setBackground(new Color(7, 63, 120));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        JLayeredPane lp = new JLayeredPane();
        lp.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight() / 6);

        TopBar bar = new TopBar(this.getX(), this.getY(), this.getWidth(), this.getHeight() / 6);
        topBar = new JLabel(bar);
        topBar.setLayout(null);
        topBar.setSize(this.getWidth(), this.getHeight() / 6);
        topBar.setOpaque(true);
        topBar.setVisible(true);

        JLabel bankName = new JLabel("Bank Name");
        bankName.setFont(new Font("Sans Serif", Font.BOLD, 50));
        bankName.setBounds(0, this.getHeight() / 10, 500, 500);
        bankName.setBackground(new Color(160, 212, 226));
        bankName.setForeground(Color.WHITE);
        bankName.setHorizontalAlignment(SwingConstants.LEFT);
        bankName.setVerticalAlignment(SwingConstants.TOP);
        bankName.setVisible(true);

        lp.add(bankName);
        lp.add(topBar);
        this.add(lp);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
