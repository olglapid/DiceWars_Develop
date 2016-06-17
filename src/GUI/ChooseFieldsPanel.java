package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class ChooseFieldsPanel extends JPanel implements MouseListener {

	private JTextField fieldsEingabe;
	private JButton anwenden;
	
	public ChooseFieldsPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.add(new JLabel("Felderanzahl eingeben (max 300)"));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 1));
		fieldsEingabe = new JTextField("", 3);
		panel1.add(fieldsEingabe);
		
		Border border = BorderFactory.createTitledBorder("Felderanzahl Auswahl");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel);
		this.add(panel1);
		anwenden = new JButton("Anwenden");
		this.add(anwenden);
		anwenden.addMouseListener(this);
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
