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

        TopBar bar = new TopBar(this.getX(), this.getY(), this.getWidth(), this.getHeight() / 6);
        topBar = new JLabel(bar);
        topBar.setLayout(null);
        topBar.setSize(this.getWidth(), this.getHeight() / 6);
        topBar.setVisible(true);
        this.add(topBar);


        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
