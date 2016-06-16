package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class ChooseFieldsMenu extends JPanel implements ActionListener {

	private JTextField fieldsEingabe;
	private JButton anwenden;
	private JButton start;
	
	public ChooseFieldsMenu() {
		
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
		anwenden.addActionListener(this);
		
		start = new JButton("Start");
		this.add(start);
		start.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
