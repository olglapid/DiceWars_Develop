package tests;

import static org.junit.Assert.*;

import org.junit.Test;

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

		node[0].y = 0;
		node[0].x = 0;
		node[1].y = 1;
		node[1].x = 0;
		node[2].y = 2;
		node[2].x = 0;
		node[3].y = 0;
		node[3].x = 1;
		node[4].y = 1;
		node[4].x = 1;
		node[5].y = 2;
		node[5].x = 1;
		node[6].y = 0;
		node[6].x = 2;
		node[7].y = 1;
		node[7].x = 2;
		node[8].y = 2;
		node[8].x = 2;

		assertFalse(Field.checkNeighborIndex(node[0], -1, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[0], -1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[0], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[0], 0, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[0], 0, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[0], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[0], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[0], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[0], 1, -1, 3));

		assertFalse(Field.checkNeighborIndex(node[1], -1, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[1], -1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[1], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[1], 0, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[1], 0, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[1], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[1], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[1], -1, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[1], 1, -1, 3));
		
		assertFalse(Field.checkNeighborIndex(node[2], -1, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[2], -1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[2], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[2], 0, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[2], 0, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[2], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[2], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[2], -1, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[2], 1, -1, 3));
		
		assertFalse(Field.checkNeighborIndex(node[3], -1, -1, 3));
		assertTrue(Field.checkNeighborIndex(node[3], -1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[3], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[3], 0, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[3], 0, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[3], 1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[3], 1, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[3], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[3], 1, -1, 3));
		
		assertFalse(Field.checkNeighborIndex(node[4], -1, -1, 3));
		assertTrue(Field.checkNeighborIndex(node[4], -1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[4], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[4], 0, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[4], 0, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[4], 1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[4], 1, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[4], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[4], 1, -1, 3));
		
		assertFalse(Field.checkNeighborIndex(node[5], -1, -1, 3));
		assertTrue(Field.checkNeighborIndex(node[5], -1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[5], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[5], 0, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[5], 0, 1, 3));
		assertTrue(Field.checkNeighborIndex(node[5], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[5], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[5], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[5], 1, -1, 3));
		
		assertFalse(Field.checkNeighborIndex(node[6], -1, -1, 3));
		assertTrue(Field.checkNeighborIndex(node[6], -1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[6], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[6], 0, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[6], 0, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[6], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[6], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[6], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[6], 1, -1, 3));
		
		assertTrue(Field.checkNeighborIndex(node[7], -1, -1, 3));
		assertTrue(Field.checkNeighborIndex(node[7], -1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[7], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[7], 0, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[7], 0, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[7], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[7], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[7], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[7], 1, -1, 3));
		
		assertTrue(Field.checkNeighborIndex(node[8], -1, -1, 3));
		assertTrue(Field.checkNeighborIndex(node[8], -1, 0, 3));
		assertTrue(Field.checkNeighborIndex(node[8], 0, -1, 3));
		assertFalse(Field.checkNeighborIndex(node[8], 0, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[8], 0, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[8], 1, 0, 3));
		assertFalse(Field.checkNeighborIndex(node[8], 1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[8], -1, 1, 3));
		assertFalse(Field.checkNeighborIndex(node[8], 1, -1, 3));

	}

}
