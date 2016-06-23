package de.htwg.se.dicewars.view.gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Button extends JFrame{
	public Button(){
		initUI();
	}
	
	private void initUI(){
		JButton field = new JButton("1");
		
		field.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
				
			}
		});
		
	
		createLayout(field);

        setTitle("Quit button");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void createLayout(JComponent... arg) {
		Container pane = getContentPane();
		GroupLayout g1 = new GroupLayout(pane);
		pane.setLayout(g1);
		
		g1.setAutoCreateContainerGaps(true);
		
		g1.setHorizontalGroup(g1.createSequentialGroup().addComponent(arg[0]));
		
		g1.setVerticalGroup(g1.createSequentialGroup()
                .addComponent(arg[0])
        );
		
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Button field = new Button();
				field.setVisible(true);
				
			}
		});
	}
}
