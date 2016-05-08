package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Board;
import de.htwg.se.dicewars.Field;
import de.htwg.se.dicewars.TUI;

public class TestGlobalPrint {

	@Test
	public final void testGlobalPrint() {
		TUI console = new TUI();
		Board field =  new Board(64);
		field = field.createField(64, 49);
		String value2 = "";
		String tmp = "";
		console.globalPrint(field);
		
		for (int j = 0; j < field.getLength(); j++) {
			value2 += console.printBox(field, tmp, j, 0);
			tmp += "";
			value2 += "\n";
			value2 += console.printBoxNeighbors(field, tmp, j, 0, 0);
			value2 += "\n";
		}		
		assertEquals(value2, console.getConsole());
	}

}
