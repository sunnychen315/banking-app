package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankViewer extends JFrame {

    JLayeredPane lp;

    public BankViewer() {

        // Sets the characteristics of the JFrame
        this.getContentPane().setBackground(new Color(7, 63, 120));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());

        lp = new JLayeredPane();
        lp.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight() / 6);

        TopBar bar = new TopBar(this.getX(), this.getY(), this.getWidth(), this.getHeight() / 6);
        JLabel topBar = new JLabel(bar);
        topBar.setLayout(null);
        topBar.setSize(this.getWidth(), this.getHeight() / 6);
        topBar.setOpaque(true);
        topBar.setVisible(true);

        JLabel bankName = new JLabel("Bank Name");
        bankName.setFont(new Font("Sans Serif", Font.BOLD, 50));
        bankName.setBounds(this.getX() + 10, this.getY() - 30, this.getWidth() / 4, this.getHeight() / 6);
        bankName.setBackground(new Color(160, 212, 226));
        bankName.setForeground(Color.WHITE);
        bankName.setHorizontalAlignment(SwingConstants.LEFT);
        bankName.setVerticalAlignment(SwingConstants.BOTTOM);
        bankName.setVisible(true);

        bankName.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // CONSTRUCT A HOME VIEWER
            }
        });

        lp.add(bankName);
        lp.add(topBar);
        this.add(lp);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
