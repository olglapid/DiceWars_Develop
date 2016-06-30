package de.htwg.se.dicewars.model;


public interface IBoard {

	/**
	 * Sets an array of Fields
	 * @param field
	 */
	public void setField(IField[][] field);
	
	/**
	 * sets the length
	 * @param length
	 */
	public void setLength(int length);
	
	/**
	 * returns the length
	 * @return
	 */
	public int getLength();
	
	/**
	 * returns the Field
	 * @return
	 */
	public IField[][] getField();
	
}
