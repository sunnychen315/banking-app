package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class LoginViewer extends JFrame {

    // instance variables

    public LoginViewer() {

        // Sets the characteristics of the JFrame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Login Page");
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
