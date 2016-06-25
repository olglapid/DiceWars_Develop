package de.htwg.se.dicewars.view.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.model.Field;

public class hexdrawer {
	static final int SIDES = 6;
	static final Color[] colour ={Color.RED,
			Color.BLUE,
			Color.GREEN,
			Color.YELLOW,
			Color.BLACK,
			Color.ORANGE,
			Color.PINK,
			Color.MAGENTA,
			Color.GRAY,
			Color.cyan};

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
	
	public static void drawchange(int i,int j,Graphics2D g2,Field field,int r,Color color,IController controller){
		String c="";
		Color tmp=Color.WHITE;
		int numberOfDices=0;
		if(field!=null){
			numberOfDices=field.getNumberOfDices();
			c=""+numberOfDices;
			tmp=colour[field.getOwner().getPlayerNr()];
			if(controller.getAttack()==field.getFieldNumber()||controller.getDefend()==field.getFieldNumber()){
				int red = Math.min(255, (int) (tmp.getRed() * 0.50));
				int green = Math.min(255, (int) (tmp.getGreen() * 0.50));
				int blue = Math.min(255, (int) (tmp.getBlue() * 0.50));
				tmp = new Color(red,green,blue);
			}
			
		}
		else {
			color=Color.WHITE;
		}
		
		int length = c.length();
		Polygon p = hexagon(i, j, r);
		if(field==null)
			c="";
		if(numberOfDices>0){
			g2.fillPolygon(p);
		g2.setColor(tmp);

		g2.drawPolygon(hexagon(i, j, r));
		drawhexagon(i, j, r, g2, tmp);
		g2.drawString(""+c, i-(r-(length*2))/4, j);

		}
		else {
			g2.setColor(Color.RED);
			g2.fillPolygon(p);
			g2.setColor(Color.WHITE);
			g2.drawPolygon(p);
			drawhexagon(i, j, r, g2, Color.WHITE);
			g2.drawString(""+c, i-(r-(length*2))/4, j);

			
		}
		
		
	}
}
