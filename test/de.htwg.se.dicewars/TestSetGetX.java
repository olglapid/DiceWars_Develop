package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import develop.Field;

public class TestSetGetX {

	@Test
	public final void testGetX() {
		Field testField = new Field();
		testField.setX(0);
		assertEquals(0, testField.getX());
	}

}
