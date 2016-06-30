package de.htwg.se.dicewars.util;


import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.state.Status;

public class Playerhandler {

	private Status status;
	private IPlayer player;
	private int amountOfPlayer;
	public Playerhandler() {
		status=Status.NEW;
		player = null;
		amountOfPlayer=0;
	}
	public void setPlayer(IPlayer player2){
		this.player=player2;
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
	public IPlayer getPlayer(){
		return this.player;
	}
	
	public void updatePlayer(IField iField, IField iField2,Status stat){
		setStatus(Status.NOTHINGTOUPDATE);
		if (stat==Status.ATTACKSUCCESS){
			IField fieldtmp = iField;
			IField neighbourtmp = iField2;
			neighbourtmp.setOwner(fieldtmp.getOwner());
			setStatus(Status.PLAYERUPDATE);
		}
	}
}
