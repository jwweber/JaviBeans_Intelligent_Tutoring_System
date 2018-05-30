package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a GUI for observing progress made on quizzes and assignments.
 * It launches a certificate of achievement JFrame if all quizzes and assignments are complete and the student is in good standing.
 * Assignment Number: Recitation Project 4
 * Completion Time: 4 hours
 * 
 *  @author Jamison Weber
 * 	@version 1.0
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
public class ProgressReport extends JPanel {
	private ControlCenter cc;
	private JLabel[] labels;
	private JPanel[] panels;
	private JPanel[] grayBox;
	private JPanel[] greenBox;
	private JPanel[] emptyBars;
	boolean[] added;
	private CardLayout cl1;
	private CardLayout cl2;
	//public constructor
	public ProgressReport(){
		try {
			cc = ControlCenter.getInstance();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		labels = new JLabel[2];
		panels = new JPanel[10];
		grayBox = new JPanel[42];
		greenBox = new JPanel[42];
		added = new boolean[12];
		for(int i = 0; i<added.length;i++){
			added[i]=false;
		}
		for(int i = 0; i < grayBox.length;i++){
			grayBox[i] = new JPanel(new BorderLayout());
			grayBox[i].setPreferredSize(new Dimension(111,150));
			grayBox[i].setBackground(Color.LIGHT_GRAY);
		}
		for(int i = 0; i < greenBox.length;i++){
			greenBox[i] = new JPanel(new BorderLayout());
			greenBox[i].setPreferredSize(new Dimension(100,140));
			greenBox[i].setBackground(Color.GREEN);
		}
		for(int i = 0; i < grayBox.length;i++){
			grayBox[i].add(greenBox[i],BorderLayout.CENTER);
		}
		emptyBars = new JPanel[14];
		for(int i = 0; i < emptyBars.length;i++){
			emptyBars[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			emptyBars[i].setSize(new Dimension(700,200));
			emptyBars[i].setBackground(Color.LIGHT_GRAY);
		}
		labels[0] = new JLabel("Quiz Progress:");
		labels[0].setFont(new Font("Times New Roman", Font.BOLD, 18));
		panels[0] = new JPanel(new BorderLayout());
		panels[0].setPreferredSize(new Dimension(800,150));
		panels[0].setBackground(Color.WHITE);
		panels[1] = new JPanel();
		panels[1].setPreferredSize(new Dimension(50,200));
		panels[2] = new JPanel();
		panels[2].setPreferredSize(new Dimension(50,200));
		cl1 = new CardLayout();
		panels[3] = new JPanel(cl1);
		panels[3].setPreferredSize(new Dimension(700,200));
		this.setPreferredSize(new Dimension(800,800));
		panels[8] = new JPanel();
		panels[8].setPreferredSize(new Dimension(800,100));
		panels[9] = new JPanel();
		panels[9].setPreferredSize(new Dimension(800,100));
		this.add(panels[8]);
		this.add(labels[0]);
		panels[3].setBackground(Color.LIGHT_GRAY);
		emptyBars[0].add(grayBox[0]);
		emptyBars[1].add(grayBox[1]);
		emptyBars[1].add(grayBox[2]);
		emptyBars[2].add(grayBox[3]);
		emptyBars[2].add(grayBox[4]);
		emptyBars[2].add(grayBox[5]);
		emptyBars[3].add(grayBox[6]);
		emptyBars[3].add(grayBox[7]);
		emptyBars[3].add(grayBox[8]);
		emptyBars[3].add(grayBox[9]);
		emptyBars[4].add(grayBox[10]);
		emptyBars[4].add(grayBox[11]);
		emptyBars[4].add(grayBox[12]);
		emptyBars[4].add(grayBox[13]);
		emptyBars[4].add(grayBox[14]);
		emptyBars[5].add(grayBox[15]);
		emptyBars[5].add(grayBox[16]);
		emptyBars[5].add(grayBox[17]);
		emptyBars[5].add(grayBox[18]);
		emptyBars[5].add(grayBox[19]);
		emptyBars[5].add(grayBox[20]);
		panels[3].add(emptyBars[13],"empty");
		panels[3].add(emptyBars[0],"1");
		panels[3].add(emptyBars[1],"2");
		panels[3].add(emptyBars[2],"3");
		panels[3].add(emptyBars[3],"4");
		panels[3].add(emptyBars[4],"5");
		panels[3].add(emptyBars[5],"6");
		panels[0].add(panels[1],BorderLayout.WEST);
		panels[0].add(panels[2],BorderLayout.EAST);
		panels[0].add(panels[3],BorderLayout.CENTER);
		labels[1] = new JLabel("Assignment Progress:");
		labels[1].setFont(new Font("Times New Roman", Font.BOLD, 18));
		panels[4] = new JPanel(new BorderLayout());
		panels[4].setPreferredSize(new Dimension(800,150));
		panels[4].setBackground(Color.WHITE);
		panels[5] = new JPanel();
		panels[5].setPreferredSize(new Dimension(50,200));
		panels[6] = new JPanel();
		panels[6].setPreferredSize(new Dimension(50,200));
		cl2 = new CardLayout();
		panels[7] = new JPanel(cl2);
		panels[7].setPreferredSize(new Dimension(700,200));		
		panels[7].setBackground(Color.LIGHT_GRAY);
		emptyBars[6].add(grayBox[21]);
		emptyBars[7].add(grayBox[22]);
		emptyBars[7].add(grayBox[23]);
		emptyBars[8].add(grayBox[24]);
		emptyBars[8].add(grayBox[25]);
		emptyBars[8].add(grayBox[26]);
		emptyBars[9].add(grayBox[27]);
		emptyBars[9].add(grayBox[28]);
		emptyBars[9].add(grayBox[29]);
		emptyBars[9].add(grayBox[30]);
		emptyBars[10].add(grayBox[31]);
		emptyBars[10].add(grayBox[32]);
		emptyBars[10].add(grayBox[33]);
		emptyBars[10].add(grayBox[34]);
		emptyBars[10].add(grayBox[35]);
		emptyBars[11].add(grayBox[36]);
		emptyBars[11].add(grayBox[37]);
		emptyBars[11].add(grayBox[38]);
		emptyBars[11].add(grayBox[39]);
		emptyBars[11].add(grayBox[40]);
		emptyBars[11].add(grayBox[41]);
		panels[7].add(emptyBars[12],"empty");
		panels[7].add(emptyBars[6],"1");
		panels[7].add(emptyBars[7],"2");
		panels[7].add(emptyBars[8],"3");
		panels[7].add(emptyBars[9],"4");
		panels[7].add(emptyBars[10],"5");
		panels[7].add(emptyBars[11],"6");
		panels[4].add(panels[5],BorderLayout.WEST);
		panels[4].add(panels[6],BorderLayout.EAST);
		panels[4].add(panels[7],BorderLayout.CENTER);
		this.add(panels[0]);
		this.add(panels[9]);
		this.add(labels[1]);
		this.add(panels[4]);
	}
	//updates panel when slider selects this panel
	//Decision tree for displaying progress bar panels
	public void update() throws IOException{
		if(cc.getNumberCompletedQuizzes() == 0){
			cl1.show(panels[3],"empty");
		}
		else if(cc.getNumberCompletedQuizzes() == 1){
			cl1.show(panels[3],"1");
		}
		else if(cc.getNumberCompletedQuizzes() == 2){
			cl1.show(panels[3],"2");
		}
		else if(cc.getNumberCompletedQuizzes() == 3){
			cl1.show(panels[3],"3");
		}
		else if(cc.getNumberCompletedQuizzes() == 4){
			cl1.show(panels[3],"4");
		}
		else if(cc.getNumberCompletedQuizzes() == 5){
			cl1.show(panels[3],"5");
		}
		else if(cc.getNumberCompletedQuizzes() == 6){
			cl1.show(panels[3],"6");
		}
		if(cc.getNumberCompletedAssignments() == 0){
			cl2.show(panels[7],"empty");
		}
		else if(cc.getNumberCompletedAssignments() == 1){
			cl2.show(panels[7],"1");
		}
		else if(cc.getNumberCompletedAssignments() == 2){
			cl2.show(panels[7],"2");
		}
		else if(cc.getNumberCompletedAssignments() == 3){
			cl2.show(panels[7],"3");
		}
		else if(cc.getNumberCompletedAssignments() == 4){
			cl2.show(panels[7],"4");
		}
		else if(cc.getNumberCompletedAssignments() == 5){
			cl2.show(panels[7],"5");
		}
		else if(cc.getNumberCompletedAssignments() == 6){
			cl2.show(panels[7],"6");
		}
		if((cc.getNumberCompletedAssignments() ==6) && (cc.getNumberCompletedQuizzes() ==6) && cc.getDecisionState() == 1){
			Certificate cert = new Certificate();
		}
	}
}
