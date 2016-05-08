package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Field;

public class checky {

	@Test
	public void test() {
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setY(0);

		node[1].setY(1);

		node[2].setY(2);


			assertFalse(Board.checky(node[0], -1, 3));
			assertTrue(Board.checky(node[0], 0, 3));
			assertTrue(Board.checky(node[0], 1, 3));
			
			assertTrue(Board.checky(node[1], -1, 3));
			assertTrue(Board.checky(node[1], 0, 3));
			assertTrue(Board.checky(node[1], 1, 3));
			
			assertTrue(Board.checky(node[2], -1, 3));
			assertTrue(Board.checky(node[2], 0, 3));
			assertFalse(Board.checky(node[2], 1, 3));
	}

}
