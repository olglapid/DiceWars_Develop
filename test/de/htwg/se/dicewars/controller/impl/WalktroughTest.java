package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.command.CountFields;
import de.htwg.se.command.Invoker;
import de.htwg.se.command.Method;
import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public class WalktroughTest {

	@Test
	public final void walkTroughFieldsTest() {
		Board board = new Board();
		board = Boardsetup.createField(64, 64);
		boolean[] visit = new boolean[64];
		Field[][] field = board.getField();
		Field tmpField = field[0][0];
		Method method = new Method();
		method.setDices(5);
		method.setField(field[0][0]);
		CountFields countfields = new CountFields(method);
		Invoker invoker = new Invoker();
		invoker.setCommand(countfields);

		assertEquals(tmpField, Walktrough.walkTroughFields(tmpField, visit, invoker, method));
		assertEquals(null, Walktrough.walkTroughFields(null, visit, invoker, method));
	}

}
