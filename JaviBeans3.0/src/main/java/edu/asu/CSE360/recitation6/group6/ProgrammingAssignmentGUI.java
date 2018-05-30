package edu.asu.CSE360.recitation6.group6;
import java.awt.Dimension;
/*
 * This class provides a GUI displaying buttons that link to different programming assignment window objects.
 * Added parameters that enable communication with ProgrammingAssignmentWindow and Evaluator
 * Assignment Number: Recitation Project 3
 * Completion Time: 30 additional minutes
 * 
 *  @author Jamison Weber
 * 	@version 2.0
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProgrammingAssignmentGUI extends JPanel{
	private JButton assignmentOne;
	private JButton assignmentTwo;
	private JButton assignmentThree;
	private JButton assignmentFour;
	private JButton assignmentFive;
	private JButton assignmentSix;
	private JPanel contentPane;
	private Evaluator ev;
	private ProgrammingAssignmentGUI pagui;
	private int userID;
	private JPanel emptyPanel;
	private JPanel emptyPanel2;
	//public constructor
	public ProgrammingAssignmentGUI(int userID, Evaluator ev){
		pagui = this;
		this.ev = ev;
		this.userID = userID;
		this.setSize(800, 800);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4, 2));
		assignmentOne = new JButton("Complete Introduction Assignment");
		assignmentTwo = new JButton("Complete Variables Assignment");
		assignmentThree = new JButton("Complete Strings Assignment");
		assignmentFour = new JButton("Complete Control Statements Assignment");
		assignmentFive = new JButton("Complete Loops Assignment");
		assignmentSix = new JButton("Complete Arrays Assignment");
		assignmentOne.setPreferredSize(new Dimension(200,100));
		assignmentOne.addActionListener(new ButtonListener());
		assignmentTwo.addActionListener(new ButtonListener());
		assignmentThree.addActionListener(new ButtonListener());
		assignmentFour.addActionListener(new ButtonListener());
		assignmentFive.addActionListener(new ButtonListener());
		assignmentSix.addActionListener(new ButtonListener());
		emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(200,100));
		emptyPanel2 = new JPanel();
		emptyPanel2.setPreferredSize(new Dimension(200,100));
		contentPane.add(emptyPanel);
		contentPane.add(emptyPanel2);
		contentPane.add(assignmentOne);
		contentPane.add(assignmentTwo);
		contentPane.add(assignmentThree);
		contentPane.add(assignmentFour);
		contentPane.add(assignmentFive);
		contentPane.add(assignmentSix);
		this.add(contentPane);
		setVisible(true);
	}
	//Method for communicating with other classes
	public void update(){
		ev.update();
	}
	//Event Handler
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == assignmentOne){
				try {
					ProgrammingAssignmentWindow paw1 = new ProgrammingAssignmentWindow(1,userID, pagui);
					Thread t1 = new Thread(paw1);
					t1.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource() == assignmentTwo ){
				try {
					ProgrammingAssignmentWindow paw2 = new ProgrammingAssignmentWindow(2,userID,pagui);
					Thread t2 = new Thread(paw2);
					t2.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource() == assignmentThree ){
				try {
					ProgrammingAssignmentWindow paw3 = new ProgrammingAssignmentWindow(3,userID,pagui);
					Thread t3 = new Thread(paw3);
					t3.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource() == assignmentFour ){
				try {
					ProgrammingAssignmentWindow paw4 = new ProgrammingAssignmentWindow(4,userID,pagui);
					Thread t4 = new Thread(paw4);
					t4.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource() == assignmentFive ){
				try {
					ProgrammingAssignmentWindow paw5 = new ProgrammingAssignmentWindow(5,userID,pagui);
					Thread t5 = new Thread(paw5);
					t5.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource() == assignmentSix ){
				try {
					ProgrammingAssignmentWindow paw6 = new ProgrammingAssignmentWindow(6,userID,pagui);
					Thread t6 = new Thread(paw6);
					t6.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
