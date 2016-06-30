package de.htwg.se.dicewars.controller.setup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.util.Dicehandler;
import de.htwg.se.dicewars.util.Fieldhandler;

public class ControllerTest {

	@Test
	public final void ControllerTest() {
		Controller controller = new Controller();
		assertEquals(null, controller.getBoard());
		assertArrayEquals(null, controller.getPlayerlist());
		assertEquals(0, controller.getFieldSize());
		assertEquals(0, controller.getNumberOfFields());
		assertEquals(Status.NEW, controller.getStatus());
		assertTrue(null != controller.getGameroutine());
		assertEquals(-1, controller.getAttack());
		assertEquals(-1, controller.getDefend());

	}

	@Test
	public final void getGameroutineTest() {
		Controller controller = new Controller();
		Gameroutine gameroutine = new Gameroutine();
		controller.setGameroutine(gameroutine);
		assertEquals(gameroutine, controller.getGameroutine());
	}

	@Test
	public final void getDefendTest() {
		Controller controller = new Controller();
		controller.setDefend(0);
		assertEquals(0, controller.getDefend());
	}

	@Test
	public final void getAttackTest() {
		Controller controller = new Controller();
		controller.setAttack(0);
		assertEquals(0, controller.getAttack());
	}

	@Test
	public final void getFieldSize() {
		Controller controller = new Controller();
		controller.setfieldSize(0);
		assertEquals(0, controller.getFieldSize());
	}

	@Test
	public final void getNumberOfFieldsTest() {
		Controller controller = new Controller();
		controller.setNumberOfFields(0);
		;
		assertEquals(0, controller.getNumberOfFields());
	}

	@Test
	public final void getPlayerlistTest() {
		Controller controller = new Controller();
		Player[] playerlist = new Player[2];
		controller.setPlayerlist(playerlist);
		assertArrayEquals(playerlist, controller.getPlayerlist());
	}

	@Test
	public final void getBoardTest() {
		Controller controller = new Controller();
		Board board = new Board();
		controller.setBoard(board);

		assertEquals(board, controller.getBoard());
	}

	@Test
	public final void getSinglePlayerTest() {
		Controller controller = new Controller();
		Player[] playerlist = new Player[2];
		Player player1 = new Player();
		Player player2 = new Player();
		playerlist[0] = player1;
		playerlist[1] = player2;

		controller.setPlayerlist(playerlist);
		controller.setSinglePlayer(player1, 1);
		assertEquals(player1, controller.getSinglePlayer(1));
		assertEquals(null, controller.getSinglePlayer(2));
		controller.setSinglePlayer(null, 1);
		assertEquals(null, controller.getSinglePlayer(2));
		controller.setSinglePlayer(null, 5);
		assertEquals(null, controller.getSinglePlayer(5));
	}

	@Test
	public final void createBoardTest() {
		Controller controller = new Controller();
		controller.createBoard(8, 9);
		Board board = controller.getBoard();
		Field[][] field = board.getField();

		assertEquals(9, Fieldhandler.countFields(field));

		controller.createBoard(9, 9);
		board = controller.getBoard();
		field = board.getField();

		assertEquals(9, Fieldhandler.countFields(field));
	}

	@Test
	public final void connectPlayerToBoardTest() {
		Controller controller = new Controller();
		controller.createBoard(9, 8);
		Player[] playerlist = new Player[2];
		Player player1 = new Player();
		Player player2 = new Player();
		player1.createField(9);
		player2.createField(9);
		player1.setPlayerNr(0);
		player1.setPlayerNr(1);
		playerlist[0] = player1;
		playerlist[1] = player2;

		int tmp = 0;
		int dices = 0;

		controller.connectPlayerToBoard(playerlist);

		Board board = controller.getBoard();
		Field[][] field = board.getField();

		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;

				if (field[x][y].getNumberOfDices() == 1) {
					dices += 1;
				}
				tmp += 1;

			}
		}
		assertEquals(tmp, 8);
		assertEquals(dices, 8);

	}

	
	@Test
	public final void spreadDicesToFieldTest(){
		Controller controller = new Controller();
		controller.createBoard(9, 8);
		Player[] playerlist = new Player[2];
		Player player1 = new Player();
		Player player2 = new Player();
		player1.createField(9);
		player2.createField(9);
		player1.setPlayerNr(0);
		player1.setPlayerNr(1);
		playerlist[0] = player1;
		playerlist[1] = player2;

		int dices = 0;

		controller.connectPlayerToBoard(playerlist);

		Board board = controller.getBoard();
		Field[][] field = board.getField();
		
		controller.spreadDicesToField(board, playerlist);
		
		for (int x = 0; x < board.getLength(); x++) {
			for (int y = 0; y < board.getLength(); y++) {
				if (field[x][y] == null)
					continue;

				if (field[x][y].getNumberOfDices() == 1) {
					dices += 1;
				}
			

			}
		}
		assertEquals(8, dices);
		
	}
	
	@Test
	public final void initTest(){
		Controller controller = new Controller();
		controller.createBoard(9, 8);
		Player[] playerlist = new Player[2];
		Player player1 = new Player();
		Player player2 = new Player();
		player1.createField(9);
		player2.createField(9);
		player1.setPlayerNr(0);
		player1.setPlayerNr(1);
		playerlist[0] = player1;
		playerlist[1] = player2;

		int dices = 0;

		controller.connectPlayerToBoard(playerlist);

		Board board = controller.getBoard();
		Field[][] field = board.getField();
		
		controller.setPlayerlist(playerlist);
		controller.setNumberOfFields(8);
		controller.init();
		
		assertEquals(0, player1.getNumberOfDices());
		assertEquals(0, player2.getNumberOfDices());
		
		assertEquals(8, Dicehandler.countDices(field, player1));
		assertEquals(8,Dicehandler.countDices(field, player2));
		
		
		
	}
	
	@Test
	public final void resetTest(){
		Controller controller = new Controller();
		controller.createBoard(9, 8);
		controller.reset();
		assertNull(controller.getPlayerlist());
		assertNull(controller.getBoard());
		assertNotNull(controller.getGameroutine());
		assertEquals(0, controller.getFieldSize());
		assertEquals(0, controller.getNumberOfFields());
		assertEquals(-1, controller.getAttack());
		assertEquals(-1, controller.getDefend());
		assertEquals(Status.NEW, controller.getStatus());
	}
}
