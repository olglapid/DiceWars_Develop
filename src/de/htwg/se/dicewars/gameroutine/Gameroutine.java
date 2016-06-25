package de.htwg.se.dicewars.gameroutine;

import de.htwg.se.dicewars.controller.impl.Dicehandler;
import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.controller.impl.Playerhandler;
import de.htwg.se.dicewars.controller.impl.Walktrough;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.observer.Observable;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;
import de.htwg.se.dicewars.strategy.FieldsToAttack;

public class Gameroutine  extends Observable{

	private Status status;
	private Attack attack;
	private Playerhandler playerUpdate;
	private Dicehandler diceUpdate;
	private int playersTurn;

	public Gameroutine() {
		attack = new Attack();
		status = Status.New;
		playerUpdate = new Playerhandler();
		diceUpdate = new Dicehandler();
		playersTurn = -1;
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
	}

	public void setPlayersTurn(int playerNbr) {
		this.playersTurn = playerNbr;
	}

	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}

	public void setPlayerUpdate(Playerhandler playerHandler) {
		this.playerUpdate = playerHandler;
	}

	public void setDiceUdate(Dicehandler diceHandler) {
		this.diceUpdate = diceHandler;
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

	public int getPlayersTurn() {
		return this.playersTurn;
	}

	public Attack getAttack() {
		return this.attack;
	}

	public void endOFTurn(Player player) {
		if (status != Status.End_Turn)
			return;

		int connectedField = Fieldhandler.countConnectedFields(player.getField(), player);
		int tmp = player.getNumberOfDices();
		tmp += connectedField;
		player.setNumberOfDices(tmp);
		player.update();

	}
	
	public void checkEndOfTurn(Player player) {
		Field[][] field = player.getField();
		Statistics stats = new Statistics();
		Context context = new Context(new FieldsToAttack());
		int numberOfFields = field.length * field.length;
		boolean[] visit = new boolean[numberOfFields];

		stats.setPlayer(player);

		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field.length; y++) {
				if (field[x][y] == null || Walktrough.checkVisit(field[x][y], visit))
					continue;

				Walktrough.walkTroughFields(field[x][y], visit, stats, context);
			}
		}
		status = Status.Valid;
		if (stats.getTmp() == 0) {
			status = Status.End_Turn;
		}

	}

	public void routine(Player player, Field agressor, Field defender, int fieldSize) {
		if (agressor.getOwner() != player) {
			setStatus(Status.Invalid_Owner);
			return;
		}

		attack.setField(agressor);
		attack.setNeighbour(defender);
		attack.attackroutine(agressor, fieldSize, defender.getX(), defender.getY());
		status = Status.Failed;
		if (attack.getStatus() == Status.Attack_Failed || attack.getStatus() == Status.Attack_Success) {
			diceUpdate.updateDices(attack.getField(),attack.getNeighbour(),attack.getStatus());
			playerUpdate.updatePlayer(attack.getField(),attack.getNeighbour(),attack.getStatus());
			status = Status.Success;
		}
		

		
		if(status == Status.Failed){
			status = attack.getStatus();
			return;
		}
		status = attack.getStatus();

	}
}
