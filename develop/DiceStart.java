package develop;

import java.util.Scanner;

public class DiceStart {

	private DiceStart(){
		
	}
	public static void main(String[] args) {

		int numberOfFields = 64;

		Scanner sc = new Scanner(System.in);

		System.out.print("Anzahl an spielern: ");
		int tmpNbrOfPlayer = sc.nextInt();
		Player[] listOfPlayer = new Player[tmpNbrOfPlayer];

		for (int i = 0; i < listOfPlayer.length; i++) {
			System.out.print("Name: ");
			String eingabe = sc.next();
			listOfPlayer[i] = new Player();
			listOfPlayer[i].name = eingabe;
			listOfPlayer[i].playerNr = i;

		}

		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = Dice.initDiceToField(listOfPlayer[i], listOfPlayer[i].numberOfFields);
		}

		Field.createField(numberOfFields);
		TUI.tui(Field.converteFieldSize(numberOfFields));
		sc.close();

		TUI.globalPrint();
	}

}
