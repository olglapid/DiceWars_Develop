package Develop;

import java.util.Scanner;

public class Dice_start {
	static Field[][] field = null;
	static int number_of_Fields = 49; // Muss quadratzahl sein
	static int field_size;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		field_size = (int) Math.sqrt((double) number_of_Fields);
		// TUI.tui();
		Scanner sc = new Scanner(System.in);

		System.out.print("Anzahl an spielern: ");
		int tmp_nbr_player = (int) sc.nextInt();
		Player[] list_of_Player = new Player[tmp_nbr_player];

		for (int i = 0; i < list_of_Player.length; i++) {
			System.out.print("Name: ");
			String eingabe = sc.next();
			list_of_Player[i] = new Player();
			list_of_Player[i].name = eingabe;
			list_of_Player[i].player_nbr = i;

		}

		for (int i = 0; i < list_of_Player.length; i++) {
			list_of_Player[i] = Dice.init_Dice_to_Field(list_of_Player[i], list_of_Player[i].number_of_Fields);
		}

		Field node = new Field();
		node = Field.createField(9);
		TUI.tui(Field.converteFieldSize(9), 0);
		int index[] = new int[2];
		// while(!Field.fieldStack.empty()){
		// index=Field.fieldStack.pop();
		// System.out.println("ROW : "+index[0]+" | COL: "+index[1]);
		// }
		sc.close();
		/* TEST NEIGHBORS */
		Field.nodeControl(node);
		/////
		TUI.globalPrint();
	}

}
