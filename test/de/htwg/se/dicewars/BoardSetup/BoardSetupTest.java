package de.htwg.se.dicewars.BoardSetup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;

public class BoardSetupTest {

	@Test
	public final void testplayerToField() {
		Board board = new Board();
		Player[] listOfPlayer = new Player[5];
		int fieldSize = 64;
		int numberOfFields = 43;
		board = Boardsetup.createField(fieldSize, numberOfFields);
		
		int tmp = 0;
		int dices = 0;

		for (int i = 0; i < listOfPlayer.length; i++) {
			listOfPlayer[i] = new Player();
			listOfPlayer[i].setPlayerNr(i);
			listOfPlayer[i].createField(8);
		}

		Field[][] field = board.getField();
		board = Boardsetup.playerToField(board, listOfPlayer, numberOfFields);
		
		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;
				if (field[x][y].getOwner() == null) {
					continue;
				}
				if (field[x][y].getNumberOfDices() == 1) {
					dices += 1;
				}
				tmp += 1;

			}
		}
		assertEquals(tmp, numberOfFields);
		assertEquals(dices, numberOfFields);
	}

}
