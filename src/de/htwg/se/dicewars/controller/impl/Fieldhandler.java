package de.htwg.se.dicewars.controller.impl;

import de.htwg.se.command.CountFields;
import de.htwg.se.command.Invoker;
import de.htwg.se.command.Method;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;

public abstract class Fieldhandler {

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

	/* -------------------------------------------------- */
	/* jede Index operation hat ihren festen platz im nachbarfeld */
	public static int getNeighborfromIndex(int x, int y) {
		if (Math.abs(x) > 1 || Math.abs(y) > 1)
			return -1;
		if (x + y < 1)
			return xPlusyLowerOne(x, y);

		return xPlusyHigherZero(x, y);

	}

	public static int xPlusyLowerOne(int x, int y) {
		if (x + y == -1) {
			return xPlusyNegativeOne(x);
		} else if (x + y == 0) {
			return xPlusyZero(x);
		} else if (x + y == -2) {
			return 7;
		}

		return -1;

	}

	public static int xPlusyHigherZero(int x, int y) {
		if (x + y == 1) {
			return xPlusyOne(x);
		} else if (x + y == 2) {
			return 5;
		}
		return -1;
	}

	public static int xPlusyZero(int x) {
		if (x == -1)
			return 4;
		return 6;

	}

	public static int xPlusyOne(int x) {
		if (x == 1)
			return 1;
		return 0;

	}

	public static int xPlusyNegativeOne(int x) {
		if (x == -1)
			return 3;
		return 2;

	}

	/* -------------------------------------------------- */

	/* Checks if index is a valid neighbour */
	public static boolean checkNeighborIndex(Field node, int x, int y, int fieldSize) {

		if (!checkNoIndent(node, x, y))
			return false;
		if (!checkIndent(node, x, y))
			return false;
		if (!checkx(node, x, fieldSize))
			return false;
		if (!checky(node, y, fieldSize))
			return false;

		return true;
	}

	public static boolean checkNoIndent(Field node, int x, int y) {
		if (node.getX() % 2 == 0) {
			if (x == y && x >= 0)
				return false;
			if (x + y == 0 && x == -1) {
				return false;
			}

		}
		return true;
	}

	public static boolean checkIndent(Field node, int x, int y) {
		if (node.getX() % 2 != 0) {
			if (x == y && x <= 0)
				return false;
			if (x + y == 0 && y == -1) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkx(Field node, int x, int fieldSize) {
		if (node.getX() + x > fieldSize - 1 || node.getX() + x < 0)
			return false;
		return true;
	}

	public static boolean checky(Field node, int y, int fieldSize) {
		if (node.getY() + y > fieldSize - 1 || node.getY() + y < 0)
			return false;
		return true;
	}

	/*----------------------------------------------------------------*/

}
