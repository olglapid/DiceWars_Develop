package de.htwg.se.dicewars.model;

import java.util.Random;

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
		Random r = new Random();
		return r.nextInt(6) + 1;
	}

}
