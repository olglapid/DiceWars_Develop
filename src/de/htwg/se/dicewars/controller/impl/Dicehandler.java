package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.dicewars.gameroutine.Attack;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.state.Status;

public class Dicehandler {
	private Status status;

	public Dicehandler(){
		status=Status.New;
	}
	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}

	public Status getStatus() {
		return this.status;
	}

	public void updateDices(Attack attack){
		Field field=attack.getField();
		Field neighbour=attack.getNeighbour();
		int dices=field.getNumberOfDices()-1;
		if(dices<=0){
			setStatus(Status.Dice_Error0);/*Status setzen*/
			return;
		}
		field.setNumberOfDices(1);
		if(attack.getStatus()==Status.Attack_Success)
			neighbour.setNumberOfDices(dices);
		
	}
}
