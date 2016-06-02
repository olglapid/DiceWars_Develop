package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public abstract class FieldHandler {

	public static int countConnectedFields(Board board) {
		int amountOfconnectedFields = 0;
		int numberOfFields = 0;
		Field[][] field = board.getField();

		numberOfFields = board.getLength() * board.getLength();
		boolean[] visit = new boolean[numberOfFields];
		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;
				if (Walktrough.checkVisit(field[x][y], visit))
					continue;
				Walktrough.walkTroughFields(field[x][y], visit);
				amountOfconnectedFields++;

			}

		}
		return amountOfconnectedFields;
	}

	
}
