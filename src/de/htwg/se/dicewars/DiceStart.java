package de.htwg.se.dicewars;


import de.htwg.se.dicewars.view.tui.TUI;



public class DiceStart {

	private DiceStart() {

	}

	public static void main(String[] args) {

		TUI startTui = new TUI();
		startTui.readData();
		startTui.startGame();
		

	}

}
