package de.htwg.se.dicewars.view.gui;

import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(800,600);
		JPanel panel = new JPanel();
		JButton button = new JButton("drück mich du huso");
		button.setBounds(300,110,100,30);
		panel.add(button);
		frame.setContentPane(panel);
		
		frame.setVisible( true );

	}

}
