package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;
import develop.TUI;

public class PrintBoxNeighbors {

	@Test
	public final void testPrintBoxNeighbors() {
		Field[][] field = Field.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";
		value1 = TUI.printBoxNeighbors(field, value1, 0, 0, 0);

		for (int ctr = 0; ctr < 8; ctr++) {
			for (int j = 0; j < field.length; j++) {
				tmp = "";
				if (field[0][j] == null) {
					value2 = TUI.format(value2, tmp);
					continue;
				} else if (field[0][j].getNachbar()[ctr] == null) {
					value2 = TUI.format(value2, tmp);
					continue;
				} else {
					tmp += field[0][j].getNachbar()[ctr].getFieldNumber();
					value2 = TUI.format(value2, tmp);

				}
			}

			value2 += "\n";

		}
		assertEquals(value1, value2);
	}

}
