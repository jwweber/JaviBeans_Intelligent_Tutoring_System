package edu.asu.CSE360.recitation6.group6;
/*
 * This class loads the flashcard images into the project.
 * Assignment Number: Recitation Project 4
 * Completion Time: 11 hours
 * 
 *  @author Behnaz Sabbaghi
 * 	@version 1.0
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FlashTopicFrame extends JPanel {	
	private JPanel contentPane;
	private JButton introF;
	private JButton varF;
	private JButton stringF;
	private JButton loopF;
	private JButton controlF;
	private JButton arrayF;
	private JLabel cardsLabel;
	private JPanel empty;
	ArrayList<ImageIcon> introFlash;
	ArrayList<ImageIcon> variableFlash;
	ArrayList<ImageIcon> stringFlash;
	ArrayList<ImageIcon> loopFlash;
	ArrayList<ImageIcon> controlFlash;
	ArrayList<ImageIcon> arrayFlash;
	final int TotalIntroFlashes=10;
	final int TotalVariableFlashes=10;
	final int TotalStringFlashes=10;
	final int TotalLoopFlashes=10;
	final int TotalControlFlashes=10;
	final int TotalArrayFlashes=10;
	ImageLoadingFlashcard flashCardViewer; 
	//public constructor
	public FlashTopicFrame() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4,	 2));
		cardsLabel = new JLabel("Study Flash Cards:");
		cardsLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(cardsLabel);
		empty = new JPanel();
		empty.setPreferredSize(new Dimension(200,100));
		contentPane.add(empty);
		introF = new JButton("Introduction-Flashcards");
		introF.addActionListener(new ButtonListener());
		contentPane.add(introF);
		introF.setSize(200, 100);
		varF = new JButton("Variables-Flashcards");
		varF.addActionListener(new ButtonListener());
		contentPane.add(varF);
		stringF = new JButton("Strings-Flashcards");
		stringF.addActionListener(new ButtonListener());
		contentPane.add(stringF);
		loopF = new JButton("Loops-Flashcards");
		loopF.addActionListener(new ButtonListener());
		contentPane.add(loopF);
		controlF = new JButton("Control Statement-Flashcards");
		controlF.addActionListener(new ButtonListener());
		contentPane.add(controlF);
		arrayF = new JButton("Arrays-Flashcards");
		arrayF.addActionListener(new ButtonListener());
		contentPane.add(arrayF);
		this.add(contentPane);
		ImageLoadingFlashcard();
	}
//Loads flashcard images
private void ImageLoadingFlashcard() {
	ImageIcon tempIcon2;
	int imageNum2;
	Image scaledImage2;
	String prePath = "src/main/resources/flashcards/introflashcards/Slide";
	String postPath =".JPG";
	introFlash = new ArrayList<ImageIcon>();
	variableFlash = new ArrayList<ImageIcon>();
	stringFlash= new ArrayList<ImageIcon>();
	loopFlash = new ArrayList<ImageIcon>();
	controlFlash = new ArrayList<ImageIcon>();
	arrayFlash = new ArrayList<ImageIcon>();
	for (int i = 0; i < TotalIntroFlashes; i++) {
		imageNum2 = i + 1;
		tempIcon2 = new ImageIcon(prePath + imageNum2 + postPath);
		scaledImage2 =  tempIcon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		introFlash.add(new ImageIcon(scaledImage2));
	}
	prePath = "src/main/resources/flashcards/variableflashcards/Slide";
	for (int i = 0; i < TotalVariableFlashes; i++) {
		imageNum2 = i + 1;
		tempIcon2 = new ImageIcon(prePath + imageNum2 + postPath);			
		scaledImage2 =  tempIcon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);	
		tempIcon2 = new ImageIcon(scaledImage2);
		variableFlash.add(tempIcon2);
	}
	prePath = "src/main/resources/flashcards/stringflashcards/Slide";
	for (int i = 0; i < TotalStringFlashes; i++) {
		imageNum2 = i + 1;
		tempIcon2 = new ImageIcon(prePath + imageNum2 + postPath);	
		scaledImage2 =  tempIcon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		stringFlash.add(new ImageIcon(scaledImage2));
	}
	prePath = "src/main/resources/flashcards/loopflashcards/Slide";
	for (int i = 0; i < TotalLoopFlashes; i++) {
		imageNum2 = i + 1;
		tempIcon2 = new ImageIcon(prePath + imageNum2 + postPath);	
		scaledImage2 =  tempIcon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		loopFlash.add(new ImageIcon(scaledImage2));
	}
	prePath = "src/main/resources/flashcards/controlflashcards/Slide";
	for (int i = 0; i < TotalControlFlashes; i++) {
		imageNum2 = i + 1;
		tempIcon2 = new ImageIcon(prePath + imageNum2 + postPath);	
		scaledImage2 =  tempIcon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		controlFlash.add(new ImageIcon(scaledImage2));
	}
	prePath = "src/main/resources/flashcards/arrayflashcards/Slide";
	for (int i = 0; i < TotalArrayFlashes; i++) {
		imageNum2 = i + 1;
		tempIcon2 = new ImageIcon(prePath + imageNum2 + postPath);	
		scaledImage2 =  tempIcon2.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		arrayFlash.add(new ImageIcon(scaledImage2));
	}
}
//Listener
public class ButtonListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton clickedButton = (JButton)e.getSource();
		
		if (clickedButton == null) System.out.println ("clicked button is null");
		
		if (clickedButton.equals(introF)) {
			flashCardViewer = new ImageLoadingFlashcard(introFlash);
		}else if (clickedButton.equals(varF)) {
			System.out.println ("varF");
			flashCardViewer = new ImageLoadingFlashcard(variableFlash);
		}else if (clickedButton.equals(stringF)) {
			flashCardViewer = new ImageLoadingFlashcard(stringFlash);
		}else if (clickedButton.equals(loopF)) {
			flashCardViewer = new ImageLoadingFlashcard(loopFlash);
		}else if (clickedButton.equals(controlF)) {
			flashCardViewer = new ImageLoadingFlashcard(controlFlash);
		}else if (clickedButton.equals(arrayF)) {
			flashCardViewer = new ImageLoadingFlashcard(arrayFlash);
		}
		if (flashCardViewer == null) System.out.println ("It's null");
		flashCardViewer.setTitle("FlashCardViewer");
		flashCardViewer.setVisible(true);
	}
}
}
