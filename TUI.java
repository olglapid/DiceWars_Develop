package Develop;

public class TUI {

	public static int[][] globalField = new int[7][7];

	public static String field(int[] row, int ctr) {
		String tmp = " ";
		String value;
		if (ctr > 0) {
			ctr--;

			value = String.valueOf(row[row.length - ctr - 1]);
			if (row[row.length - ctr - 1] == 0)
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

	public static void tui(int field_size, int trigger) {

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
	public static String printBox(String value,int x, int y){
		if(y>=Field.globalList.length){
			return value;
		}
		if(Field.globalList[x][y]==null){
			value+="|   |";
			return printBox(value, x, y+1);
		}
			
		if(Field.globalList[x][y].fieldNumber>=100){
			value+="|"+Field.globalList[x][y].fieldNumber+"|";
		}
		else if (Field.globalList[x][y].fieldNumber>=10) {
			value+="|"+Field.globalList[x][y].fieldNumber+" |";
		}
		else {
			value+="|"+Field.globalList[x][y].fieldNumber+"  |";
		}
		return printBox(value, x, y+1);
	}
	public static String printBoxNeighbors(String value,int x,int y,int ctr){
		if(ctr>=6)
			return value;
		if(y>=Field.globalList.length)
			return printBoxNeighbors((value+="\n"), x, 0,ctr+1);
		if(Field.globalList[x][y]==null){
			value+="|   |";
			return printBoxNeighbors(value, x, y+1, ctr);
		}
		if(Field.globalList[x][y].nachbar[ctr]==null){
			value+="|   |";
			return printBoxNeighbors(value, x, y+1, ctr);
		}
		if(Field.globalList[x][y].nachbar[ctr].fieldNumber>=100){
			value+="|"+Field.globalList[x][y].nachbar[ctr].fieldNumber+"|";
		}
		else if(Field.globalList[x][y].nachbar[ctr].fieldNumber>=10){
			value+="|"+Field.globalList[x][y].nachbar[ctr].fieldNumber+" |";
		}
		else {
			value+="|"+Field.globalList[x][y].nachbar[ctr].fieldNumber+"  |";
		}
		return printBoxNeighbors(value, x, y+1, ctr);
		
	}
	public static void globalPrint() {
		System.out.println();
		String value="";
		for (int j = 0; j < Field.globalList.length; j++) {
			System.out.println(printBox(value, j, 0));
			value="";
			System.out.println(printBoxNeighbors(value, j, 0, 0));

		}
		
	}
}
