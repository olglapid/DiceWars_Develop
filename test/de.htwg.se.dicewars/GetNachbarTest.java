package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Field;

public class GetNachbarTest {

	@Test
	public final void testGetNachbar() {
		Field testField = new Field();
		Field[] nachbar = new Field[8];

		testField.setNachbar(nachbar);
		assertArrayEquals(nachbar, testField.getNachbar());
	}

}
