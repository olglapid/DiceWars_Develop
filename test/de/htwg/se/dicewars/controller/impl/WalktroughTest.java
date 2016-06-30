package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;


import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;
import de.htwg.se.dicewars.strategy.CountDices;
import de.htwg.se.dicewars.util.Walktrough;

public class WalktroughTest {

	@Test
	public final void walkTroughFieldsTest() {
		Boardsetup boardsetup = new Boardsetup();
		Board board = new Board();
		int index = 0;
		board = boardsetup.createField(64, 64);
		boolean[] visit = new boolean[64];
		Field[][] field = board.getField();
		Field tmpField = field[0][0];
		
		Statistics stats=new Statistics();
		Context context = new Context(new CountDices());


		assertEquals(tmpField, Walktrough.walkTroughFields(tmpField, visit, stats, context));
		assertEquals(null, Walktrough.walkTroughFields(null, visit, stats, context));
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field.length; y++) {
				if (field[x][y] == null)
					continue;
				index = field[x][y].getFieldNumber()-1;
				assertTrue(visit[index]);

			}
		}
	}

}
