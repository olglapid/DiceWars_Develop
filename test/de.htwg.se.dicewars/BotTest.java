package de.htwg.se.dicewars;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.TUI;

public class BotTest {

	@Test
	public final void testBot() {
		String value1="";
		TUI console = new TUI();;
		
		int ctr = 10;
		console.setConsole(console.bot(ctr));
		
		for(int i=0;i<ctr;i++){
			value1+=" \\ / ";
		}
		value1+="\\\n";
		assertEquals(value1, console.getConsole());
	}

}
