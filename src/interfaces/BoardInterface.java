package interfaces;

import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public interface BoardInterface {

	
	/**
     * ???
     * @param nbr
     * @param index
     */
	public void setOwner(int nbr, int index);
	
	
	/**
     * ???
     * @param index
     * @return ???
     */
	public int getOwner(int index);
	
	
	/**
     * ???
     * @param index
     */
	public void setExField(int index);
	
	
	/**
     * ???
     * @param index
     * @return ???
     */
	public boolean getExField(int index);
	
	
	/**
     * Set length of Board
     * @param length
     */
	public void setLength(int length);
	
	
	/**
     * @return length of board
     */
	public int getLength();
	
	
	/**
     * Reserve space for Field
     * @param field
     * @param x
     * @param y
     * @return space for Field
     */
	public Field initSingleField(Field[][] field, int x, int y);
	
	
	/**
     * Returns a random number in range of value
     * @param value
     * @return random number
     */
	public int randomNumber(int value);
	
	
	/**
     * Converts field in x/y size e.g. 49 = 7, 48 = 7, 37 = 6
     * @param numberOfFields
     * @return converted field
     */
	public int converteFieldSize(int numberOfFields);
	
	
	/**
     * Mallocs neighbors array
     * @param node
     * @return field with neighbors
     */
	public Field mallocNodes(Field node);
	
	
	/**
     * ???
     * @param node
     */
	public void setNeighborsNull(Field node);
	
	
	/**
     * Check for field with x does exist
     * @param node
     * @param x
     * @param fieldSize
     * @return true if exist or false if not
     */
	public boolean checkx(Field node, int x, int fieldSize);
	
	
	/**
     * Check for field with y does exist
     * @param node
     * @param y
     * @param fieldSize
     * @return true if exist or false if not
     */
	public boolean checky(Field node, int y, int fieldSize);
	
	
	/**
     * ???
     * @param node
     * @param x
     * @param y
     * @return true or false
     */
	public static boolean checkIndent(Field node, int x, int y) {
		return false;
	}
	
	
	/**
     * ???
     * @param node
     * @param x
     * @param y
     * @return true or false
     */
	public boolean checkNoIndent(Field node, int x, int y);
	

	/**
     * Check for field with parameters x and y neighbor of this field
     * @param node
     * @param nextx
     * @param nexty
     * @param fieldSize
     * @return true if is neighbor or false if not
     */
	public boolean checkNeighborIndex(Field node, int nextx, int nexty, int fieldSize);
	
	
	/**
     * ???
     * @param x
     * @return ???
     */
	public int xPlusyNegativeOne(int x);
	
	
	/**
     * ???
     * @param x
     * @return ???
     */
	public int xPlusyZero(int x);
	
	
	/**
     * ???
     * @param x
     * @return ???
     */
	public int xPlusyOne(int x);
	
	
	/**
     * ???
     * @param x
     * @param y
     * @return ???
     */
	public int xPlusyLowerOne(int x, int y);
	
	
	/**
     * ???
     * @param x
     * @param y
     * @return ???
     */
	public int xPlusyHigherZero(int x, int y);
	
	
	/**
     * Returns the index of a identified neighbor which is stored in nachbar
     * @param int x
     * @param int y
     * @return int 
     */
	public int getNeighborfromIndex(int x, int y);
	
	
	/**
     * Connected the nodes in a field
     * @param field
     * @param node
     * @param numberOfFields
     * @param fieldSize
     * @return connected field
     */
	public Field connectNodes(Field[][] field, Field node, int numberOfFields, int fieldSize);
	
	
	/**
     * Created a big field with some other field
     * @param fieldSize
     * @param numberOfFields
     * @return big field
     */
	public Board createField(int fieldSize, int numberOfFields);
	
	
	/**
     * Set an existing neighbor for field
     * @param fieldTmp
     * @param a
     * @param b
     * @return neighbor field
     */
	public Field setNeigbors(Field[][] fieldTmp, int a, int b);
	
	
	/**
     * Set number for a field
     * @param field
     * @param x
     * @param y
     */
	public void setFieldNumber(Field[][] field, int x, int y);
	
	
	/**
     * Set index for a field
     * @param fieldSize
     * @param fieldNumber
     * @return index x and y parameters
     */
	public int[] fieldNumberToIndex(int fieldSize, int fieldNumber);
	
	
	/**
     * Connect field with his neighbors
     * @param field
     * @return connected field
     */
	public Field[][] connectFields(Field[][] field);
	
	
	/**
     * Convert 2d field in simple field
     * @param field
     * @param p
     * @return converted simple field
     */
	public Field[][] fieldInList(Field[][] field, Field p);
	
	
	/**
     * Set number of dices
     * @param field
     * @param x
     * @param y
     * @param amount
     * @return ???
     */
	public int addDice(Board field, int x, int y, int amount);
	
	
	/**
     * ???
     * @param field
     * @param listOfPlayer
     * @param numberOfFields
     * @return ???
     */
	public int[] playerSpreadDices(Board field, Player[] listOfPlayer, int numberOfFields);
	
	
	/**
     *
     * @param playerGet
     * @return 
     */
	public int getPlayerIndex(int[] playerGet);
	
	
	/**
     * Get index to player
     * @param dices
     * @return index
     */
//	public int getDicesRandom(int dices);
//	
//	
//	/**
//     * ???
//     * @param field
//     * @param listOfPlayer
//     * @param numberOfFields
//     * @param playerGet
//     * @return ???
//     */
	public Board spreadPlayerToField(Board field, Player[] listOfPlayer, int numberOfFields, int[] playerGet);
	
	
	/**
     * Get maximal part of list
     * @param list
     * @return max part
     */
	public int getMax(int[] list);
	
	
	/**
     * Check if list empty
     * @param list
     * @return true if empty or false if not empty
     */
	public boolean checkEmptyList(int[] list);
	
	
	/**
     * Check max number of dices in field
     * @param field
     * @param x
     * @param y
     * @return true if not more than 7 or false if more
     */
	public boolean checkDicesAdd(Board field, int x, int y);
	
	
	/**
     * ???
     * @param list
     * @param index
     * @param ctr
     * @return ???
     */
	public int lowerIndex(int[] list, int index, int ctr);
	
	
	/**
     * ???
     * @param list
     * @param index
     * @param ctr
     * @return ???
     */
	public int higherIndex(int[] list, int index, int ctr);
	
	
	/**
     * ???
     * @param list
     * @return ???
     */
	public int wuerfelnOhneZurueckLegen(int[] list);
	
	
	/**
     * Distribute the rest of dices
     * @param list
     * @param rest
     */
	public void handleRest(int[] list, int rest);
	
	
	/**
     * ???
     * @param list
     * @param numberOfFields
     */
	public void handOutFields(int[] list, int numberOfFields);
	
	
	/**
     * Get fields to players
     * @param field
     * @param listOfPlayer
     * @param numberOfFields
     * @return ???
     */
	public Board playerToField(Board field, Player[] listOfPlayer, int numberOfFields);
}
