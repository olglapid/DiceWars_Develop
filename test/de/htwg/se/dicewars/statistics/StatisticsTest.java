package de.htwg.se.dicewars.statistics;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatisticsTest {

	@Test
	public final void seterGettertest() {
		Statistics stats = new Statistics();
		stats.setBoard(null);
		stats.setField(null);
		stats.setNumberOfConnectedFields(0);
		stats.setNumberOfFields(0);;
		stats.setNumberOfDices(0);
		stats.setPlayer(null);
		stats.setTmp(0);
		
		assertEquals(0, stats.getNumberOfConnectedFields());
		assertEquals(0, stats.getNumberOfDices());
		assertEquals(0, stats.getNumberOfFields());
		assertEquals(0, stats.getTmp());
		assertNull(stats.getBoard());
		assertNull(stats.getField());
		assertNull(stats.getPlayer());
		
		int size = 6;
		stats.createBoard(size);
		assertNotNull(stats.getBoard());
		stats.createBoard(size-1);
		stats.deleteBoard();
		assertEquals(size-1, stats.getBoard().length);
	}

}
