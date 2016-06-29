package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.gameroutine.Attack;

import de.htwg.se.dicewars.model.Field;

import de.htwg.se.dicewars.state.Status;

public class DicehandlerTest {
	@Test
	public final void countDicesTest() {
		// Player player = new Player();
		// Board board = new Board();
		// Field[][] field;
		// board = Boardsetup.createField(64, 64);
		// field = board.getField();
		// player.setField(field);
		// player.setNumberOfDices(64);
		// player.initShuffle(null);
		// player.update();
		//
		// int result = Dicehandler.countDices(board.getField(),null);
		// assertEquals(result, 64);
		// player.setNumberOfDices(1000);
		// int expected = 8 * 64;
		// player.update();
		// result = Dicehandler.countDices(board.getField(),null);
		// assertEquals(expected, result);
	}

	@Test
	public final void getStatusTest() {
		Dicehandler dicehandler = new Dicehandler();
		dicehandler.setStatus(Status.Valid);
		assertEquals(Status.Valid, dicehandler.getStatus());
	}

	@Test
	public final void updateDicesTest() {
		Dicehandler dicehandler = new Dicehandler();
		Attack attack = new Attack();
		Field field1 = new Field();
		Field field2 = new Field();

		field1.setNumberOfDices(8);
		field2.setNumberOfDices(1);
		attack.setField(field1);
		attack.setNeighbour(field2);
		attack.setStatus(Status.AttackSuccess);

		dicehandler.updateDices(attack.getField(), attack.getNeighbour(), attack.getStatus());

		assertEquals(1, field1.getNumberOfDices());
		assertEquals(7, field2.getNumberOfDices());

		attack.setStatus(Status.AttackFailed);
		dicehandler.updateDices(attack.getField(), attack.getNeighbour(), attack.getStatus());

		assertEquals(1, field1.getNumberOfDices());
		assertEquals(7, field2.getNumberOfDices());

	}

}
