package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Develop.Field;

public class setFieldNumberTest {

	@Test
	public void Test() {
		int ctr = 1;
		Field.createField(64);
		for (int j = 0; j < Field.field.length; j++) {
			for (int i = 0; i < Field.field.length; i++) {
				Field.setFieldNumber(j, i);
				if (Field.field[j][i] == null) {
					;
				}

				else {
					assertEquals(ctr, Field.field[j][i].fieldNumber);
				}
				ctr = ctr + 1;
			}
		}
	}

}
