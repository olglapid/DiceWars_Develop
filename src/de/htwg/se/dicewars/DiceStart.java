package de.htwg.se.dicewars;


import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.view.gui.DicewarsFrame;
import de.htwg.se.dicewars.view.tui.TUI;




public class DiceStart {

	protected IController controller;
	
	private DiceStart() {
		
	}

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		TUI startTui = new TUI(controller);
		DicewarsFrame diceframe = new DicewarsFrame(controller);
		diceframe.setVisible(true);
		startTui.readData();
		startTui.startGame();
		

	}
	
	

}
