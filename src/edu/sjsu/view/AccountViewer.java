package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class AccountViewer extends JFrame {

    // instance variables

    public AccountViewer() {

        // Sets the characteristics of the JFrame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Account Page");
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
