package de.htwg.se.dicewars.view.tui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.observer.Event;
import de.htwg.se.dicewars.observer.IObserver;
import de.htwg.se.dicewars.state.Status;

public class TUI implements IObserver {
	private static final Logger LOGGER = LogManager.getLogger(TUI.class.getName());
	private final String newline = System.getProperty("line.separator");
	String console;
	private IController controller;
	private int mode1;
	private int mode2;

	public TUI(IController controller) {
		console = "";
		this.controller = controller;
		controller.addObserver(this);
		mode1 = 1;
		mode2 = 2;

	}

	@Override
	public void update(Event e) {
		tui();
		LOGGER.info(newline + console);
		LOGGER.info(controller.getStatus());
		LOGGER.info("OBSI");
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

	public String field(IBoard globalField, IField[] iFields, int ctr, int trigger) {
		int tmpCtr = ctr;
		String tmp = "";
		String value;
		if (tmpCtr > 0) {
			tmpCtr--;

			if (iFields[iFields.length - tmpCtr - 1] == null)
				value = "";
			else {
				if (trigger == 0) {
					value = String.valueOf(iFields[iFields.length - tmpCtr - 1].getFieldNumber());
				} else if (trigger == 1) {
					value = String.valueOf(iFields[iFields.length - tmpCtr - 1].getOwner().getPlayerNr());
				} else {
					value = String.valueOf(iFields[iFields.length - tmpCtr - 1].getNumberOfDices());
				}
			}

			tmp = format(tmp, value) + field(globalField, iFields, tmpCtr, trigger);

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

	public void tui() {
		IBoard globalField = controller.getBoard();
		int fieldSize = globalField.getLength();
		String tmp = "";
		for (int i = 0; i < fieldSize; i++) {

			if (i % 2 != 0) {
				tmp += "  " + field(globalField, globalField.getField()[i], fieldSize, mode1);
				tmp += "  " + field(globalField, globalField.getField()[i], fieldSize, mode2);
				continue;
			}
			tmp += top(fieldSize);
			tmp += field(globalField, globalField.getField()[i], fieldSize, mode1);
			tmp += field(globalField, globalField.getField()[i], fieldSize, mode2);
			tmp += bot(fieldSize);
		}

		tmp += "\n";
		tmp += "----------------------------------------------------------------";
		this.setConsole(tmp);
	}

	public String printBox(IBoard field, String value, int x, int y) {
		String value1 = "";
		IField[][] tmpField = field.getField();

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

	public String printBoxNeighbors(IBoard field, String value, int x, int y, int ctr) {
		String tmp = value;
		IField[][] tmpField = field.getField();
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

	public void globalPrint(IBoard field) {
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

		Scanner sc = new Scanner(System.in);

		do {
			LOGGER.info(newline + " Spielfeldgröße: ");
			fieldSize = sc.nextInt();
			LOGGER.info(newline + " Anzahl Felder: ");
			numberOfFields = sc.nextInt();
		} while (numberOfFields > fieldSize);

		LOGGER.info(newline + " Anzahl an spielern: ");
		tmpNbrOfPlayer = sc.nextInt();

		IPlayer[] listOfPlayer = new Player[tmpNbrOfPlayer];
		for (int i = 0; i < listOfPlayer.length; i++) {
			LOGGER.info(newline + " Name: ");
			String eingabe = sc.next();
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setName(eingabe);
			listOfPlayer[i].setPlayerNr(i);
			listOfPlayer[i].createField(Convertmethods.converteFieldSize(fieldSize));

		}

		controller.createBoard(fieldSize, numberOfFields);
		controller.setNumberOfFields(numberOfFields);
		controller.connectPlayerToBoard(listOfPlayer);
		controller.setfieldSize(Convertmethods.converteFieldSize(fieldSize));

		controller.spreadDicesToField(controller.getBoard(), listOfPlayer);
		controller.setPlayerlist(listOfPlayer);
		controller.init();
	}

	public void startGame() {
		int attack = 0;
		int defend = 0;
		Scanner sc = new Scanner(System.in);
		while (controller.getStatus() != Status.ENDTURN ) {
			LOGGER.info("Spieler "+controller.getGameroutine().getPlayersTurn() + " ist an der Reihe");
			LOGGER.info(newline + " Feld Auswählen: ");
			attack = sc.nextInt();
			if(attack==0)
				break;
			LOGGER.info(newline + " Feld Angreifen: ");
			defend = sc.nextInt();
			controller.setAttack(attack);
			controller.setDefend(defend);
			controller.startGame();
			

		}
		sc.close();

	}

}
