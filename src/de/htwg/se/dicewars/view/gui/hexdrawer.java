package de.htwg.se.dicewars.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import com.sun.javafx.tk.FontMetrics;

public class hexdrawer {
	static final int SIDES = 6;

	public static Polygon hexagon(int x, int y, int r) {
		Polygon p = new Polygon();

		int[] xcord = new int[SIDES];
		xcord[0] = x;
		xcord[1] = x + r - (r / SIDES);
		xcord[2] = x + r - (r / SIDES);
		xcord[3] = x;
		xcord[4] = x - r + (r / SIDES);
		xcord[5] = x - r + (r / SIDES);

		int[] ycord = new int[SIDES];
		ycord[0] = y + r;
		ycord[1] = y + (r / 2);
		ycord[2] = y - (r / 2);
		ycord[3] = y - r;
		ycord[4] = y - (r / 2);
		ycord[5] = y + (r / 2);

		for (int i = 0; i < SIDES; i++) {
			p.addPoint(xcord[i], ycord[i]);
		}
		return p;
	}

	public static Polygon drawhexagon(int x, int y, int r, Graphics2D g2, Color color) {
		Polygon p = hexagon(x, y, r);
		g2.setColor(color);
		g2.fillPolygon(p);
		g2.setColor(Color.WHITE);
		g2.drawPolygon(p);
		
		return p;
	}
	
	public static void drawchange(int i,int j,Graphics2D g2,int n,int r,Color color){
		String c=""+n;
		int length = c.length();
		Polygon p = hexagon(i, j, r);
		if(n==0)
			c="";
		if(n>0){
			g2.fillPolygon(p);
		g2.setColor(Color.GRAY);

		g2.drawPolygon(hexagon(i, j, r));
		drawhexagon(i, j, r, g2, color);
		g2.drawString(""+c, i-(r-(length*2))/4, j);

		}
		else {
			g2.setColor(Color.RED);
			g2.fillPolygon(p);
			g2.setColor(Color.GRAY);
			g2.drawPolygon(p);
			drawhexagon(i, j, r, g2, Color.GREEN);
			g2.drawString(""+c, i-(r-(length*2))/4, j);

			
		}
		
		
	}

	/*public static void drawHex(Graphics g, int length, int r,Polygon[][] poly) {
		Polygon p;
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int xcord = 0, ycord = 0;
		for (int x = 0; x < length; x++) {
			ycord += r + r-(2*r/SIDES);
			if (x % 2 != 0)
				xcord +=r-(r/(2*SIDES));

			for (int y = 0; y < length; y++) {

				xcord += r + r-(r/SIDES);
				System.out.println(xcord + " " + ycord);
				p = hexagon(xcord, ycord, r, Color.BLUE);
				poly[x][y]=p;
				g2.setColor(Color.BLACK);
				g2.drawPolygon(p);
				g2.setColor(Color.WHITE);
				g2.fillPolygon(p);
			}
			xcord = 0;
		}
	}
*/
}
