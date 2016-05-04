package develop;

import java.util.Scanner;

public class DiceStart {

	private DiceStart(){
		
	}
	public static void main(String[] args) {
	
		int fieldSize = 64;
		int numberOfFields = 49;
		String console = "";
		Scanner sc = new Scanner(System.in);

		System.out.print("Anzahl an spielern: ");
		int tmpNbrOfPlayer = sc.nextInt();
		Player[] listOfPlayer = new Player[tmpNbrOfPlayer];

		for (int i = 0; i < listOfPlayer.length; i++) {
			System.out.print("Name: ");
			String eingabe = sc.next();
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setName(eingabe);
			listOfPlayer[i].setPlayerNr(i);

		}

		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = Dice.initDiceToField(listOfPlayer[i], listOfPlayer[i].getNumberOfFields());
		}

		Field[][] field=Field.createField(fieldSize,numberOfFields);
		console+=TUI.tui(Field.converteFieldSize(fieldSize),field);
		sc.close();
		console+="\n";
		console+=TUI.globalPrint(field);
		System.out.println(console);
	}

}
