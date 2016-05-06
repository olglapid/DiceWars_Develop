package de.htwg.se.dicewars;

import static org.junit.Assert.*;



import org.junit.Test;

import de.htwg.se.dicewars.Field;
import de.htwg.se.dicewars.TUI;

public class FieldTest {

	@Test
	public final void testField() {
		Field[][] field = BoardSetup.createField(64, 49);
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
	}

}
