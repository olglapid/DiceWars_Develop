package de.htwg.se.dicewars.controller.setup;

import de.htwg.se.dicewars.BoardSetup.BoardSetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.view.TUI;

public class Controller {

	private TUI console;
	private Board board;
	private Player[] playerlist;
	private int numberOfFields;
	private int fieldSize;

	public Controller() {
		console = null;
		board = null;
		playerlist = null;
		numberOfFields = 0;
		fieldSize = 0;
	}

	private boolean checkRange(int index) {
		if (index > 0 && index < playerlist.length)
			return true;
		return false;
	}

	public void setfieldSize(int tmpFieldSize){
		this.fieldSize=tmpFieldSize;
	}
	
	public void setTUI(TUI tmpConsole) {
		this.console = tmpConsole;
	}

	public void setBoard(Board tmpBoard) {
		this.board = tmpBoard;
	}

	public void setPlayerlist(Player[] tmpPlayerList) {

	}

	public void setSinglePlayer(Player player, int index) {
		if (player != null) {
			if (checkRange(index)) {
				this.playerlist[index] = player;
			}
		}
	}
	
	public void setNumberOfFields(int tmpNumberOfFields){
		this.numberOfFields=tmpNumberOfFields;
	}

	public Board getBoard() {
		return this.board;
	}

	public Player[] getPlayerlist() {
		return this.playerlist;
	}

	public Player getSinglePlayer(int index) {
		if (checkRange(index))
			return this.playerlist[index];
		return null;
	}

	public TUI getTUI() {
		return this.console;
	}
	
	public int getFieldSize(){
		return this.fieldSize;
	}
	
	public int getNumberOfFields(){
		return this.numberOfFields;
	}

	public void createBoard(int fieldSize, int numberOfFields) {

		if (fieldSize < numberOfFields) {
			fieldSize = numberOfFields;
		}
		Board tmpBoard = new Board();
		tmpBoard = BoardSetup.createField(fieldSize, numberOfFields);
		setBoard(tmpBoard);
	}

	public void connectPlayerToBoard(Player[] listOfPlayer) {
		if (this.board != null && this.numberOfFields >= 0 && listOfPlayer != null)
			BoardSetup.playerToField(this.board, listOfPlayer, numberOfFields);
	}
}
