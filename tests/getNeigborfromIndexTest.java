package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.BoardSetup;
import develop.Field;

public class getNeigborfromIndexTest {

	@Test
	public void test() {
		assertEquals(7,BoardSetup.getNeighborfromIndex(-1,-1));
		assertEquals(3,BoardSetup.getNeighborfromIndex(-1,0));
		assertEquals(2,BoardSetup.getNeighborfromIndex(0,-1));
		assertEquals(1,BoardSetup.getNeighborfromIndex(1,0));
		assertEquals(0,BoardSetup.getNeighborfromIndex(0,1));
		assertEquals(6,BoardSetup.getNeighborfromIndex(1,-1));
		assertEquals(4,BoardSetup.getNeighborfromIndex(-1,1));
		assertEquals(6,BoardSetup.getNeighborfromIndex(0,0));
		assertEquals(5,BoardSetup.getNeighborfromIndex(1,1));
		assertEquals(-1,BoardSetup.getNeighborfromIndex(-3,-1));
		assertEquals(-1,BoardSetup.getNeighborfromIndex(3,1));
	}

}
