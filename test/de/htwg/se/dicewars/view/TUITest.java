package de.htwg.se.dicewars.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import org.junit.Test;

import de.htwg.se.dicewars.boardsetup.Boardsetup;
import de.htwg.se.dicewars.controller.impl.Controller;
import de.htwg.se.dicewars.model.Board;
import de.htwg.se.dicewars.model.Field;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.state.Status;
import de.htwg.se.dicewars.view.tui.TUI;

public class TUITest {

	@Test
	public final void testTUI() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		controller.setNumberOfFields(49);
		controller.setfieldSize(64);

		Player[] playerList = new Player[2];
		playerList[0] = new Player();
		playerList[1] = new Player();
		playerList[0].setPlayerNr(0);
		playerList[0].createField(8);
		playerList[1].setPlayerNr(1);
		playerList[1].createField(8);

		controller.setPlayerlist(playerList);
		controller.create();

		Board board = controller.getBoard();

		String value1 = "";
		String value2 = "";
		String tmp = "";

		console.tui();
		value1 = console.getConsole();
		for (int i = 0; i < board.getLength(); i++) {
			if (i % 2 != 0) {
				tmp += "  " + console.field(board, board.getField()[i], board.getLength(), 1);
				tmp += "  " + console.field(board, board.getField()[i], board.getLength(), 2);
				continue;
			}
			tmp += console.top(board.getLength());
			tmp += console.field(board, board.getField()[i], board.getLength(), 1);
			tmp += console.field(board, board.getField()[i], board.getLength(), 2);
			tmp += console.bot(board.getLength());

		}
		tmp += "\n";
		tmp += "----------------------------------------------------------------";

		value2 = tmp;
		System.out.println(value2);
		System.out.println(value1);
		assertEquals(value2, value1);
	}

	@Test
	public final void testSetConsole() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);

		console.setConsole("Test");
		assertEquals("Test", console.getConsole());
	}

	@Test
	public final void testAddConsole() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		console.setConsole("Test");
		console.addConsole("Test");
		assertEquals("TestTest", console.getConsole());
	}

	@Test
	public final void testField() {
		/*
		 * Field[][] field = Board.createField(64, 49); String value1 = "";
		 * String value2 = ""; String tmp = ""; value1 = TUI.field(field,
		 * field[0], field.length);
		 * 
		 * 
		 * for(int i=0;i<field.length;i++){ if(field[0][i]!=null) tmp +=
		 * field[0][i].getFieldNumber(); value2=TUI.format(value2, tmp); tmp="";
		 * } value2+="\n";
		 * 
		 * assertEquals(value2, value1);
		 */
	}

	@Test
	public final void testTop() {
		String value1 = "";
		int ctr = 10;
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		console.setConsole(console.top(ctr));

		for (int i = 0; i < ctr; i++) {
			value1 += " / \\ ";
		}
		value1 += "/\n";
		assertEquals(value1, console.getConsole());
	}

	@Test
	public final void testBot() {
		String value1 = "";
		Controller controller = new Controller();
		TUI console = new TUI(controller);

		int ctr = 10;
		console.setConsole(console.bot(ctr));

		for (int i = 0; i < ctr; i++) {
			value1 += " \\ / ";
		}
		value1 += "\\\n";
		assertEquals(value1, console.getConsole());
	}

	@Test
	public final void testTui() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		assertEquals("", console.getConsole());
	}

	@Test
	public final void testPrintBox() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		Board board = new Board();
		String value1 = "";
		String value2 = "";
		String tmp = "";

		board = Boardsetup.createField(64, 32);
		Field[][] field = board.getField();
		value1 = console.printBox(board, value1, 0, 0);
		for (int i = 0; i < board.getLength(); i++) {
			tmp = "";
			if (field[0][i] != null)
				tmp += field[0][i].getFieldNumber();
			value2 = console.format(value2, tmp);
		}
		assertEquals(value2, value1);
	}

	@Test
	public final void testFormat() {
		/*
		 * String value1=""; String value2="1"; String value3="10"; String
		 * value4="100";
		 * 
		 * assertEquals("|  1|", TUI.format(value1, value2)); assertEquals(
		 * "| 10|", TUI.format(value1, value3)); assertEquals("|100|",
		 * TUI.format(value1, value4)); value1=""; value1 = TUI.format(value1,
		 * value2); value1 = TUI.format(value1, value3); value1 =
		 * TUI.format(value1, value4); assertEquals("|  1|| 10||100|",value1);
		 */
	}

	@Test
	public final void testPrintBoxNeighbors() {
		/*
		 * Field[][] field = Board.createField(64, 49); String value1 = "";
		 * String value2 = ""; String tmp = ""; value1 =
		 * TUI.printBoxNeighbors(field, value1, 0, 0, 0);
		 * 
		 * for (int ctr = 0; ctr < 8; ctr++) { for (int j = 0; j < field.length;
		 * j++) { tmp = ""; if (field[0][j] == null) { value2 =
		 * TUI.format(value2, tmp); continue; } else if
		 * (field[0][j].getNachbar()[ctr] == null) { value2 = TUI.format(value2,
		 * tmp); continue; } else { tmp +=
		 * field[0][j].getNachbar()[ctr].getFieldNumber(); value2 =
		 * TUI.format(value2, tmp);
		 * 
		 * } }
		 * 
		 * value2 += "\n";
		 * 
		 * } assertEquals(value1, value2);
		 */
	}

	@Test
	public final void testGlobalPrint() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		Board board = new Board();
		board = Boardsetup.createField(64, 49);
		String value2 = "";
		String tmp = "";
		console.globalPrint(board);

		for (int j = 0; j < board.getLength(); j++) {
			value2 += console.printBox(board, tmp, j, 0);
			tmp += "";
			value2 += "\n";
			value2 += console.printBoxNeighbors(board, tmp, j, 0, 0);
			value2 += "\n";
		}
		assertEquals(value2, console.getConsole());
	}

	@Test
	public final void readDataTest() {
		Controller controller = new Controller();
		TUI console = new TUI(controller);
		String felder = "9" + System.getProperty("line.separator") + "9" + System.getProperty("line.separator") + "2"
				+ System.getProperty("line.separator") + "a" + System.getProperty("line.separator") + "b";

		InputStream inp = System.in;
		System.setIn(new ByteArrayInputStream(felder.getBytes()));
		console.readData();
		System.setIn(inp);
		
		assertEquals(3, controller.getBoard().getLength());
		assertNotNull(controller.getPlayerlist());
		assertEquals(9, controller.getNumberOfFields());

		
		felder = "-1" + System.getProperty("line.separator") + "-1"  + System.getProperty("line.separator") + "0";
		
		inp = System.in;
		System.setIn(new ByteArrayInputStream(felder.getBytes()));
		
		console.startGame();
		
		assertNotEquals(Status.NEW, controller.getStatus());
		
		

	}

}
