package Develop;

import java.util.Stack;

public class Field {
	public Field nachbar[] = null;
	int nachbarCtr;
	public int x;
	public int y;
	int fieldNumber;
	int numberOfDices;

	public Field() {
		x = 0;
		y = 0;
		numberOfDices = 0;
		nachbarCtr = 0;
		fieldNumber = 0;
	}

	public static Field[][] field;
	static Stack<int[]> fieldStack = new Stack<int[]>();

	/*----------------------------------------------------------- Neuer Ansatz ----------------------------------*/
	/* reserve space for Field */
	public static Field initSingleField(Field node, int x, int y) {
		if (TUI.globalField[x][y] > 0)
			System.out.println("ERROR:");
		int[] index = new int[2];
		index[0] = x;
		index[1] = y;
		node = new Field();
		node.y = y;
		node.x = x;
		mallocNodes(node, x, y);
		TUI.globalField[x][y] += 1;
		FieldInList(node);
		fieldStack.push(index);
		return node;

	}

	/*
	 * If a new Node is created, existing neighbours dont know they exist so we
	 * need to let them know
	 */
	public static Field connectNewNeighbours(Field node) {
		// TODO Alle nachbarn von Node sagen, dass "Ich" existiere

		return node;
	}

	/* returns a random number in range of value */
	public static int randomNumber(int value) {
		return (int) (Math.random() * value);
	}

	/* converts field in x/y size e.g. 49 = 7, 48 = 7, 37 = 6 */
	public static int converteFieldSize(int numberOfFields) {
		return (int) Math.ceil(Math.sqrt(numberOfFields));
	}

	/* mallocs neighbors array */
	public static Field mallocNodes(Field node, int x, int y) {
		Field tmp[] = new Field[8];
		node.nachbar = tmp;
		setNeighborsNull(node);
		return node;
	}

	public static void setNeighborsNull(Field node) {

		for (int i = 0; i < node.nachbar.length; i++) {
			node.nachbar[i] = null;
		}
	}

	public static boolean checkx(Field node, int x, int fieldSize) {
		if (node.x + x > fieldSize - 1 || node.x + x < 0)
			return false;
		return true;
	}

	public static boolean checky(Field node, int y, int fieldSize) {
		if (node.y + y > fieldSize - 1 || node.y + y < 0)
			return false;
		return true;
	}

	public static boolean checkNeighborIndex(Field node, int nextx, int nexty, int fieldSize) {

		if (node.x % 2 == 0) {
			if (nextx == nexty && nextx >= 0)
				return false;
			if (nextx + nexty == 0) {
				if (nextx == -1)
					return false;
			}

		}
		if (node.x % 2 != 0) {
			if (nextx == nexty && nextx <= 0)
				return false;
			if (nextx + nexty == 0) {
				if (nexty == -1)
					return false;
			}
		}
		if (!checkx(node, nextx, fieldSize))
			return false;
		if (!checky(node, nexty, fieldSize))
			return false;

		return true;
	}

	/* jede Index operation hat ihren festen platz im nachbarfeld */
	//msdf
	public static int getNeighborfromIndex(int x, int y) {
		switch (x + y) {
		case -1:
			if (x == -1)
				return 3;
			else {
				return 2;
			}
		case 0:
			if (x == -1) {
				return 4;
			} else {
				return 6;
			}
		case 1:
			if (x == 1)
				return 1;
			else {
				return 0;
			}
		case 2:
			return 5;
		case -2:
			return 7;

		default:
			System.out.println("INDEX ERROR: FIELD.JAVA 114");
			return -1;
		}

	}

	public static Field connectNodes(Field node, int numberOfFields, int fieldSize) {
		if (numberOfFields == 1)
			return node;
		int nextx, nexty, vorzeichenx, vorzeicheny, index;

		do {
			nextx = randomNumber(2);
			nexty = randomNumber(2);
			vorzeichenx = randomNumber(2);
			vorzeicheny = randomNumber(2);
			if (vorzeicheny == 1)
				nexty = nexty * (-1);
			if (vorzeichenx == 1)
				nextx = nextx * (-1);

		} while (!checkNeighborIndex(node, nextx, nexty, fieldSize));

		index = getNeighborfromIndex(nextx, nexty);

		if (TUI.globalField[node.x + nextx][node.y + nexty] > 0) {
			node.nachbar[index] = field[node.x + nextx][node.y + nexty];
			return connectNodes(node.nachbar[index], numberOfFields, fieldSize);
		}

		if (node.nachbar[index] == null) {
			node.nachbar[index] = initSingleField(node.nachbar[index], node.x + nextx, node.y + nexty);
			return connectNodes(node.nachbar[index], numberOfFields - 1, fieldSize);
		}

		return connectNodes(node.nachbar[index], numberOfFields, fieldSize);
	}

	public static Field createField(int numberOfFields) {
		Field node = null;
		int matrixSize = converteFieldSize(numberOfFields);
		System.out.println("matrixSize " + matrixSize);
		field = new Field[matrixSize][matrixSize];
		TUI.globalField = new int[matrixSize][matrixSize];
		node = initSingleField(node, randomNumber(matrixSize), randomNumber(matrixSize));
		node = mallocNodes(node, node.x, node.y);
		/* 24 = 24 verbundene Felder erstellen */
		connectNodes(node, 9, matrixSize);
		connectFields();
		return node;
	}

	public static Field nodeControl(Field node) {
		// System.out.println("x " + node.x + " | y " + node.y);
		// System.out.println("MEINE NACHBARN SIND: ");
		for (int i = 0; i < node.nachbar.length; i++) {
			if (node.nachbar[i] == null)
				continue;
			// System.out.print(" | x: " + node.nachbar[i].x + " / y: " +
			// node.nachbar[i].y);
		}
		for (int i = 0; i < 2; i++) {
			if (node.nachbar[i] == null)
				continue;
			nodeControl(node.nachbar[i]);
		}
		return node;
	}

	public static Field setNeigbors(Field fieldTmp[][], int a, int b) {
		int value, x, y;
		for (int j = -1; j <= 1; j++) {
			for (int i = -1; i <= 1; i++) {
				value = getNeighborfromIndex(j, i);
				// System.out.println("Value: "+value+" i : "+i);
				if (value == -1)
					continue;
				if (!checkNeighborIndex(fieldTmp[a][b], j, i, fieldTmp.length)) {
					// System.out.println("value: "+value + " NULL");

					fieldTmp[a][b].nachbar[value] = null;
				} else {
					if (j == -1 && i == 1 && value == 4 && a == 1 && b == 0) {
						System.out.println("FUCK");

					}
					// System.out.println(a+" "+b+" J : "+j+" I: "+i);
					// System.out.println("value: "+value + " Nicht NULL");
					fieldTmp[a][b].nachbar[value] = fieldTmp[a + j][b + i];
				}
			}
		}
		return fieldTmp[a][b];
	}

	public static void setFieldNumber(int x, int y) {
		field[x][y].fieldNumber = ((x * field.length) + y + 1);
	}

	public static void connectFields() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[j][i] == null)
					continue;
				field[j][i] = setNeigbors(field, j, i);
				setFieldNumber(j, i);
			}

		}

	}

	public static void FieldInList(Field p) {
		field[p.x][p.y] = p;
	}
}
