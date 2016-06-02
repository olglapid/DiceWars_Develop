package interfaces;

import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public interface TuiInterface {
	
	/**
     * Set console
     * @param console
     */
	public void setConsole(String console);
	
	
	/**
     * Addition of consoles
     * @param console
     */
	public void addConsole(String console);
	
	
	/**
     * Get console
     * @return console
     */
	public String getConsole();
	
	
	/**
     * ???
     * @param globalField
     * @param row
     * @param ctr
     * @param trigger
     * @return ???
     */
	public String field(Board globalField, Field[] row, int ctr,int trigger);
	
	
	/**
     * Build the top of the field
     * @param ctr
     * @return top
     */
	public String top(int ctr);
	
	
	/**
     * Build the down part of the field
     * @param ctr
     * @return down part
     */
	public String bot(int ctr);
	
	
	/**
     * Set console with one field picture
     * @param fieldSize
     * @param globalField
     */
	public void tui(int fieldSize, Board globalField);
	
	
	/**
     * ???
     * @param field
     * @param value
     * @param x
     * @param y
     * @return ???
     */
	public String printBox(Board field, String value, int x, int y);
	
	
	/**
     * Set borders
     * @param value
     * @param value1
     * @return value1 with border with " "
     */
	public String format(String value, String value1);
	
	
	/**
     * Put and print some fields together as big field
     * @param field
     * @param value
     * @param x
     * @param y
     * @param ctr
     * @return big field from some fields
     */
	public String printBoxNeighbors(Board field, String value, int x, int y, int ctr);
	
	
	/**
     * Print all console
     * @param field
     */
	public void globalPrint(Board field);
}
