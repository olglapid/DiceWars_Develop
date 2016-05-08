package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Field;

public class checkx {

	@Test
	public void testcheckx() {
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setX(0);

		node[1].setX(1);

		node[2].setX(2);


			assertFalse(Board.checkx(node[0], -1, 3));
			assertTrue(Board.checkx(node[0], 0, 3));
			assertTrue(Board.checkx(node[0], 1, 3));
			
			assertTrue(Board.checkx(node[1], -1, 3));
			assertTrue(Board.checkx(node[1], 0, 3));
			assertTrue(Board.checkx(node[1], 1, 3));
			
			assertTrue(Board.checkx(node[2], -1, 3));
			assertTrue(Board.checkx(node[2], 0, 3));
			assertFalse(Board.checkx(node[2], 1, 3));

	}

}
