package de.htwg.se.dicewars.controller.impl;


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

	public void updateDices(Field field, Field neighbour,Status stat) {
		Field fieldtmp = field;
		Field neighbourtmp = neighbour;
		int dices = fieldtmp.getNumberOfDices() - 1;
		if (dices <= 0) {
			setStatus(Status.DiceError0);/* Status setzen */
			return;
		}
		fieldtmp.setNumberOfDices(1);
		if (stat == Status.AttackSuccess)
			neighbourtmp.setNumberOfDices(dices);

	}

	public void updateDices(Player player) {
		player.shuffleList();
		player.update();

	}
}
