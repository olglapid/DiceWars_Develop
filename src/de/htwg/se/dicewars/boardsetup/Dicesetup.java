package de.htwg.se.dicewars.boardsetup;

import de.htwg.se.dicewars.model.impl.Field;

public abstract class Dicesetup {
	private Dicesetup(){
		
	}
	public static int addDice(Field field, int amount) {
		int returnDices = 0;
		int tmp = field.getNumberOfDices();
		tmp += amount;
		returnDices = field.addNumberOfDices(tmp);
		return returnDices;
	}

	public static int getDicesRandom(int dices, int value) {
		int random = 0;
		if (dices <= 0)
			return 0;
		do {
			random = Convertmethods.randomNumber(value);
		} while (dices - random < 0);
		return random;
	}

	public static boolean checkDicesAdd(Field field) {
		if (field.getNumberOfDices() > 7) {
			return true;
		}
		return false;
	}
}
