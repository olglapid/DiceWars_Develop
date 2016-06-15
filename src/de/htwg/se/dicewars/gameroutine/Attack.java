package de.htwg.se.dicewars.gameroutine;

import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.state.Status;

public class Attack {
	private Status status;
	private Field field;
	private Field neighbour;
	public Attack(){
		status=Status.New;
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

	public void checkAttack(Field field, int fieldSize, int attackX, int attackY) {

		int x = attackX - field.getX();
		int y = attackY - field.getY();
		int index = Fieldhandler.getNeighborfromIndex(x, y);

		if (index == -1) {
			setStatus(Status.Invalid_Attack_Neighbour);
			return;
		}

		Field tmp = field.getNachbar()[index];
		
		if (tmp == null) {
			setStatus(Status.Invalid_Attack_Field);
			return;
		}

		if (field.getOwner() == tmp.getOwner()) {
			setStatus(Status.Invalid_Attack_Owner);
			return;
		}

		if (field.getNumberOfDices() <= 1) {
			setStatus(Status.Invalid_Attack_Dices);
			return;
		}

		setStatus(Status.Valid_Attack);

	}

	public void attack(Field field, int fieldSize, int attackX, int attackY) {

		
		int rtdAttack = 0;
		int rtdDefend = 0;

		int index = Fieldhandler.getNeighborfromIndex(attackX - field.getX(), attackY - field.getY());
		Field tmp = field.getNachbar()[index];

		rtdAttack = field.rollTheDice();
		rtdDefend = tmp.rollTheDice();

		if (rtdAttack <= rtdDefend) {
			setStatus(Status.Attack_Failed);
		} else {
			setStatus(Status.Attack_Success);
		}
		setField(field);
		setNeighbour(field.getNachbar()[index]);
	}

	public void attackroutine(Field field, int fieldSize, int attackX, int attackY) {
		if (field == null) {
			setStatus(Status.Invalid_Attack_Field);
		} else {
			checkAttack(field, fieldSize, attackX, attackY);
			if (getStatus() == Status.Valid_Attack) {
				attack(field, fieldSize, attackX, attackY);
			}
		}
	}
}
