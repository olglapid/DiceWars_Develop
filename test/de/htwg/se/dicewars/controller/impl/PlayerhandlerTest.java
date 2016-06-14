package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class PlayerhandlerTest {
	@Test
	public final void PlayerhandlerTest() {
		Playerhandler playerhandler = new Playerhandler();
		assertEquals(null, playerhandler.getPlayer());
		assertEquals(Status.New, playerhandler.getStatus());
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
		playerhandler.setStatus(Status.Nothing_To_Update);
		assertEquals(Status.Nothing_To_Update, playerhandler.getStatus());
	}

	@Test
	public final void getAmountOfPlayerTest() {
		Playerhandler playerhandler = new Playerhandler();
		playerhandler.setAmountOfPlayer(7);
		assertEquals(7, playerhandler.getAmountOfPlayer());
	}

	@Test
	public final void updatePlayerTest() {
		Board board = new Board();
		Field[][] field;
		Field[] tmpNeighbour;
		board = Boardsetup.createField(9, 9);
		field = board.getField();

		Player hans = new Player();
		Player peter = new Player();

		hans.setPlayerNr(1);
		peter.setPlayerNr(2);

		hans.setName("hans");
		peter.setName("peter");
	}
}
