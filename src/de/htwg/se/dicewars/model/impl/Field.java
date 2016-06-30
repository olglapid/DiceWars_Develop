package de.htwg.se.dicewars.model.impl;

import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;

public class Field implements IField{
	private IField[] nachbar = null;
	private int x;
	private int y;
	private int fieldNumber;
	private int numberOfDices;
	private IPlayer owner;

	public Field() {
		x = 0;
		y = 0;
		numberOfDices = 0;
		fieldNumber = 0;
		owner = null;
	}
	
	@Override
	public void setOwner(IPlayer owner) {
		this.owner = owner;
	}

	@Override
	public IPlayer getOwner() {
		return this.owner;
	}

	@Override
	public void setNachbar(IField[] nachbar) {
		this.nachbar = nachbar;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	@Override
	public int addNumberOfDices(int dices) {
		int returnDices = 0;
		int tmp = this.numberOfDices;
		int set = tmp + dices;
		if (tmp + dices > 8) {
			returnDices = tmp + dices - 8;
			set = 8;
		}
		this.numberOfDices = set;
		return returnDices;
	}

	@Override
	public void setNumberOfDices(int dices) {
		this.numberOfDices = dices;

	}

	@Override
	public IField[] getNachbar() {
		return this.nachbar;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public int getFieldNumber() {
		return this.fieldNumber;
	}

	@Override
	public int getNumberOfDices() {
		return this.numberOfDices;
	}
	
	@Override
	public int rollTheDice(){
		Dice dice = new Dice();
		int returnValue=0;
		for (int i = 0; i < numberOfDices; i++) {
			
			returnValue+=dice.rollTheDice();
		}
		return returnValue;
		
	}


}
