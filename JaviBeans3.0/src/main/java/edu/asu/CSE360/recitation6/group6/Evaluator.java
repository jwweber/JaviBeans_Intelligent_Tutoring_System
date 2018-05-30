package edu.asu.CSE360.recitation6.group6;
/*
 * This class organizes all code related to student evaluation and is observed by the companion.
 * Assignment Number: Recitation Project 4
 * Completion Time: 3 Hours
 * 
 *  @author Jamison Weber
 * 	@version 1.0
 */
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Evaluator extends Observable{
	private JPanel panelOne;
	private ProgrammingAssignmentGUI pagui;
	private QuizGUI qugui;
	private ControlCenter cc;
	private JLabel quizzes;
	private JLabel assignments;
	private JPanel panelTwo;
	//public constructor
	public Evaluator(int userID) throws FileNotFoundException{
		panelOne = new JPanel();
		quizzes = new JLabel("Quizzes:");
		assignments = new JLabel("Assignments:");
		quizzes.setFont(new Font("Times New Roman", Font.BOLD, 30));
		assignments.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelOne.setPreferredSize(new Dimension(800,800));
		pagui = new ProgrammingAssignmentGUI(userID,this);
		panelOne.add(assignments);
		panelOne.add(pagui);
		panelTwo = new JPanel();
		panelTwo.setPreferredSize(new Dimension(800,800));
		panelTwo.add(quizzes);
		qugui = new QuizGUI(userID,this);
		panelTwo.add(qugui);
		cc = ControlCenter.getInstance();
		cc.setUserID(userID);
	}
	//mandatory method for observer patter
	public void update(){
		setChanged();
		notifyObservers();
	}
	//panelOne getter
	public JPanel getPanelOne(){
		return panelOne;
	}
	//panelTwo getter
	public JPanel getPanelTwo(){
		return panelTwo;
	}
}
