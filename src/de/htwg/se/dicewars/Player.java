package de.htwg.se.dicewars;

public class Player {
	private String name;
	private int numberOfFields;
	private int playerNr;
	private int numberOfDices;
	private Field[][] myFields;

	public Player() {
		this.name = null;
		this.playerNr = 0;
		this.numberOfFields = 0;
		this.numberOfDices = 0;
		this.myFields = new Field[0][0];
	}

	public void createField(int size) {
		this.myFields = new Field[size][size];
	}

	public Field getFieldFromIndex(int x, int y) {
		if (x > this.myFields.length || y > this.myFields.length || x < 0 || y < 0) {
			return null;
		}
		return this.myFields[x][y];
	}

	public void setFieldFromIndex(Field field) {
		this.myFields[field.getX()][field.getY()] = field;
	}

	public Field[][] getField() {
		return this.myFields;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfFields(int numberOfFields) {
		this.numberOfFields = numberOfFields;
	}

	public void setPlayerNr(int nbr) {
		this.playerNr = nbr;
	}

	public void setNumberOfDices(int nbr) {
		this.numberOfDices = nbr;
	}

	public String getName() {
		return this.name;
	}

	public int getNumberOfFields() {
		return this.numberOfFields;
	}

	public int getPlayerNr() {
		return this.playerNr;
	}

	public int getNumberOfDices() {
		return this.numberOfDices;
	}

//	public int numberOfConnectedFields() {
//		static boolean[] tmp = new boolean[myFields.length];
//	}
}
