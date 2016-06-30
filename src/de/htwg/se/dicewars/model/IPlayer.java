package de.htwg.se.dicewars.model;


public interface IPlayer {

	/**
	 * Creates an empty Array of Fields for Player
	 * @param size
	 */
	public void createField(int size);
	
	/**
	 * returns a Field from the array a Player owns
	 * @param x
	 * @param y
	 * @return
	 */
	public IField getFieldFromIndex(int x, int y);
	
	/**
	 * Sets a array of Fields
	 * @param field
	 */
	public void setField(IField[][] field);
	
	/**
	 * Sets a Array of Fields
	 * @param field
	 */
	public void setFieldFromIndex(IField field);
	
	/**
	 * Returns the array of fields a player owns
	 * @return
	 */
	public IField[][] getField();
	
	/**
	 * sets the name of a player
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * Sets the total amount of Fields a player owns
	 * @param numberOfFields
	 */
	public void setNumberOfFields(int numberOfFields);
	
	/**
	 * set player number for identification
	 * @param nbr
	 */
	public void setPlayerNr(int nbr);
	
	/**
	 * Set number of Dices 
	 * needed to spread dices to the fields
	 * @param nbr
	 */
	public void setNumberOfDices(int nbr);
	
	/**
	 * adds number of Dices 
	 * needed to spread dices to the fields
	 * @param nbr
	 */
	public void addNumberOfDices(int nbr);
	
	/**
	 * returns the name 
	 * @return
	 */
	public String getName();
	
	/**
	 * returns number of Fields
	 * @return
	 */
	public int getNumberOfFields();
	
	/**
	 * returns the player number
	 * @return
	 */
	public int getPlayerNr();
	
	/**
	 * returns the number of Dices a player owns
	 * @return
	 */
	public int getNumberOfDices();
	
	/**
	 * returns a random Field a player owns
	 * @return
	 */
	public IField popShoffled();
	
	/**
	 * Shuffles the list of Fields
	 */
	public void shuffleList();
	
	/**
	 * adds a field to the list
	 * @param field
	 */
	public void pushShuffledField(IField field);
	
	/**
	 * creates a stack of fields
	 * @param tmp
	 */
	public void initShuffle(IField[][] tmp);
	
	/**
	 * delets Field a player lost in battle
	 */
	public void updateShuffle();
	
	/**
	 * Adds dices to Fields randomly
	 * if numberofdices > 0
	 */
	public void update();
	
	
	
}
