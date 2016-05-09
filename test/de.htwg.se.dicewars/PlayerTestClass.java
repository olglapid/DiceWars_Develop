package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTestClass {

	@Test
	public final void testPlayer() {
		Player testPlayer = new Player();
		assertEquals(null, testPlayer.getName());
		assertEquals(0, testPlayer.getNumberOfDices());
		assertEquals(0, testPlayer.getNumberOfFields());
		assertEquals(0, testPlayer.getPlayerNr());
	}

	@Test
	public final void testSetName() {
		Player testPlayer = new Player();
		testPlayer.setName("Test");
		assertEquals("Test", testPlayer.getName());
	}

	@Test
	public final void testSetNumberOfFields() {
		Player testPlayer = new Player();
		testPlayer.setNumberOfFields(1);
		assertEquals(1, testPlayer.getNumberOfFields());
	}

	@Test
	public final void testSetPlayerNr() {
		Player testPlayer = new Player();
		testPlayer.setPlayerNr(1);
		assertEquals(1, testPlayer.getPlayerNr());
	}

	@Test
	public final void testSetNumberOfDices() {
		Player testPlayer = new Player();
		testPlayer.setNumberOfDices(1);
		assertEquals(1, testPlayer.getNumberOfDices());
	}

}
