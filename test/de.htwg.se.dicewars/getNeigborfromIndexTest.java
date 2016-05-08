package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Board;


public class getNeigborfromIndexTest {

	@Test
	public void test() {
		assertEquals(7,Board.getNeighborfromIndex(-1,-1));
		assertEquals(3,Board.getNeighborfromIndex(-1,0));
		assertEquals(2,Board.getNeighborfromIndex(0,-1));
		assertEquals(1,Board.getNeighborfromIndex(1,0));
		assertEquals(0,Board.getNeighborfromIndex(0,1));
		assertEquals(6,Board.getNeighborfromIndex(1,-1));
		assertEquals(4,Board.getNeighborfromIndex(-1,1));
		assertEquals(6,Board.getNeighborfromIndex(0,0));
		assertEquals(5,Board.getNeighborfromIndex(1,1));
		assertEquals(-1,Board.getNeighborfromIndex(-3,-1));
		assertEquals(-1,Board.getNeighborfromIndex(3,1));
	}

}
