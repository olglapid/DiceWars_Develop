package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Field;
import de.htwg.se.dicewars.TUI;

public class PrintBoxTest {

	@Test
	public final void testPrintBox() {
		TUI console = new TUI();
		Board field = new Board(64);
		String value1 = "";
		String value2 = "";
		String tmp = "";
		
		field = field.createField(64, 32);
		value1 = console.printBox(field, value1, 0, 0);
		for (int i = 0; i < field.getLength(); i++) {
			tmp = "";
			if (field.brd[0][i] != null)
				tmp += field.brd[0][i].getFieldNumber();
			value2 = console.format(value2, tmp);
		}
		System.out.println(value1);
		assertEquals(value2, value1);
	}

}
