package de.htwg.se.dicewars.view.gui;

import static org.junit.Assert.*;

import java.awt.Polygon;

import org.junit.Test;

public class HexdrawerTest {

	@Test
	public final void hexagonTest() {
		Polygon poly = hexdrawer.hexagon(100, 100, 50);
		assertTrue(poly.contains(100, 100));
	}

}
