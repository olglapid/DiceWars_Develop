package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.gameroutine.Attack;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class PlayerhandlerTest {
	@Test
	public final void Playerhandler1Test() {
		Playerhandler playerhandler = new Playerhandler();
		assertEquals(null, playerhandler.getPlayer());
		assertEquals(Status.NEW, playerhandler.getStatus());
		assertEquals(0, playerhandler.getAmountOfPlayer());

	}

	@Test
	public final void getPlayerTest() {
		Player player = new Player();
		Playerhandler playerhandler = new Playerhandler();

		playerhandler.setPlayer(player);

		assertEquals(player, playerhandler.getPlayer());

	}

	@Test
	public final void getStatusTest() {
		Playerhandler playerhandler = new Playerhandler();
		playerhandler.setStatus(Status.NOTHINGTOUPDATE);
		assertEquals(Status.NOTHINGTOUPDATE, playerhandler.getStatus());
	}

	@Test
	public final void getAmountOfPlayerTest() {
		Playerhandler playerhandler = new Playerhandler();
		playerhandler.setAmountOfPlayer(7);
		assertEquals(7, playerhandler.getAmountOfPlayer());
	}

	@Test
	public final void updatePlayerTest() {
		Boardsetup boardsetup = new Boardsetup();
		Board board = new Board();
		Field[][] field;

		board = boardsetup.createField(9, 9);
		field = board.getField();

		Player hans = new Player();
		Player peter = new Player();

		hans.setPlayerNr(1);
		peter.setPlayerNr(2);

		hans.setName("hans");
		peter.setName("peter");

		field[1][1].setOwner(hans);
		field[1][1].setNumberOfDices(1);
		field[1][2].setOwner(hans);
		field[1][2].setNumberOfDices(1);
		field[1][0].setOwner(peter);
		field[1][0].setNumberOfDices(8);

		field[1][0].setNumberOfDices(1000000);

		Attack attack = new Attack();

		attack.attackroutine(field[1][0], 1, 1);

		Playerhandler playerhandler = new Playerhandler();
		playerhandler.updatePlayer(attack.getField(), attack.getNeighbour(), attack.getStatus());

		assertEquals(peter, field[1][1].getOwner());
		assertEquals(Status.PLAYERUPDATE, playerhandler.getStatus());

		field[1][1].setOwner(hans);

		field[1][0].setNumberOfDices(1);

		attack.attackroutine(field[1][0], 1, 1);
		playerhandler.updatePlayer(attack.getField(), attack.getNeighbour(), attack.getStatus());
		assertEquals(hans, field[1][1].getOwner());
		assertEquals(Status.NOTHINGTOUPDATE, playerhandler.getStatus());

	}

}
