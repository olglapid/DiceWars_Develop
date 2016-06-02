package de.htwg.se.dicewars.BoardSetup;

import de.htwg.se.dicewars.controller.impl.DiceHandler;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Player;

public abstract class PlayerSetup {
	/*Returns a random Player form list*/
	public int getPlayerIndex(int[] playerGet) {
		Board tmp = new Board(5);
		int index = 0;
		do {
			index = ConvertMethods.randomNumber(playerGet.length);
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
		int dices = 0;
		int ctr = 1;
		int[] index;
		while (numberOfDices > 0) {
			if (ctr > length) {
				ctr = 1;
			}
			if (ConvertMethods.randomNumber(1) == 0) {
				ctr++;
				continue;
			}
			index = ConvertMethods.fieldNumberToIndex(length, ctr);

			if (player.getFieldFromIndex(index[0], index[1]) == null) {
				ctr++;
				continue;
			}
			if (numberOfDices > 7) {
				dices = DiceSetup.getDicesRandom(numberOfDices, 7);
			} else {
				dices = DiceSetup.getDicesRandom(numberOfDices, numberOfDices);
			}

		}
	}
}
