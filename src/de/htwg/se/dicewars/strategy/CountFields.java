package de.htwg.se.dicewars.strategy;


import de.htwg.se.dicewars.statistics.Statistics;

public class CountFields implements Strategy{
	public Statistics doOperation(Statistics stats){
		int tmp = stats.getNumberOfFields();
		tmp++;
		stats.setNumberOfFields(tmp);
		return stats;
	}
}
