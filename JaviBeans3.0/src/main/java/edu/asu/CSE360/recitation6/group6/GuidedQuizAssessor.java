package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a decorator object for the Quiz Assessor
 * Assignment Number: Recitation Project 4
 * Completion Time: 1 hour
 *  @author Jamison Weber 
 * 	@version 1.0
 */
public class GuidedQuizAssessor extends QuizAssessorDecorator{
	private String[] hints;
	//public constructor
	public GuidedQuizAssessor(String hint1, String hint2, String hint3, String hint4, String hint5){
		this.hints = new String[5];
		hints[0] = hint1;
		hints[1] = hint2;
		hints[2] = hint3;
		hints[3] = hint4;
		hints[4] = hint5;
	}
	//required method inherited from decorator
	public void displayMessage(int count, boolean isCorrect){
		super.displayMessage();
		if(isCorrect){
			super.cmp.setMessage2("Correct!");
		}
		else{
			super.cmp.setMessage2(hints[count]);
		}
	}
}
