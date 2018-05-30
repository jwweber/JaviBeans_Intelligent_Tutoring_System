package edu.asu.CSE360.recitation6.group6;
/*
 * This class provides functionality for the decorator pattern
 * Completion Time: 2 hours
 * 
 *  @author Jamison Weber 
 * 	@version 1.0
 */
import java.io.FileNotFoundException;

public class CompanionDecorator implements Companion {
	protected Companion c;
	protected ControlCenter cc;
	protected CompanionMessagePanel cmp;
	//public constructor
	public CompanionDecorator(){
		cmp = CompanionMessagePanel.getInstance();
		try {
			cc = ControlCenter.getInstance();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//required method for decorator panel
	public void add(Companion c){
		this.c = c;
	}
	//Required method inherited from interface
	@Override
	public void displayMessage() {
		// TODO Auto-generated method stub
		if(c != null){
			c.displayMessage();
		}	
	}
}
