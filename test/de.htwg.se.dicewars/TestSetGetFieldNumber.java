package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;

public class TestSetGetFieldNumber {

	@Test
	public final void testGetFieldNumber() {
		Field testField = new Field();
		testField.setFieldNumber(1);
		assertEquals(1, testField.getFieldNumber());
	}

}
