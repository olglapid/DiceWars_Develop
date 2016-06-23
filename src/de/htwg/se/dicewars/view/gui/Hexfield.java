package de.htwg.se.dicewars.view.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import GUI.hexmech;

public class Hexfield {
	final static Color COLOURBACK =  Color.WHITE;
	final static Color COLOURGRID =  Color.BLACK;	
	
	final static int BSIZE = 12;
	final static int HEXSIZE = 60;
	final static int BORDERS = 15;
	final static int EMPTY = 0;
	int[][] board = new int[BSIZE][BSIZE];
	
	Hexfield(){
		createField();
		
	}
	
	void createField() {

		hexmech.setXYasVertex(false);

		hexmech.setHeight(HEXSIZE);
		hexmech.setBorders(BORDERS);
		for (int x = 0; x < BSIZE; x++) {
			for (int y = 0; y < BSIZE; y++) {
				board[x][y] = EMPTY;
			}
		}

	}

	public DrawingPanel createAndShowGUI() {
		DrawingPanel panel = new DrawingPanel();
		return panel;
	}
	
	class DrawingPanel extends JPanel
	{	
		public DrawingPanel(){
			setBackground(COLOURBACK);
			MyMouseListener ml = new MyMouseListener();            
			addMouseListener(ml);
		}
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			super.paintComponent(g2);
			//draw grid
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
					hexmech.drawHex(i,j,g2);
				}
			}
			//fill in hexes
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {					
					//if (board[i][j] < 0) hexmech.fillHex(i,j,COLOURONE,-board[i][j],g2);
					//if (board[i][j] > 0) hexmech.fillHex(i,j,COLOURTWO, board[i][j],g2);
					hexmech.fillHex(i,j,board[i][j],g2);
				}
			}

			//g.setColor(Color.RED);
			//g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
		}
		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel 
			public void mouseClicked(MouseEvent e) { 
				int x = e.getX(); 
				int y = e.getY(); 
				//mPt.x = x;
				//mPt.y = y;
				Point p = new Point( hexmech.pxtoHex(e.getX(),e.getY()) );
				if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

				//DEBUG: colour in the hex which is supposedly the one clicked on
				//clear the whole screen first.
				/* for (int i=0;i<BSIZE;i++) {
					for (int j=0;j<BSIZE;j++) {
						board[i][j]=EMPTY;
					}
				} */

				//What do you want to do when a hexagon is clicked?
				board[p.x][p.y] = (int)'X';
				repaint();
			}		 
		}
	}

}
