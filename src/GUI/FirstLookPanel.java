package GUI;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstLookPanel extends JPanel implements MouseListener {
	
	private JButton start;
	
	public FirstLookPanel() {
		
		ChoosePlayerPanel player = new ChoosePlayerPanel();
		ChooseFieldsPanel fields = new ChooseFieldsPanel();
		
		this.add(player);
		this.add(fields);
		
		start = new JButton("Start");
		this.add(start);
		start.addMouseListener(this);
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
