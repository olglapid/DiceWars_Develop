package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Field;

public class TestSetGetX {

	@Test
	public final void testGetX() {
		Field testField = new Field();
		testField.setX(0);
		assertEquals(0, testField.getX());
	}

}
