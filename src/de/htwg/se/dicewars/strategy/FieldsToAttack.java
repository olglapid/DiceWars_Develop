package de.htwg.se.dicewars.strategy;

import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;

import de.htwg.se.dicewars.statistics.Statistics;

public class FieldsToAttack implements Strategy {
	@Override
	public Statistics doOperation(Statistics stats) {
		IPlayer player = stats.getPlayer();
		IField field = stats.getField();
		IField[] nachbar = field.getNachbar();
		int number = stats.getTmp();
		if (player != field.getOwner() || field.getNumberOfDices() < 2) {
			return stats;
		}

		for (int i = 0; i < nachbar.length; i++) {
			if (nachbar[i] == null || nachbar[i].getOwner() == player) {
				continue;
			}

			number++;
		}
		
		stats.setTmp(number);
		return stats;
	}
}
