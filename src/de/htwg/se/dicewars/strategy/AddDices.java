package de.htwg.se.dicewars.strategy;


import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.statistics.PlayerStatistics;
import de.htwg.se.dicewars.statistics.Statistics;

public class AddDices implements Strategy{
	public Statistics doOperation(Statistics stats){
		int dices=stats.getDicesToAdd();
		int dicesRet=0;
		Field[][] field = stats.getBoard();
		Player player = stats.getPlayer();
		
		
		
//		dicesRet=field.addNumberOfDices(dices);
//		field.setNumberOfDices(dicesRet);
		return stats;
	}
}
