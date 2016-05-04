package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Player;

public class TestSetGetNumberOfDicesPlayer {

	@Test
	public final void testGetNumberOfDices() {
		Player player = new Player();
		int nbr = 0;
		player.setNumberOfDices(nbr);
		assertEquals(nbr, player.getNumberOfDices());
	}

}
