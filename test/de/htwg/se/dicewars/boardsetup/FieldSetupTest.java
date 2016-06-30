package de.htwg.se.dicewars.boardsetup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Fieldsetup;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;

public class FieldSetupTest {

	

	@Test
	public final void testSetNeigbors() {
		Field[][] field = new Field[3][3];

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				field[j][i] = new Field();
				field[j][i] = Fieldsetup.mallocNodes(field[j][i]);
				field[j][i].setX(j);
				field[j][i].setY(i);

			}
		}

		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[0], field[0][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[1], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[2], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[3], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 0).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[0], field[0][2]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[1], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[2], field[0][0]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[3], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[6], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 1).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[0], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[1], field[1][2]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[2], field[0][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[3], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[6], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 0, 2).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[0], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[1], field[2][0]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[2], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[3], field[0][0]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[4], field[0][1]);// FALSCH
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[5], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 0).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[0], field[1][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[1], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[2], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[3], field[0][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[4], field[0][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[5], field[2][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 1).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[0], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[1], field[2][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[2], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[3], field[0][2]);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 1, 2).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[0], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[1], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[2], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[3], field[1][0]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 0).getNachbar()[7], null);

		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[0], field[2][2]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[1], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[2], field[2][0]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[3], field[1][1]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 1).getNachbar()[7], field[1][0]);

		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[0], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[1], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[2], field[2][1]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[3], field[1][2]);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[4], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[5], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[6], null);
		assertSame(Fieldsetup.setNeigbors(field, 2, 2).getNachbar()[7], field[1][1]);
	}

	@Test
	public final void testSetFieldNumber() {
		Boardsetup boardsetup = new Boardsetup();
		int ctr = 1;
		Board board = boardsetup.createField(16, 9);
		Field[][] field = board.getField();
		for (int j = 0; j < board.getLength(); j++) {
			for (int i = 0; i < board.getLength(); i++) {
				Fieldsetup.setFieldNumber(field, j, i);
				if (field[j][i] == null) {
				}

				else {
					assertEquals(ctr, field[j][i].getFieldNumber());
				}
				ctr = ctr + 1;
			}
		}

	}

	@Test
	public final void testhandOutFields() {
		int numberOfFields = 49;
		int[] list = new int[6];
		int tmp = 0;
		Fieldsetup.handOutFields(list, numberOfFields);
		for (int i = 0; i < list.length; i++) {
			tmp += list[i];
		}
		assertEquals(numberOfFields, tmp);
	}

	@Test
	public final void testhandleRest() {
		int[] list = new int[5];
		int rest = 5;
		int tmp = 0;
		for (int i = 0; i < list.length; i++) {
			list[i] = 0;
		}
		Fieldsetup.handleRest(list, rest);
		for (int i = 0; i < list.length; i++) {
			tmp += list[i];
		}
		assertEquals(rest, tmp);
	}

}
