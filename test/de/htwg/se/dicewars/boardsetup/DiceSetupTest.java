package de.htwg.se.dicewars.boardsetup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.model.impl.Field;

public class DiceSetupTest {

	@Test
	public final void testgetDicesRandom() {
		int dices = 1;
		int value = 5;
		int result = Dicesetup.getDicesRandom(dices, value);
		System.out.println(result);
		System.out.println(dices);
		assertTrue(-1 < result);
		assertTrue(result <= value);
		assertEquals(0, Dicesetup.getDicesRandom(0, value));
		assertEquals(0, Dicesetup.getDicesRandom(-1, value));

	}

	@Test
	public final void testaddDice() {
		Field testfield = new Field();
		testfield.setNumberOfDices(0);
		int amount = 10;
		int returndices = 0;

		returndices = Dicesetup.addDice(testfield, amount);
		assertEquals(2, returndices);
		assertEquals(amount-returndices,testfield.getNumberOfDices());
	}
	
	@Test
	public final void testcheckDicesAdd(){
		Field testfield = new Field();
		testfield.setNumberOfDices(0);
		assertFalse(Dicesetup.checkDicesAdd(testfield));
		
		testfield.setNumberOfDices(8);
		assertTrue(Dicesetup.checkDicesAdd(testfield));
	}

}
