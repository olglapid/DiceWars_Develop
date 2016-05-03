package develop;

public class TUI {
	private TUI() {

	}

	public static int[][] globalField = null;

	public static String field(int[] row, int ctr) {
		int tmpCtr = ctr;
		String tmp = " ";
		String value;
		if (tmpCtr > 0) {
			tmpCtr--;

			value = String.valueOf(row[row.length - tmpCtr - 1]);
			if (row[row.length - tmpCtr - 1] == 0)
				value = "";
			switch (value.length()) {
			case 1:
				tmp = "| " + value + " |" + field(row, tmpCtr);
				break;
			case 2:
				tmp = "|" + value + " |" + field(row, tmpCtr);
				break;
			case 3:
				tmp = "|" + value + "|" + field(row, tmpCtr);
				break;

			default:
				tmp = "|   |" + field(row, tmpCtr);
				break;
			}

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

	public static void tui(int fieldSize) {

		String tmp = "";

		for (int i = 0; i < fieldSize; i++) {

			if (i % 2 != 0) {
				tmp += "  " + field(globalField[i], fieldSize);
				tmp += "  " + field(globalField[i], fieldSize);
				continue;
			}
			tmp += top(fieldSize);
			tmp += field(globalField[i], fieldSize);
			tmp += field(globalField[i], fieldSize);
			tmp += bot(fieldSize);
		}

		System.out.println(tmp);
		System.out.println("----------------------------------------------------------------");

	}

	public static void printNeighbors(Field[][] field, int fieldSize) {
		for (int i = 0; i < fieldSize; i++) {
			for (int j = 0; j < fieldSize; j++) {
				System.out.print("Field : [" + i + "][" + j + "] : ");
				for (int a = 0; a < field[i][j].nachbarCtr; a++) {
					System.out.print(field[i][j].nachbar[a].fieldNumber + " | ");
				}
				System.out.println();
			}
		}
	}

	public static String printBox(String value, int x, int y) {
		if (y >= Field.field.length) {
			return value;
		}
		if (Field.field[x][y] == null) {
			value += "|   |";
			return printBox(value, x, y + 1);
		}

		if (Field.field[x][y].fieldNumber >= 100) {
			value += "|" + Field.field[x][y].fieldNumber + "|";
		} else if (Field.field[x][y].fieldNumber >= 10) {
			value += "|" + Field.field[x][y].fieldNumber + " |";
		} else {
			value += "|" + Field.field[x][y].fieldNumber + "  |";
		}
		return printBox(value, x, y + 1);
	}
	
public static String format(String value, int x, int y, int ctr){
	int tmpCtr = ctr;
	String tmpValue=value;
	String I = "|";
	int number;
	if(Field.field[x][y].nachbar[tmpCtr] == null){
		tmpValue+=I+"   "+I;
		return tmpValue;
	}
		
	
	
	number = Field.field[x][y].nachbar[tmpCtr].fieldNumber;
	tmpValue+=I;
	for(int i=100;i>1;i=i/10){
		if(number/i>0)
			break;
		tmpValue+=" ";
	}

	tmpValue+=number+I;
	
	return tmpValue;
}

	public static String printBoxNeighbors(String value, int x, int y, int ctr) {
		int tmpCtr = ctr;
		if (tmpCtr >= 8)
			return value;
		if (y >= Field.field.length){
			value += "\n";
			return printBoxNeighbors(value, x, 0, tmpCtr + 1);
		}
			
		if (Field.field[x][y] == null) {
			value += "|   |";
			return printBoxNeighbors(value, x, y + 1, tmpCtr);
		}

		return printBoxNeighbors(format(value, x, y, tmpCtr), x, y + 1, tmpCtr);

	}

	public static void globalPrint() {
		System.out.println();
		String value = "";
		for (int j = 0; j < Field.field.length; j++) {
			System.out.println(printBox(value, j, 0));
			value = "";
			System.out.println(printBoxNeighbors(value, j, 0, 0));

		}

	}
}
