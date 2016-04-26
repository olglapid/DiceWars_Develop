package egal;
public class TUI {

	public static int[][] globalField=new int[7][7];
	public static String field(int[] row, int ctr) {
		String tmp = " ";
		String value;
		if (ctr > 0) {
			ctr--;

			value = String.valueOf(row[row.length - ctr - 1]);
			if(row[row.length - ctr - 1] == 0)
				value = "";
			switch (value.length()) {
			case 1:
				tmp = "| " + value + " |" + field(row, ctr);
				break;
			case 2:
				tmp = "|" + value + " |" + field(row, ctr);
				break;
			case 3:
				tmp = "|" + value + "|" + field(row, ctr);
				break;

			default:
				tmp = "|   |" + field(row, ctr);
				break;
			}


		} else {
			tmp = tmp + "\n";
		}

		return tmp;
	}

	public static String top(int ctr) {
		String tmp = "";
		if (ctr > 0) {
			ctr--;
			tmp += " / \\ " + top(ctr);
		} else {
			tmp += "/\n";
		}
		return tmp;
	}

	public static String bot(int ctr) {
		String tmp = "";
		if (ctr > 0) {
			ctr--;
			tmp += " \\ / " + bot(ctr);
		} else {
			tmp += "\\\n";
		}
		return tmp;
	}

	public static void tui( int field_size, int trigger) {

		String tmp = "";

		for (int i = 0; i < field_size; i++) {

			if (i % 2 != 0) {
				tmp += "  " + field(globalField[i], field_size);
				tmp += "  " + field(globalField[i], field_size);
				continue;
			}
			tmp += top(field_size);
			tmp += field(globalField[i], field_size);
			tmp += field(globalField[i], field_size);
			tmp += bot(field_size);
		}

		System.out.println(tmp);
		System.out.println("----------------------------------------------------------------");
		
	}

	public static void print_neigbors(Field[][] field, int field_size) {
		for (int i = 0; i < field_size; i++) {
			for (int j = 0; j < field_size; j++) {
				System.out.print("Field : [" + i + "][" + j + "] : ");
				for (int a = 0; a < field[i][j].nachbarCtr; a++) {
					System.out.print(field[i][j].nachbar[a].fieldNumber + " | ");
				}
				System.out.println();
			}
		}
	}
}
