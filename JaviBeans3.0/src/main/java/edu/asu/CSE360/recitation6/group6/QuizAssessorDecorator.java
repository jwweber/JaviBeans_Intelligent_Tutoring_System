package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a decorator object for multiple inheritance of quiz assessor
 * Assignment Number: Recitation Project 4
 * Completion Time: 1 hour
 * 
 *  @author Jamison Weber
 * 	@version 1.0
 */
public class QuizAssessorDecorator implements QuizAssessorComponent{
	protected QuizAssessorComponent qac;
	protected CompanionMessagePanel cmp;
	//public constructor
	public QuizAssessorDecorator(){
		cmp = CompanionMessagePanel.getInstance();
	}
	//required method for decorator pattern
	public void add(QuizAssessorComponent qac){
		this.qac = qac;
	}
	@Override
	//required method for decorator pattern
	public void displayMessage() {
		// TODO Auto-generated method stub
		if(qac != null){
			qac.displayMessage();
		}
	}
}
