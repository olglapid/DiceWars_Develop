package de.htwg.se.dicewars.boardsetup;


import de.htwg.se.dicewars.model.IPlayer;


public abstract class Playersetup {
	private Playersetup(){
		
	}

	
	public static void addDicesToPlayer(IPlayer[] listOfPlayer, int index, int amount) {
		int tmp = 0;
		tmp = listOfPlayer[index].getNumberOfDices();
		tmp += amount;
		listOfPlayer[index].setNumberOfDices(tmp);
	}
	

}
