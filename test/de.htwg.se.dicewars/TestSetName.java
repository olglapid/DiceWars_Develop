package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Player;

public class TestSetName {

	@Test
	public final void testGetName() {
		Player player = new Player();
		String name = "Simon";
		player.setName(name);
		assertEquals(name, player.getName());
	}

}
