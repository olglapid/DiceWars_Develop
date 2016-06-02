package de.htwg.se.dicewars.BoardSetup;

import de.htwg.se.dicewars.DiceStart;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public abstract class BoardSetup {
	
	
	public static Board createField(int fieldSize, int numberOfFields) {

		Field node = new Field();
		int matrixSize = ConvertMethods.converteFieldSize(fieldSize);
		Field[][] field = new Field[matrixSize][matrixSize];

		node = FieldSetup.initSingleField(field, ConvertMethods.randomNumber(matrixSize), ConvertMethods.randomNumber(matrixSize));
		node = FieldSetup.mallocNodes(node);

		FieldSetup.connectNodes(field, node, numberOfFields, matrixSize);
		FieldSetup.connectFields(field);
		Board board = new Board(fieldSize);
		board.setField(field);

		return board;
	}
	
	public static Board playerToField(Board board, Player[] listOfPlayer, int numberOfFields) {
		Field[][] field=board.getField();
		int[] listOfFields = new int[listOfPlayer.length];
		int index = 0;
		FieldSetup.handOutFields(listOfFields, numberOfFields);

		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;
				index = ConvertMethods.wuerfelnOhneZurueckLegen(listOfFields);
				field[x][y].setOwner(listOfPlayer[index]);
				DiceSetup.addDice(board, x, y, 1);
				PlayerSetup.addDicesToPlayer(listOfPlayer, index, 1);
				listOfPlayer[index].setFieldFromIndex(field[x][y]);
				System.out.println(listOfPlayer[index].getNumberOfDices());
			}
		}
		board.setField(field);
		return board;
	}
}
