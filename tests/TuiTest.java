package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;
import develop.TUI;

public class TuiTest {

	@Test
	public final void testTui() {
		Field[][] field = Field.createField(64, 49);
		String value1 = "";
		String value2 = "";
		String tmp = "";
		
		value1=TUI.tui(field.length, field);
		for (int i = 0; i < field.length; i++) {
			if(i%2!=0){
				tmp += "  " + TUI.field(field, field[i], field.length);
				tmp += "  " + TUI.field(field, field[i], field.length);
				continue;
			}
			tmp += TUI.top(field.length);
			tmp += TUI.field(field, field[i], field.length);
			tmp += TUI.field(field, field[i], field.length);
			tmp += TUI.bot(field.length);
			
		}
		tmp+="\n";
		tmp+="----------------------------------------------------------------";
		value2=tmp;
		assertEquals(value2, value1);
	}

}
