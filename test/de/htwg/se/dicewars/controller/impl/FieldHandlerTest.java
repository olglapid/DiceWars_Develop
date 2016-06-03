package de.htwg.se.dicewars.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.boardsetup.Fieldsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public class FieldHandlerTest {

	@Test
	public final void countConnectedFields() {
		Board board = new Board();
		board = Boardsetup.createField(9, 7);
		Field field[][] = board.getField();
		Field dummyfield = new Field();
		int flds =0;
		int fieldnumber=0;
		
		for (int i = 0; i < board.getLength(); i++) {
			for (int j = 0; j < board.getLength(); j++) {
				if(field[i][j] == null){
					dummyfield.setFieldNumber((i * field.length) + j + 1);
					dummyfield.setX(i);
					dummyfield.setY(j);
					field[i][j] = dummyfield;
				}
			}
		}
		flds = Fieldhandler.countConnectedFields(board);
		System.out.println(flds);
		assertEquals(7, flds);
	}

}
