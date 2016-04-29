package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Develop.Field;

public class checky {

	@Test
	public void test() {
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].y = 0;

		node[1].y = 1;

		node[2].y = 2;


			assertFalse(Field.checky(node[0], -1, 3));
			assertTrue(Field.checky(node[0], 0, 3));
			assertTrue(Field.checky(node[0], 1, 3));
			
			assertTrue(Field.checky(node[1], -1, 3));
			assertTrue(Field.checky(node[1], 0, 3));
			assertTrue(Field.checky(node[1], 1, 3));
			
			assertTrue(Field.checky(node[2], -1, 3));
			assertTrue(Field.checky(node[2], 0, 3));
			assertFalse(Field.checky(node[2], 1, 3));
	}

}
