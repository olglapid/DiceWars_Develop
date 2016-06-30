package de.htwg.se.dicewars.model.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;



public class Player implements IPlayer{
	private String name;
	private int numberOfFields;
	private int playerNr;
	private int numberOfDices;
	private IField[][] myFields;
	private LinkedList<IField> fieldListshuffled;

	public Player() {
		this.name = null;
		this.playerNr = 0;
		this.numberOfFields = 0;
		this.numberOfDices = 0;
		this.myFields = new Field[0][0];
		this.fieldListshuffled = new LinkedList<IField>();
	}

	public void createField(int size) {
		this.myFields = new Field[size][size];
	}

	public IField getFieldFromIndex(int x, int y) {
		if (x > this.myFields.length || y > this.myFields.length || x < 0 || y < 0) {
			return null;
		}
		return this.myFields[x][y];
	}
	public void setField(IField[][] field){
		this.myFields=field;
	}
	
	public void setFieldFromIndex(IField field) {
		this.myFields[field.getX()][field.getY()] = field;
	}

	public IField[][] getField() {
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

	public IField popShoffled() {
		return this.fieldListshuffled.pop();
	}

	public void shuffleList() {
		Collections.shuffle(fieldListshuffled);
	}

	public void pushShuffledField(IField field) {
		if (field.getNumberOfDices() < 8)
			this.fieldListshuffled.add(field);
	}

	public void initShuffle(IField[][] tmp) {
		IField[][] field = tmp;
		if (field == null)
			field = myFields;
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field.length; y++) {
				if (myFields[x][y] == null)
					continue;
				pushShuffledField(myFields[x][y]);
			}
		}
		shuffleList();
	}

	public void updateShuffle() {
		fieldListshuffled.clear();
		initShuffle(myFields);
	}

	public void update() {
		Random r = new Random();
		int random;
		int tmp=0;
		IField field;

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
				random = r.nextInt(numberOfDices+1);
			else {
				random = r.nextInt(7);
			}
			
			numberOfDices = numberOfDices - random;
			tmp=field.addNumberOfDices(random);
			numberOfDices = numberOfDices + tmp;	
		}
		updateShuffle();
		update();
		
		
	}

}
