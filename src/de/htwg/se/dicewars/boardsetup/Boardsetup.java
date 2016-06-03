package de.htwg.se.dicewars.boardsetup;

import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public abstract class Boardsetup {
	
	
	public static Board createField(int fieldSize, int numberOfFields) {

		Field node = new Field();
		int matrixSize = Convertmethods.converteFieldSize(fieldSize);
		Field[][] field = new Field[matrixSize][matrixSize];

		node = Fieldsetup.initSingleField(field, Convertmethods.randomNumber(matrixSize), Convertmethods.randomNumber(matrixSize));
		node = Fieldsetup.mallocNodes(node);

		Fieldsetup.connectNodes(field, node, numberOfFields, matrixSize);
		Fieldsetup.connectFields(field);
		Board board = new Board();
		board.setField(field);
		board.setLength(matrixSize);

		return board;
	}
	
	public static Board playerToField(Board board, Player[] listOfPlayer, int numberOfFields) {
		Field[][] field=board.getField();
		int[] listOfFields = new int[listOfPlayer.length];
		int index = 0;
		Fieldsetup.handOutFields(listOfFields, numberOfFields);

		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;
				index = Convertmethods.wuerfelnOhneZurueckLegen(listOfFields);
				field[x][y].setOwner(listOfPlayer[index]);
				Dicesetup.addDice(field[x][y], 1);
				Playersetup.addDicesToPlayer(listOfPlayer, index, 1);
				
				listOfPlayer[index].setFieldFromIndex(field[x][y]);
			}
		}
		board.setField(field);
		return board;
	}
}
