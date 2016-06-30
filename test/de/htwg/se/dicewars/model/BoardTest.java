package de.htwg.se.dicewars.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;

public class BoardTest {



	@Test
	public void Board(){
		IBoard brd= new Board();
		assertNotNull(brd);
	
	}
	@Test
	public void setFieldTest() {
		IBoard brd= new Board();
		IField[][] testField = new Field[3][3];
		brd.setField(testField);
		assertEquals(testField, brd.getField());
		
	}
	@Test
	public void setLengthTest() {
		IBoard brd= new Board();
		brd.setLength(3);
		assertEquals(3, brd.getLength());
	}

	



	







	
}
