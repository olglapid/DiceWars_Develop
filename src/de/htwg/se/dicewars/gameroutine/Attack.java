package de.htwg.se.dicewars.gameroutine;

import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.observer.Observable;
import de.htwg.se.dicewars.state.Status;

public class Attack extends Observable{
	private Status status;
	private Field field;
	private Field neighbour;
	public Attack(){
		status=Status.NEW;
		field=null;
		neighbour=null;
	}
	public void setField(Field field){
		this.field=field;
	}
	public void setNeighbour(Field field){
		this.neighbour=field;
	}
	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}

	public Status getStatus() {
		return this.status;
	}
	public Field getNeighbour(){
		return this.neighbour;
	}
	public Field getField(){
		return this.field;
	}

	public void checkAttack(Field field, int attackX, int attackY) {

		int x = attackX - field.getX();
		int y = attackY - field.getY();
		int index = Fieldhandler.getNeighborfromIndex(x, y);

		if (index == -1) {
			setStatus(Status.INVALIDATTACKNEIGHBOR);
			return;
		}

		Field tmp = field.getNachbar()[index];
		
		if (tmp == null) {
			setStatus(Status.INVALIDATTACKFIELD);
			return;
		}

		if (field.getOwner() == tmp.getOwner()) {
			setStatus(Status.INVALIDATTACKOWNER);
			return;
		}

		if (field.getNumberOfDices() <= 1) {
			setStatus(Status.INVALIDATTACKDICES);
			return;
		}

		setStatus(Status.VALIDATTACK);

	}

	public void attack(Field field, int attackX, int attackY) {


		int rtdAttack = 0;
		int rtdDefend = 0;

		int index = Fieldhandler.getNeighborfromIndex(attackX - field.getX(), attackY - field.getY());
		Field tmp = field.getNachbar()[index];

		rtdAttack = field.rollTheDice();
		rtdDefend = tmp.rollTheDice();

		if (rtdAttack <= rtdDefend) {
			setStatus(Status.ATTACKFAILED);
		} else {
			setStatus(Status.ATTACKSUCCESS);
		}
		setField(field);
		setNeighbour(field.getNachbar()[index]);
		
	}

	public void attackroutine(Field field, int attackX, int attackY) {
		if (field == null) {
			setStatus(Status.INVALIDATTACKFIELD);
		} else {
			checkAttack(field, attackX, attackY);
			if (getStatus() == Status.VALIDATTACK) {
				attack(field, attackX, attackY);
			}
		}
		notifyObservers();


	}
}
