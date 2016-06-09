package de.htwg.se.dicewars.statistics;


import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public class PlayerStatistics {
	private int amountOfFieldAttack;
	private int ammountOfFields;
	private int connectedFields;
	private Player player;
	
	public PlayerStatistics() {
		amountOfFieldAttack=0;
		ammountOfFields=0;
		connectedFields=0;
		player=null;
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
