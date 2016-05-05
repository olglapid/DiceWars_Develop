package develop;

import java.util.Scanner;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class DiceStart {
	private static final Logger log4j = LogManager.getLogger(DiceStart.class 
	        .getName());
	private DiceStart(){
		
	}
	public static void main(String[] args) {
	
		int fieldSize = 94;
		int numberOfFields = 15;
		String console = "";
		final String newline = System.getProperty("line.separator");
		Scanner sc = new Scanner(System.in);

		log4j.info(newline+" Anzahl an spielern: ");
		int tmpNbrOfPlayer = sc.nextInt();
		Player[] listOfPlayer = new Player[tmpNbrOfPlayer];

		for (int i = 0; i < listOfPlayer.length; i++) {
			log4j.info(newline + " Name: ");
			String eingabe = sc.next();
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setName(eingabe);
			listOfPlayer[i].setPlayerNr(i);

		}

		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = Dice.initDiceToField(listOfPlayer[i], listOfPlayer[i].getNumberOfFields());
		}

		Field[][] field=BoardSetup.createField(fieldSize,numberOfFields);
		console+=TUI.tui(BoardSetup.converteFieldSize(fieldSize),field);
		sc.close();
		console+="\n";
		console+=TUI.globalPrint(field);
		log4j.info(newline+console);
		
	}

}
