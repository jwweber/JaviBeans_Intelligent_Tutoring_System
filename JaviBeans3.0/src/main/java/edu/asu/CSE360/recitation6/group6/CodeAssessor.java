package edu.asu.CSE360.recitation6.group6;
/*
 * This class accepts student written code, compiles it, runs it and evaluates the output.
 * Class now includes elapsed time for assignment completion and additional error checking
 * Class now communicates with ProgrammingAssignmentWindow
 * Assignment Number: Recitation Project 3
 * Completion Time: 6 additional Hours
 * 
 *  @author Jamison Weber
 * 	@version 2.0
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
//This class will assess the results of a student coding assignment but compiling the input and analyzing it.
public class CodeAssessor extends Assessor{
	private boolean compiled;
	private boolean correct;
	private Formatter fileWriter;
	private Formatter updater;
	private String studentContent;
	private String instructions1;
	private String instructions2;
	private String instructions3;
	private String instructions4;
	private String answerKey;
	private String studentOutput;
	private String title;
	private String includeKey;
	private String hintMessage;
	private int userID;
	private int moduleNumber;
	private boolean hasIncludeKey;
	private ProgrammingAssignmentWindow paw;
	private BasicTimer timer;
	private double elapsedTime;
	private Thread clock;
	//public constructor
	public CodeAssessor(ProgrammingAssignmentWindow paw,String title, String instructions1, String instructions2,String instructions3, String instructions4, String answerKey, String includeKey, String hintMessage,int userID,int moduleNumber) throws FileNotFoundException{
		super("src/main/resources/myFile.txt","src/main/resources/Quiz1.txt", userID, moduleNumber, null);
		super.changeState(4);
		this.paw = paw;
		this.answerKey = answerKey;
		this.instructions1 = instructions1;
		this.instructions2 = instructions2;
		this.instructions3 = instructions3;
		this.instructions4 = instructions4;
		this.title = title;
		this.includeKey = includeKey;
		this.hintMessage = hintMessage;
		this.userID = userID;
		this.moduleNumber = moduleNumber;
		timer = new BasicTimer();
		clock = new Thread(timer);
		clock.start();
		questionFour.setText(title);
		programmingInstructions1.setText(instructions1);
		programmingInstructions1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingInstructions2.setText(instructions2);
		programmingInstructions2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingInstructions3.setText(instructions3);
		programmingInstructions3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		programmingInstructions4.setText(instructions4);
		programmingInstructions4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea.setPreferredSize(new Dimension(750,425));
		box.setPreferredSize(new Dimension(750,5));
		labelHolder.setPreferredSize(new Dimension(750,75));
		this.setPreferredSize(new Dimension(800,800));
		submitButton.addActionListener(new Listener());
		runButton.addActionListener(new Listener());
		programmingEmptyLabel2.setText("Output: \n");
		programmingEmptyLabel2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		boxLabel.setText("");
	}
	//test if key matches output
	private void evaluate(){
		if(answerKey.equals(studentOutput)){
			correct = true;
		}
		else{
			correct = false;
		}
	}
	//Ensures the student code has the correct key words
	private void analyze(){
		int len = includeKey.length();
		int firstPos = 0;
		int secondPos = firstPos + len;
		int codeLen = studentContent.length();
		hasIncludeKey = false;
		for(int i = 0; i < (codeLen - len); i++){
			if(studentContent.substring(firstPos,secondPos).equals(includeKey)){
				hasIncludeKey = true;
			}
			firstPos++;
			secondPos++;
		}
	}
	//prepare submit button popup
	private void launchPopup(){
		if(compiled == true && correct == true && hasIncludeKey == true){
			popupLB.setText("Correct! Your program compiles and has the correct output.");
		}
		else if(compiled == true && correct == false){
			popupLB.setText("Incorrect! Your program compiles but has the incorrect output.");
		}
		else if(compiled == true && correct == true && hasIncludeKey == false){
			popupLB.setText("Incorrect! "+ hintMessage);
		}
		else{
			popupLB.setText("Incorrect! Your program does not compile.");
		}
		genericPopup();
	}
	//Write StudentCode Class based on text area input
	private void writeStudentCode() throws IOException, InterruptedException{
		try{
			//Must change this path when moving to maven
			fileWriter = new Formatter("src/main/java/edu/asu/CSE360/recitation6/group6/StudentCode.java");
			System.out.println("StudentCode class created.");
		}
		catch(Exception e){
			System.out.println("Error creating student code");
		}
		fileWriter.format("package edu.asu.CSE360.recitation6.group6;");
		fileWriter.format("\n");
		fileWriter.format("public class StudentCode{");
		fileWriter.format("\n");
		fileWriter.format(studentContent);
		fileWriter.format("\n");
		fileWriter.format("}");
		fileWriter.close();
		compileStudentCode();
	}
	//compile, run and read student code
	private void compileStudentCode() throws IOException, InterruptedException{
		//delete previous class file to prevent error
		File file = new File("target\\classes\\edu\\asu\\CSE360\\recitation6\\group6\\StudentCode.class");
		if(file.delete()){
		     System.out.println("File deleted successfully");
		}
		else{
		     System.out.println("Failed to delete the file");
		}
		Process compiler;
		//Compile Student code
		compiler = Runtime.getRuntime().exec("javac src/main/java/edu/asu/CSE360/recitation6/group6/StudentCode.java");
		compiler.waitFor();		
		//Look for created class to determine if compiled
		file = new File("src\\main\\java\\edu\\asu\\CSE360\\recitation6\\group6\\StudentCode.class");
		if(file.exists() && !file.isDirectory()) { 
			compiled = true;
		}
		else{
			compiled = false;
			System.out.println("failed to compile");
			studentOutput = "Error: Code does not compile!";
		}
		
		//Move new class from source folder to bin folder
		if(compiled == true){
			Path temp = Files.move(Paths.get("src\\main\\java\\edu\\asu\\CSE360\\recitation6\\group6\\StudentCode.class"), Paths.get("target\\classes\\edu\\asu\\CSE360\\recitation6\\group6\\StudentCode.class"));
			if(temp != null){
			 	System.out.println("File renamed and moved successfully");
			}
			else{
				System.out.println("Failed to move the file");
			}
		}
		//If the student code compiles, run it and read the output
		if(compiled == true){
			Process pb = new ProcessBuilder("java.exe","-cp","target/classes","edu.asu.CSE360.recitation6.group6.StudentCode").start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
			studentOutput = reader.readLine();
		}
		System.out.println(studentOutput);
		compiler.waitFor();
		//delete new class file
		file = new File("target\\classes\\edu\\asu\\CSE360\\recitation6\\group6\\StudentCode.class");
        if(file.delete()){
            System.out.println("File deleted successfully");
        }
        else{
            System.out.println("Failed to delete the file");
        }
		//restore defaults;
		resetStudentCode();
	}
	//reset StudentCode Class after use
	private void resetStudentCode(){
		try{
			fileWriter = new Formatter("src/main/java/edu/asu/CSE360/recitation6/group6/StudentCode.java");
			System.out.println("Default class created.");
		}
		catch(Exception e){
			System.out.println("Error creating student code");
		}
		fileWriter.format("package edu.asu.CSE360.recitation6.group6;");
		fileWriter.format("\n");
		fileWriter.format("public class StudentCode{");
		fileWriter.format("\n");
		fileWriter.format("public static void main(String[] args){");
		fileWriter.format("\n");
		fileWriter.format("System.out.println(\"Default Message\");");
		fileWriter.format("\n");
		fileWriter.format("}");
		fileWriter.format("\n");
		fileWriter.format("}");
		fileWriter.close();
	}
	//Saves results to profile
	public void updateProfile() throws IOException{
		int lineCounter = 0;
		BufferedReader file = new BufferedReader(new FileReader("src/main/resources/user_profiles/UserProfile"+userID+".txt"));
		String line;
		StringBuffer inputBuffer = new StringBuffer();
		while ((line = file.readLine()) != null) {
			lineCounter++;
			if(lineCounter == (46 + (3 * moduleNumber))){
			    line = "Yes";
			    inputBuffer.append(line);
				inputBuffer.append(System.getProperty("line.separator"));
			 }
			 else if(lineCounter == (47 + (3 * moduleNumber))){
				if(correct == true){
			    	line = "Right";
			    	inputBuffer.append(line);
			    	inputBuffer.append(System.getProperty("line.separator"));
			    }
			    else{
					line = "Wrong";
			    	inputBuffer.append(line);
			    	inputBuffer.append(System.getProperty("line.separator"));
			    }
			 }
			 else if(lineCounter == (48 + (3 * moduleNumber))){
				 	line = Double.toString(elapsedTime); //place holder, must update
			    	inputBuffer.append(line);
		    	    inputBuffer.append(System.getProperty("line.separator"));
			 }
			 else{
			    	inputBuffer.append(line);
				    inputBuffer.append(System.getProperty("line.separator"));
			 }	
		}
		String inputString = inputBuffer.toString();
		file.close();
		FileOutputStream fileOut = new FileOutputStream("src/main/resources/user_profiles/UserProfile"+userID+".txt");
		fileOut.write(inputString.getBytes());
		fileOut.close();
	}
	//Event handler
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submitButton){
				clock.stop();
				elapsedTime = timer.getElapsedSeconds();
				studentContent = textArea.getText();	
				try {
					writeStudentCode();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boxLabel.setText(studentOutput);
				repaint();
				evaluate();
				analyze();
				launchPopup();
				try {
					updateProfile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				paw.update();
				
			}
			else if(e.getSource() == runButton){
				studentContent = textArea.getText();
				try {
					writeStudentCode();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				boxLabel.setText(studentOutput);
				repaint();
			}
		}
	}
}
