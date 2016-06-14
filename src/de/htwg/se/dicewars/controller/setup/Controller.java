package de.htwg.se.dicewars.controller.setup;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Player;


public class Controller {

	private Board board;
	private Player[] playerlist;
	private int numberOfFields;
	private int fieldSize;

	public Controller() {
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

	public void setfieldSize(int tmpFieldSize) {
		this.fieldSize = tmpFieldSize;
	}

	public void setBoard(Board tmpBoard) {
		this.board = tmpBoard;
	}

	public void setPlayerlist(Player[] tmpPlayerList) {
		this.playerlist = tmpPlayerList;
	}

	public void setSinglePlayer(Player player, int index) {
		if (player != null && checkRange(index)) {
			this.playerlist[index] = player;

		}
	}

	public void setNumberOfFields(int tmpNumberOfFields) {
		this.numberOfFields = tmpNumberOfFields;
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

	public int getFieldSize() {
		return this.fieldSize;
	}

	public int getNumberOfFields() {
		return this.numberOfFields;
	}

	public void createBoard(int fieldSize, int numberOfFields) {
		int tmpfieldSize = fieldSize;
		int tmpnumberOfFields = numberOfFields;
		if (tmpfieldSize < tmpnumberOfFields) {
			tmpfieldSize = tmpnumberOfFields;
		}
		Board tmpBoard = new Board();
		tmpBoard = Boardsetup.createField(tmpfieldSize, tmpnumberOfFields);
		setfieldSize(tmpfieldSize);
		setNumberOfFields(tmpnumberOfFields);
		setBoard(tmpBoard);
	}

	public void connectPlayerToBoard(Player[] listOfPlayer) {
		if (this.board != null && this.numberOfFields >= 0 && listOfPlayer != null)
			Boardsetup.playerToField(this.board, listOfPlayer, numberOfFields);
	}
	public void spreadDicesToField(Board board,Player[] listOfPlayer){
		Boardsetup.spreadDices(board, listOfPlayer);
	}
}
