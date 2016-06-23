package de.htwg.se.dicewars.view.gui;


import java.awt.Container;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.Box;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import de.htwg.se.dicewars.controller.IController;


public class DicewarsFrame extends JFrame {

	private static final int DEFAULT_Y = 800;
	private static final int DEFAULT_X = 800;
	private Container pane;
	private IController controller;
	
	public DicewarsFrame(){
		
		initUI();
		createMenuBar();
	}
	
	private void initUI(){
		setTitle("Dicewars");
		setSize(DEFAULT_X,DEFAULT_Y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");
        ImageIcon newI = new ImageIcon("new.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
 
        JMenu options = new JMenu("Options");
        options.setMnemonic(KeyEvent.VK_O);
        
        /*EXIT*/
        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        /*NEW*/
        JMenuItem newMenuItem = new JMenuItem("New", icon);
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setToolTipText("Start a new game");
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	createField();
            }
        });
        
       
           
        
        
        JMenu helpMenu = new JMenu("Help");
        

        
        file.add(newMenuItem);
        file.add(eMenuItem);
        menubar.add(file);
        menubar.add(options);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(helpMenu);
        setJMenuBar(menubar);
        
    }
	
    private void createField(){
    	JPanel panel = new JPanel();
    	
    	Hexfield field = new Hexfield();
    	setSize(DEFAULT_X-1, DEFAULT_Y-1);
        setLocationRelativeTo(null);
    	getContentPane().add(new Graphfield(10, 30));  
    }
    
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				DicewarsFrame ex = new DicewarsFrame();
				ex.setVisible(true);
			}
		});
		
		
		
	}
}
