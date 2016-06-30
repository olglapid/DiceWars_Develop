package de.htwg.se.dicewars.model.impl;

import java.util.Random;

import de.htwg.se.dicewars.model.IDice;

public class Dice implements IDice{
	private int sides;

	public Dice() {
		sides = 6;
	}

	@Override
	public void setSides(int side) {
		this.sides = side;
	}

	@Override
	public int getSides() {
		return this.sides;
	}

	@Override
	public int rollTheDice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}

}
