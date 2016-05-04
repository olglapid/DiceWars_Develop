package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;
import develop.TUI;

public class PrintBoxTest {

	@Test
	public final void testPrintBox() {
		Field[][] field = Field.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";

		value1 = TUI.printBox(field, value1, 0, 0);
		for (int i = 0; i < field.length; i++) {
			tmp = "";
			if (field[0][i] != null)
				tmp += field[0][i].getFieldNumber();
			value2 = TUI.format(value2, tmp);
		}
		assertEquals(value2, value1);
	}

}
