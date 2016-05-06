package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Player;

public class TestSetGetNumberOfFieldsPlayer {

	@Test
	public final void testGetNumberOfFields() {
		Player player = new Player();
		int nbr=0;
		player.setNumberOfFields(nbr);
		assertEquals(nbr, player.getNumberOfFields());
	}

}
