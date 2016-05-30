package de.htwg.se.dicewars;

import java.util.Random;

public class Board {
	Field[][] brd;
	private int length;
	private int[] owner;
	private boolean[] fieldsExists;

	public Board(int fieldSize) {
		brd = new Field[converteFieldSize(fieldSize)][converteFieldSize(fieldSize)];
		length = brd.length;
		owner = new int[fieldSize];
		fieldsExists = new boolean[fieldSize];
		for (int i = 0; i < fieldSize; i++) {
			owner[i] = -1;
			fieldsExists[i] = false;
		}
	}

	public void setField(Field[][] field) {
		this.brd = field;
	}

	public void setOwner(int nbr, int index) {
		this.owner[index] = nbr;
	}

	public int getOwner(int index) {
		return this.owner[index];
	}

	public void setExField(int index) {
		this.fieldsExists[index] = true;
	}

	public boolean getExField(int index) {
		return this.fieldsExists[index];
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}

	/* reserve space for Field */
	public Field initSingleField(Field[][] field, int x, int y) {
		Field node = new Field();
		node.setY(y);
		node.setX(x);
		field[x][y] = node;
		mallocNodes(node);
		fieldInList(field, node);
		return node;

	}

	/* returns a random number in range of value */
	public int randomNumber(int value) {
		Random r = new Random();
		return r.nextInt(value);
	}

	/* converts field in x/y size e.g. 49 = 7, 48 = 7, 37 = 6 */
	public int converteFieldSize(int numberOfFields) {
		return (int) Math.ceil(Math.sqrt(numberOfFields));
	}

	/* mallocs neighbors array */
	public Field mallocNodes(Field node) {
		Field[] tmp = new Field[8];
		node.setNachbar(tmp);
		setNeighborsNull(node);
		return node;
	}

	public void setNeighborsNull(Field node) {
		Field[] tmp = new Field[8];

		for (int i = 0; i < node.getNachbar().length; i++) {
			tmp[i] = null;
		}
		node.setNachbar(tmp);
	}

	public boolean checkx(Field node, int x, int fieldSize) {
		if (node.getX() + x > fieldSize - 1 || node.getX() + x < 0)
			return false;
		return true;
	}

	public boolean checky(Field node, int y, int fieldSize) {
		if (node.getY() + y > fieldSize - 1 || node.getY() + y < 0)
			return false;
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

	public boolean checkNoIndent(Field node, int x, int y) {
		if (node.getX() % 2 == 0) {
			if (x == y && x >= 0)
				return false;
			if (x + y == 0 && x == -1) {
				return false;
			}

		}
		return true;
	}

	public boolean checkNeighborIndex(Field node, int nextx, int nexty, int fieldSize) {

		if (!checkNoIndent(node, nextx, nexty))
			return false;
		if (!checkIndent(node, nextx, nexty))
			return false;
		if (!checkx(node, nextx, fieldSize))
			return false;
		if (!checky(node, nexty, fieldSize))
			return false;

		return true;
	}

	/* jede Index operation hat ihren festen platz im nachbarfeld */
	public int xPlusyNegativeOne(int x) {
		if (x == -1)
			return 3;
		return 2;

	}

	public int xPlusyZero(int x) {
		if (x == -1)
			return 4;
		return 6;

	}

	public int xPlusyOne(int x) {
		if (x == 1)
			return 1;
		return 0;

	}

	public int xPlusyLowerOne(int x, int y) {
		if (x + y == -1) {
			return xPlusyNegativeOne(x);
		} else if (x + y == 0) {
			return xPlusyZero(x);
		} else if (x + y == -2) {
			return 7;
		}

		return -1;

	}

	public int xPlusyHigherZero(int x, int y) {
		if (x + y == 1) {
			return xPlusyOne(x);
		} else if (x + y == 2) {
			return 5;
		}
		return -1;
	}

	public int getNeighborfromIndex(int x, int y) {
		if (x + y < 1)
			return xPlusyLowerOne(x, y);

		return xPlusyHigherZero(x, y);

	}

	public Field connectNodes(Field[][] field, Field node, int numberOfFields, int fieldSize) {
		if (numberOfFields == 1)
			return node;
		int nextx;
		int nexty;
		int vorzeichenx;
		int vorzeicheny;
		int index;

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

		if (field[node.getX() + nextx][node.getY() + nexty] != null) {
			node.getNachbar()[index] = field[node.getX() + nextx][node.getY() + nexty];
			return connectNodes(field, node.getNachbar()[index], numberOfFields, fieldSize);
		}

		node.getNachbar()[index] = initSingleField(field, node.getX() + nextx, node.getY() + nexty);
		return connectNodes(field, node.getNachbar()[index], numberOfFields - 1, fieldSize);

	}

	public Board createField(int fieldSize, int numberOfFields) {

		Field node = new Field();
		int matrixSize = converteFieldSize(fieldSize);
		Field[][] field = new Field[matrixSize][matrixSize];

		node = initSingleField(field, randomNumber(matrixSize), randomNumber(matrixSize));
		node = mallocNodes(node);

		connectNodes(field, node, numberOfFields, matrixSize);
		connectFields(field);
		Board board = new Board(fieldSize);
		board.brd = field;
		return board;
	}

	public Field setNeigbors(Field[][] fieldTmp, int a, int b) {
		int value;
		for (int j = -1; j <= 1; j++) {
			for (int i = -1; i <= 1; i++) {
				value = getNeighborfromIndex(j, i);

				if (!checkNeighborIndex(fieldTmp[a][b], j, i, fieldTmp.length)) {
					fieldTmp[a][b].getNachbar()[value] = null;
				} else {

					fieldTmp[a][b].getNachbar()[value] = fieldTmp[a + j][b + i];
				}
			}
		}
		return fieldTmp[a][b];
	}

	public void setFieldNumber(Field[][] field, int x, int y) {
		if (field[x][y] != null)
			field[x][y].setFieldNumber((x * field.length) + y + 1);
	}

	public int[] fieldNumberToIndex(int fieldSize, int fieldNumber) {
		int tmpFieldNumber = fieldNumber - 1;
		int[] index = new int[2];

		index[1] = tmpFieldNumber % fieldSize;
		index[0] = tmpFieldNumber / fieldSize;

		return index;
	}

	public Field[][] connectFields(Field[][] field) {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[j][i] == null)
					continue;
				field[j][i] = setNeigbors(field, j, i);
				setFieldNumber(field, j, i);
			}
		}
		return field;
	}

	public Field[][] fieldInList(Field[][] field, Field p) {
		field[p.getX()][p.getY()] = p;
		return field;
	}

	public int addDice(Board field, int x, int y, int amount) {
		int returnDices = 0;
		int tmp = field.brd[x][y].getNumberOfDices();
		tmp += amount;
		returnDices = field.brd[x][y].setNumberOfDices(tmp);
		return returnDices;
	}

	public int[] playerSpreadDices(Board field, Player[] listOfPlayer, int numberOfFields) {
		int[] fickdich = new int[0];
		return fickdich;
	}

	public int getPlayerIndex(int[] playerGet) {
		Board tmp = new Board(5);
		int index = 0;
		do {
			index = tmp.randomNumber(playerGet.length);
		} while (playerGet[index] == 0);
		return index;
	}

	public int getDicesRandom(int dices, int value) {
		Board tmp = new Board(5);
		int random = 0;
		if (dices == 0)
			return 0;
		do {
			random = tmp.randomNumber(value);
		} while (dices - random < 0);
		return random;
	}

	public Board spreadPlayerToField(Board field, Player[] listOfPlayer, int numberOfFields, int[] playerGet) {
		return field;
	}

	public int getMax(int[] list) {
		int tmp = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] > tmp) {
				tmp = list[i];
			}
		}
		return tmp;
	}

	public boolean checkEmptyList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean checkDicesAdd(Board field, int x, int y) {
		if (field.brd[x][y].getNumberOfDices() > 7) {
			return true;
		}
		return false;
	}

	public int lowerIndex(int[] list, int index, int ctr) {
		int tmpIndex = index - ctr;
		if (tmpIndex < 0) {
			return -2;
		} else if (list[tmpIndex] > 0) {
			return tmpIndex;
		} else {
			return -1;
		}
	}

	public int higherIndex(int[] list, int index, int ctr) {
		int tmpIndex = index + ctr;
		if (tmpIndex >= list.length) {
			return -3;
		} else if (list[tmpIndex] > 0) {
			return tmpIndex;
		} else {
			return -1;
		}
	}

	public int wuerfelnOhneZurueckLegen(int[] list) {
		int index = randomNumber(list.length);
		if (list[index] > 0) {
			list[index] -= 1;
			return index;
		}
		int tmpP;
		int tmpN;
		for (int i = 1; i < list.length; i++) {
			tmpP = higherIndex(list, index, i);
			tmpN = lowerIndex(list, index, i);
			if (tmpP >= 0) {
				list[tmpP] -= 1;
				return tmpP;
			}
			if (tmpN >= 0) {
				list[tmpN] -= 1;
				return tmpN;
			}
		}

		return -1;
	}

	public void handleRest(int[] list, int rest) {
		int index = 0;
		for (int i = 0; i < rest; i++) {
			index = randomNumber(list.length);
			list[index] += 1;
		}
	}

	public void handOutFields(int[] list, int numberOfFields) {
		int length = list.length;
		int rest = numberOfFields % length;
		int fields = numberOfFields / length;
		for (int i = 0; i < list.length; i++) {
			list[i] = fields;
		}
		handleRest(list, rest);
	}

	public void addDicesToPlayer(Player[] listOfPlayer, int index, int amount) {
		int tmp = 0;
		tmp = listOfPlayer[index].getNumberOfDices();
		tmp += amount;
		listOfPlayer[index].setNumberOfDices(tmp);
	}

	public Board playerToField(Board field, Player[] listOfPlayer, int numberOfFields) {
		int[] listOfFields = new int[listOfPlayer.length];
		int index = 0;
		handOutFields(listOfFields, numberOfFields);

		for (int x = 0; x < field.getLength(); x++) {
			for (int y = 0; y < field.getLength(); y++) {
				if (field.brd[x][y] == null)
					continue;
				index = wuerfelnOhneZurueckLegen(listOfFields);
				field.brd[x][y].setOwner(listOfPlayer[index]);
				addDice(field, x, y, 1);
				addDicesToPlayer(listOfPlayer, index, 1);
				listOfPlayer[index].setFieldFromIndex(field.brd[x][y]);
				System.out.println(listOfPlayer[index].getNumberOfDices());
			}
		}
		return field;
	}

	public void handOutDices(Player player) {
		int numberOfDices = player.getNumberOfDices();
		int dices = 0;
		int ctr=1;
		int[] index;
		while (numberOfDices > 0) {
			if(ctr>length){
				ctr=1;
			}
			if(randomNumber(1)==0){
				ctr++;
				continue;
			}
			index=fieldNumberToIndex(this.length, ctr);
			
			if(player.getFieldFromIndex(index[0], index[1])==null){
				ctr++;
				continue;
			}
			if (numberOfDices > 7) {
				dices = getDicesRandom(numberOfDices, 7);
			} else {
				dices = getDicesRandom(numberOfDices, numberOfDices);
			}
			

		}
	}
}
