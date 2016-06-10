package GUI;

import javax.swing.*;

@SuppressWarnings("serial")
public class DiceWarsGui extends JFrame {

	public DiceWarsGui() {
		Startmenu menu = new Startmenu();
		ChoosePlayerMenu player = new ChoosePlayerMenu();
		ChooseFieldsMenu fields = new ChooseFieldsMenu();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		this.setJMenuBar(menu);
		mainPanel.add(player);
		mainPanel.add(fields);
		
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
