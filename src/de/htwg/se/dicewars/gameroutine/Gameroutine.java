package de.htwg.se.dicewars.gameroutine;

import de.htwg.se.dicewars.controller.impl.Dicehandler;
import de.htwg.se.dicewars.controller.impl.Playerhandler;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class Gameroutine {

	private Status status;
	private Attack attack;
	private Playerhandler playerUpdate;
	private Dicehandler diceUpdate;
	private int playersTurn;

	public Gameroutine() {
		status = Status.New;
		playerUpdate = new Playerhandler();
		diceUpdate = new Dicehandler();
		playersTurn=-1;
	}

	public void setPlayersTurn(int playerNbr){
		this.playersTurn=playerNbr;
	}
	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}
	
	public void setPlayerUpdate(Playerhandler playerHandler){
		this.playerUpdate=playerHandler;
	}
	
	public void setDiceUdate(Dicehandler diceHandler){
		this.diceUpdate=diceHandler;
	}

	public Status getStatus() {
		return this.status;
	}

	public Dicehandler getDiceUpdate() {
		return this.diceUpdate;
	}

	public Playerhandler getPlayerUpdate() {
		return this.playerUpdate;
	}
	public int getPlayersTurn(){
		return this.playersTurn;
	}

	public void routine(Player player, Field field, int attackX, int attackY) {
		if(player.getPlayerNr()<getPlayersTurn()){
			setStatus(Status.PlayersTurn_Error);
			return;
		}
//		if(){
//			
//		}
	}
}
