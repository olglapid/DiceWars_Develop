package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;

public class SetGetYTest {

	@Test
	public final void testSetY() {
		Field testField = new Field();
		testField.setY(0);
		assertEquals(0, testField.getY());
	}


}
