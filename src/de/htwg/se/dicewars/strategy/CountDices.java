package de.htwg.se.dicewars.strategy;

import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.statistics.Statistics;

public class CountDices implements Strategy {
	public Statistics doOperation(Statistics stats) {
		Field field = stats.getField();
		int tmp;
		if (stats.getPlayer() == null) {
			tmp = stats.getNumberOfDices();
			tmp += field.getNumberOfDices();
			stats.setNumberOfDices(tmp);

		} else {

			if (field.getOwner() == stats.getPlayer()) {
				tmp = stats.getNumberOfDices();
				tmp += field.getNumberOfDices();
				stats.setNumberOfDices(tmp);
			}
		}

		return stats;
	}
}
