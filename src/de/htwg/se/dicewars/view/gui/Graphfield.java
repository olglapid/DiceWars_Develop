package de.htwg.se.dicewars.view.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.model.IBoard;
import de.htwg.se.dicewars.model.IField;


public class Graphfield extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1395240609585095479L;

	private Polygon[][] poly;
	private IField[][] field;
	private int size;
	private int radius;
	private Color color;
	private boolean attack;
	private IController controller;

	public Graphfield(int r, IController controller) {
		this.controller = controller;
		IBoard board = controller.getBoard();
		this.field = board.getField();
		attack = false;
		radius = r;
		color = Color.BLACK;
		size = field.length;
		poly = new Polygon[field.length][field.length];
		MyMouseListener m1 = new MyMouseListener();
		addMouseListener(m1);
	}

	public void setPoly(Polygon[][] poly){
		this.poly=poly;
	}
	
	public void setSize(int size){
		this.size=size;
	}
	public void setRadius(int radius){
		this.radius=radius;
	}
	
	public void setColor(Color color){
		this.color=color;
	}
	
	public void setAttack(boolean attack){
		this.attack = attack;
	}
	
	public void setField(IField[][] field2) {
		this.field = field2;
		newPoly();
		repaint();
		
	}
	
	public void setController(IController controller){
		this.controller = controller;
	}
	public void newPoly(){
		this.poly = null;
		this.poly = new Polygon[field.length][field.length];
		
	}

	public IField[][] getField(){
		return this.field;
	}
	
	public IController getController(){
		return this.controller;
	}
	public boolean getAttack(){
		return this.attack;
	}
	public Polygon[][] getPoly(){
		return this.poly;
	}

	public int getRadius(){
		return this.radius;
	}
	
	public int getSiz(){
		return this.size;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		super.paintComponent(g2);
		int xcord = 0, ycord = 0;
		for (int i = 0; i < size; i++) {
			ycord += radius + radius - (2 * radius / Hexdrawer.SIDES);
			if (i % 2 != 0)
				xcord += radius - (radius / (2 * Hexdrawer.SIDES));
			for (int j = 0; j < size; j++) {
				xcord += radius + radius - (radius / Hexdrawer.SIDES);
				poly[i][j] = Hexdrawer.drawhexagon(xcord, ycord, radius, g2, Color.PINK);
			}
			xcord = 0;
		}
		xcord = 0;
		ycord = 0;
		for (int i = 0; i < size; i++) {
			ycord += radius + radius - (2 * radius / Hexdrawer.SIDES);
			if (i % 2 != 0)
				xcord += radius - (radius / (2 * Hexdrawer.SIDES));
			for (int j = 0; j < size; j++) {
				xcord += radius + radius - (radius / Hexdrawer.SIDES);
				Hexdrawer.drawchange(xcord, ycord, g2, field[i][j], radius, color, controller);
			}
			xcord = 0;
		}

	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			int[] index = Convertmethods.fieldNumberToIndex(field.length, getField(x, y));

			if (field[index[0]][index[1]] == null) {
				return;
			}
			if (!attack) {

				controller.setAttack(getField(x, y));
				attack = true;
				repaint();
			} else {
				controller.setDefend(getField(x, y));
				controller.startGame();
				attack = false;
				repaint();
				controller.setAttack(0);
				controller.setDefend(0);

			}

		}
	}

	public int getField(int x, int y) {
		for (int i = 0; i < poly.length; i++) {
			for (int j = 0; j < poly.length; j++) {
				if (poly[i][j].contains(x, y)) {
					int nbr = i * poly.length + (j + 1);
					color = Color.WHITE;
					return nbr;
				}
			}
		}
		return 0;
	}

}
