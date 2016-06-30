package de.htwg.se.dicewars.statistics;

import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Field;

public class Statistics {
	private IField[][] board;
	private IField field;
	private IPlayer player;
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


	public void setPlayer(IPlayer player2) {
		this.player = player2;
	}

	public void setField(IField field2) {
		this.field = field2;
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

	public IField getField() {
		return this.field;
	}

	public IPlayer getPlayer() {
		return this.player;
	}

	public void createBoard(int size) {
		this.board = new Field[size][size];
	}

	public void setBoard(IField[][] field) {
		this.board = field;
	}

	public IField[][] getBoard() {
		return this.board;
	}

	public void deleteBoard() {
		int size = board.length;
		board = null;
		createBoard(size);
	}

}
