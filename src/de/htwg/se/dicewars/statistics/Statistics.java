package de.htwg.se.dicewars.statistics;

import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public class Statistics {
	private Field[][] board;
	private Field field;
	private Player player;
	private int dicesToAdd;
	private int numberOfDices;
	private int numberOfFields;
	private int numberOfAttackableFields;
	private int numberOfConnectedFields;
	private int nbrOBConnectedFields;

	public Statistics() {
		nbrOBConnectedFields=0;
		dicesToAdd = 0;
		field = null;
		player=null;
		board = null;
		numberOfDices = 0;
		numberOfFields = 0;
		numberOfAttackableFields = 0;
		numberOfConnectedFields = 0;

		
	}
	public void setNbrOfBiggestConnectedField(int nbr){
		this.nbrOBConnectedFields=nbr;
	}
	public void setPlayer(Player player){
		this.player=player;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public void setNumberOfDices(int nbr) {
		this.numberOfDices = nbr;
	}

	public void setNumberOfFields(int nbr) {
		this.numberOfFields = nbr;
	}

	public void setNumberOfAttackableFields(int nbr) {
		this.numberOfAttackableFields = nbr;
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

	public int getNumberOfAttackableFields() {
		return this.numberOfAttackableFields;
	}

	public int getNumberOfConnectedFields() {
		return this.numberOfConnectedFields;
	}

	public Field getField() {
		return this.field;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	



}
