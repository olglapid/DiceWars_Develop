package de.htwg.se.dicewars;

public class Player {
	private String name;
	private int numberOfFields;
	private int playerNr;
	private int numberOfDices;

	public Player() {
		this.name = null;
		this.playerNr = 0;
		this.numberOfFields = 0;
		this.numberOfDices = 0;
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
	
	public String getName(){
		return this.name;
	}
	
	public int getNumberOfFields(){
		return this.numberOfFields;
	}
	
	public int getPlayerNr(){
		return this.playerNr;
	}
	
	public int getNumberOfDices(){
		return this.numberOfDices;
	}
}
