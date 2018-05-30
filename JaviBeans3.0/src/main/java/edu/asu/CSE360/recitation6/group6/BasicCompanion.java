package edu.asu.CSE360.recitation6.group6;
    /*
	 * This class will load and display renderings of facial expressions onto a JPanel.
	 * This class now follows the observer pattern and observes the evaluator
	 * This class also follows the decorator pattern
	 * Assignment Number: Recitation Project 4
	 * Completion Time: 3 additional hours
	 * 
	 *  @author Rozhin Azima, Jamison Weber 
	 * 	@version 3.0
	 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Arc2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
//Constructor: Creates objects for each facial expressions and adds them to a card layout JPanel
public class BasicCompanion extends JPanel implements Observer, Companion{
	private static final long serialVersionUID = 1L;
	private static double sorryMouthYPos = 0;
	private static double sorryMouthYVel = 0.25;
	private static double sorryEyebrowsYPos = 0;
	private static double sorryEyebrowsYVel = 0.05;
	private static double happyXPos = 0;
	private static double happyYPos = 0;
	private static double happyYVel = 0.25;
	private CardLayout cl = new CardLayout();
	private Worry worry;
	private Happy happy;
	private Sorry sorry;
	private Think think;
	private int state;
	private JLabel lab;
	private JPanel panel;
	private Color eggshell;
	private static int faceState =1;
	private static int faceState1 =1;
	private Observable subject;
	private ControlCenter cc;
	private CompanionMessagePanel cmp;
	//public constructor
	public BasicCompanion(Observable subject) throws FileNotFoundException{
		super.setLayout(cl);
		this.subject = subject;
		cc = ControlCenter.getInstance();
		cmp = CompanionMessagePanel.getInstance();
		//draw face objects
		worry = new Worry();
		happy = new Happy();
		sorry = new Sorry();
		think = new Think();
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(350,350));
		eggshell = Color.WHITE;
		panel.setBackground(eggshell);
		lab = new JLabel("<Rozhin Azima>");
		lab.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lab);
		state = 1;
		//Initiate background threads for animation
		Thread sorryThread = new Thread(new SorryAnimator(5));
		sorryThread.start();
		Thread happyThread = new Thread(new HappyAnimator(5));
		happyThread.start();
		Thread ThinkingThread = new Thread(new thinkingThread(250));
		ThinkingThread.start();
		Thread worryThread = new Thread(new worryThread(350));
		worryThread.start();
		this.add(worry, "worry");
		this.add(sorry, "sorry");
		this.add(happy, "happy");
		this.add(think, "think");
		this.add(panel, "panel");
		this.changeState(1);
	}
	//This method will change the visible panel depending on the state
	public void changeState(int state) {
		this.state = state;
			if (state == 1) {
				cl.show(this, "happy");
			} else if (state == 2) {
				cl.show(this, "think");
			} else if (state == 3) {
				cl.show(this, "worry");
			}
			  else if (state == 4) {
				cl.show(this, "sorry");
			}
			else{
		    	  cl.show(this, "think");
			}
	}
	//This class paints a pre-rendered image onto a JPanel
	private class Worry extends JPanel  {
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			//backGround
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			
			if(faceState1 == 1){
				ImageIcon think = new ImageIcon("src/main/resources/worryFace.png");
				think.paintIcon(this, g,45,35);
			}
			else if(faceState1 == 2){
				ImageIcon think1 = new ImageIcon("src/main/resources/worryFace2.jpg");
				think1.paintIcon(this, g,45,35);
			}
			else if(faceState1 == 3){
				ImageIcon think2 = new ImageIcon("src/main/resources/worryFace3.jpg");
				think2.paintIcon(this, g,45,35);
			}	
		}
	}
	//this class implements Runnable and changes the face state to animate the worry objects
	private class worryThread implements Runnable {
		private int milliseconds;
		// in constructor we pass the frame rate of the animation
		public worryThread(int milliseconds){
			this.milliseconds = milliseconds;
		}
		//this method provides the change state between the 3 pictures of worry 
		public void run() {
			while(true){
				if(faceState1 == 1){
					faceState1 = 2;
				} 
				else if(faceState1 == 2){
					faceState1 = 3;
				}
				else if(faceState1 == 3){
					faceState1 = 1;
				}
				worry.repaint();
				try{
					Thread.sleep(milliseconds);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	//This class paints a pre-rendered image onto a JPanel
	private class Think extends JPanel {
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			//backGround
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 500, 500);
			if(faceState == 1){
				ImageIcon think = new ImageIcon("src/main/resources/ThinkingFace.png");
				think.paintIcon(this, g,25,25);		
			}
			else if(faceState == 2){
				ImageIcon think1 = new ImageIcon("src/main/resources/ThinkingFace2.jpg");
				think1.paintIcon(this, g,25,25);
			}
			else if(faceState == 3){
				ImageIcon think2 = new ImageIcon("src/main/resources/ThinkingFace3.jpg");
				think2.paintIcon(this, g,25,25);
			}
		}
	}
	//this class implements Runnable and change the face state to animate the think class
	private class thinkingThread implements Runnable {
		private int milliseconds;
		public thinkingThread(int milliseconds){
			this.milliseconds = milliseconds;
		}
		//this method provides the change state between the 3 pictures of think 
		public void run() {
			while(true){
				if(faceState == 1){
					faceState = 2;
				} 
				else if(faceState == 2){
					faceState = 3;
				}
				else if(faceState == 3){
					faceState = 1;
				}
				think.repaint();
				try{
					Thread.sleep(milliseconds);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	//This class paints an image of a sorry-face onto a JPanel using the draw() method 
	//from the graphics package
	private class Sorry extends JPanel {	 
		public void paintComponent(Graphics g){
		   super.paintComponent(g);
		   //backGround
		   g.setColor(Color.WHITE);
		   g.fillRect(0, 0, 500, 500);
		   //face
		   g.setColor(Color.YELLOW);
		   g.fillOval(50, 25, 250, 250);
		   //eye left
		   g.setColor(Color.WHITE);
		   g.fillOval(80, 67, 87, 87);
		   //eyeball left
		   g.setColor(Color.BLACK);
		   g.fillOval(102, 90, 47, 47);
		   //eye right
		   g.setColor(Color.WHITE);
		   g.fillOval(180, 67, 87, 87);
		   //eyeball right
		   g.setColor(Color.BLACK);
		   g.fillOval(195,90, 47, 47);
		   //mouth
		   Graphics2D g2 = (Graphics2D) g;
		   Graphics2D g3 = (Graphics2D) g2;	
		   g2.setColor(Color.black);
		   g2.fill(new Arc2D.Double( 95,sorryMouthYPos +160,180,150,170, -150, Arc2D.OPEN));
		   g.setColor(Color.YELLOW);
		   g.fillArc(106,(int) (sorryMouthYPos +  170), 150, 140, 20, 170);
		   //left eyebrow
		   g.setColor(Color.BLACK);
		   g.fillArc(27, (int) (sorryEyebrowsYPos + 1), 120, 140, 20, 10);
		   //right eyebrow
		   g.setColor(Color.BLACK);
		   g.fillArc(195, (int) (sorryEyebrowsYPos + 1), 140, 135, 160, -12);
	     }
	 }
	//this class implements Runnable and change the face state to animate the think class
	private class SorryAnimator implements Runnable{
		private int milliseconds;
		// in constructor we pass the frame rate of the animation
		public SorryAnimator(int milliseconds){
			this.milliseconds = milliseconds;
		}
		//this method provides the boundaries of the sad face's movement 
		public void run(){
			while(true){
				if(sorryMouthYPos < 0 || sorryMouthYPos > 5 ){
					sorryMouthYVel = -sorryMouthYVel;
				}
				sorryMouthYPos = sorryMouthYPos + sorryMouthYVel;
				if(sorryEyebrowsYPos < 0 || sorryEyebrowsYPos > 5 ){
					sorryEyebrowsYVel = -sorryEyebrowsYVel;
				}
				sorryEyebrowsYPos = sorryEyebrowsYPos + sorryEyebrowsYVel;
				sorry.repaint();
				try{
					Thread.sleep(milliseconds);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	//This class paints an image of a happy-face onto a JPanel using the draw() method 
		//from the graphics package
	private class Happy extends JPanel
	{
		public void paintComponent(Graphics g){
		   super.paintComponent(g);
		 //backGround
		   g.setColor(Color.WHITE);
		   g.fillRect(0, 0, 500, 500);
		   //face
		   g.setColor(Color.YELLOW);
		   g.fillOval((int)(happyXPos + 50), (int)(happyYPos + 25), 250, 250);
		   //eye left
		   g.setColor(Color.WHITE);
		   g.fillOval((int)(happyXPos + 90), (int)(happyYPos + 67), 87, 87);
		   //eyeball left
		   g.setColor(Color.BLACK);
		   g.fillOval((int)(happyXPos + 112), (int)(happyYPos + 90), 47, 47);
		   //eye right
		   g.setColor(Color.WHITE);
		   g.fillOval((int)(happyXPos + 190), (int)(happyYPos + 67), 87, 87);
		   //eyeball right
		   g.setColor(Color.BLACK);
		   g.fillOval((int)(happyXPos + 205),(int)(happyYPos + 90), 47, 47);
		   //mouth
		   Graphics2D g2 = (Graphics2D) g;
		   Graphics2D g3 = (Graphics2D) g2;
		   g2.setColor(Color.PINK);
		   g2.fill(new Arc2D.Double((int)(happyXPos + 75),(int)(happyYPos + 100), 200,150,170, 200, Arc2D.CHORD));
	     }
	 }
	//this class implements Runnable and change the face state to animate the think class
	private class HappyAnimator implements Runnable{
		private int milliseconds;
		public HappyAnimator(int milliseconds){
			this.milliseconds = milliseconds;
		}
		//this method provides the boundaries of the happy face's movement 
		public void run(){
			while(true){
				if(happyYPos < -30 || happyYPos > 30 ){
					happyYVel = -happyYVel;		
				}
				happyYPos = happyYPos + happyYVel;
				happy.repaint();
				try{
					Thread.sleep(milliseconds);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		try {
			state = cc.getDecisionState();
			System.out.println("state: "+state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changeState(state);
	}
	public Observable getSubject(){
		return this.subject;
	}
	public void setSubject(Observable subject){
		this.subject = subject;
	}
	@Override
	public void displayMessage() {
		// TODO Auto-generated method stub
		cmp.setMessage1("Companion speaking: ");
	}
}
