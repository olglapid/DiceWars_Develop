package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.Board;
import de.htwg.se.dicewars.Field;
import de.htwg.se.dicewars.TUI;

public class TuiTest {

	@Test
	public final void testTui() {
		TUI console = new TUI();
		Board field = new Board(64);
		field = field.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";
		
		console.tui(field.getLength(), field);
		value1 = console.getConsole();
		for (int i = 0; i < field.getLength(); i++) {
			if(i%2!=0){
				tmp += "  " + console.field(field, field.brd[i], field.getLength());
				tmp += "  " + console.field(field, field.brd[i], field.getLength());
				continue;
			}
			tmp += console.top(field.getLength());
			tmp += console.field(field, field.brd[i], field.getLength());
			tmp += console.field(field, field.brd[i], field.getLength());
			tmp += console.bot(field.getLength());
			
		}
		tmp+="\n";
		tmp+="----------------------------------------------------------------";
		value2=tmp;
		assertEquals(value2, value1);
	}

}
