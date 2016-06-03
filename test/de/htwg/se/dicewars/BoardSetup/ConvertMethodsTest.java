package de.htwg.se.dicewars.BoardSetup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

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
			index = ConvertMethods.wuerfelnOhneZurueckLegen(list);
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
		
		board = BoardSetup.createField(64, 64);
		int[] index = new int[2];
		Field[][] field = board.getField();

		for (int j = 0; j < board.getLength(); j++) {
			for (int i = 0; i < board.getLength(); i++) {

				index = ConvertMethods.fieldNumberToIndex(board.getLength(), field[j][i].getFieldNumber());
				
				assertEquals(field[j][i].getX(), index[0]);
				assertEquals(field[j][i].getY(), index[1]);
			}
		}
	}
}
