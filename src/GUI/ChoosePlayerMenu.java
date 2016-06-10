package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ChoosePlayerMenu extends JPanel implements ActionListener {
	
	JRadioButton spieler2;
	JRadioButton spieler3;
	JRadioButton spieler4;
	JRadioButton spieler5;
	JRadioButton spieler6;
	JRadioButton spieler7;
	JRadioButton spieler8;
	JRadioButton spieler9;
	JRadioButton spieler10;
	JButton auswahl;
	
	public ChoosePlayerMenu() {
		//Buttons definieren
		spieler2 = new JRadioButton("2 Spieler (min 10 Felder)");
		spieler2.setSelected(true);
		spieler3 = new JRadioButton("3 Spieler (min 15 Felder)");
		spieler3.setSelected(true);
		spieler4 = new JRadioButton("4 Spieler (min 20 Felder)");
		spieler4.setSelected(true);
		spieler5 = new JRadioButton("5 Spieler (min 25 Felder)");
		spieler5.setSelected(true);
		spieler6 = new JRadioButton("6 Spieler (min 30 Felder)");
		spieler6.setSelected(true);
		spieler7 = new JRadioButton("7 Spieler (min 35 Felder)");
		spieler7.setSelected(true);
		spieler8 = new JRadioButton("8 Spieler (min 40 Felder)");
		spieler8.setSelected(true);
		spieler9 = new JRadioButton("9 Spieler (min 45 Felder)");
		spieler9.setSelected(true);
		spieler10 = new JRadioButton("10 Spieler (min 50 Felder)");
		spieler10.setSelected(true);
		
		
		//Buttons gruppieren
		ButtonGroup group = new ButtonGroup();
		group.add(spieler2);
		group.add(spieler3);
		group.add(spieler4);
		group.add(spieler5);
		group.add(spieler6);
		group.add(spieler7);
		group.add(spieler8);
		group.add(spieler9);
		group.add(spieler10);
		
		
		//ActionListener registrieren
		spieler2.addActionListener(this);
		spieler3.addActionListener(this);
		spieler4.addActionListener(this);
		spieler5.addActionListener(this);
		spieler6.addActionListener(this);
		spieler7.addActionListener(this);
		spieler8.addActionListener(this);
		spieler9.addActionListener(this);
		spieler10.addActionListener(this);
		
		
		//Buttons zu einem Panel zusammenfassen
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(spieler2);
		radioPanel.add(spieler3);
		radioPanel.add(spieler4);
		radioPanel.add(spieler5);
		radioPanel.add(spieler6);
		radioPanel.add(spieler7);
		radioPanel.add(spieler8);
		radioPanel.add(spieler9);
		radioPanel.add(spieler10);
		
		Border border = BorderFactory.createTitledBorder("Spieleranzahl Auswahl");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(radioPanel);
		
		auswahl = new JButton("Auswahl speichern");
		radioPanel.add(auswahl);
		auswahl.addActionListener(this);
		//this.setVisible(true);
		//this.setSize(500, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == spieler2) {
			//10-50
		} else if(source == spieler3) {
			//15-60
		} else if(source == spieler4) {
			//20-70
		} else if(source == spieler5) {
			//25-80
		} else if(source == spieler6) {
			//30-90
		} else if(source == spieler7) {
			//35-100
		} else if(source == spieler8) {
			//40-150
		} else if(source == spieler9) {
			//45-200
		} else if(source == spieler10) {
			//50-300
		}
		
	}
	

}
