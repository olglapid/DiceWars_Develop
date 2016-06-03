package de.htwg.se.dicewars.gameroutine;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class AttackTest {

	@Test
	public final void attacktest() {
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
		
		attack.attackroutine(field[2][2], 2, 2, 1);

		assertEquals(Status.Invalid_Attack_Field, attack.getStatus());
		
		attack.attackroutine(field[2][1], 2, 2, 2);

		assertEquals(Status.Invalid_Attack_Field, attack.getStatus());

		attack.attackroutine(field[1][1], 2, 1, 0);

		assertEquals(Status.Invalid_Attack_Dices, attack.getStatus());

		attack.attackroutine(field[1][1], 2, 1, 2);

		assertEquals(Status.Invalid_Attack_Owner, attack.getStatus());

		attack.attackroutine(field[1][1], 2, 1, 2);

		assertEquals(Status.Invalid_Attack_Owner, attack.getStatus());

		attack.attackroutine(field[1][0], 2, 1, 2);

		assertEquals(Status.Invalid_Attack_Neighbour, attack.getStatus());
		
		field[1][0].setNumberOfDices(1000000);
		System.out.println(field[1][0].getNumberOfDices());
		
		attack.attackroutine(field[1][0], 2, 1, 1);
		
		assertEquals(Status.Attack_Success, attack.getStatus());
		
		field[1][1].setNumberOfDices(2);
		attack.attackroutine(field[1][1], 2, 1, 0);
		
		assertEquals(Status.Attack_Failed, attack.getStatus());
		
		
		

	}

}
