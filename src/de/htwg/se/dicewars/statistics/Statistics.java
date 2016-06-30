package de.htwg.se.dicewars.statistics;

import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;

public class Statistics {
	private Field[][] board;
	private Field field;
	private Player player;
	private int numberOfDices;
	private int numberOfFields;
	private int tmp;
	private int numberOfConnectedFields;


	public Statistics() {

		field = null;
		player = null;
		board = null;
		numberOfDices = 0;
		numberOfFields = 0;
		tmp = 0;
		numberOfConnectedFields = 0;

	}


	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void setNumberOfDices(int nbr) {
		this.numberOfDices = nbr;
	}

	public void setNumberOfFields(int nbr) {
		this.numberOfFields = nbr;
	}

	public void setTmp(int nbr) {
		this.tmp = nbr;
	}

	public void setNumberOfConnectedFields(int nbr) {
		this.numberOfConnectedFields = nbr;
	}

	public int getNumberOfDices() {
		return this.numberOfDices;
	}

	public int getNumberOfFields() {
		return this.numberOfFields;
	}

	public int getTmp() {
		return this.tmp;
	}

	public int getNumberOfConnectedFields() {
		return this.numberOfConnectedFields;
	}

	public Field getField() {
		return this.field;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void createBoard(int size) {
		this.board = new Field[size][size];
	}

	public void setBoard(Field[][] field) {
		this.board = field;
	}

	public Field[][] getBoard() {
		return this.board;
	}

	public void deleteBoard() {
		int size = board.length;
		board = null;
		createBoard(size);
	}

}
