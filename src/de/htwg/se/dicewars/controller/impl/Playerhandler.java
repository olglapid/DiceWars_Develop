package de.htwg.se.dicewars.controller.impl;


import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class Playerhandler {

	private Status status;
	private Player player;
	private int amountOfPlayer;
	public Playerhandler() {
		status=Status.New;
		player = null;
		amountOfPlayer=0;
	}
	public void setPlayer(Player player){
		this.player=player;
	}
	public void setAmountOfPlayer(int nbr){
		this.amountOfPlayer=nbr;
	}
	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}

	public Status getStatus() {
		return this.status;
	}
	public int getAmountOfPlayer(){
		return this.amountOfPlayer;
	}
	public Player getPlayer(){
		return this.player;
	}
	
	public void updatePlayer(Field field, Field neighbour,Status stat){
		setStatus(Status.NothingToUpdate);
		if (stat==Status.AttackSuccess){
			Field fieldtmp = field;
			Field neighbourtmp = neighbour;
			neighbourtmp.setOwner(fieldtmp.getOwner());
			setStatus(Status.PlayerUpdated);
		}
	}
}
