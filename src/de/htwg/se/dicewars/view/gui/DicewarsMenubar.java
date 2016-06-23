package de.htwg.se.dicewars.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import de.htwg.se.dicewars.controller.IController;
import de.htwg.se.dicewars.observer.IObserver;

public class DicewarsMenubar extends JFrame{

	private static final long serialVersionUID = -4482501416575327082L;

	private static final Logger LOGGER = LogManager.getLogger(DicewarsMenubar.class.getName());

	private static final int SIZE_1BY1 = 1;
	private static final int SIZE_4BY4 = 4;
	private static final int SIZE_9BY9 = 9;
	
	IController controller;
	
	JMenu optionsMenu;
	JMenuItem showMenuItem, resize9MenuItem, resize4MenuItem, resize1MenuItem;
	
	@Inject
	public DicewarsMenubar(IController controller, JFrame frame){
		this.controller = controller;
				
	
	}
	
	public void createOptionsMenu(IController controller){
		
		optionsMenu = new JMenu("Options");
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.showAllCandidates();
		}
		
		
	}
	
}
