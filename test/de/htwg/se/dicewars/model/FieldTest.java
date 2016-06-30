package de.htwg.se.dicewars.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;

public class FieldTest {
	@Test
	public final void Field() {
		Field field = new Field();
		assertEquals(0, field.getX());
		assertEquals(0, field.getY());
		assertEquals(0, field.getFieldNumber());
		assertEquals(0, field.getNumberOfDices());
		assertEquals(null, field.getOwner());
	}

	@Test
	public final void getOwnerTest() {
		Field field = new Field();
		Player player = new Player();
		field.setOwner(player);
		assertEquals(player, field.getOwner());
	}

	@Test
	public final void setNachbarTest() {
		Field[] nachbar = new Field[9];
		Field field = new Field();
		field.setNachbar(nachbar);
		assertArrayEquals(nachbar, field.getNachbar());
	}

	@Test
	public final void setXTest() {
		Field field = new Field();
		field.setX(9);
		assertEquals(9, field.getX());
	}

	@Test
	public final void setYTest() {
		Field field = new Field();
		field.setY(9);
		assertEquals(9, field.getY());
	}

	@Test
	public final void setFieldNumberTest() {
		Field field = new Field();
		field.setFieldNumber(9);
		assertEquals(9, field.getFieldNumber());
	}

	@Test
	public final void addNumberOfDicesTest() {
		Field field = new Field();
		int testNumber = 1;
		int returnDices=0;
		returnDices=field.addNumberOfDices(testNumber);
		assertEquals(1, field.getNumberOfDices());
		assertEquals(0, returnDices);
		testNumber = 7;
		returnDices=field.addNumberOfDices(testNumber);
		assertEquals(8, field.getNumberOfDices());
		assertEquals(0, returnDices);
		testNumber = 1;
		returnDices=field.addNumberOfDices(testNumber);
		assertEquals(8, field.getNumberOfDices());
		assertEquals(1, returnDices);
		testNumber=1000;
		returnDices=field.addNumberOfDices(testNumber);
		assertEquals(8, field.getNumberOfDices());
		assertEquals(1000, returnDices);
	}

	@Test
	public final void setNumberOfDicesTest() {
		Field field = new Field();
		field.setNumberOfDices(5);
		assertEquals(5, field.getNumberOfDices());
	}
	
	@Test
	public final void rollTheDiceTest(){
		Field field = new Field();
		field.setNumberOfDices(8);
		int gamble = field.rollTheDice();
		assertTrue(0 < gamble && gamble<=(8*6));
		
	}
	
	

	

}
