package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.controller.IController;
import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.observer.Observable;

public class Controller extends Observable implements IController {

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

	@Override
	public int getAttack() {
		return this.attack;
	}

	@Override
	public int getDefend() {
		return this.defend;
	}

	@Override
	public void setGameroutine(Gameroutine gameroutine) {
		this.gameroutine = gameroutine;
	}

	@Override
	public Gameroutine getGameroutine() {
		return this.gameroutine;
	}

	@Override
	public boolean checkRange(int index) {
		if (index > 0 && index < playerlist.length)
			return true;
		return false;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void setDefend(int defend) {
		this.defend = defend;
	}

	@Override
	public Status getStatus() {
		return this.status;
	}

	@Override
	public void setfieldSize(int tmpFieldSize) {
		this.fieldSize = tmpFieldSize;
	}

	@Override
	public void setBoard(Board tmpBoard) {
		this.board = tmpBoard;
	}

	@Override
	public void setPlayerlist(Player[] tmpPlayerList) {
		this.playerlist = tmpPlayerList;
	}

	@Override
	public void setSinglePlayer(Player player, int index) {
		if (player != null && checkRange(index)) {
			this.playerlist[index] = player;

		}
	}

	@Override
	public void setNumberOfFields(int tmpNumberOfFields) {
		this.numberOfFields = tmpNumberOfFields;
	}

	@Override
	public Board getBoard() {
		return this.board;
	}

	@Override
	public Player[] getPlayerlist() {
		return this.playerlist;
	}

	@Override
	public Player getSinglePlayer(int index) {
		if (checkRange(index))
			return this.playerlist[index];
		return null;
	}

	@Override
	public int getFieldSize() {
		return this.fieldSize;
	}

	@Override
	public int getNumberOfFields() {
		return this.numberOfFields;
	}

	@Override
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

	@Override
	public void connectPlayerToBoard(Player[] listOfPlayer) {
		if (this.board != null && this.numberOfFields >= 0 && listOfPlayer != null)
			Boardsetup.playerToField(this.board, listOfPlayer, numberOfFields);
	}

	@Override
	public void spreadDicesToField(Board board, Player[] listOfPlayer) {
		Boardsetup.spreadDices(board, listOfPlayer);
		notifyObservers();
	}

	@Override
	public void init() {
		int dices = numberOfFields / playerlist.length;
		for (int i = 0; i < playerlist.length; i++) {
			playerlist[i].initShuffle(null);
			playerlist[i].setNumberOfDices(dices);
			playerlist[i].update();
			notifyObservers();
		}
	}

	@Override
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

		int[] index = Convertmethods.fieldNumberToIndex(fieldSize, attack);
		Field attackfield = field[index[0]][index[1]];
		index = Convertmethods.fieldNumberToIndex(fieldSize, defend);
		Field defendfield = field[index[0]][index[1]];

		gameroutine.routine(playerlist[playersTurn], attackfield, defendfield, fieldSize);
		attack = -1;
		defend = -1;
		if (gameroutine.getStatus() != Status.Success) {
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
		notifyObservers();
	}

}