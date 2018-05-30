package edu.asu.CSE360.recitation6.group6;
    /*
	 * This class will load and display a specified html file onto a JPanel.
	 * This class will handle exceptions relating to missing files.
	 * Assignment Number: Recitation Project 1
	 * Completion Time: 15 Hours
	 * 
	 *  @author Behnaz Sadat, Jamison Weber
	 * 	@version 1.0
	 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Tutor extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel lab;
	private JPanel panel;
	private Color eggshell;
	private JEditorPane ep1;
	private JEditorPane ep2;
	private JEditorPane ep3;
	private JEditorPane ep4;
	private int state;
	private CardLayout cl = new CardLayout();
	//Constructor creates a cardlayout JPanel, 
	//initializes every subpanel and adds them to the main JPanel.
	public Tutor() throws IOException{
		super.setLayout(cl);
		state = 0;
		initializeStateZero();
		initializeStateOne();
		initializeStateTwo();
		initializeStateThree();
		initializeStateFour();
		this.add(panel, "panel");
		this.add(ep1,"p1");
		this.add(ep2,"p2");
		this.add(ep3,"p3");
		this.add(ep4,"p4");
		this.changeState(0);
	}
	//This method will change the visible panel depending on the state
	public void changeState(int state){
		if(state == 0){
			cl.show(this, "panel");
		}
		else if(state >= 1 && state <= 4){
			cl.show(this, "p"+state);
		}
	}
	//This method creates the JPanel for state zero and adds a label.
	private void initializeStateZero(){
		this.setPreferredSize(new Dimension(350,350));
		panel = new JPanel();
		eggshell = Color.WHITE;
		panel.setBackground(eggshell);
		lab = new JLabel("<Behnaz Sadat>");
		lab.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lab);
	}
	//This method creates a JEditorPane and loads and displays its corresponding html file.
	//It also provides exception handling in case the html file is missing.
	private void initializeStateOne() throws IOException{
		ep1 = new JEditorPane();
		try{
			File fileP1 = new File("src/main/resources/P1.html");
			URL urlP1 =fileP1.toURI().toURL();
			ep1.setPage(urlP1);
		}
		catch(IOException e){
			System.err.println("P1.html not found!");
		}
		ep1.setEditable(false);
		ep1.setVisible(true);	
	}
	//This method creates a JEditorPane and loads and displays its corresponding html file.
	//It also provides exception handling in case the html file is missing.
	private void initializeStateTwo() throws IOException{
		ep2 = new JEditorPane();
		try{
			File fileP2 = new File("src/main/resources/P2.html");
			URL urlP2 =fileP2.toURI().toURL();
			ep2.setPage(urlP2);
		}
		catch(IOException e){
			System.err.println("P2.html not found!");
		}
		ep2.setEditable(false);
		ep2.setVisible(true);	
	}
	//This method creates a JEditorPane and loads and displays its corresponding html file.
	//It also provides exception handling in case the html file is missing.
	private void initializeStateThree() throws IOException{
		ep3 = new JEditorPane();
		try{
			File fileP3 = new File("src/main/resources/P3.html");
			URL urlP3 =fileP3.toURI().toURL();
			ep3.setPage(urlP3);
		}
		catch(IOException e){
			System.err.println("P3.html not found!");
		}
		ep3.setEditable(false);
		ep3.setVisible(true);	
	}
	//This method creates a JEditorPane and loads and displays its corresponding html file.
	//It also provides exception handling in case the html file is missing.
	private void initializeStateFour() throws IOException{
		ep4 = new JEditorPane();
		try{
			File fileP4 = new File("src/main/resources/P4.html");
			URL urlP4 =fileP4.toURI().toURL();
			ep4.setPage(urlP4);
		}
		catch(IOException e){
			System.err.println("P4.html not found!");
		}
		ep4.setEditable(false);
		ep4.setVisible(true);	
	}
}