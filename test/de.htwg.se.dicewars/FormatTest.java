package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.TUI;

public class FormatTest {

	@Test
	public final void testFormat() {
		String value1="";
		String value2="1";
		String value3="10";
		String value4="100";
		
		assertEquals("|  1|", TUI.format(value1, value2));
		assertEquals("| 10|", TUI.format(value1, value3));
		assertEquals("|100|", TUI.format(value1, value4));
		value1="";
		value1 = TUI.format(value1, value2);
		value1 = TUI.format(value1, value3);
		value1 = TUI.format(value1, value4);
		assertEquals("|  1|| 10||100|",value1);
	}

}
