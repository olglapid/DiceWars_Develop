package de.htwg.se.dicewars.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {



	@Test
	public void Board(){
		Board brd= new Board();
		assertNotNull(brd);
	
	}
	@Test
	public void setFieldTest() {
		Board brd= new Board();
		Field[][] testField = new Field[3][3];
		brd.setField(testField);
		assertEquals(testField, brd.getField());
		
	}
	@Test
	public void setLengthTest() {
		Board brd= new Board();
		brd.setLength(3);
		assertEquals(3, brd.getLength());
	}

	



	







	
}
