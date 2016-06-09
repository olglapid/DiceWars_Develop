package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.dicewars.gameroutine.Attack;
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
	
	public void updatePlayer(Attack attack){
		setStatus(Status.Nothing_To_Update);
		if (attack.getStatus()==Status.Attack_Success){
			Field field = attack.getField();
			Field neighbour = attack.getNeighbour();
			neighbour.setOwner(field.getOwner());
			setStatus(Status.Player_Updated);
		}
	}
}
