package de.htwg.se.dicewars.view;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.se.dicewars.DiceStart;
import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.setup.Controller;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import interfaces.TuiInterface;

public class TUI implements TuiInterface {
	private static final Logger log4j = LogManager.getLogger(DiceStart.class.getName());
	String console;

	public TUI() {
		console = "";
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public void addConsole(String console) {
		this.console += console;
	}

	public String getConsole() {
		return this.console;
	}

	public String field(Board globalField, Field[] row, int ctr, int trigger) {
		int tmpCtr = ctr;
		String tmp = "";
		String value;
		if (tmpCtr > 0) {
			tmpCtr--;

			if (row[row.length - tmpCtr - 1] == null)
				value = "";
			else {
				if (trigger == 0) {
					value = String.valueOf(row[row.length - tmpCtr - 1].getFieldNumber());
				} else if (trigger == 1) {
					value = String.valueOf(row[row.length - tmpCtr - 1].getOwner().getPlayerNr());
				} else {
					value = String.valueOf(row[row.length - tmpCtr - 1].getNumberOfDices());
				}
			}

			tmp = format(tmp, value) + field(globalField, row, tmpCtr, trigger);

		} else {
			tmp = tmp + "\n";
		}

		return tmp;
	}

	public String top(int ctr) {
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

	public String bot(int ctr) {
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

	public void tui(int fieldSize, Board globalField) {

		String tmp = "";

		for (int i = 0; i < fieldSize; i++) {

			if (i % 2 != 0) {
				tmp += "  " + field(globalField, globalField.getField()[i], fieldSize, 1);
				tmp += "  " + field(globalField, globalField.getField()[i], fieldSize, 2);
				continue;
			}
			tmp += top(fieldSize);
			tmp += field(globalField, globalField.getField()[i], fieldSize, 1);
			tmp += field(globalField, globalField.getField()[i], fieldSize, 2);
			tmp += bot(fieldSize);
		}

		tmp += "\n";
		tmp += "----------------------------------------------------------------";
		this.setConsole(tmp);
		;
	}

	public String printBox(Board field, String value, int x, int y) {
		String value1 = "";
		Field[][] tmpField = field.getField();

		if (y >= tmpField.length) {
			return value;
		}
		if (tmpField[x][y] == null) {
			value1 = "";
		} else {
			value1 += tmpField[x][y].getFieldNumber();
		}

		return printBox(field, format(value, value1), x, y + 1);
	}

	public String format(String value, String value1) {

		String tmpValue = value;
		String border = "|";
		int number;

		number = value1.length();
		tmpValue += border;
		for (int i = number; i < 3; i++) {

			tmpValue += " ";
		}

		tmpValue += value1 + border;

		return tmpValue;
	}

	public String printBoxNeighbors(Board field, String value, int x, int y, int ctr) {
		String tmp = value;
		Field[][] tmpField = field.getField();
		int tmpCtr = ctr;
		if (tmpCtr >= 8)
			return tmp;
		if (y >= field.getLength()) {
			tmp += "\n";
			return printBoxNeighbors(field, tmp, x, 0, tmpCtr + 1);
		}

		if (tmpField[x][y] == null) {
			tmp += "|   |";
			return printBoxNeighbors(field, tmp, x, y + 1, tmpCtr);
		}
		String value1 = "";
		if (tmpField[x][y].getNachbar()[ctr] == null) {
			return printBoxNeighbors(field, format(tmp, value1), x, y + 1, tmpCtr);
		}
		value1 += tmpField[x][y].getNachbar()[ctr].getFieldNumber();
		return printBoxNeighbors(field, format(tmp, value1), x, y + 1, tmpCtr);

	}

	public void globalPrint(Board field) {
		String value = "";
		String endValue = "";
		for (int j = 0; j < field.getLength(); j++) {
			endValue += printBox(field, value, j, 0);
			value += "";
			endValue += "\n";
			endValue += printBoxNeighbors(field, value, j, 0, 0);
			endValue += "\n";
		}
		this.setConsole(endValue);
	}

	public void readData() {
		int fieldSize = 0;
		int numberOfFields = 0;
		int tmpNbrOfPlayer = 0;

		final String newline = System.getProperty("line.separator");
		Controller controller = new Controller();
		

		
		Scanner sc = new Scanner(System.in);

		
		do {
			log4j.info(newline + " Spielfeldgröße: ");
			fieldSize = sc.nextInt();
			log4j.info(newline + " Anzahl Felder: ");
			numberOfFields = sc.nextInt();
		} while ( numberOfFields > fieldSize);
		
		
		log4j.info(newline + " Anzahl an spielern: ");
		tmpNbrOfPlayer = sc.nextInt();
		
		Player[] listOfPlayer = new Player[tmpNbrOfPlayer];
		for (int i = 0; i < listOfPlayer.length; i++) {
			log4j.info(newline + " Name: ");
			String eingabe = sc.next();
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setName(eingabe);
			listOfPlayer[i].setPlayerNr(i);
			listOfPlayer[i].createField(Convertmethods.converteFieldSize(fieldSize));

		}
		sc.close();
		
		controller.createBoard(fieldSize, numberOfFields);
		controller.setNumberOfFields(numberOfFields);
		controller.connectPlayerToBoard(listOfPlayer);
		controller.setfieldSize(fieldSize);
		
		tui(controller.getBoard().getLength(), controller.getBoard());
		
		controller.spreadDicesToField(controller.getBoard(), listOfPlayer);
		
	
		log4j.info(newline + this.console);

	}

}
