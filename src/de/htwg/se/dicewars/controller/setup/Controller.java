package de.htwg.se.dicewars.controller.setup;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class Controller {

	private Board board;
	private Player[] playerlist;
	private int numberOfFields;
	private int fieldSize;
	private Gameroutine gameroutine;
	private Status status;
	private int attack;
	private int defend;

	public Controller() {
		board = null;
		playerlist = null;
		numberOfFields = 0;
		fieldSize = 0;
		status = Status.New;
		gameroutine = new Gameroutine();
		attack = -1;
		defend = -1;
	}

	private boolean checkRange(int index) {
		if (index > 0 && index < playerlist.length)
			return true;
		return false;
	}

	public void setAttack(int attack){
		this.attack=attack;
	}
	
	public void setDefend(int defend){
		this.defend=defend;
	}
	
	public Status getStatus(){
		return this.status;
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

	public void spreadDicesToField(Board board, Player[] listOfPlayer) {
		Boardsetup.spreadDices(board, listOfPlayer);
	}
	
	public void init (){
		int dices = numberOfFields/playerlist.length;
		for (int i = 0; i < playerlist.length; i++) {
			playerlist[i].initShuffle(null);
			playerlist[i].setNumberOfDices(dices);
			playerlist[i].update();
			System.out.println(playerlist[i].getNumberOfDices());
		}
	}

	public void startGame() {
		if (status == Status.New) {
			gameroutine.setPlayersTurn(0);
			fieldSize = board.getLength();
		}

		if (attack < 0 || defend < 0) {
			status = Status.Choose_Aktion;
			return;
		}
		int playersTurn = gameroutine.getPlayersTurn();
		Field[][] field = board.getField();

		int index[] = Convertmethods.fieldNumberToIndex(fieldSize, attack);
		Field attackfield = field[index[0]][index[1]];
		index = Convertmethods.fieldNumberToIndex(fieldSize, defend);
		Field defendfield = field[index[0]][index[1]];

		System.out.println(playersTurn);
		gameroutine.routine(playerlist[playersTurn], attackfield, defendfield, fieldSize);
		attack = -1;
		defend = -1;
		if (gameroutine.getStatus() != Status.Success){
			status = gameroutine.getStatus();
			return;
		}
		gameroutine.checkEndOfTurn(playerlist[playersTurn]);

		if (gameroutine.getStatus() == Status.End_Turn) {
			int numberOfFields = Fieldhandler.countConnectedFields(playerlist[playersTurn].getField(),
					playerlist[playersTurn]);
			playerlist[playersTurn].addNumberOfDices(numberOfFields);
			playerlist[playersTurn].update();

			if (gameroutine.getPlayersTurn() == playerlist.length - 1) {
				gameroutine.setPlayersTurn(0);
			}
		}

	}
}
