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
				testField[j][i] = Field.mallocNodes(testField[j][i]);
				testField[j][i].setX(j);
				testField[j][i].setY(i);

			}
		}

		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[0], testField[0][1]);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[1], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[2], null);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[3], null);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 0, 0).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[0], testField[0][2]);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[1], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[2], testField[0][0]);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[3], null);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[6], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 0, 1).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[0], null);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[1], testField[1][2]);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[2], testField[0][1]);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[3], null);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[6], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 0, 2).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[0], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[1], testField[2][0]);
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[2], null);
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[3], testField[0][0]);
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[4], testField[0][1]);// FALSCH
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[5], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 1, 0).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[0], testField[1][2]);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[1], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[2], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[3], testField[0][1]);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[4], testField[0][2]);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[5], testField[2][2]);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 1, 1).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[0], null);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[1], testField[2][2]);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[2], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[3], testField[0][2]);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 1, 2).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[0], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[1], null);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[2], null);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[3], testField[1][0]);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 2, 0).getNachbar()[7], null);

		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[0], testField[2][2]);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[1], null);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[2], testField[2][0]);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[3], testField[1][1]);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 2, 1).getNachbar()[7], testField[1][0]);

		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[0], null);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[1], null);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[2], testField[2][1]);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[3], testField[1][2]);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[4], null);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[5], null);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[6], null);
		assertSame(Field.setNeigbors(testField, 2, 2).getNachbar()[7], testField[1][1]);

	}

}
