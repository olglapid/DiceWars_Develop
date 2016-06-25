package de.htwg.se.dicewars;


import GUI.DiceWarsGui;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.view.gui.DicewarsFrame;
import de.htwg.se.dicewars.view.tui.TUI;




public class DiceStart {

	private TUI tui;
	protected IController controller;
	
	private DiceStart() {
		
	}

	public static void main(String[] args) {

		for (int i = 1; i < 49; i++) {
			System.out.println(i);
		}
		
		Controller controller = new Controller();
		
		TUI startTui = new TUI(controller);
		DicewarsFrame diceframe = new DicewarsFrame(controller);
		diceframe.setVisible(true);
		startTui.readData();
		startTui.startGame();
		

	}
	
	

}
