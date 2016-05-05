package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.BoardSetup;
import develop.Field;
import develop.TUI;

public class TestGlobalPrint {

	@Test
	public final void testGlobalPrint() {
		Field[][] field = BoardSetup.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";
		value1 = TUI.globalPrint(field);
		
		for (int j = 0; j < field.length; j++) {
			value2 += TUI.printBox(field, tmp, j, 0);
			tmp += "";
			value2 += "\n";
			value2 += TUI.printBoxNeighbors(field, tmp, j, 0, 0);
			value2 += "\n";
		}
		
		assertEquals(value2, value1);
	}

}
