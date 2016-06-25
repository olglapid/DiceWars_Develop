package de.htwg.se.dicewarsTest;

import static org.junit.Assert.*;

import java.security.GeneralSecurityException;

import org.junit.Test;

import de.htwg.se.dicewars.DiceStart;

public class DiceStartTest {

	@Test
	public final void testMain(){
		DiceStart game=DiceStart.getInstance();
		DiceStart.main(new String[] {"#", "n", "r", "s", "+", "001", "00"});
	
		assertTrue(game.getTui().getConsole().contains("00"));
	}
	
	@Test
	public final void testGetInstance() {
		DiceStart game=DiceStart.getInstance();
		assertNotNull(game);

		
	}

}
