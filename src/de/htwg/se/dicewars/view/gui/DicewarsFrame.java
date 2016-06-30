package de.htwg.se.dicewars.view.gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.model.IBoard;


public class DicewarsFrame extends JFrame{

	private static final long serialVersionUID = -7155561780790604205L;
	private static final int DEFAULT_Y = 800;
	private static final int DEFAULT_X = 800;
	private static final int RADIUS = 30;
	private IController controller;
	private boolean trig;
	JFrame frame = new JFrame("Auswahlfeld");

	private ChooseFieldsPanel field;
	private ChoosePlayerPanel player;

	public DicewarsFrame(IController controller) {
		this.controller = controller;
		this.controller.setfieldSize(7);
		this.controller.setNumberOfFields(30);
		initUI();
		createMenuBar();
		field = new ChooseFieldsPanel(controller);
		player = new ChoosePlayerPanel(controller);
		trig = false;
	}

	private void initUI() {
		setTitle("Dicewars");
		setSize(DEFAULT_X, DEFAULT_Y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createMenuBar() {

		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenu options = new JMenu("Options");
		options.setMnemonic(KeyEvent.VK_O);

		JMenuItem einstellungen = new JMenuItem("Settings");
		einstellungen.setMnemonic(KeyEvent.VK_0);
		einstellungen.setToolTipText("Set Fieldsize");
		einstellungen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				settings();
			}
		});
		

		/* NEW */
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setToolTipText("Start a new game");
		newMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createField();
			}
		});

		JMenu helpMenu = new JMenu("Help");
		options.setMnemonic(KeyEvent.VK_O);

		JMenuItem verwaltung = new JMenuItem("Rules");
		verwaltung.setMnemonic(KeyEvent.VK_0);
		verwaltung.setToolTipText("Rules");
		verwaltung.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "In diesem Spiel kann man die Tische für 2 – 10 Spieler erstellen.\n"
					    + "Nachdem, dass man Anzahl Spieler und Anzahl Felder bestätigt hat, wird die Karte generiert.\n"
					    + "Karte des Spiels wird zufällig generiert, aber alle Spieler fallen unter maximal gleichen Bedingungen für die Anzahl der Gebiete und die Anzahl der Würfel.\n"
					    + "Verteilung der Würfel nach den Gebieten erfolgt zufällig.\n"
					    + "Um das Zug zu erfolgen, müssen Sie Ihr Gebiet, mit dem Sie das Gebiet des Gegners angriffen möchten, markieren lassen und müssen Sie zeigen, welches Gebiet Sie angriffen möchten.\n"
					    + "Aber Ihr Gebiet soll an das Gebiet des Gegners grenzen und auf Ihrem Gebiet soll mehr als 1 Würfel sein.\n"
					    + "Nach Ihrer Auswahl werden alle Würfel, die auf Ihrem Gebiet und auf dem Gebiet des Gegners stehen, gewürfelt und das Ergebnis wird gerechnet.\n"
					    + "Wenn das Ergebnis bei Ihnen höher liegt, geht der Würfelturm in Feindgebiet, aber lässt seinen Würfel auf dem Gebiet, von dem Angriff war, stehen.\n"
					    + "Wenn das Würfelergebnis bei Ihrem Gegner höher liegt, bleibt Würfelturm des Gegners weiter stehen und auf Ihrem Gebiet bleibt nur einen Würfel stehen.\n"
					    + "Falls die Würfelergebnisse gleich sind, verlieren Sie die Schlacht und auf Ihrem Gebiet bleibt nur einen Würfel stehen.\n"
					    + "Der Würfelturm des Gegners bleibt weiter stehen.\n"
					    + "Gewinnt derjenige, der alle Gebiete auf der Karte angegriffen hat.",
					    "Rules",
					    JOptionPane.PLAIN_MESSAGE);
			}
		});
		

		file.add(newMenuItem);
		options.add(einstellungen);
		helpMenu.add(verwaltung);
		menubar.add(file);
		menubar.add(options);
		menubar.add(Box.createHorizontalGlue());
		menubar.add(helpMenu);
		setJMenuBar(menubar);

	}

	private void createField() {
	
		if (controller.getFieldSize() == 0||controller.getPlayerlist()==null) {
			return;
		}
		
		if(trig){
			controller.reset();
			controller.setNumberOfFields(field.getAnzFelder());
			controller.setfieldSize(Convertmethods.converteFieldSize(field.getAnzFelder()));
			player.fillPLayer();
			
			getContentPane().removeAll();
			
			
		}
		controller.create();
		IBoard board = controller.getBoard();
		setSize(DEFAULT_X - 1, DEFAULT_Y - 1);
		setLocationRelativeTo(null);
			
	
		getContentPane().add(new Graphfield(RADIUS, this.controller));
		getContentPane().invalidate();
		getContentPane().validate();
		
		trig=true;
		int newSizeX = (2 * RADIUS * board.getLength()) + RADIUS;
		int newSizeY = 2 * RADIUS * board.getLength() + RADIUS;
		if (newSizeX > DEFAULT_X && newSizeY > DEFAULT_Y) {

			setSize(newSizeX, newSizeY);
		}
		

	}

	private void settings() {
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(1, 0));

		frame.add(player);
		frame.add(field);

		frame.pack();
		frame.setVisible(true);

	}


}