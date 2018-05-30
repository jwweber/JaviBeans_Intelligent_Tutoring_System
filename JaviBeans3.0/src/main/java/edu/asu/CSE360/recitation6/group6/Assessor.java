package edu.asu.CSE360.recitation6.group6;
	/*
	 * This class provides a variety of panels that accept user input.
	 * Added multiple quizzes and necessary code for decorator pattern
	 * Assignment Number: Recitation Project 4
	 * Completion Time: 15 additional hours	 * 
	 *  @author Rozhin Azima, Jamison Weber
	 * 	@version 3.0
	 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class Assessor extends JPanel implements QuizAssessorComponent {
	//Class Variables
	private int state;
    //State 0 label
	protected JLabel name;
    //Labels for state 3
    protected JLabel optionOneLB;
    protected JLabel optionTwoLB;
    protected JLabel optionThreeLB;
    //Checkboxes for state 2
    protected JCheckBox optionOneCB;
    protected JCheckBox optionTwoCB;
    protected JCheckBox optionThreeCB;
    //Textfield for state 4
    protected JTextArea textArea;
    protected JScrollPane programmingScrollPane;
    protected JLabel programmingInstructions1;
    protected JLabel programmingInstructions2;
    protected JLabel programmingInstructions3;
    protected JLabel programmingInstructions4;
    protected JButton submitButton;
    protected JLabel programmingEmptyLabel1;
    protected JLabel programmingEmptyLabel2;
    protected JPanel box;
    protected JPanel labelHolder;
    protected JLabel boxLabel;
    protected JButton runButton;
    //Menu objects for state 1
    protected JComboBox menu;
    protected String[] menuItems = {"Option 1","Option 2","Option 3"};
    //Button objects for state 3
    protected JButton optionOneBTN;
    protected JButton optionTwoBTN;
    protected JButton optionThreeBTN;
    //Subpanel objects
    protected JPanel outerPanelZero;
    protected JPanel outerPanelOne;
    protected JPanel outerPanelTwo;
    protected JPanel outerPanelThree;
    protected JPanel outerPanelFour;
    protected JPanel outerPanelFive;
    protected JPanel panelZero;
    protected JPanel panelOne;
    protected JPanel panelTwo;
    protected JPanel panelThree;
    protected JPanel panelFour;
    protected JPanel panelFive;
    protected JPanel northPanelZero;
    protected JPanel northPanelOne;
    protected JPanel northPanelTwo;
    protected JPanel northPanelThree;
    protected JPanel northPanelFour;
    protected JPanel northPanelFive;
    protected GridBagConstraints c;
    protected JPanel finalPanel;
    protected JPanel buttonPanelFinal;
    protected JPanel panel3;
    protected JPanel panel4;
    protected JPanel quizLabelFinal;
    protected JPanel panel6;
    protected JPanel previousNextPanel;
    protected JPanel panel8;
    protected JPanel quizInstructionFinale;
    protected JPanel panel10;
    private CardLayout cardLayout = new CardLayout();
    //Panel Labels
    protected JLabel questionOne;
    protected JLabel questionTwo;
    protected JLabel questionThree;
    protected JLabel questionFour;
    protected JLabel quizLabel;
    //Panel 5 objects
    protected JLabel quizInstructions;
    protected JLabel emptyLabel1;
    protected JLabel emptyLabel2;
    protected JLabel quizInstructions1;
    protected JLabel emptyLabel3;
    protected JLabel emptyLabel4;
    protected JLabel emptyLabel5;
    protected JLabel emptyLabel6;
    protected JLabel emptyLabel7;
    protected JLabel emptyLabel8;
    protected JLabel emptyLabel9;
    protected ButtonGroup buttonGroup;
    protected JRadioButton radioButton1;
    protected JRadioButton radioButton2;
    protected JRadioButton radioButton3;
    protected JRadioButton radioButton4;
    protected JRadioButton dummyButton;
    protected JButton nextButton;
    protected JButton backButton ;
    private int score = 0;
    //Popup objects
    protected JFrame popup;
    protected JPanel popupPanel;
    protected JLabel popupLB;
    protected JButton popupBTN;
    private Color eggshell;
    ArrayList<QuizAssessor> qList;
    private String resTemp,writeFile, readFile;
    private int count = 0;
    private boolean[] results;
    private String[] chosenAnswers = {"","","","",""};
    private String quizName;
    private BasicTimer quizTimer;
    private Thread quizClock;
    protected int userID;
    protected int moduleNumber;
    protected QuizGUI qugui;
    protected CompanionMessagePanel cmp;
    //Constructor: This method initializes all interactive and panel objects and provides layout orientation
    public Assessor(String readFile, String writeFile, int userID,int moduleNumber, QuizGUI qugui){
    	this.qugui = qugui;
    	this.userID = userID;
    	this.moduleNumber = moduleNumber;
    	cmp = CompanionMessagePanel.getInstance();
    	quizTimer = new BasicTimer();
    	quizClock = new Thread(quizTimer);
    	quizClock.start();
		this.writeFile = writeFile;
		this.readFile = readFile;
		results = new boolean[5];
		qList = new ArrayList<>();
		qList = QuizAssessor.getList(readFile);
		super.setLayout(cardLayout);
		this.setPreferredSize(new Dimension(350,350));
		state = 5;
		eggshell = Color.WHITE;
		outerPanelZero = new JPanel(new BorderLayout());
		outerPanelZero.setBackground(new Color(252, 243, 207));
	    outerPanelOne = new JPanel(new BorderLayout());
	    outerPanelOne.setBackground(eggshell);
	    outerPanelTwo = new JPanel(new BorderLayout());
	    outerPanelTwo.setBackground(eggshell);
	    outerPanelThree = new JPanel(new BorderLayout());
	    outerPanelThree.setBackground(eggshell);
	    outerPanelFour = new JPanel(new BorderLayout());
	    outerPanelFour.setBackground(Color.LIGHT_GRAY);
	    outerPanelFive = new JPanel(new BorderLayout());
	    outerPanelFive.setBackground(eggshell);
		panelZero = new JPanel(new GridBagLayout());
		panelZero.setBackground(eggshell);
		panelOne = new JPanel(new GridBagLayout());
		panelOne.setBackground(eggshell);
		panelTwo = new JPanel(new GridBagLayout());
		panelTwo.setBackground(eggshell);
		panelThree = new JPanel(new GridBagLayout());
		panelThree.setBackground(eggshell);
		panelFour = new JPanel();
		panelFour.setBackground(Color.LIGHT_GRAY);
		panelFive = new JPanel(new GridBagLayout());
		panelFive.setBackground(eggshell);
		c = new GridBagConstraints();
		northPanelZero = new JPanel();
		northPanelZero.setBackground(eggshell);
	    northPanelOne = new JPanel();
	    northPanelOne.setBackground(eggshell);
	    northPanelTwo = new JPanel();
	    northPanelTwo.setBackground(eggshell);
	    northPanelThree = new JPanel();
	    northPanelThree.setBackground(eggshell);
	    northPanelFour = new JPanel();
	    northPanelFour.setBackground(Color.LIGHT_GRAY);
	    northPanelFive = new JPanel();
	    northPanelFive.setBackground(eggshell);
	    finalPanel = new JPanel();
	    buttonPanelFinal = new JPanel();
	    panel3 = new JPanel();
	    panel4 = new JPanel();
	    quizLabelFinal = new JPanel();
	    panel6 = new JPanel();
	    previousNextPanel = new JPanel();
	    panel8 = new JPanel();
	    quizInstructionFinale = new JPanel();
	    panel10 = new JPanel();
	    //State initializes
		initializeStateZero();
		initializeStateOne();
		initializeStateTwo();
		initializeStateThree();
		initializeStateFour();
		initializeStateFive();
		//add to layout
		this.add(outerPanelZero, "outerPanelZero");
		this.add(outerPanelOne, "outerPanelOne");
		this.add(outerPanelTwo, "outerPanelTwo");
		this.add(outerPanelThree, "outerPanelThree");
		this.add(outerPanelFour, "outerPanelFour");
		this.add(finalPanel, "panel1");
		//popup related initialization
		popupPanel = new JPanel();
	    popupLB = new JLabel("Hello World!");
	    popupLB.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    popupBTN = new JButton("OK");
	    popupBTN.setPreferredSize(new Dimension(60,30));
	    popupBTN.addActionListener(new Listener());
	    popupPanel.add(popupLB);
	    popupPanel.add(popupBTN);
	    //launch
		update();
	}
	//This method will update the visible JPanel depending on the current state
	private void update(){
		if(state == 0){
			cardLayout.show(this, "outerPanelZero");
		}
		else if(state == 1){
			cardLayout.show(this, "outerPanelOne");
		}
		else if(state == 2){
			cardLayout.show(this, "outerPanelTwo");
		}
		else if(state == 3){
			cardLayout.show(this, "outerPanelThree");
		}
		else if(state == 4){
			cardLayout.show(this, "outerPanelFour");
		}
		else if(state == 5){
			cardLayout.show(this, "panel1");
		}
		else{
			System.out.println("Invalid State!");
		}
	}
	//This method adjusts the state and calls update
	public void changeState(int state){
		this.state = state;
		update();
	}
	//This method builds the panel for state zero and defines layout orientation
	private void initializeStateZero(){
		name = new JLabel("<Jamison Weber>");
		name.setFont(new Font("Times New Roman", Font.BOLD, 30));
		northPanelZero.add(name);
		outerPanelZero.add(northPanelZero,BorderLayout.NORTH);
		outerPanelZero.add(panelZero,BorderLayout.CENTER);
	}
	//This method builds the panel for state one and defines layout orientation
	private void initializeStateOne(){
		questionOne = new JLabel("Question 1:");
		questionOne.setFont(new Font("Times New Roman", Font.BOLD, 30));
		menu = new JComboBox(menuItems);
		menu.setPreferredSize(new Dimension(200,20));
		menu.setSelectedIndex(0);
		menu.addActionListener(new Listener());
		northPanelOne.add(questionOne);
		outerPanelOne.add(northPanelOne, BorderLayout.NORTH);
		c.gridx = 0;
		c.gridy = 0;
		panelOne.add(menu,c);
		outerPanelOne.add(panelOne,BorderLayout.CENTER);
	}
	//This method builds the panel for state two and defines layout orientation
	private void initializeStateTwo(){
		questionTwo = new JLabel("Question 2:");
		questionTwo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		optionOneLB = new JLabel(" option 1");
		optionOneLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		optionTwoLB = new JLabel(" option 2");
		optionTwoLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		optionThreeLB = new JLabel(" option 3");
		optionThreeLB.setFont(new Font("Times New Roman", Font.BOLD, 25));
		optionOneCB = new JCheckBox();
		optionTwoCB = new JCheckBox();
		optionThreeCB = new JCheckBox();
		optionOneCB.addActionListener(new Listener());
		optionTwoCB.addActionListener(new Listener());
		optionThreeCB.addActionListener(new Listener());
		northPanelTwo.add(questionTwo);
		outerPanelTwo.add(northPanelTwo,BorderLayout.NORTH);
		c.gridx = 0;
		c.gridy = 0;
		panelTwo.add(optionOneCB,c);
		c.gridx = 1;
		c.gridy = 0;
		panelTwo.add(optionOneLB,c);
		c.gridx = 0;
		c.gridy = 1;
		panelTwo.add(optionTwoCB,c);
		c.gridx = 1;
		c.gridy = 1;
		panelTwo.add(optionTwoLB,c);
		c.gridx = 0;
		c.gridy = 2;
		panelTwo.add(optionThreeCB,c);
		c.gridx = 1;
		c.gridy = 2;
		panelTwo.add(optionThreeLB,c);
		outerPanelTwo.add(panelTwo,BorderLayout.CENTER);
	}
	//This method builds the panel for state three and defines layout orientation
	private void initializeStateThree(){
		questionThree = new JLabel("Question 3:");
		questionThree.setFont(new Font("Times New Roman", Font.BOLD, 30));
		optionOneBTN = new JButton("option 1");
		optionOneBTN.setPreferredSize(new Dimension(150,50));
		optionOneBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		optionTwoBTN = new JButton("option 2");
		optionTwoBTN.setPreferredSize(new Dimension(150,50));
		optionTwoBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		optionThreeBTN = new JButton("option 3");
		optionThreeBTN.setPreferredSize(new Dimension(150,50));
		optionThreeBTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		optionOneBTN.addActionListener(new Listener());
		optionTwoBTN.addActionListener(new Listener());
		optionThreeBTN.addActionListener(new Listener());
		northPanelThree.add(questionThree);
		outerPanelThree.add(northPanelThree, BorderLayout.NORTH);
		c.gridx = 0;
		c.gridy = 0;
		panelThree.add(optionOneBTN, c);
		c.gridx = 0;
		c.gridy = 1;
		panelThree.add(optionTwoBTN, c);
		c.gridx = 0;
		c.gridy = 2;
		panelThree.add(optionThreeBTN, c);
		outerPanelThree.add(panelThree, BorderLayout.CENTER);
	}
	//This method builds the panel for state four and defines layout orientation
	private void initializeStateFour(){
		questionFour = new JLabel("Question 4:");
		questionFour.setFont(new Font("Times New Roman", Font.BOLD, 30));
		programmingInstructions1 = new JLabel("Instructions for assignment go here.");
		programmingInstructions1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingInstructions2 = new JLabel("Instructions for assignment go here.");
		programmingInstructions2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingInstructions3 = new JLabel("Instructions for assignment go here.");
		programmingInstructions3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingInstructions4 = new JLabel("Instructions for assignment go here.");
		programmingInstructions4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea = new JTextArea("Write here...");
		textArea.setPreferredSize(new Dimension(300,20));
		textArea.setEditable(true);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingScrollPane = new JScrollPane(textArea);
		programmingEmptyLabel1 = new JLabel(" ");
		programmingEmptyLabel2 = new JLabel(" ");
		northPanelFour.add(questionFour);		
		outerPanelFour.add(northPanelFour, BorderLayout.NORTH);
		panelFour.add(programmingInstructions1);
		panelFour.add(programmingInstructions2);
		panelFour.add(programmingInstructions3);
		panelFour.add(programmingInstructions4);
		panelFour.add(programmingEmptyLabel1);
		panelFour.add(textArea);
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		box = new JPanel();
		box.setPreferredSize(new Dimension(300,50));
		box.setBackground(Color.LIGHT_GRAY);
		labelHolder = new JPanel(new FlowLayout(-2));
		labelHolder.setPreferredSize(new Dimension(300,50));
		labelHolder.setBackground(Color.WHITE);
		panelFour.add(programmingEmptyLabel2);
		panelFour.add(box);
		boxLabel = new JLabel("Temp Label");
		labelHolder.add(boxLabel);
		panelFour.add(labelHolder);
		runButton = new JButton("Run");
		runButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panelFour.add(runButton);
		panelFour.add(submitButton);
		outerPanelFour.add(panelFour, BorderLayout.CENTER);
	}
	//initialization for quiz assessor
	private void initializeStateFive(){
		emptyLabel1 = new JLabel(" ");
		emptyLabel2 = new JLabel(" ");
		emptyLabel3 = new JLabel(" ");
		emptyLabel4 = new JLabel(" ");
		emptyLabel5 = new JLabel(" ");
		emptyLabel6 = new JLabel(" ");
		emptyLabel7 = new JLabel(" ");
		emptyLabel8 = new JLabel(" ");
		emptyLabel9 = new JLabel(" ");
	    quizLabel = new JLabel();
		quizLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		quizLabel.setBackground(Color.GRAY);
		nextButton = new JButton("Next");
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		nextButton.setActionCommand("Next");;
		nextButton.addActionListener(new ButtonListener());
		backButton = new JButton("Back");
		backButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		backButton.addActionListener(new ButtonListener());
		backButton.setActionCommand("Back");
		quizInstructions = new JLabel("");
		quizInstructions.setFont(new Font("Times New Roman", Font.BOLD, 18));
		buttonGroup = new ButtonGroup();
		radioButton1 = new JRadioButton("");
		radioButton1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radioButton2 = new JRadioButton("");
		radioButton2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radioButton3 = new JRadioButton("");
		radioButton3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radioButton4 = new JRadioButton("");
		radioButton4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		radioButton1.addActionListener(new Listener());
		radioButton2.addActionListener(new Listener());
		radioButton3.addActionListener(new Listener());
		radioButton4.addActionListener(new Listener());
		dummyButton = new JRadioButton("");
		dummyButton.setVisible(false);
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		buttonGroup.add(radioButton4);
		buttonGroup.add(dummyButton);
		quizLabelFinal.setSize(600,100);
		quizLabelFinal.add(outerPanelFive);
		outerPanelFive.setLayout(new GridLayout(1,4));
		outerPanelFive.add(quizLabel);
		panelFive.setLayout(new GridLayout(3, 2));
		panelFive.add(emptyLabel6);
		panelFive.add(emptyLabel7);
		panelFive.add(radioButton1);
		panelFive.add(radioButton2);
		panelFive.add(radioButton3);
		panelFive.add(radioButton4);
	    panel10.add(panel6, BorderLayout.NORTH);
		panel6.setSize(600,400);
		panel6.add(quizInstructions);
	    buttonPanelFinal.setLayout(new BoxLayout(buttonPanelFinal, BoxLayout.Y_AXIS));
		panel8.setSize(600,200);
		quizInstructionFinale.setLayout(new BoxLayout(quizInstructionFinale, BoxLayout.Y_AXIS));
        quizInstructionFinale.add(panel8); 
		buttonPanelFinal.add(panel6);
		buttonPanelFinal.add(panelFive);   
		previousNextPanel.add(panel4,BorderLayout.SOUTH);   
		panel4.setSize(600,200);
		panel4.add(panel3);
		panel3.setLayout(new GridLayout(1, 4));
		panel3.add(backButton);
		panel3.add(emptyLabel4);
		panel3.add(emptyLabel5);
		panel3.add(nextButton);	
		finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));
		finalPanel.add(quizLabelFinal);
	    finalPanel.add(quizInstructionFinale);
	    finalPanel.add(buttonPanelFinal);
	    finalPanel.add(previousNextPanel);
		change(0);
	}
	//This method creates a question to the existing window
		//This method creates a generic popup window to be called by listener
		//nextButton
		//backbutton
		public void change(int pos){
			if(pos == 0){
				//nextButton.setEnabled(true);
				backButton.setEnabled(false);
			}
			else if(pos == 4){
				backButton.setEnabled(true);
				nextButton.setText("Submit");
			}
			else{
				nextButton.setText("Next");
				backButton.setEnabled(true);
			}
			QuizAssessor q = qList.get(pos);
			quizInstructions.setText(q.getQuestion());
			radioButton1.setText(q.getOpt1());
			radioButton2.setText(q.getOpt2());
			radioButton3.setText(q.getOpt3());
			radioButton4.setText(q.getOpt4());
		}
	//This method creates a generic popup window to be called by listener
	public void genericPopup(){
		popup = new JFrame();
		popup.setSize(new Dimension(600,100));
		popup.setLocationRelativeTo(null);
		popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popup.setTitle("Assessment:");
		popup.setResizable(false);
		popup.setContentPane(popupPanel);
		popup.setVisible(true);
	}
	public void updateQUGUI(){
		qugui.update();
	}
	//This is a private class that creates a popup window whenever an interactive
	//object is triggered.
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== menu){
				JComboBox temp = (JComboBox) e.getSource();
				String option = (String) temp.getSelectedItem();
				switch(option){
					case "Option 1":
						genericPopup();
						break;
					case "Option 2":
						genericPopup();
						break;
					case "Option 3":
						genericPopup();
						break;
					default:
						System.out.println("Error");	
				}
			}
			else if(e.getSource() == optionOneCB){
				genericPopup();
			}
			else if(e.getSource() == optionTwoCB){
				genericPopup();
			}
			else if(e.getSource() == optionThreeCB){
				genericPopup();
			}
			else if(e.getSource() == optionOneBTN){
				genericPopup();
			}
			else if(e.getSource() == optionTwoBTN){
				genericPopup();
			}
			else if(e.getSource() == optionThreeBTN){
				genericPopup();
			}
			else if(e.getSource() == popupBTN){
				popup.dispose();
			}else {
				nextButton.setEnabled(true);
				resTemp = ((JRadioButton)e.getSource()).getText();
				
				chosenAnswers[count] = resTemp;
			}
		}
	}
	//Listener
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			boolean justAdded = false;
			if(e.getActionCommand() == "Back"){
				
				if(count>0){
					if(justAdded){
						score--;
						justAdded = false;
					}
					count--;
					change(count);
					if((radioButton1.getText()).equals(chosenAnswers[count])){
						radioButton1.setSelected(true);
					}
					else if((radioButton2.getText()).equals(chosenAnswers[count])){
						radioButton2.setSelected(true);
					}
					else if((radioButton3.getText()).equals(chosenAnswers[count])){
						radioButton3.setSelected(true);
					}
					else
						radioButton4.setSelected(true);
				}
			}
			else{
				if(resTemp.equalsIgnoreCase(qList.get(count).rightAnswer())){
					results[count] = true;
					score++;
					justAdded = true;
					qugui.displayQuizMessage(count, true);
				}
				else{
					System.out.println(score);
					qugui.displayQuizMessage(count, false);
				}
				if(count == 4){
					quizClock.stop();
					//Call to write to File
					new FileIO().writeToFile(score, writeFile,results,quizTimer.getElapsedSeconds(),userID, moduleNumber);
					removeAll();
					setLayout(new BorderLayout());
					add(new JLabel("You scored : "+score+"/5"));
					revalidate();
					repaint();
					updateQUGUI();
				}
				else {
					count++;
					change(count);
					radioButton1.setSelected(false);
					radioButton2.setSelected(false);
					radioButton3.setSelected(false);
					radioButton4.setSelected(false);
					dummyButton.setSelected(true);
					nextButton.setEnabled(false);
				}
			}
		}
	}
	//Required Method for decorator pattern
	@Override
	public void displayMessage() {
		// TODO Auto-generated method stub
		cmp.setMessage1("Companion speaking: ");
	}
}
