package de.htwg.se.dicewars.model;

public interface IDice {

	/**
	 * Set the sides of a dice
	 * @param side
	 */
	public void setSides(int side);
	
	/**
	 * returns the sides of a dice
	 * @return
	 */
	public int getSides();
	
	/**
	 * roll the dice
	 * @return
	 */
	public int rollTheDice();
}
