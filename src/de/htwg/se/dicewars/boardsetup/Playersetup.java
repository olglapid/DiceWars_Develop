package de.htwg.se.dicewars.boardsetup;


import de.htwg.se.dicewars.model.Player;

public abstract class Playersetup {
	private Playersetup(){
		
	}
	/*Returns a random Player form list*/
	public int getPlayerIndex(int[] playerGet) {
		int index = 0;
		do {
			index = Convertmethods.randomNumber(playerGet.length);
		} while (playerGet[index] == 0);
		return index;
	}
	
	public static void addDicesToPlayer(Player[] listOfPlayer, int index, int amount) {
		int tmp = 0;
		tmp = listOfPlayer[index].getNumberOfDices();
		tmp += amount;
		listOfPlayer[index].setNumberOfDices(tmp);
	}
	
	public void handOutDices(Player player, int length) {
		int numberOfDices = player.getNumberOfDices();
		int ctr = 1;
		int[] index;
		while (numberOfDices > 0) {
			if (ctr > length) {
				ctr = 1;
			}
			index = Convertmethods.fieldNumberToIndex(length, ctr);
			if (Convertmethods.randomNumber(1) == 0 || player.getFieldFromIndex(index[0], index[1]) == null) {
				ctr++;
				continue;
			}

			if (numberOfDices > 7) {
				Dicesetup.getDicesRandom(numberOfDices, 7);
			} else {
				Dicesetup.getDicesRandom(numberOfDices, numberOfDices);
			}

		}
	}
}
