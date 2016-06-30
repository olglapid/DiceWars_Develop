package de.htwg.se.dicewars.model.impl;

import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;

public class Board implements IBoard {
	private IField[][] brd;
	private int length;

	public Board() {
		brd = null;
		length = 0;
	}

	public void setField(IField[][] field) {
		this.brd = field;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}

	public IField[][] getField() {
		return this.brd;
	}

}
