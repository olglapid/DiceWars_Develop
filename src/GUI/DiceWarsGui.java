package GUI;

import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class DiceWarsGui extends JFrame {

	public DiceWarsGui() {
		
		FirstLookPanel start = new FirstLookPanel();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		mainPanel.setLayout(new GridLayout(2, 2));
		mainPanel.add(start);
		
		this.setContentPane(mainPanel);

		this.setTitle("DiceWars-Startpanel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DiceWarsGui();
	}
}
