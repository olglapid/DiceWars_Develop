package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.BoardSetup;
import develop.Field;

public class CheckNeighborindex {

	@Test
	public void test() {
		Field node[] = new Field[9];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();
		node[3] = new Field();
		node[4] = new Field();
		node[5] = new Field();
		node[6] = new Field();
		node[7] = new Field();
		node[8] = new Field();

		node[0].setY(0);
		node[0].setX(0);
		node[1].setY(1);
		node[1].setX(0);
		node[2].setY(2);
		node[2].setX(0);
		node[3].setY(0);
		node[3].setX(1);
		node[4].setY(1);
		node[4].setX(1);
		node[5].setY(2);
		node[5].setX(1);
		node[6].setY(0);
		node[6].setX(2);
		node[7].setY(1);
		node[7].setX(2);
		node[8].setY(2);
		node[8].setX(2);

		assertFalse(BoardSetup.checkNeighborIndex(node[0], -1, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[0], -1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[0], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[0], 0, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[0], 0, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[0], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[0], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[0], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[0], 1, -1, 3));

		assertFalse(BoardSetup.checkNeighborIndex(node[1], -1, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[1], -1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[1], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[1], 0, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[1], 0, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[1], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[1], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[1], -1, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[1], 1, -1, 3));

		assertFalse(BoardSetup.checkNeighborIndex(node[2], -1, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[2], -1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[2], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[2], 0, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[2], 0, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[2], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[2], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[2], -1, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[2], 1, -1, 3));

		assertFalse(BoardSetup.checkNeighborIndex(node[3], -1, -1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[3], -1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[3], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[3], 0, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[3], 0, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[3], 1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[3], 1, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[3], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[3], 1, -1, 3));

		assertFalse(BoardSetup.checkNeighborIndex(node[4], -1, -1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[4], -1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[4], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[4], 0, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[4], 0, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[4], 1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[4], 1, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[4], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[4], 1, -1, 3));

		assertFalse(BoardSetup.checkNeighborIndex(node[5], -1, -1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[5], -1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[5], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[5], 0, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[5], 0, 1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[5], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[5], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[5], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[5], 1, -1, 3));

		assertFalse(BoardSetup.checkNeighborIndex(node[6], -1, -1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[6], -1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[6], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[6], 0, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[6], 0, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[6], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[6], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[6], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[6], 1, -1, 3));

		assertTrue(BoardSetup.checkNeighborIndex(node[7], -1, -1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[7], -1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[7], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[7], 0, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[7], 0, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[7], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[7], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[7], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[7], 1, -1, 3));

		assertTrue(BoardSetup.checkNeighborIndex(node[8], -1, -1, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[8], -1, 0, 3));
		assertTrue(BoardSetup.checkNeighborIndex(node[8], 0, -1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[8], 0, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[8], 0, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[8], 1, 0, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[8], 1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[8], -1, 1, 3));
		assertFalse(BoardSetup.checkNeighborIndex(node[8], 1, -1, 3));

	}

}
