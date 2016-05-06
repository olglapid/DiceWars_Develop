package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.BoardSetup;

public class FieldNumberToIndexTest {

	@Test
	public final void testFieldNumberToIndex() {
		develop.Field[][] testField = BoardSetup.createField(64, 64);
		int[] index = new int[2];

		for (int j = 0; j < testField.length; j++) {
			for (int i = 0; i < testField.length; i++) {
				index = BoardSetup.fieldNumberToIndex(testField.length,testField[j][i].getFieldNumber());
				assertEquals(testField[j][i].getX(), index[0]);
				assertEquals(testField[j][i].getY(), index[1]);
			}
		}

	}

}
