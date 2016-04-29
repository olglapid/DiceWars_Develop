package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Develop.Field;

public class getNeigborfromIndexTest {

	@Test
	public void test() {
		assertEquals(5,Field.getNeighborfromIndex(-1,-1));
		assertEquals(3,Field.getNeighborfromIndex(-1,0));
		assertEquals(2,Field.getNeighborfromIndex(0,-1));
		assertEquals(1,Field.getNeighborfromIndex(1,0));
		assertEquals(0,Field.getNeighborfromIndex(0,1));
		assertEquals(4,Field.getNeighborfromIndex(1,-1));
		assertEquals(4,Field.getNeighborfromIndex(-1,1));
		assertEquals(4,Field.getNeighborfromIndex(0,0));
		assertEquals(5,Field.getNeighborfromIndex(1,1));
	}

}
