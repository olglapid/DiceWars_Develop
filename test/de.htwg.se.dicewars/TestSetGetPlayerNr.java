package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Player;

public class TestSetGetPlayerNr {

	@Test
	public final void testGetPlayerNr() {
		Player player = new Player();
		int nbr=0;
		player.setPlayerNr(nbr);
		assertEquals(nbr, player.getPlayerNr());
	}

}
