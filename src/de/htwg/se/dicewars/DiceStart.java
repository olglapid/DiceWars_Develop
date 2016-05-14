package de.htwg.se.dicewars;


import java.util.Scanner;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class DiceStart {
	private static final Logger log4j = LogManager.getLogger(DiceStart.class 
	        .getName());
	private DiceStart(){
		
	}
	public static void main(String[] args) {
	
		int fieldSize = 0;
		int numberOfFields = 0;
		TUI console = new TUI();
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
		do{
		log4j.info(newline+" Spielfeldgröße: ");
		fieldSize = sc.nextInt();
		log4j.info(newline+" Anzahl Felder: ");
		numberOfFields = sc.nextInt();
		}while(numberOfFields>fieldSize);
		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = Dice.initDiceToField(listOfPlayer[i], listOfPlayer[i].getNumberOfFields());
		}

		Board field =  new Board(fieldSize);
		
		field=field.createField(fieldSize,numberOfFields);
		field = field.playerToField(field, listOfPlayer, numberOfFields);
		console.tui(field.getLength(),field);
		log4j.info(newline+console.getConsole());
		sc.close();
		
		

		console.globalPrint(field);
		log4j.info(newline+console.getConsole());
		
		
	}

}
