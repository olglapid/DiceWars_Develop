package GUI;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Startmenu extends JMenuBar implements ActionListener{
	
	JMenuItem rules, game, exit;
	
	public Startmenu() {
		
		JMenuBar menu = new JMenuBar();

		JMenu verwaltung;
				
		//VERWALTUNG
		verwaltung = new JMenu("Menu");
		verwaltung.setMnemonic(KeyEvent.VK_A);
		menu.add(verwaltung);
		
		rules = new JMenuItem("Rules");
		rules.setMnemonic(KeyEvent.VK_A);
		rules.addActionListener(this);
		verwaltung.add(rules);
		
		game = new JMenuItem("New Game");
		game.setMnemonic(KeyEvent.VK_A);
		game.addActionListener(this);
		verwaltung.add(game);
		
		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_A);
		exit.addActionListener(this);
		verwaltung.add(exit);
		
		this.add(menu);
		//this.setVisible(true);
		//this.setSize(500, 500);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == rules) {
			JOptionPane.showMessageDialog( 
					rules, "In diesem Spiel kann man die Tische für 2 – 6 Spieler erstellen. \n Nachdem, dass die alle Spieler am Tisch Platz genommen haben und danach bestätigt haben, wird die Generation der Karte erfolgt."
							+ "\n Karte des Spiels wird zufällig generiert, aber alle Spieler fallen unter gleichen Bedingungen für die Anzahl der Gebiete und die Anzahl der Würfel."
							+ "\n Verteilung der Würfel nach den Gebieten erfolgt zufällig. "
							+ "\n Um das Zug zu erfolgen, müssen Sie Ihr Gebiet, mit dem Sie das Gebiet des Gegners angriffen möchten, markieren lassen und müssen Sie zeigen, welches Gebiet Sie angriffen möchten.\n Aber Ihr Gebiet soll an das Gebiet des Gegners grenzen und auf Ihrem Gebiet soll mehr als 1 Würfel sein."
							+ "\n Nach Ihrer Auswahl erfolgt die Austragung der Schlacht. Alle Würfel, die auf Ihrem Gebiet und auf dem Gebiet des Gegners stehen, gewürfelt werden und das Ergebnis wird gerechnet.\n Wenn das Ergebnis bei Ihnen höher liegt, geht der Würfelturm in Feindgebiet, aber lässt seinen Würfel auf dem Gebiet,"
							+ " von dem Angriff war, stehen.\n Wenn das Würfelergebnis bei Ihrem Gegner höher liegt, bleibt Würfelturm des Gegners weiter stehen und auf Ihrem Gebiet bleibt nur einen Würfel stehen.\n Falls die Würfelergebnisse gleich sind, verlieren Sie die Schlacht und auf Ihrem Gebiet bleibt nur einen Würfel stehen."
							+ " \n Der Würfelturm des Gegners bleibt weiter stehen."
							+ "\n Sie können mehrere mögliche Züge durchführen oder ablehnen. Um die Runde durchlassen, drücken Sie „Zugende“.\n Die Züge werden automatisch beendet, wenn auf alle Ihren Gebieten einen Würfel stehen bleibt."
							+ "\n Nachdem der Zug beendet wird, werden die zusätzlichen Würfel auf Ihr Gebiet hinzugefügt.\n Jedes angegriffen Gebiet, das in einer Gruppe der Gebiete vereinigt, bringt einen Würfel.\n Alle Würfel werden zwischen Ihren Gebieten nach dem Zufallsprinzip aufgeteilt. Die Anzahl der Würfel,"
							+ " die hinzugefügt werden, entspricht der Anzahl der Gebiete, die in einer Gruppe vereinigt.\n Zum Beispiel, Sie haben ein Paar vereinigte Gebiete, die als Gruppe stehen, 6 Gebiete in einem Eck der Karte, 3 Gebiete in anderem und 5 Gebiete in drittem Eck.\n In diesem Fall werden 6 Würfel,"
							+ " nach der Anzahl der Gebiete in der Hauptgruppe, hinzugefügt.\n Deswegen ist es vorteilhaft, vor dem Zugende alle Gebiete in einem Gebiet, in einer Hauptgruppe, zu vereinigen."
							+ "\n Nachdem die Würfel hinzugefügt werden, ist nächster Spieler am Zug."
							+ "\n Wenn ein Spieler das Spiel verlassen hat, hatte er keine Verbindung zu Internet oder wollte das Spiel aufhören, bekommen seine Würfel und Gebiete grau Verfärbung.\n Die Austragung der Schlacht mit denen erfolgt unter gleichen Bedingungen, aber grau Würfel können nicht angreifen."
							+ "\n Gewinnt derjenige, der alle Gebiete auf der Karte angegriffen hat."
							+ "\n Erhält der Gewinner alle Punkte gutgeschrieben.");
					
		}
		
		if(source == game) {
			
		}
		if(source == exit) {
			int jaOderNein = JOptionPane.showConfirmDialog(exit, "Fenster schliessen?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
        	if(jaOderNein == JOptionPane.YES_OPTION)
        	System.exit(0);
		}
	}

}
