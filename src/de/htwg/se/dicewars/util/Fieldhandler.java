package de.htwg.se.dicewars.util;

import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.statistics.Statistics;
import de.htwg.se.dicewars.strategy.Context;
import de.htwg.se.dicewars.strategy.CountFields;

public abstract class Fieldhandler {
	private Fieldhandler(){
		
	}

	/* returns the largest connected Field */
	public static int countFields(Field[][] field) {
		int amount = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[i][j] == null)
					continue;
				amount++;
			}
		}
		return amount;
	}

	public static int countConnectedFields(Field[][] field, Player player) {
		int numberOfFields = 0;
		int connectedFields = 0;
		int tmp = 0;
		int tmp1 = 0;
		Statistics stats = new Statistics();

		if(player != null){
			stats.setPlayer(player);
		}
		Context context = new Context(new CountFields());
		numberOfFields = field.length * field.length;
		boolean[] visit = new boolean[numberOfFields];
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field.length; y++) {
				if (field[x][y] == null || Walktrough.checkVisit(field[x][y], visit))
					continue;
				
				Walktrough.walkTroughFields(field[x][y], visit, stats, context);

				tmp = stats.getNumberOfFields();
				tmp1 = stats.getNumberOfConnectedFields();
				tmp1++;
				stats.setNumberOfConnectedFields(tmp1);
				if (connectedFields < tmp)
					connectedFields = tmp;
				stats.setNumberOfFields(0);

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
