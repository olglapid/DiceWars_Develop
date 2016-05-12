package de.htwg.se.dicewars;

public class Field {
	private Field[] nachbar = null;
	private int x;
	private int y;
	private int fieldNumber;
	private int numberOfDices;
	private Player owner;

	public Field() {
		x = 0;
		y = 0;
		numberOfDices = 0;
		fieldNumber = 0;
		owner = null;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return this.owner;
	}

	public void setNachbar(Field[] nachbar) {
		this.nachbar = nachbar;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public void setNumberOfDices(int dices) {
		this.numberOfDices = dices;
	}

	public Field[] getNachbar() {
		return this.nachbar;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getFieldNumber() {
		return this.fieldNumber;
	}

	public int getNumberOfDices() {
		return this.numberOfDices;
	}

}
