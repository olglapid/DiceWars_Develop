package de.htwg.se.dicewars.gameroutine;

import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.observer.Observable;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;
import de.htwg.se.dicewars.strategy.FieldsToAttack;
import de.htwg.se.dicewars.util.Dicehandler;
import de.htwg.se.dicewars.util.Fieldhandler;
import de.htwg.se.dicewars.util.Playerhandler;
import de.htwg.se.dicewars.util.Walktrough;

public class Gameroutine  extends Observable{

	private Status status;
	private Attack attack;
	private Playerhandler playerUpdate;
	private Dicehandler diceUpdate;
	private int playersTurn;

	public Gameroutine() {
		attack = new Attack();
		status = Status.NEW;
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

	public void endOFTurn(IPlayer player) {
		if (status != Status.ENDTURN)
			return;

		int connectedField = Fieldhandler.countConnectedFields(player.getField(), player);
		int tmp = player.getNumberOfDices();
		tmp += connectedField;
		player.setNumberOfDices(tmp);
		player.update();

	}
	
	public void checkEndOfTurn(IPlayer player) {
		IField[][] field = player.getField();
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
		status = Status.VALID;
		if (stats.getTmp() == 0) {
			status = Status.ENDTURN;
		}

	}

	public void routine(IPlayer playerlist, IField attackfield, IField defendfield, int fieldSize) {
		if (attackfield.getOwner() != playerlist) {
			setStatus(Status.INVALIDOWNER);
			return;
		}

		attack.setField(attackfield);
		attack.setNeighbour(defendfield);
		attack.attackroutine(attackfield, defendfield.getX(), defendfield.getY());
		status = Status.FAILED;
		if (attack.getStatus() == Status.ATTACKFAILED || attack.getStatus() == Status.ATTACKSUCCESS) {
			diceUpdate.updateDices(attack.getField(),attack.getNeighbour(),attack.getStatus());
			playerUpdate.updatePlayer(attack.getField(),attack.getNeighbour(),attack.getStatus());
			status = Status.SUCCESS;
		}
		

		
		if(status == Status.FAILED){
			status = attack.getStatus();
			return;
		}
		status = attack.getStatus();

	}
}
