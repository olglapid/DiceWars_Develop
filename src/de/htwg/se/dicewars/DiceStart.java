package de.htwg.se.dicewars;

import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.view.gui.DicewarsFrame;
import de.htwg.se.dicewars.view.tui.TUI;

public class DiceStart {

	protected IController controller;
	protected static TUI tui;
	private static DiceStart instance = null;
	private static DicewarsFrame diceframe;

	private DiceStart() {
		IController controller = new Controller();

		tui = new TUI(controller);
		diceframe = new DicewarsFrame(controller);
		
	}

	public static DiceStart getInstance() {

		if (instance == null) {
			instance = new DiceStart();
		}
		return instance;
	}
	public IController getController(){
		return controller;
	}
	public TUI getTui(){
		return tui;
	}
	public DicewarsFrame getDicewarsFrame(){
		return diceframe;
	}

	public static void main(String[] args) {

		DiceStart game = DiceStart.getInstance();
		

		if (args.length == 0) {
			game.getDicewarsFrame().setVisible(true);
			game.getTui().readData();
			game.getTui().startGame();
		}
		else {
			for(String input: args){
				game.getTui().addConsole(input);
			}
		}

	}

}
