package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;

public class setNeigborsTest {

	@Test
	public void test() {
		Field[][] testField = new Field[3][3];

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				testField[j][i] = new Field();
				Field.mallocNodes(testField[j][i], j, i);
				testField[j][i].x = j;
				testField[j][i].y = i;

			}
		}

		
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[0], testField[0][1]);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[1], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[2], null);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[3], null);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 0, 0).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[0], testField[0][2]);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[1], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[2], testField[0][0]);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[3], null);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[6], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 0, 1).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[0], null);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[1], testField[1][2]);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[2], testField[0][1]);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[3], null);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[6], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 0, 2).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[0], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[1], testField[2][0]);
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[2], null);
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[3], testField[0][0]);
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[4], testField[0][1]);//FALSCH
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[5], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 1, 0).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[0], testField[1][2]);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[1], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[2], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[3], testField[0][1]);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[4], testField[0][2]);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[5], testField[2][2]);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 1, 1).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[0], null);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[1], testField[2][2]);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[2], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[3], testField[0][2]);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 1, 2).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[0], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[1], null);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[2], null);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[3], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 2, 0).nachbar[7], null);
		
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[0], testField[2][2]);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[1], null);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[2], testField[2][0]);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[3], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 2, 1).nachbar[7], testField[1][0]);
		
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[0], null);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[1], null);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[2], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[3], testField[1][2]);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[4], null);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[5], null);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[6], null);
		assertSame(Field.setNeigbors(testField, 2, 2).nachbar[7], testField[1][1]);
		
	}

}
