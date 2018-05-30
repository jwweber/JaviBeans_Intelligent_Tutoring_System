package edu.asu.CSE360.recitation6.group6;
import java.awt.Dimension;
/*
 * This class provides a GUI displaying buttons that link to different programming assignment window objects.
 * Added ability to communicate with assessor objects and evaluator
 * Now holds guided quiz assessor decorator objects
 * Assignment Number: Recitation Project 4
 * Completion Time: 1 additional hour
 * 
 *  @author Jamison Weber
 * 	@version 2.0
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class QuizGUI extends JPanel{
	private JButton quizOne;
	private JButton quizTwo;
	private JButton quizThree;
	private JButton quizFour;
	private JButton quizFive;
	private JButton quizSix;
	private JPanel contentPane;
	private JPanel emptyPanel;
	private JPanel emptyPanel2;
	private int userID;
	private Evaluator ev;
	protected QuizGUI qugui;
	private ControlCenter cc;
	GuidedQuizAssessor gqa;
	//public constructor
	public QuizGUI(int userID, Evaluator ev){
		qugui = this;
		this.ev = ev;
		this.userID = userID;
		this.setPreferredSize(new Dimension(400, 400));
		setBounds(100, 100, 450, 300);
		try {
			cc = ControlCenter.getInstance();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4, 2));
		quizOne = new JButton("Complete Quiz 1");
		quizTwo = new JButton("Complete Quiz 2");
		quizThree = new JButton("Complete Quiz 3");
		quizFour = new JButton("Complete Quiz 4");
		quizFive = new JButton("Complete Quiz 5");
		quizSix = new JButton("Complete Quiz 6");
		quizOne.setPreferredSize(new Dimension(200,100));
		quizOne.addActionListener(new ButtonListener());
		quizTwo.addActionListener(new ButtonListener());
		quizThree.addActionListener(new ButtonListener());
		quizFour.addActionListener(new ButtonListener());
		quizFive.addActionListener(new ButtonListener());
		quizSix.addActionListener(new ButtonListener());
		emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(200,100));
		emptyPanel2 = new JPanel();
		emptyPanel2.setPreferredSize(new Dimension(200,100));
		contentPane.add(emptyPanel);
		contentPane.add(emptyPanel2);
		contentPane.add(quizOne);
		contentPane.add(quizTwo);
		contentPane.add(quizThree);
		contentPane.add(quizFour);
		contentPane.add(quizFive);
		contentPane.add(quizSix);
		this.add(contentPane);
		setVisible(true);
	}
	//method for interclass communication
	public void update(){
		ev.update();
	}
	//method for updating guided quiz assessor 
	public void displayQuizMessage(int count, boolean isCorrect){
		
		if(cc.getGuided()){
			gqa.displayMessage(count, isCorrect);
		}
	}
	//Event Handler
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == quizOne){
				JFrame frame = new JFrame();
		        frame.setSize(800,700);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        new FileIO().init();
				Assessor qa = new Assessor("src/main/resources/myFile.txt","src/main/resources/Quiz1.txt",userID,1,qugui);
		        frame.add(qa);
		        frame.setVisible(true);
		        gqa = new GuidedQuizAssessor("<html>Incorrect: Think about a relatively<br>unknown company.</html>",
		        		"<html>Incorrect: Think of the<br>mythological clairevoyant at Delphi.</html>",
		        		"<html>Incorrect: It is a label for a<br>computer to remember things</html>",
		        		"<html>Incorrect: It's more<br>than you think</html>",
		        		"<html>Incorrect: objects are about<br>arranging information</html>");
		        if(cc.getGuided()){
		        	gqa.add(qa);
		        }
				
			}else if(e.getSource() == quizTwo ){
				JFrame frame = new JFrame();
		        frame.setSize(800,700);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        new FileIO().init();
				Assessor qa = new Assessor("src/main/resources/myFile2.txt","src/main/resources/Quiz2.txt",userID,2,qugui);
		        frame.add(qa);
		        frame.setVisible(true);
		        gqa = new GuidedQuizAssessor("<html>Incorrect: Array length must<br>be declared at initialization.</html>",
		        		"<html>Incorrect: Its the number of elements.</html>",
		        		"<html>Incorrect: The answer is no.<br>But why?</html>",
		        		"<html>Incorrect: 2D arrays need two<br>sets of brackets. Rows come<br>first, then columns</html>",
		        		"<html>Incorrect: It is pretty obvious.</html>");
		        if(cc.getGuided()){
		        	gqa.add(qa);
		        }
			}else if(e.getSource() == quizThree ){
				JFrame frame = new JFrame();
		        frame.setSize(800,700);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        new FileIO().init();
				Assessor qa = new Assessor("src/main/resources/myFile3.txt","src/main/resources/Quiz3.txt",userID,3,qugui);
		        frame.add(qa);
		        frame.setVisible(true);
		        gqa = new GuidedQuizAssessor("<html>Incorrect: Think very precisely</html>",
		        		"<html>Incorrect: Think of the simplest answer</html>",
		        		"<html>Incorrect: Keep in mind the number<br>of elements in the loop</html>",
		        		"<html>Incorrect: Remember that 5<br>is out of bounds</html>",
		        		"<html>Incorrect: Double check the range.</html>");
		        if(cc.getGuided()){
		        	gqa.add(qa);
		        }
			}else if(e.getSource() == quizFour ){
				JFrame frame = new JFrame();
		        frame.setSize(800,700);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        new FileIO().init();
				Assessor qa = new Assessor("src/main/resources/myFile4.txt","src/main/resources/Quiz4.txt",userID,4,qugui);
		        frame.add(qa);
		        frame.setVisible(true);
		        gqa = new GuidedQuizAssessor("<html>Incorrect: Look at the data type</html>",
		        		"<html>Incorrect: Think about grouping strings</html>",
		        		"<html>Incorrect: toString() returns a string.</html>",
		        		"<html>Incorrect: Remember character<br>indexing begins at zero,</html>",
		        		"<html>Incorrect: Possibly, yeah...</html>");
		        if(cc.getGuided()){
		        	gqa.add(qa);
		        }
			}else if(e.getSource() == quizFive ){
				JFrame frame = new JFrame();
		        frame.setSize(800,700);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        new FileIO().init();
				Assessor qa = new Assessor("src/main/resources/myFile5.txt","src/main/resources/Quiz5.txt",userID,5,qugui);
		        frame.add(qa);
		        frame.setVisible(true);
		        gqa = new GuidedQuizAssessor("<html>Incorrect: Notice it is print()<br>and not println().</html>",
		        		"<html>Incorrect: It is two symbols,<br>not words.</html>",
		        		"<html>Incorrect: Try to look at it logically.</html>",
		        		"<html>Incorrect: Some things are optional.</html>",
		        		"<html>Incorrect: The result is one word.</html>");
		        if(cc.getGuided()){
		        	gqa.add(qa);
		        }
			}else if(e.getSource() == quizSix ){
				JFrame frame = new JFrame();
		        frame.setSize(800,700);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        new FileIO().init();
				Assessor qa = new Assessor("src/main/resources/myFile6.txt","src/main/resources/Quiz6.txt",userID,6,qugui);
		        frame.add(qa);
		        frame.setVisible(true);
		        gqa = new GuidedQuizAssessor("<html>Incorrect: Somewhere in the middle.</html>",
		        		"<html>Incorrect: It's an integer.</html>",
		        		"<html>Incorrect: hmm, possibly...</html>",
		        		"<html>Incorrect: immutable means unalterable.</html>","<html>Incorrect: It is exactly one<br>of these.</html>");
		        if(cc.getGuided()){
		        	gqa.add(qa);
		        }
			}
		}
	}
}
