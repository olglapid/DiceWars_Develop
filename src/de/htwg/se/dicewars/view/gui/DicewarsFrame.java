package de.htwg.se.dicewars.view.gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DicewarsFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Button example");
		frame.setLayout(new FlowLayout());
		Container c = frame.getContentPane();
		c.add(new JButton("Ignore me!"));
		c.add(new JButton("Click me!"));
		
		c.add(new JTextField("Type something! Please!"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 150);
		frame.setVisible(true);


	}
}
