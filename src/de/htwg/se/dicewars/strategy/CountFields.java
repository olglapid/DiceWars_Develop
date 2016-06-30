package de.htwg.se.dicewars.strategy;

import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.statistics.Statistics;

public class CountFields implements Strategy {
	@Override
	public Statistics doOperation(Statistics stats) {
		IField field = stats.getField();
		IPlayer player = stats.getPlayer();
		int tmp = stats.getNumberOfFields();

		if (player == null) {
			tmp = stats.getNumberOfFields();
			tmp++;
			stats.setNumberOfFields(tmp);
			return stats;
		}
		if (field.getOwner() == player) {
			IField[] neighbour = field.getNachbar();
			for (int i = 0; i < neighbour.length; i++) {
				if (neighbour[i] != null && neighbour[i].getOwner() == player) {
					tmp = stats.getNumberOfFields();
					tmp++;
					stats.setNumberOfFields(tmp);
					return stats;
				}
			}

		}
		return stats;
	}
}
