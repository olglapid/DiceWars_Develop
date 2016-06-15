package de.htwg.se.dicewars.model;

import java.util.Collections;
import java.util.LinkedList;

import de.htwg.se.dicewars.boardsetup.Convertmethods;

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
	public void setField(Field[][] field){
		this.myFields=field;
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
	
	public void addNumberOfDices(int nbr) {
		this.numberOfDices += nbr;
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

	public Field popShoffled() {
		return this.fieldListshuffled.pop();
	}

	public void shuffleList() {
		Collections.shuffle(fieldListshuffled);
	}

	public void pushShuffledField(Field field) {
		if (field.getNumberOfDices() < 8)
			this.fieldListshuffled.add(field);
	}

	public void initShuffle(Field[][] tmp) {
		Field[][] field = tmp;
		if (field == null)
			field = myFields;
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field.length; y++) {
				if (myFields[x][y] == null)
					continue;
				pushShuffledField(myFields[x][y]);
			}
		}
	}

	public void updateShuffle() {
		fieldListshuffled.clear();
		initShuffle(myFields);
	}

	public void update() {
		int random;
		int tmp=0;
		Field field;

		if(fieldListshuffled.isEmpty())
			return;
		for (int i = 0; i < fieldListshuffled.size(); i++) {
			if (numberOfDices <= 0)
				return;
			field=fieldListshuffled.get(i);
			tmp=field.getNumberOfDices();
			if(tmp == 8)
				continue;
			if(numberOfDices<8)
				random = Convertmethods.randomNumber(numberOfDices+1);
			else {
				random = Convertmethods.randomNumber(7);
			}
			
			numberOfDices = numberOfDices - random;
			tmp=field.addNumberOfDices(random);
			numberOfDices = numberOfDices + tmp;	
		}
		updateShuffle();
		update();
		
		
	}

}
