package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a decorator object for the companion face
 * Assignment Number: Recitation Project 4
 * Completion Time: 1 hours
 * 
 *  @author Jamison Weber 
 * 	@version 1.0
 */
import java.io.IOException;

public class CompanionTroll extends CompanionDecorator{
	private int state;
	//public constructor
	public CompanionTroll(){
		
	}
	//public constructor
	public void displayMessage(){
		try {
			state = super.cc.getDecisionState();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.displayMessage();
		if(state == 1){
			super.cmp.setMessage2("Don't let your success go to your head.");
		}
		else if(state == 4){
			super.cmp.setMessage2("Hmm, looks like you aren't doing very well.");
		}
		else if(state == 3){
			super.cmp.setMessage2("<html>Maybe at this point<br>the best option is to give up.</html>");
		}
	}
}
