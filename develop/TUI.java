package develop;

public class TUI {
	private TUI() {

	}

	public static String field(Field[][] globalField, Field[] row, int ctr) {
		int tmpCtr = ctr;
		String tmp = "";
		String value;
		if (tmpCtr > 0) {
			tmpCtr--;

			if (row[row.length - tmpCtr - 1] == null)
				value = "";
			else {
				value = String.valueOf(row[row.length - tmpCtr - 1].getFieldNumber());
			}

			tmp = format(tmp, value) + field(globalField, row, tmpCtr);

		} else {
			tmp = tmp + "\n";
		}

		return tmp;
	}

	public static String top(int ctr) {
		String tmp = "";
		int tmpCtr = ctr;
		if (tmpCtr > 0) {
			tmpCtr--;
			tmp += " / \\ " + top(tmpCtr);
		} else {
			tmp += "/\n";
		}
		return tmp;
	}

	public static String bot(int ctr) {
		String tmp = "";
		int tmpCtr = ctr;
		if (tmpCtr > 0) {
			tmpCtr--;
			tmp += " \\ / " + bot(tmpCtr);
		} else {
			tmp += "\\\n";
		}
		return tmp;
	}

	public static String tui(int fieldSize, Field[][] globalField) {

		String tmp = "";

		for (int i = 0; i < fieldSize; i++) {

			if (i % 2 != 0) {
				tmp += "  " + field(globalField, globalField[i], fieldSize);
				tmp += "  " + field(globalField, globalField[i], fieldSize);
				continue;
			}
			tmp += top(fieldSize);
			tmp += field(globalField, globalField[i], fieldSize);
			tmp += field(globalField, globalField[i], fieldSize);
			tmp += bot(fieldSize);
		}

		
		tmp+="\n";
		tmp+="----------------------------------------------------------------";
		return tmp;
	}

	public static String printBox(Field[][] field, String value, int x, int y) {
		String value1 = "";
		if (y >= field.length) {
			return value;
		}
		if (field[x][y] == null) {
			value1 = "";
		} else {
			value1 += field[x][y].getFieldNumber();
		}

		return printBox(field, format(value, value1), x, y + 1);
	}

	public static String format(String value, String value1) {

		String tmpValue = value;
		String border = "|";
		int number;

		number = value1.length();
		tmpValue += border;
		for (int i = number; i < 3; i++) {

			tmpValue += " ";
		}

		tmpValue += value1 + border;

		return tmpValue;
	}

	public static String printBoxNeighbors(Field[][] field, String value, int x, int y, int ctr) {
		int tmpCtr = ctr;
		if (tmpCtr >= 8)
			return value;
		if (y >= field.length) {
			value += "\n";
			return printBoxNeighbors(field, value, x, 0, tmpCtr + 1);
		}

		if (field[x][y] == null) {
			value += "|   |";
			return printBoxNeighbors(field, value, x, y + 1, tmpCtr);
		}
		String value1 = "";
		if (field[x][y].getNachbar()[ctr] == null) {
			return printBoxNeighbors(field, format(value, value1), x, y + 1, tmpCtr);
		}
		value1 += field[x][y].getNachbar()[ctr].getFieldNumber();
		return printBoxNeighbors(field, format(value, value1), x, y + 1, tmpCtr);

	}

	public static String globalPrint(Field[][] field) {
		String value = "";
		String endValue = "";
		for (int j = 0; j < field.length; j++) {
			endValue += printBox(field, value, j, 0);
			value += "";
			endValue += "\n";
			endValue += printBoxNeighbors(field, value, j, 0, 0);
			endValue += "\n";
		}
		return endValue;
	}

}
