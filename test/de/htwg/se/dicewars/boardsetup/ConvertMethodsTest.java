package de.htwg.se.dicewars.boardsetup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;

public class ConvertMethodsTest {

	@Test
	public final void testwuerfelnOhneZurueckLegen() {
		int[] list = new int[5];
		int[] listAdd = new int[5];
		int index = 0;
		;
		for (int i = 0; i < list.length; i++) {
			list[i] = 5;
			listAdd[i] = 0;
		}
		while (index > -1) {
			index = Convertmethods.wuerfelnOhneZurueckLegen(list);
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
	public final void testFieldNumberToIndex() {
		Board board = new Board();
		Boardsetup boardsetup = new Boardsetup();

		board = boardsetup.createField(64, 64);
		int[] index = new int[2];
		Field[][] field = board.getField();

		for (int j = 0; j < board.getLength(); j++) {
			for (int i = 0; i < board.getLength(); i++) {

				index = Convertmethods.fieldNumberToIndex(board.getLength(), field[j][i].getFieldNumber());

				assertEquals(field[j][i].getX(), index[0]);
				assertEquals(field[j][i].getY(), index[1]);
			}
		}
	}

	@Test
	public final void testgetMax() {
		int[] testList = new int[3];

		testList[0] = 10;
		testList[1] = 50;
		testList[2] = -100;

		assertEquals(testList[1], Convertmethods.getMax(testList));
	}

	@Test
	public final void testcheckEmptyList() {
		int[] testList = new int[3];

		testList[0] = 0;
		testList[1] = 50;
		testList[2] = 0;

		assertFalse(Convertmethods.checkEmptyList(testList));

		testList[1] = 0;

		assertTrue(Convertmethods.checkEmptyList(testList));
	}
}
