package de.htwg.se.dicewars.command;

import de.htwg.se.dicewars.boardsetup.Dicesetup;
import de.htwg.se.dicewars.model.Field;

public class Method {

	private int dices;
	private Field field;
	private int nbrFields=0;

	public void addDices() {
		dices = Dicesetup.addDice(field, dices);
	}

	public void countFields() {
		nbrFields=nbrFields+1;
	}

	public void setField(Field tmpField) {
		field = tmpField;
	}


	public void setDices(int nbr) {
		dices = nbr;
	}
	public void resetNbrFields(){
		nbrFields=0;
	}
	public int getNbrFields(){
		return this.nbrFields;
	}
}
