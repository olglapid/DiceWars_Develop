package de.htwg.se.dicewars;

import java.util.Scanner;

import org.apache.logging.log4j.Logger;

import de.htwg.se.dicewars.BoardSetup.BoardSetup;
import de.htwg.se.dicewars.BoardSetup.ConvertMethods;
import de.htwg.se.dicewars.BoardSetup.FieldSetup;
import de.htwg.se.dicewars.BoardSetup.PlayerSetup;
import de.htwg.se.dicewars.controller.impl.FieldHandler;
import de.htwg.se.dicewars.controller.impl.Walktrough;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Dice;
import de.htwg.se.dicewars.model.Player;

import org.apache.logging.log4j.LogManager;

public class DiceStart {
	private static final Logger log4j = LogManager.getLogger(DiceStart.class.getName());

	private DiceStart() {

	}

	public static void main(String[] args) {

		int fieldSize = 0;
		int numberOfFields = 0;
		TUI console = new TUI();
		final String newline = System.getProperty("line.separator");
		Scanner sc = new Scanner(System.in);

		do {
			log4j.info(newline + " Spielfeldgröße: ");
			fieldSize = sc.nextInt();
			log4j.info(newline + " Anzahl Felder: ");
			numberOfFields = sc.nextInt();
		} while (numberOfFields > fieldSize);
		
		log4j.info(newline + " Anzahl an spielern: ");
		int tmpNbrOfPlayer = sc.nextInt();
		Player[] listOfPlayer = new Player[tmpNbrOfPlayer];

		for (int i = 0; i < listOfPlayer.length; i++) {
			log4j.info(newline + " Name: ");
			String eingabe = sc.next();
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setName(eingabe);
			listOfPlayer[i].setPlayerNr(i);
			listOfPlayer[i].createField(8);

		}
		Board field = new Board(fieldSize);
		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = Dice.initDiceToField(listOfPlayer[i], listOfPlayer[i].getNumberOfFields());
			listOfPlayer[i].createField(ConvertMethods.converteFieldSize(fieldSize));
		}

		
		
		field = BoardSetup.createField(fieldSize, numberOfFields);
		
		field = BoardSetup.playerToField(field, listOfPlayer, numberOfFields);
		FieldHandler.countConnectedFields(field);
		console.tui(field.getLength(), field);
		log4j.info(newline + console.getConsole());
		sc.close();
	

		console.globalPrint(field);
		log4j.info(newline + console.getConsole());
		Board tmp = new Board(2);
		for (int i = 0; i < listOfPlayer.length; i++) {
			tmp.setField(listOfPlayer[i].getField());
			console.tui(field.getLength(),tmp);
		log4j.info(newline + console.getConsole());
		}
		
		

	}

}
