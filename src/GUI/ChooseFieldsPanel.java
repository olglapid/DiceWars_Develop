package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import de.htwg.se.dicewars.view.gui.Graphfield;

@SuppressWarnings("serial")
public class ChooseFieldsPanel extends JPanel implements MouseListener {

	private JTextField fieldsEingabe;
	private JButton anwenden, start;
	
	public ChooseFieldsPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.setSize(250, 200);
		panel.add(new JLabel("Felderanzahl eingeben (max 300)"));
		
		JPanel panel1 = new JPanel();
		panel1.setSize( 0, 80);
		panel1.setLayout(new GridLayout(0, 1));
		fieldsEingabe = new JTextField("", 3);
		panel1.add(fieldsEingabe);
		
		Border border = BorderFactory.createTitledBorder("Felderanzahl Auswahl");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel);
		this.add(panel1);
		anwenden = new JButton("Anwenden");
		panel1.add(anwenden);
		anwenden.addMouseListener(this);
		
		start = new JButton("Start");
		panel1.add(start);
		start.addMouseListener(this);
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == anwenden) {
		
		}
		
		if(source == start) {
			if(fieldsEingabe.getText().length() == 0) {
				JOptionPane.showMessageDialog(
					    fieldsEingabe, "Waehle Anzahl Felder und Anzahl Spieler!",
					    "Eingabefehler",
					    JOptionPane.ERROR_MESSAGE);
			} else {
				JFrame frame = new JFrame("Spielfeld");
				frame.setSize(400, 400);
				frame.setLayout(new GridLayout(1, 0));
				
				Graphfield game = new Graphfield(10,30);
				
				frame.add(game);
				
				//frame.add(game);
				frame.pack();
				frame.setVisible(true);
			}
			
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
