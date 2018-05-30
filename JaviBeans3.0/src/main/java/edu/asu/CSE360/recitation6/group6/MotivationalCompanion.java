package edu.asu.CSE360.recitation6.group6;
/*
 * Decorator for companion face that provides motivational support for user
 * Assignment Number: Recitation Project 4
 * Completion Time: 5 Hours
 * 
 *  @author Jamison Weber
 * 	@version 1.0
 */
import java.io.IOException;
//public constructor
public class MotivationalCompanion extends CompanionDecorator {
	private int state;
	//public constructor
	public MotivationalCompanion(){	
	}
	//overridden method inherited from decorator
	public void displayMessage(){
		try {
			state = super.cc.getDecisionState();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.displayMessage();
		System.out.println(state);
		//additional behavior`
		if(state ==1){
			super.cmp.setMessage2("You're doing great. You deserve a break!");
		}else if(state == 4){
			super.cmp.setMessage2("Be sure to study a bit harder for your next exam or programming assignment.");
		}
		else if(state == 3){
			super.cmp.setMessage2("<html>Don't give up. Perhaps consider resetting<br>your progress and starting over.</html>");
		}
	}
}