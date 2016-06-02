package de.htwg.se.dicewars.BoardSetup;

import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public abstract class DiceSetup {
	public static int addDice(Board board, int x, int y, int amount) {
		Field[][] field = board.getField();
		int returnDices = 0;
		int tmp = field[x][y].getNumberOfDices();
		tmp += amount;
		returnDices = field[x][y].setNumberOfDices(tmp);
		return returnDices;
	}

	public static int getDicesRandom(int dices, int value) {
		int random = 0;
		if (dices == 0)
			return 0;
		do {
			random = ConvertMethods.randomNumber(value);
		} while (dices - random < 0);
		return random;
	}

	public boolean checkDicesAdd(Board board, int x, int y) {
		Field[][] field = board.getField();
		if (field[x][y].getNumberOfDices() > 7) {
			return true;
		}
		return false;
	}
}
