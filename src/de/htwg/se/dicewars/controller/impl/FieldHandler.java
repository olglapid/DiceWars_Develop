package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.command.CountFields;
import de.htwg.se.command.Invoker;
import de.htwg.se.command.Method;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public abstract class FieldHandler {

	/* returns the largest connected Field */
	public static int countConnectedFields(Board board) {
		int numberOfFields = 0;
		int connectedFields = 0;
		int tmp = 0;
		Field[][] field = board.getField();

		Method method = new Method();
		method.setDices(5);
		method.setField(field[0][0]);
		connectedFields = method.getNbrFields();
		CountFields countfields = new CountFields(method);
		Invoker invoker = new Invoker();
		invoker.setCommand(countfields);

		numberOfFields = board.getLength() * board.getLength();
		boolean[] visit = new boolean[numberOfFields];
		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;
				if (Walktrough.checkVisit(field[x][y], visit))
					continue;
				Walktrough.walkTroughFields(field[x][y], visit, invoker, method);
				tmp = method.getNbrFields();
				if (connectedFields < tmp)
					connectedFields = tmp;
				method.resetNbrFields();

			}

		}
		return connectedFields;
	}

}
