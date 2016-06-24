package de.htwg.se.dicewars.view.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.htwg.se.dicewars.model.Field;


public class Graphfield extends JPanel {
	Polygon[][] poly;
	Field[][] field;
	int size;
	int radius;
	Graphics g;
	Color color;

	public Graphfield(int length, int r,Field[][] field) {
		radius = r;
		color=Color.BLACK;
		size = field.length;
		poly = new Polygon[field.length][field.length];
		this.field = field;
		MyMouseListener m1 = new MyMouseListener();
		addMouseListener(m1);
		// Hexdrawer.drawHex(g, length, r, poly);
	}

	public void setField(Field[][] field){
		this.field=field;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		super.paintComponent(g2);
		int xcord = 0, ycord = 0;
		for (int i = 0; i < size; i++) {
			ycord += radius + radius - (2 * radius / hexdrawer.SIDES);
			if (i % 2 != 0)
				xcord += radius - (radius / (2 * hexdrawer.SIDES));
			for (int j = 0; j < size; j++) {
				xcord += radius + radius - (radius / hexdrawer.SIDES);
				poly[i][j] = hexdrawer.drawhexagon(xcord, ycord, radius, g2, Color.PINK);
			}
			xcord = 0;
		}
		xcord=0;
		ycord=0;
		for (int i = 0; i < size; i++) {
			ycord += radius + radius - (2 * radius / hexdrawer.SIDES);
			if (i % 2 != 0)
				xcord += radius - (radius / (2 * hexdrawer.SIDES));
			for (int j = 0; j < size; j++) {
				xcord += radius + radius - (radius / hexdrawer.SIDES);
				hexdrawer.drawchange(xcord, ycord, g2, field[i][j], radius,color);
			}
			xcord = 0;
		}

	}

	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			getField(x, y);
			repaint();
			

		}
	}

	public int getField(int x, int y) {
		for (int i = 0; i < poly.length; i++) {
			for (int j = 0; j < poly.length; j++) {
				if (poly[i][j].contains(x, y)) {
					int nbr = i * poly.length + (j + 1);
					color=Color.GRAY ;
					System.out.println("Field " + (i * poly.length + (j + 1)));
					return nbr;
				}
			}
		}
		return 0;
	}

}
/*
 * class Hexdrawer { static final int SIDES = 6;
 * 
 * public static Polygon hexagon(int x, int y, int r, Color color) { Polygon p =
 * new Polygon();
 * 
 * int[] xcord = new int[SIDES]; xcord[0]=x; xcord[1]=x+r-(r/SIDES);
 * xcord[2]=x+r-(r/SIDES); xcord[3]=x; xcord[4]=x-r+(r/SIDES);
 * xcord[5]=x-r+(r/SIDES);
 * 
 * int[] ycord = new int[SIDES]; ycord[0]=y+r; ycord[1]=y+(r/2);
 * ycord[2]=y-(r/2); ycord[3]=y-r; ycord[4]=y-(r/2); ycord[5]=y+(r/2);
 * 
 * for (int i = 0; i < SIDES; i++) { p.addPoint(xcord[i], ycord[i]); } return p;
 * }
 * 
 * public static void drawHex(Graphics g, int length, int r,Polygon[][] poly) {
 * Polygon p; Graphics2D g2 = (Graphics2D)g;
 * g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
 * RenderingHints.VALUE_ANTIALIAS_ON); int xcord = 0, ycord = 0; for (int x = 0;
 * x < length; x++) { ycord += r + r-(2*r/SIDES); if (x % 2 != 0) xcord
 * +=r-(r/(2*SIDES));
 * 
 * for (int y = 0; y < length; y++) {
 * 
 * xcord += r + r-(r/SIDES); System.out.println(xcord + " " + ycord); p =
 * hexagon(xcord, ycord, r, Color.BLUE); poly[x][y]=p; g2.setColor(Color.BLACK);
 * g2.drawPolygon(p); g2.setColor(Color.WHITE); g2.fillPolygon(p); } xcord = 0;
 * } } public static void repaint(Graphics g, int length,Polygon[][] poly){
 * Graphics2D g2 = (Graphics2D)g;
 * g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
 * RenderingHints.VALUE_ANTIALIAS_ON); for (int i = 0; i < poly.length; i++) {
 * for (int j = 0; j < poly.length; j++) { g2.setColor(Color.GREEN);
 * g2.drawPolygon(poly[i][j]); g2.setColor(Color.RED);
 * g2.fillPolygon(poly[i][j]); } } }
 * 
 * 
 * }
 */