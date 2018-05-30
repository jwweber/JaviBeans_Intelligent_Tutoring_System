package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a singleton object that updates the content of the message panel.
 * Assignment Number: Recitation Project 4
 * Completion Time: 3 hours
 * 
 *  @author Jamison Weber 
 * 	@version 1.0
 */
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompanionMessagePanel extends JPanel{
	private static CompanionMessagePanel instance;
	public JLabel message1;
	public JLabel message2;
	public JLabel message3;
	private Thread clock;
	protected int seconds;
	//private constructor
	private CompanionMessagePanel(){
		this.setPreferredSize(new Dimension(350,350));
		this.setBackground(Color.WHITE);
		seconds = 0;
		message1 = new JLabel();
		message1.setText("<html>Companion speaking:<br>Welcome to JavaBeans,<br>Good luck with your studies.</html>!");
		message2 = new JLabel();
		message3 = new JLabel();
		this.add(message1);
		this.add(message2);
		this.add(message3);
	}
	//Required method for singleton pattern
	public static CompanionMessagePanel getInstance(){
		if(instance == null){
			instance = new CompanionMessagePanel();
		}
		return instance;
	}
	//message setter
	public void setMessage1(String message){
		message1.setText(message);
		revalidate();
	}
	//message setter
	public void setMessage2(String message){
		message2.setText(message);
		revalidate();
	}
	//message setter
	public void setMessage3(String message){
		message2.setText(message);
		revalidate();
	}
}
