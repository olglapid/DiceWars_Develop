package de.htwg.se.dicewars.model.impl;


public class Board {
	private Field[][] brd;
	private int length;

	public Board() {
		brd = null;
		length = 0;
	}

	public void setField(Field[][] field) {
		this.brd = field;
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
