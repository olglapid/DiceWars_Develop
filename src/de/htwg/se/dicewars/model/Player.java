package de.htwg.se.dicewars.model;

import java.util.Collections;
import java.util.LinkedList;

public class Player {
	private String name;
	private int numberOfFields;
	private int playerNr;
	private int numberOfDices;
	private Field[][] myFields;
	private LinkedList<Field> fieldListshuffled;
	

	public Player() {
		this.name = null;
		this.playerNr = 0;
		this.numberOfFields = 0;
		this.numberOfDices = 0;
		this.myFields = new Field[0][0];
		this.fieldListshuffled = new LinkedList<Field>();
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
	
	public Field popShoffled(){
		return this.fieldListshuffled.pop();
	}
	public void shuffleList(){
		Collections.shuffle(fieldListshuffled);
	}
	public void pushShuffledField(Field field){
		if(field.getNumberOfDices()<8)
			this.fieldListshuffled.add(field);
	}
	public void updateShuffle(){
		Field field;
		boolean[] tmp;
		int size = this.fieldListshuffled.size();
		tmp=new boolean[size];
		for (int i = 0; i < size; i++) {
			field = this.fieldListshuffled.get(i);
			if(field.getNumberOfDices()==8)
				tmp[i]=true;
		}
		for (int i = 0; i < tmp.length; i++) {
			if(tmp[i]==false)
				continue;
			this.fieldListshuffled.remove(i);
		}
	}
	

}
