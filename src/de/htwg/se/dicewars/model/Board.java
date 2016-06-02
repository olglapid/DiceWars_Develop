package de.htwg.se.dicewars.model;

import de.htwg.se.dicewars.BoardSetup.ConvertMethods;

public class Board {
	private Field[][] brd;
	private int length;
	private int[] owner;
	private boolean[] fieldsExists;

	public Board(int fieldSize) {
		brd = new Field[ConvertMethods.converteFieldSize(fieldSize)][ConvertMethods.converteFieldSize(fieldSize)];
		length = brd.length;
		owner = new int[fieldSize];
		fieldsExists = new boolean[fieldSize];
		for (int i = 0; i < fieldSize; i++) {
			owner[i] = -1;
			fieldsExists[i] = false;
		}
	}

	public void setField(Field[][] field) {
		this.brd = field;
	}

	public void setOwner(int nbr, int index) {
		this.owner[index] = nbr;
	}

	public int getOwner(int index) {
		return this.owner[index];
	}

	public void setExField(int index) {
		this.fieldsExists[index] = true;
	}

	public boolean getExField(int index) {
		return this.fieldsExists[index];
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}

	public Field[][] getField() {
		return this.brd;
	}

}
