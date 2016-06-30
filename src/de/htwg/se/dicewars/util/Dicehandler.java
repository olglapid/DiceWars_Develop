package de.htwg.se.dicewars.util;


import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;
import de.htwg.se.dicewars.strategy.CountDices;

public class Dicehandler {
	private Status status;

	public Dicehandler() {
		status = Status.NEW;
	}

	public void setStatus(Status tmpMessege) {
		this.status = tmpMessege;
	}

	public Status getStatus() {
		return this.status;
	}

	
	/* Wenn player = null dann zähle alle und nicht nur die von Player */
	public static int countDices(IField[][] iFields, IPlayer player1) {
		Statistics stats = new Statistics();
		Context context = new Context(new CountDices());
		stats.setPlayer(player1);

		int numberOfFields = iFields.length * iFields.length;
		boolean[] visit = new boolean[numberOfFields];

		for (int x = 0; x < iFields.length; x++) {
			for (int y = 0; y < iFields.length; y++) {
				if (iFields[x][y] == null || Walktrough.checkVisit(iFields[x][y], visit))
					continue;

				Walktrough.walkTroughFields(iFields[x][y], visit, stats, context);
			}
		}
		return stats.getNumberOfDices();

	}

	public void updateDices(IField iField, IField iField2,Status stat) {
		IField fieldtmp = iField;
		IField neighbourtmp = iField2;
		int dices = fieldtmp.getNumberOfDices() - 1;
		if (dices <= 0) {
			setStatus(Status.DICEERROR);/* Status setzen */
			return;
		}
		fieldtmp.setNumberOfDices(1);
		if (stat == Status.ATTACKSUCCESS)
			neighbourtmp.setNumberOfDices(dices);

	}

	public void updateDices(IPlayer player1) {
		player1.shuffleList();
		player1.update();

	}
}
