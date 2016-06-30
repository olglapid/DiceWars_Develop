package de.htwg.se.dicewars.view.gui;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Test;

import com.google.inject.Injector;

import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;

public class GraphfieldTest {

	@Test
	public final void GraphfieldTest() {
		Board board = new Board();
		Field[][] field = new Field[8][8];
		Controller controller = new Controller(); 
		board.setField(field);
		controller.setBoard(board);
		Graphfield graph = new Graphfield(10, controller);
		
		assertEquals(controller, graph.getController());
		assertNotNull(graph.getPoly());
		assertFalse(graph.getAttack());
		assertNotNull(graph.getColor());
		assertTrue(graph.getSiz()>=0);
		assertTrue(graph.getRadius()>0);
		assertNotNull(graph.getField());
		
	}
	
	@Test
	public final void setgetTest(){
		Board board = new Board();
		Field[][] field = new Field[8][8];
		Controller controller = new Controller(); 
		board.setField(field);
		controller.setBoard(board);
		Graphfield graph = new Graphfield(10, controller);
		
		graph.setField(field);
		graph.setColor(null);
		graph.setPoly(null);
		graph.setRadius(0);
		graph.setSize(0);
		graph.setController(null);
		graph.setAttack(true);
		
		assertNotNull(graph.getField());
		assertNull(graph.getPoly());
		assertNull(graph.getController());
		assertNull(graph.getColor());
		assertEquals(0, graph.getSiz());
		assertEquals(0, graph.getRadius());
		assertTrue(graph.getAttack());
		
		
		
	}

}
