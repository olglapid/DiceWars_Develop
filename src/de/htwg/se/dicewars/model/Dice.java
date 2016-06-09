package de.htwg.se.dicewars.model;

import de.htwg.se.dicewars.boardsetup.Convertmethods;

/*Noch einzubauen*/
public class Dice {
	private int sides;

	public Dice() {
		sides = 6;
	}

	public void setSides(int side) {
		this.sides = side;
	}

	public int getSides() {
		return this.sides;
	}

	public int rollTheDice() {
		int result;
		result = Convertmethods.randomNumber(sides);
		result++;
		return result;
	}

}
