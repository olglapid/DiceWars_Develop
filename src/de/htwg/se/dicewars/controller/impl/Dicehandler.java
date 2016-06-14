package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.dicewars.gameroutine.Attack;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;
import de.htwg.se.dicewars.strategy.CountDices;

public class Dicehandler {
	private Status status;

	public Dicehandler() {
		status = Status.New;
	}

	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}

	public Status getStatus() {
		return this.status;
	}

	/* Wenn player = null dann zähle alle und nicht nur die von Player */
	public static int countDices(Field[][] field, Player player) {
		Statistics stats = new Statistics();
		Context context = new Context(new CountDices());
		stats.setPlayer(player);

		int numberOfFields = field.length * field.length;
		boolean[] visit = new boolean[numberOfFields];

		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field.length; y++) {
				if (field[x][y] == null || Walktrough.checkVisit(field[x][y], visit))
					continue;

				Walktrough.walkTroughFields(field[x][y], visit, stats, context);
			}
		}
		return stats.getNumberOfDices();

	}

	public void updateDices(Attack attack) {
		Field field = attack.getField();
		Field neighbour = attack.getNeighbour();
		int dices = field.getNumberOfDices() - 1;
		if (dices <= 0) {
			setStatus(Status.Dice_Error0);/* Status setzen */
			return;
		}
		field.setNumberOfDices(1);
		if (attack.getStatus() == Status.Attack_Success)
			neighbour.setNumberOfDices(dices);

	}

	public void updateDices(Player player) {
		player.shuffleList();
		player.update();

	}
}
