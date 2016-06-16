package de.htwg.se.dicewars;


import de.htwg.se.controller.IController;
import de.htwg.se.dicewars.view.tui.TUI;



public class DiceStart {

	private TUI tui;
	protected IController controller;
	
	private DiceStart() {
		
	}

	public static void main(String[] args) {

		
		
		TUI startTui = new TUI();
		startTui.readData();
		startTui.startGame();
		

	}

}
