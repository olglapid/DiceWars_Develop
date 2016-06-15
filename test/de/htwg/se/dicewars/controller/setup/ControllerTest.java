package de.htwg.se.dicewars.controller.setup;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.controller.impl.Fieldhandler;
import de.htwg.se.dicewars.gameroutine.Gameroutine;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;

public class ControllerTest {

	@Test
	public final void ControllerTest() {
		Controller controller = new Controller();
		assertEquals(null, controller.getBoard());
		assertArrayEquals(null, controller.getPlayerlist());
		assertEquals(0, controller.getFieldSize());
		assertEquals(0, controller.getNumberOfFields());
		assertEquals(Status.New, controller.getStatus());
		assertTrue(null != controller.getGameroutine());
		assertEquals(-1, controller.getAttack());
		assertEquals(-1, controller.getDefend());

	}

	@Test
	public final void getGameroutineTest(){
		Controller controller = new Controller();
		Gameroutine gameroutine = new Gameroutine();
		controller.setGameroutine(gameroutine);
		assertEquals(gameroutine, controller.getGameroutine());
	}
	@Test
	public final void getDefendTest(){
		Controller controller = new Controller();
		controller.setDefend(0);
		assertEquals(0, controller.getDefend());
	}
	
	@Test
	public final void getAttackTest(){
		Controller controller = new Controller();
		controller.setAttack(0);
		assertEquals(0, controller.getAttack());
	}
	
	@Test
	public final void getFieldSize(){
		Controller controller = new Controller();
		controller.setfieldSize(0);
		assertEquals(0, controller.getFieldSize());
	}
	
	@Test
	public final void getNumberOfFieldsTest(){
		Controller controller = new Controller();
		controller.setNumberOfFields(0);;
		assertEquals(0, controller.getNumberOfFields());
	}
	@Test
	public final void getPlayerlistTest(){
		Controller controller = new Controller();
		Player[] playerlist = new Player[2];
		controller.setPlayerlist(playerlist);
		assertArrayEquals(playerlist, controller.getPlayerlist());
	}
	
	@Test
	public final void getBoardTest(){
		Controller controller = new Controller();
		Board board = new Board();
		controller.setBoard(board);
		
		assertEquals(board, controller.getBoard());
	}
	
	@Test
	public final void getSinglePlayerTest(){
		Controller controller = new Controller();
		Player[] playerlist = new Player[2];
		Player player1 = new Player();
		Player player2 = new Player();
		playerlist[0]=player1;
		playerlist[1]=player2;
		
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
	public final void createBoardTest(){
		Controller controller = new Controller();
		controller.createBoard(8, 9);
		Board board = controller.getBoard();
		Field[][] field=board.getField();
		
		assertEquals(9, Fieldhandler.countFields(field));
		
		controller.createBoard(9, 9);
		board = controller.getBoard();
		field=board.getField();
		
		assertEquals(9, Fieldhandler.countFields(field));
	}
	
	@Test
	public final void connectPlayerToBoardTest(){
		
	}
	
}