package de.htwg.se.dicewars.gameroutine;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.state.Status;

public class AttackTest {

	@Test
	public final void attacktest() {
		Boardsetup boardsetup = new Boardsetup();
		IBoard board = new Board();
		IField[][] field;
		IField[] tmpNeighbour;
		board = boardsetup.createField(9, 9);
		field = board.getField();

		IPlayer hans = new Player();
		IPlayer peter = new Player();

		hans.setPlayerNr(1);
		peter.setPlayerNr(2);

		hans.setName("hans");
		peter.setName("peter");

		/*--- Feld preparieren ---*/
		field[2][2] = null;
		tmpNeighbour = field[2][1].getNachbar();
		tmpNeighbour[0] = null;
		tmpNeighbour = field[1][2].getNachbar();
		tmpNeighbour[1] = null;
		tmpNeighbour = field[1][1].getNachbar();
		tmpNeighbour[5] = null;

		field[1][1].setOwner(hans);
		field[1][1].setNumberOfDices(1);
		field[1][2].setOwner(hans);
		field[1][2].setNumberOfDices(1);
		field[1][0].setOwner(peter);
		field[1][0].setNumberOfDices(8);
		/*-----------------------*/
		Attack attack = new Attack();

		attack.attackroutine(field[2][2], 2, 1);

		assertEquals(Status.INVALIDATTACKFIELD, attack.getStatus());

		attack.attackroutine(field[2][1], 2, 2);

		assertEquals(Status.INVALIDATTACKFIELD, attack.getStatus());

		attack.attackroutine(field[1][1], 1, 0);

		assertEquals(Status.INVALIDATTACKDICES, attack.getStatus());

		attack.attackroutine(field[1][1], 1, 2);

		assertEquals(Status.INVALIDATTACKOWNER, attack.getStatus());

		attack.attackroutine(field[1][1], 1, 2);

		assertEquals(Status.INVALIDATTACKOWNER, attack.getStatus());

		attack.attackroutine(field[1][0], 1, 2);

		assertEquals(Status.INVALIDATTACKNEIGHBOR, attack.getStatus());

		field[1][0].setNumberOfDices(1000000);

		attack.attackroutine(field[1][0], 1, 1);

		assertEquals(Status.ATTACKSUCCESS, attack.getStatus());

		field[1][1].setNumberOfDices(2);
		attack.attackroutine(field[1][1], 1, 0);

		assertEquals(Status.ATTACKFAILED, attack.getStatus());

	}

}
