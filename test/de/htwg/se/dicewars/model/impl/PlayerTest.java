package de.htwg.se.dicewars.model.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IPlayer;
import de.htwg.se.dicewars.model.impl.Board;
import de.htwg.se.dicewars.model.impl.Field;
import de.htwg.se.dicewars.model.impl.Player;
import de.htwg.se.dicewars.util.Dicehandler;
import de.htwg.se.dicewars.view.tui.TUI;

public class PlayerTest {

	@Test
	public final void testPlayer() {
		Player testPlayer = new Player();
		assertEquals(null, testPlayer.getName());
		assertEquals(0, testPlayer.getNumberOfDices());
		assertEquals(0, testPlayer.getNumberOfFields());
		assertEquals(0, testPlayer.getPlayerNr());
	}

	@Test
	public final void testSetName() {
		Player testPlayer = new Player();
		testPlayer.setName("Test");
		assertEquals("Test", testPlayer.getName());
	}

	@Test
	public final void testSetNumberOfFields() {
		Player testPlayer = new Player();
		testPlayer.setNumberOfFields(1);
		assertEquals(1, testPlayer.getNumberOfFields());
	}

	@Test
	public final void testSetPlayerNr() {
		Player testPlayer = new Player();
		testPlayer.setPlayerNr(1);
		assertEquals(1, testPlayer.getPlayerNr());
	}

	@Test
	public final void testSetNumberOfDices() {
		Player testPlayer = new Player();
		testPlayer.setNumberOfDices(1);
		assertEquals(1, testPlayer.getNumberOfDices());
	}
	
	@Test
	public final void setGetTest(){
		Player player = new Player();
		player.setNumberOfFields(10);
		
		Field[][] field = new Field[3][3];
		field[0][0] = new Field();
		player.setField(field);
		assertNotNull(player.getFieldFromIndex(0, 0));
		assertNull(player.getFieldFromIndex(-1,0));
		assertNull(player.getFieldFromIndex(0,-1));
		assertNull(player.getFieldFromIndex(-1,-1));

		player.addNumberOfDices(3);
		assertEquals(3, player.getNumberOfDices());
		player.initShuffle(field);
		assertNotNull(player.popShoffled());
		
		
	}
	
	@Test
	public final void testUpdate() {
		IController controller = new Controller();
		TUI tui= new TUI(controller);
		Dicehandler dicehandler = new Dicehandler();
		IBoard testboard=new Board();
		int dices=0;
		
		IPlayer player1 = new Player();
		IPlayer player2 = new Player();
		IPlayer[] list = new Player[2];
		
		
		list[0]=player1;
		list[1]=player2;
		
		player1.setName("simon");
		player1.setPlayerNr(0);
		player1.createField(Convertmethods.converteFieldSize(9));
		player2.setName("Olga");
		player2.createField(Convertmethods.converteFieldSize(9));
		player2.setPlayerNr(1);
		
		controller.createBoard(9, 8);
		controller.setNumberOfFields(8);
		controller.connectPlayerToBoard(list);
		controller.setfieldSize(9);		
		controller.spreadDicesToField(controller.getBoard(), list);
		testboard.setField(player1.getField());
		
		player1.initShuffle(null);
		player2.initShuffle(null);

		System.out.println(tui.getConsole());
		dicehandler.updateDices(player1);
		
		
		dices = Dicehandler.countDices(player1.getField(),player1);
		System.out.println(dices);
		assertEquals(8, dices);
		
		
		
		
		
		
		
		
	}
	

}
