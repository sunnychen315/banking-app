package edu.sjsu.assets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class StylishButton extends JButton{
	
	public StylishButton(String text) {
		super(text);
		this.setBackground(Color.WHITE);
		this.setFont(new Font("Sans Serif", Font.PLAIN, 15));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		this.setPreferredSize(new Dimension(230, 30));
		this.setFocusable(false);
	}
}
