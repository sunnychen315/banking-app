package edu.sjsu.view;

import javax.swing.*;
import java.awt.*;

public class TopBar implements Icon {
    int x;
    int y;
    int width;
    int height;

    public TopBar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle rect = new Rectangle(x, y, width, height);
        g2.setColor(new Color(160, 212, 226));
        g2.draw(rect);
        g2.fill(rect);
    }

    public int getIconWidth() {
        return width;
    }

    public int getIconHeight() {
        return height;
    }
}
