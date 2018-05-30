package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a window that displays orogramming assignment related instructions and textfields.
 * Added parameters that enable communication with ProgrammingAssignmentWindow and CodeAssessor
 * Assignment Number: Recitation Project 4
 * Completion Time: 30 additional minutes
 * 
 *  @author Jamison Weber
 * 	@version 2.0
 */
import java.io.IOException;

import javax.swing.JFrame;

public class ProgrammingAssignmentWindow extends JFrame implements Runnable {
	private int moduleNumber;
	private int profileID;
	private ProgrammingAssignmentGUI pagui;
	//public constructor
	public ProgrammingAssignmentWindow(int moduleNumber, int profileID, ProgrammingAssignmentGUI pagui) throws IOException{
		this.pagui = pagui;
		this.moduleNumber = moduleNumber;
		this.profileID = profileID;
	}
	@Override
	//Thread execution instructions
	public void run() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(800,800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ProgrammingAssignmentList pal;
		try {
			pal = new ProgrammingAssignmentList();
			moduleNumber--;
			CodeAssessor ca = new CodeAssessor
					(this, pal.get(9*moduleNumber),pal.get(9*moduleNumber + 1),
							pal.get(9*moduleNumber + 2),pal.get(9*moduleNumber + 3),pal.get(9*moduleNumber + 4),
							pal.get(9*moduleNumber + 5),pal.get(9*moduleNumber + 6),pal.get(9*moduleNumber + 7),profileID, moduleNumber);
			frame.add(ca);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
	}
	//method required for communication with other classes
	public void update(){
		pagui.update();
	}
}