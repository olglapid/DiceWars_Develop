package de.htwg.se.dicewars.view.gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.renderable.RenderableImageOp;

import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.model.Player;
import de.htwg.se.dicewars.observer.Observable;
@SuppressWarnings("serial")
public class ChoosePlayerPanel extends JPanel implements MouseListener{
	
	private JRadioButton[] spieler;
	private JButton auswahl;
	private IController controller;
	private int anzspieler;
	
	public ChoosePlayerPanel(IController controller) {
		this.controller = controller;
		//Buttons definieren
		
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.setSize(250, 280);
		
		ButtonGroup group = new ButtonGroup();
		spieler = new JRadioButton[8];
		
		for (int i = 0; i < spieler.length; i++) {
			spieler[i]= new JRadioButton(i+2 + " Spieler");
			spieler[i].setSelected(true);
			group.add(spieler[i]);
			spieler[i].addMouseListener(this);
			radioPanel.add(spieler[i]);
		}

		anzspieler = 2;
		Border border = BorderFactory.createTitledBorder("Spieleranzahl Auswahl");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(radioPanel);
		
		auswahl = new JButton("Auswahl speichern");
		radioPanel.add(auswahl);
		auswahl.addMouseListener(this);
		//this.setVisible(true);
		//this.setSize(500, 500);
	}
	public int getAnzspeiler(){
		return this.anzspieler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(controller.getFieldSize()==0){
			return;
		}
		
		
		for (int i = 0; i < spieler.length; i++) {
			if(spieler[i]==source){
				System.out.println("WARUM");
				anzspieler=i+2;
				break;
			}
		}
		if(source==auswahl){
			System.out.println("DARUM");
			fillPLayer();
		}
		
		
	}
	
	public void fillPLayer(){
		Player[] playerList = new Player[anzspieler];
		int fieldSize = controller.getFieldSize();;
		for (int i = 0; i < playerList.length; i++) {
			playerList[i]=new Player();
			playerList[i].setPlayerNr(i);
			playerList[i].createField(fieldSize);
			
		}
		controller.setPlayerlist(playerList);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	

}
