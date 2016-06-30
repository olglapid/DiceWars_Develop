package de.htwg.se.dicewars.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.model.impl.Dice;

public class DiceTest {

	@Test
	public final void getSidesTest() {
		Dice dice = new Dice();
		dice.setSides(7);
		assertEquals(7, dice.getSides());
	}

	@Test
	public final void rollTheDiceTest() {
//		Dice dice = new Dice();
//		int result = 0;
//		boolean cond = false;
//		assertEquals(6, dice.getSides());
//		for (int i = 0; i < 100; i++) {
//			result = dice.rollTheDice();
//			if (result > 0 && result <= dice.getSides())
//				cond = true;
//			assertTrue(cond);
//
//		}
//		dice.setSides(8);
//
//		assertEquals(8, dice.getSides());
//
//		for (int i = 0; i < 100; i++) {
//			result = dice.rollTheDice();
//			if (result > 0 && result <= dice.getSides()) {
//				cond = true;
//			}
//			assertTrue(cond);
//		}
	}

}
