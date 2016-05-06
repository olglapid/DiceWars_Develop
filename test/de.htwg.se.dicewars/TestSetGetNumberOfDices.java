package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Field;

public class TestSetGetNumberOfDices {

	@Test
	public final void testGetNumberOfDices() {
		Field testField = new Field();
		testField.setNumberOfDices(0);
		assertEquals(0, testField.getNumberOfDices());
		
	}

}
