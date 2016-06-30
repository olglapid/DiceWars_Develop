package de.htwg.se.dicewars.model;

import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;

public interface IField {

	/**
	 * Set the Owner of a Field
	 * @param owner
	 */
	public void setOwner(Player owner);
	
	/**
	 * Get the Owner of a Field
	 */
	public Player getOwner();
	
	/**
	 * Set the neighbourhood of a Field
	 * @param nachbar
	 */
	public void setNachbar(Field[] nachbar);
	
	/**
	 * Set coordinate x of a Field
	 * @param x
	 */
	public void setX(int x);
	
	/**
	 * Set coordinate y of a Field
	 * @param y
	 */
	public void setY(int y);
	
	/**
	 * Set Fieldnumber for identification
	 * @param fieldNumber
	 */
	public void setFieldNumber(int fieldNumber);
	
	/**
	 * adds dices, returns the dices which can't be set
	 * @param dices
	 * @return
	 */
	
	public int addNumberOfDices(int dices);
	
	
	/**
	 * Sets amount of dices to Field
	 * @param dices
	 */
	public void setNumberOfDices(int dices);
	
	/**
	 * returns the neighborhood of an field
	 * @return
	 */
	
	public Field[] getNachbar();
	
	/**
	 * Returns x coordinate
	 * @return
	 */
	
	public int getX();
	
	/**
	 * returns y coordinate
	 * @return
	 */
	
	public int getY();
	
	/**
	 * Returns the fieldnumber
	 * @return
	 */
	
	public int getFieldNumber();
	
	/**
	 * returns number of dices a field contains
	 * @return
	 */
	
	public int getNumberOfDices();
	
	/**
	 * rolls dices and returns the sum of all rolled dices
	 * @return
	 */
	
	public int rollTheDice();
	
	
	
	
}
