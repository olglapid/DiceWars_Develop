package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTestClass {

	@Test
	public final void testCheckx() {
		Board field = new Board(3);
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setX(0);

		node[1].setX(1);

		node[2].setX(2);

		assertFalse(field.checkx(node[0], -1, 3));
		assertTrue(field.checkx(node[0], 0, 3));
		assertTrue(field.checkx(node[0], 1, 3));

		assertTrue(field.checkx(node[1], -1, 3));
		assertTrue(field.checkx(node[1], 0, 3));
		assertTrue(field.checkx(node[1], 1, 3));

		assertTrue(field.checkx(node[2], -1, 3));
		assertTrue(field.checkx(node[2], 0, 3));
		assertFalse(field.checkx(node[2], 1, 3));
	}

	@Test
	public final void testChecky() {
		Board field = new Board(3);
		Field node[] = new Field[3];
		node[0] = new Field();
		node[1] = new Field();
		node[2] = new Field();

		node[0].setY(0);

		node[1].setY(1);

		node[2].setY(2);

		assertFalse(field.checky(node[0], -1, 3));
		assertTrue(field.checky(node[0], 0, 3));
		assertTrue(field.checky(node[0], 1, 3));

		assertTrue(field.checky(node[1], -1, 3));
		assertTrue(field.checky(node[1], 0, 3));
		assertTrue(field.checky(node[1], 1, 3));

		assertTrue(field.checky(node[2], -1, 3));
		assertTrue(field.checky(node[2], 0, 3));
		assertFalse(field.checky(node[2], 1, 3));
	}

	@Test
	public final void testCheckNeighborIndex() {
		Board field = new Board(9);
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

		assertFalse(field.checkNeighborIndex(node[0], -1, -1, 3));
		assertFalse(field.checkNeighborIndex(node[0], -1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[0], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[0], 0, 0, 3));
		assertTrue(field.checkNeighborIndex(node[0], 0, 1, 3));
		assertTrue(field.checkNeighborIndex(node[0], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[0], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[0], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[0], 1, -1, 3));

		assertFalse(field.checkNeighborIndex(node[1], -1, -1, 3));
		assertFalse(field.checkNeighborIndex(node[1], -1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[1], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[1], 0, 0, 3));
		assertTrue(field.checkNeighborIndex(node[1], 0, 1, 3));
		assertTrue(field.checkNeighborIndex(node[1], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[1], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[1], -1, 1, 3));
		assertTrue(field.checkNeighborIndex(node[1], 1, -1, 3));

		assertFalse(field.checkNeighborIndex(node[2], -1, -1, 3));
		assertFalse(field.checkNeighborIndex(node[2], -1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[2], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[2], 0, 0, 3));
		assertFalse(field.checkNeighborIndex(node[2], 0, 1, 3));
		assertTrue(field.checkNeighborIndex(node[2], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[2], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[2], -1, 1, 3));
		assertTrue(field.checkNeighborIndex(node[2], 1, -1, 3));

		assertFalse(field.checkNeighborIndex(node[3], -1, -1, 3));
		assertTrue(field.checkNeighborIndex(node[3], -1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[3], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[3], 0, 0, 3));
		assertTrue(field.checkNeighborIndex(node[3], 0, 1, 3));
		assertTrue(field.checkNeighborIndex(node[3], 1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[3], 1, 1, 3));
		assertTrue(field.checkNeighborIndex(node[3], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[3], 1, -1, 3));

		assertFalse(field.checkNeighborIndex(node[4], -1, -1, 3));
		assertTrue(field.checkNeighborIndex(node[4], -1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[4], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[4], 0, 0, 3));
		assertTrue(field.checkNeighborIndex(node[4], 0, 1, 3));
		assertTrue(field.checkNeighborIndex(node[4], 1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[4], 1, 1, 3));
		assertTrue(field.checkNeighborIndex(node[4], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[4], 1, -1, 3));

		assertFalse(field.checkNeighborIndex(node[5], -1, -1, 3));
		assertTrue(field.checkNeighborIndex(node[5], -1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[5], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[5], 0, 0, 3));
		assertFalse(field.checkNeighborIndex(node[5], 0, 1, 3));
		assertTrue(field.checkNeighborIndex(node[5], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[5], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[5], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[5], 1, -1, 3));

		assertFalse(field.checkNeighborIndex(node[6], -1, -1, 3));
		assertTrue(field.checkNeighborIndex(node[6], -1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[6], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[6], 0, 0, 3));
		assertTrue(field.checkNeighborIndex(node[6], 0, 1, 3));
		assertFalse(field.checkNeighborIndex(node[6], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[6], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[6], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[6], 1, -1, 3));

		assertTrue(field.checkNeighborIndex(node[7], -1, -1, 3));
		assertTrue(field.checkNeighborIndex(node[7], -1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[7], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[7], 0, 0, 3));
		assertTrue(field.checkNeighborIndex(node[7], 0, 1, 3));
		assertFalse(field.checkNeighborIndex(node[7], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[7], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[7], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[7], 1, -1, 3));

		assertTrue(field.checkNeighborIndex(node[8], -1, -1, 3));
		assertTrue(field.checkNeighborIndex(node[8], -1, 0, 3));
		assertTrue(field.checkNeighborIndex(node[8], 0, -1, 3));
		assertFalse(field.checkNeighborIndex(node[8], 0, 0, 3));
		assertFalse(field.checkNeighborIndex(node[8], 0, 1, 3));
		assertFalse(field.checkNeighborIndex(node[8], 1, 0, 3));
		assertFalse(field.checkNeighborIndex(node[8], 1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[8], -1, 1, 3));
		assertFalse(field.checkNeighborIndex(node[8], 1, -1, 3));
	}

	@Test
	public final void testGetNeighborfromIndex() {
		Board testField = new Board(3);
		assertEquals(7, testField.getNeighborfromIndex(-1, -1));
		assertEquals(3, testField.getNeighborfromIndex(-1, 0));
		assertEquals(2, testField.getNeighborfromIndex(0, -1));
		assertEquals(1, testField.getNeighborfromIndex(1, 0));
		assertEquals(0, testField.getNeighborfromIndex(0, 1));
		assertEquals(6, testField.getNeighborfromIndex(1, -1));
		assertEquals(4, testField.getNeighborfromIndex(-1, 1));
		assertEquals(6, testField.getNeighborfromIndex(0, 0));
		assertEquals(5, testField.getNeighborfromIndex(1, 1));
		assertEquals(-1, testField.getNeighborfromIndex(-3, -1));
		assertEquals(-1, testField.getNeighborfromIndex(3, 1));
	}

	@Test
	public final void testSetNeigbors() {
		Board field = new Board(3);
		Field[][] testField = new Field[3][3];

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				testField[j][i] = new Field();
				testField[j][i] = field.mallocNodes(testField[j][i]);
				testField[j][i].setX(j);
				testField[j][i].setY(i);

			}
		}

		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[0], testField[0][1]);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[1], testField[1][0]);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[2], null);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[3], null);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 0, 0).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[0], testField[0][2]);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[1], testField[1][1]);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[2], testField[0][0]);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[3], null);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[6], testField[1][0]);
		assertSame(field.setNeigbors(testField, 0, 1).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[0], null);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[1], testField[1][2]);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[2], testField[0][1]);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[3], null);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[6], testField[1][1]);
		assertSame(field.setNeigbors(testField, 0, 2).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[0], testField[1][1]);
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[1], testField[2][0]);
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[2], null);
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[3], testField[0][0]);
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[4], testField[0][1]);// FALSCH
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[5], testField[2][1]);
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 1, 0).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[0], testField[1][2]);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[1], testField[2][1]);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[2], testField[1][0]);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[3], testField[0][1]);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[4], testField[0][2]);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[5], testField[2][2]);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 1, 1).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[0], null);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[1], testField[2][2]);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[2], testField[1][1]);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[3], testField[0][2]);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 1, 2).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[0], testField[2][1]);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[1], null);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[2], null);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[3], testField[1][0]);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 2, 0).getNachbar()[7], null);

		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[0], testField[2][2]);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[1], null);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[2], testField[2][0]);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[3], testField[1][1]);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 2, 1).getNachbar()[7], testField[1][0]);

		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[0], null);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[1], null);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[2], testField[2][1]);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[3], testField[1][2]);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[4], null);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[5], null);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[6], null);
		assertSame(field.setNeigbors(testField, 2, 2).getNachbar()[7], testField[1][1]);
	}

	@Test
	public final void testSetFieldNumber() {
		int ctr = 1;
		Board field = new Board(9);
		field = field.createField(16, 9);

		for (int j = 0; j < field.getLength(); j++) {
			for (int i = 0; i < field.getLength(); i++) {
				field.setFieldNumber(field.brd, j, i);
				if (field.brd[j][i] == null) {
				}

				else {
					assertEquals(ctr, field.brd[j][i].getFieldNumber());
				}
				ctr = ctr + 1;
			}
		}

	}

	@Test
	public final void testFieldNumberToIndex() {
		Board field = new Board(64);
		field = field.createField(64, 64);
		int[] index = new int[2];

		for (int j = 0; j < field.getLength(); j++) {
			for (int i = 0; i < field.getLength(); i++) {
				index = field.fieldNumberToIndex(field.getLength(), field.brd[j][i].getFieldNumber());
				assertEquals(field.brd[j][i].getX(), index[0]);
				assertEquals(field.brd[j][i].getY(), index[1]);
			}
		}
	}

	@Test
	public final void testwuerfelnOhneZurueckLegen() {
		Board field = new Board(5);
		int[] list = new int[5];
		int[] listAdd = new int[5];
		int index = 0;
		;
		for (int i = 0; i < list.length; i++) {
			list[i] = 5;
			listAdd[i] = 0;
		}
		while (index > -1) {
			index = field.wuerfelnOhneZurueckLegen(list);
			if (index > -1) {
				listAdd[index] += 1;
			}
		}
		for (int i = 0; i < list.length; i++) {
			assertEquals(0, list[i]);
			assertEquals(5, listAdd[i]);
		}

	}

	@Test
	public final void testhandOutFields() {
		int numberOfFields = 49;
		Board field = new Board(numberOfFields);
		int[] list = new int[6];
		int tmp = 0;
		field.handOutFields(list, numberOfFields);
		for (int i = 0; i < list.length; i++) {
			tmp += list[i];
		}
		assertEquals(numberOfFields, tmp);
	}

	@Test
	public final void testhandleRest() {
		Board field = new Board(5);
		int[] list = new int[5];
		int rest = 5;
		int tmp = 0;
		for (int i = 0; i < list.length; i++) {
			list[i] = 0;
		}
		field.handleRest(list, rest);
		for (int i = 0; i < list.length; i++) {
			tmp += list[i];
		}
		assertEquals(rest, tmp);
	}

	@Test
	public final void testplayerToField() {
		Board field = new Board(64);
		Player[] listOfPlayer = new Player[5];
		int fieldSize = 64;
		int numberOfFields = 43;
		field = field.createField(fieldSize, numberOfFields);
		int tmp = 0;

		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setPlayerNr(i);
		}

		field.playerToField(field, listOfPlayer, numberOfFields);

		for (int x = 0; x < field.getLength(); x++) {
			for (int y = 0; y < field.getLength(); y++) {
				if (field.brd[x][y] == null)
					continue;
				if (field.brd[x][y].getOwner() == null) {
					continue;
				}
				tmp += 1;

			}
		}
		assertEquals(tmp, numberOfFields);
	}
}
