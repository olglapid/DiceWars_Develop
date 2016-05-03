package develop;

import java.util.Scanner;

public class Dice_start {
	static Field[][] field = null;
	static int number_of_Fields = 64;
	static int field_size;

	public static void main(String[] args) {

		field_size = (int) Math.sqrt((double) number_of_Fields);

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

		Field node ;
		node = Field.createField(number_of_Fields);
		TUI.tui(Field.converteFieldSize(number_of_Fields), 0);
		int index[] = new int[2];
		sc.close();

		TUI.globalPrint();
	}

}