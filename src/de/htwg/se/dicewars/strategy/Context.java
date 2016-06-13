package de.htwg.se.dicewars.strategy;

import de.htwg.se.dicewars.statistics.Statistics;

public class Context {
	private Strategy strategy;
	public Context(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public Statistics executeStrategy(Statistics stats){
	      return strategy.doOperation(stats);
	   }
}
