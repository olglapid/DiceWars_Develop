package de.htwg.se.dicewars.util;


import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.state.Status;

public class Playerhandler {

	private Status status;
	private Player player;
	private int amountOfPlayer;
	public Playerhandler() {
		status=Status.NEW;
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
		setStatus(Status.NOTHINGTOUPDATE);
		if (stat==Status.ATTACKSUCCESS){
			Field fieldtmp = field;
			Field neighbourtmp = neighbour;
			neighbourtmp.setOwner(fieldtmp.getOwner());
			setStatus(Status.PLAYERUPDATE);
		}
	}
}
