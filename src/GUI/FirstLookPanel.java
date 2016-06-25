package GUI;

import java.awt.GridLayout;
//import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FirstLookPanel extends JPanel implements MouseListener {
	
	private JButton start, rules, exit;
	
	public FirstLookPanel() {
		
		this.setLayout(new GridLayout(0, 3));
		this.setSize(400, 400);
		
		start = new JButton("New Game");
		start.setSize(50, 50);
		this.add(start);
		start.addMouseListener(this);
		
		rules = new JButton("Rules");
		rules.setSize(50, 50);
		this.add(rules);
		rules.addMouseListener(this);
		
		exit = new JButton("Exit");
		exit.setSize(50, 50);
		this.add(exit);
		exit.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		
		if(source == start) {
			JFrame frame = new JFrame("Auswahlfeld");
			frame.setSize(400, 400);
			frame.setLayout(new GridLayout(1, 0));
			
//			ChooseFieldsPanel field = new ChooseFieldsPanel();
//			ChoosePlayerPanel player = new ChoosePlayerPanel();
//			
//			frame.add(player);
//			frame.add(field);
//			
//			frame.pack();
//			frame.setVisible(true);
		}
		
		if(source == rules) {
			JOptionPane.showMessageDialog( 
					rules, "In diesem Spiel kann man die Tische f�r 2 � 6 Spieler erstellen. \n Nachdem, dass die alle Spieler am Tisch Platz genommen haben und danach best�tigt haben, wird die Generation der Karte erfolgt."
							+ "\n Karte des Spiels wird zuf�llig generiert, aber alle Spieler fallen unter gleichen Bedingungen f�r die Anzahl der Gebiete und die Anzahl der W�rfel."
							+ "\n Verteilung der W�rfel nach den Gebieten erfolgt zuf�llig. "
							+ "\n Um das Zug zu erfolgen, m�ssen Sie Ihr Gebiet, mit dem Sie das Gebiet des Gegners angriffen m�chten, markieren lassen und m�ssen Sie zeigen, welches Gebiet Sie angriffen m�chten.\n Aber Ihr Gebiet soll an das Gebiet des Gegners grenzen und auf Ihrem Gebiet soll mehr als 1 W�rfel sein."
							+ "\n Nach Ihrer Auswahl erfolgt die Austragung der Schlacht. Alle W�rfel, die auf Ihrem Gebiet und auf dem Gebiet des Gegners stehen, gew�rfelt werden und das Ergebnis wird gerechnet.\n Wenn das Ergebnis bei Ihnen h�her liegt, geht der W�rfelturm in Feindgebiet, aber l�sst seinen W�rfel auf dem Gebiet,"
							+ " von dem Angriff war, stehen.\n Wenn das W�rfelergebnis bei Ihrem Gegner h�her liegt, bleibt W�rfelturm des Gegners weiter stehen und auf Ihrem Gebiet bleibt nur einen W�rfel stehen.\n Falls die W�rfelergebnisse gleich sind, verlieren Sie die Schlacht und auf Ihrem Gebiet bleibt nur einen W�rfel stehen."
							+ " \n Der W�rfelturm des Gegners bleibt weiter stehen."
							+ "\n Sie k�nnen mehrere m�gliche Z�ge durchf�hren oder ablehnen. Um die Runde durchlassen, dr�cken Sie �Zugende�.\n Die Z�ge werden automatisch beendet, wenn auf alle Ihren Gebieten einen W�rfel stehen bleibt."
							+ "\n Nachdem der Zug beendet wird, werden die zus�tzlichen W�rfel auf Ihr Gebiet hinzugef�gt.\n Jedes angegriffen Gebiet, das in einer Gruppe der Gebiete vereinigt, bringt einen W�rfel.\n Alle W�rfel werden zwischen Ihren Gebieten nach dem Zufallsprinzip aufgeteilt. Die Anzahl der W�rfel,"
							+ " die hinzugef�gt werden, entspricht der Anzahl der Gebiete, die in einer Gruppe vereinigt.\n Zum Beispiel, Sie haben ein Paar vereinigte Gebiete, die als Gruppe stehen, 6 Gebiete in einem Eck der Karte, 3 Gebiete in anderem und 5 Gebiete in drittem Eck.\n In diesem Fall werden 6 W�rfel,"
							+ " nach der Anzahl der Gebiete in der Hauptgruppe, hinzugef�gt.\n Deswegen ist es vorteilhaft, vor dem Zugende alle Gebiete in einem Gebiet, in einer Hauptgruppe, zu vereinigen."
							+ "\n Nachdem die W�rfel hinzugef�gt werden, ist n�chster Spieler am Zug."
							+ "\n Wenn ein Spieler das Spiel verlassen hat, hatte er keine Verbindung zu Internet oder wollte das Spiel aufh�ren, bekommen seine W�rfel und Gebiete grau Verf�rbung.\n Die Austragung der Schlacht mit denen erfolgt unter gleichen Bedingungen, aber grau W�rfel k�nnen nicht angreifen."
							+ "\n Gewinnt derjenige, der alle Gebiete auf der Karte angegriffen hat."
							+ "\n Erh�lt der Gewinner alle Punkte gutgeschrieben.");
		}
		
		if(source == exit) {
			int jaOderNein = JOptionPane.showConfirmDialog(exit, "Fenster schliessen?", "Fenster Dialog", JOptionPane.YES_NO_OPTION);
        	if(jaOderNein == JOptionPane.YES_OPTION)
        	System.exit(0);
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
