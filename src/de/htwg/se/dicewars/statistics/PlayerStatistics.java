package de.htwg.se.dicewars.statistics;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public class PlayerStatistics {
	private int amountOfFieldAttack;
	private int ammountOfFields;
	private int connectedFields;
	private int amountOfDicesStored;
	private Player player;
	private LinkedList<Field> fieldList;
	private LinkedList<Field> fieldListshuffled;
	
	public PlayerStatistics() {
		amountOfDicesStored=0;
		amountOfFieldAttack=0;
		ammountOfFields=0;
		connectedFields=0;
		player=null;
		fieldList = new LinkedList<Field>();
		fieldListshuffled = new LinkedList<Field>();
	}
	public void setAmountOfDicesStored(int nbr){
		this.amountOfDicesStored=nbr;
	}
	public void shuffleList(){
		Collections.shuffle(fieldListshuffled);
	}
	public void removeElemFromLList(int index){
		this.fieldList.remove(index);
	}
	public void addElemToLList(Field field){
		this.fieldList.add(field.getFieldNumber(), field);
		this.fieldListshuffled.add(field);
	}
	public void pushShuffledField(Field field){
		if(field.getNumberOfDices()<8)
			this.fieldListshuffled.add(field);
	}		
	public void setAmountOfFields(int amount){
		this.ammountOfFields=amount;
	}
	public void setAmountOfFieldAttack(int nbr){
		this.amountOfFieldAttack=nbr;
	}
	public void setPlayer(Player player){
		this.player=player;
	}
	public void setConnectedFields(int connected){
		this.connectedFields=connected;
	}
	
	public int getAmountOfFieldAttack(){
		return this.amountOfFieldAttack;
	}
	public int getAmountOffields(){
		return this.ammountOfFields;
	}
	public Player getPlayer(){
		return this.player;
	}
	public int getConnectedFields(){
		return this.connectedFields;
	}

	public int getAmountOfDicesStored(){
		return this.amountOfDicesStored;
	}
	public void Update(){
		Field[][] field=player.getField();
		int connected=0;
		int fields=0;
		connected=Fieldhandler.countConnectedFields(field);
		fields=Fieldhandler.countFields(field);
		setConnectedFields(connected);
		setAmountOfFields(fields);
		
	}
	
}
