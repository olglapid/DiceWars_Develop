package de.htwg.se.dicewars.strategy;


import de.htwg.se.dicewars.statistics.Statistics;

public interface Strategy {
	public Statistics doOperation(Statistics stats);
}
