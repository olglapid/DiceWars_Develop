package de.htwg.se.dicewars.boardsetup;


import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.dicewars.model.Player;

public class PlayerSetupTest {

	@Test
	public final void addDicesToPlayerTest(){
		Player[] playerlist = new Player[2];
		Player player1 = new Player();
		Player player2 = new Player();
		
		playerlist[0]=player1;
		playerlist[1]=player2;
		
		Playersetup.addDicesToPlayer(playerlist,0,5);
		Playersetup.addDicesToPlayer(playerlist,1,10);
		
		assertEquals(5,player1.getNumberOfDices());
		assertEquals(10,player2.getNumberOfDices());
		
	}


}
