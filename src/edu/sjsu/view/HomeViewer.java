package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class HomeViewer extends JFrame {

    // instance variables

    public HomeViewer() {

        // Sets the characteristics of the JFrame
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Home Page");
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
