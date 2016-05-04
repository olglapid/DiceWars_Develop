package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;

public class setFieldNumberTest {

	@Test
	public void Test() {
		int ctr = 1;
		Field[][] field = Field.createField(64);
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				Field.setFieldNumber(field,j, i);
				if (field[j][i] == null) {
					;
				}

				else {
					assertEquals(ctr, field[j][i].fieldNumber);
				}
				ctr = ctr + 1;
			}
		}
	}

}
