package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Player;

public class TestSetGetNumberOfFieldsPlayer {

	@Test
	public final void testGetNumberOfFields() {
		Player player = new Player();
		int nbr=0;
		player.setNumberOfFields(nbr);
		assertEquals(nbr, player.getNumberOfFields());
	}

}
