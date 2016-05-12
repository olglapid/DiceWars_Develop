package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class TUITestClass {

	@Test
	public final void testTUI() {
		TUI console = new TUI();
		Board field = new Board(64);
		field = field.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";

		console.tui(field.brd.length, field);
		value1 = console.getConsole();
		for (int i = 0; i < field.brd.length; i++) {
			if (i % 2 != 0) {
				tmp += "  " + console.field(field, field.brd[i], field.getLength(),0);
				tmp += "  " + console.field(field, field.brd[i], field.getLength(),0);
				continue;
			}
			tmp += console.top(field.getLength());
			tmp += console.field(field, field.brd[i], field.getLength(),0);
			tmp += console.field(field, field.brd[i], field.getLength(),0);
			tmp += console.bot(field.getLength());

		}
		tmp += "\n";
		tmp += "----------------------------------------------------------------";
		value2 = tmp;
		assertEquals(value2, value1);
	}

	@Test
	public final void testSetConsole() {
		TUI console = new TUI();
		console.setConsole("Test");
		assertEquals("Test", console.getConsole());
	}

	@Test
	public final void testAddConsole() {
		TUI console = new TUI();
		console.setConsole("Test");
		console.addConsole("Test");
		assertEquals("TestTest", console.getConsole());
	}

	@Test
	public final void testField() {
		/*
		Field[][] field = Board.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";
		value1 = TUI.field(field, field[0], field.length);

		
		for(int i=0;i<field.length;i++){
			if(field[0][i]!=null)
				tmp += field[0][i].getFieldNumber();
			value2=TUI.format(value2, tmp);
			tmp="";
		}
		value2+="\n";

		assertEquals(value2, value1);
		*/
	}

	@Test
	public final void testTop() {
		String value1 = "";
		int ctr = 10;
		TUI console = new TUI();
		console.setConsole(console.top(ctr));

		for (int i = 0; i < ctr; i++) {
			value1 += " / \\ ";
		}
		value1 += "/\n";
		assertEquals(value1, console.getConsole());
	}

	@Test
	public final void testBot() {
		String value1 = "";
		TUI console = new TUI();
		;

		int ctr = 10;
		console.setConsole(console.bot(ctr));

		for (int i = 0; i < ctr; i++) {
			value1 += " \\ / ";
		}
		value1 += "\\\n";
		assertEquals(value1, console.getConsole());
	}

	@Test
	public final void testTui() {
		TUI console = new TUI();
		assertEquals("", console.getConsole());
	}

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
		assertEquals(value2, value1);
	}

	@Test
	public final void testFormat() {
		/*
		 * String value1=""; String value2="1"; String value3="10"; String
		 * value4="100";
		 * 
		 * assertEquals("|  1|", TUI.format(value1, value2)); assertEquals(
		 * "| 10|", TUI.format(value1, value3)); assertEquals("|100|",
		 * TUI.format(value1, value4)); value1=""; value1 = TUI.format(value1,
		 * value2); value1 = TUI.format(value1, value3); value1 =
		 * TUI.format(value1, value4); assertEquals("|  1|| 10||100|",value1);
		 */
	}

	@Test
	public final void testPrintBoxNeighbors() {
		/*
		 * Field[][] field = Board.createField(64, 49); String value1 = "";
		 * String value2 = ""; String tmp = ""; value1 =
		 * TUI.printBoxNeighbors(field, value1, 0, 0, 0);
		 * 
		 * for (int ctr = 0; ctr < 8; ctr++) { for (int j = 0; j < field.length;
		 * j++) { tmp = ""; if (field[0][j] == null) { value2 =
		 * TUI.format(value2, tmp); continue; } else if
		 * (field[0][j].getNachbar()[ctr] == null) { value2 = TUI.format(value2,
		 * tmp); continue; } else { tmp +=
		 * field[0][j].getNachbar()[ctr].getFieldNumber(); value2 =
		 * TUI.format(value2, tmp);
		 * 
		 * } }
		 * 
		 * value2 += "\n";
		 * 
		 * } assertEquals(value1, value2);
		 */
	}

	@Test
	public final void testGlobalPrint() {
		TUI console = new TUI();
		Board field = new Board(64);
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
