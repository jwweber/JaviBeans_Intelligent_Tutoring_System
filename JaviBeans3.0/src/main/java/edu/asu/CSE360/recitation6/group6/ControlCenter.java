package edu.asu.CSE360.recitation6.group6;
/*
 * This class provides the decision making scheme for the state of the companion face.
 * Singleton pattern implementation
 * Assignment Number: Recitation Project 4
 * Formerly called CompanionIntelligence
 * Completion Time: 6 additional hours
 * 
 *  @author Jamison Weber
 * 	@version 2.0
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ControlCenter{
	private static ControlCenter instance;
	private int decisionState;
	private boolean[] completedQuizzes;
	private boolean[] assignmentResults;
	private boolean[][] quizResults;
	private boolean[] completedAssignments;
	private double[] elapsedTimeQuizzes;
	private double[] elapsedTimeAssignments;
	private BufferedReader br;
	private String path = "src/main/resources/user_profiles/UserProfile";
	private String line;
	private int userID;
	private String userName;
	private boolean guided;
	//private constructor
	private ControlCenter() throws FileNotFoundException{
		decisionState = 1;
		completedQuizzes = new boolean[6];
		assignmentResults = new boolean[6];
		quizResults = new boolean[6][5];
		completedAssignments = new boolean[6];
		elapsedTimeQuizzes = new double[6];
		elapsedTimeAssignments = new double[6];
		guided = false;
	}
	//Singleton required method
	public static ControlCenter getInstance() throws FileNotFoundException{
		if(instance == null){
			instance = new ControlCenter();
		}
		return instance;
	}
	//Reads saved data from user profile
	public void read() throws IOException{
		br = new BufferedReader(new FileReader(path+userID+".txt"));
		line = br.readLine();
		userID = Integer.parseInt(line);
		line = br.readLine();
		userName = line;
		line = br.readLine();
		for(int i = 0; i < 6; i++){
			line = br.readLine();
			if(line.equals("Yes")){
				completedQuizzes[i] = true;
			}
			else if(line.equals("No")){
				completedQuizzes[i] = false;
			}
			for(int j = 0; j <5; j++){
				line = br.readLine();
				if(line.equals("Right")){
					quizResults[i][j] = true;
				}
				else{
					quizResults[i][j] = false;
				}
			}
			line = br.readLine();
			elapsedTimeQuizzes[i] = Double.parseDouble(line);
		}
		for(int k = 0; k < 6; k++){
			line = br.readLine();
			if(line.equals("Yes")){
				completedAssignments[k] = true;
			}
			else{
				completedAssignments[k] = false;
			}
			line = br.readLine();
			if(line.equals("Right")){
				assignmentResults[k] = true;
			}
			else{
				assignmentResults[k] = false;
			}
			line = br.readLine();
			elapsedTimeAssignments[k] = Double.parseDouble(line);
		}
		br.close();
	}
	//ID setter
	public void setUserID(int ID){
		this.userID = ID;
	}
	//username getter
	public String getUserName(){
		return userName;
	}
	//completed quizzes getter
	public double getNumberCompletedQuizzes(){
		return countArray(completedQuizzes);
	}
	//completed assignments getter
	public double getNumberCompletedAssignments(){
		return countArray(completedAssignments);
	}
	//guided setter
	public void setGuided(boolean b){
		guided = b;
		System.out.println(guided);
	}
	//guider getter
	public boolean getGuided(){
		return guided;
	}
	//Display data read from user Profile
	public void dumpData() throws IOException{
		read();
		for(int i = 0; i < 6; i++){
			System.out.println(completedQuizzes[i]);
			for(int j = 0; j <5; j++){
				System.out.println(quizResults[i][j]);
			}
		}
		for(int k = 0; k < 6; k++){
			System.out.println(completedAssignments[k]);
			System.out.println(assignmentResults[k]); 
		}
	}
	//High level decision logic for companion face state. Complexity level 10.
	public void react(){
		if(quizProgress().equals("Good") && assignmentProgress().equals("Good")){
			decisionState = 1;
		}else if(quizProgress().equals("Good") && assignmentProgress().equals("Bad")){
			decisionState = 1;
		}else if(quizProgress().equals("Bad") && assignmentProgress().equals("Good")){
			decisionState = 1;
		}else if(quizProgress().equals("Good") && assignmentProgress().equals("Terrible")){
			decisionState = 4;
		}else if(quizProgress().equals("Terrible") && assignmentProgress().equals("Good")){
			decisionState = 4;
		}else if(quizProgress().equals("Bad") && assignmentProgress().equals("Bad")){
			decisionState = 4;
		}else if(quizProgress().equals("Bad") && assignmentProgress().equals("Terrible")){
			decisionState = 3;
		}else if(quizProgress().equals("Terrible") && assignmentProgress().equals("Bad")){
			decisionState = 3;
		}else if(quizProgress().equals("Terrible") && assignmentProgress().equals("Terrible")){
			decisionState = 3;
		}
	}
	//Determines progress quality of users quiz history based on correct answers and time spent.
	private String quizProgress(){
		String progress = "Good";
		double averageQuizTime = averageQuizTime();
		double numberQuizzesCompleted = countArray(completedQuizzes);
		double totalPointsEarned = (scoreQuiz(0,quizResults) + scoreQuiz(1,quizResults) 
										+ scoreQuiz(2,quizResults) + scoreQuiz(3,quizResults) 
										+ scoreQuiz(4,quizResults) + scoreQuiz(5,quizResults));
		double ratio = totalPointsEarned / (6 * numberQuizzesCompleted);
		if((4.0/6.0) < ratio && averageQuizTime <= 300){
			progress = "Good";
		}
		else if((2.0/6.0) < ratio && averageQuizTime <= 420){
			progress = "Bad";
		}
		else if(ratio > 0.0){
			progress = "Terrible";
		}
		return progress;
	}
	//quantifies quiz results
	private double scoreQuiz(int quizNumber, boolean[][] arr){
		double count = 0;
		for(int i = 0; i < 5;i++){
			if(arr[quizNumber][i]){
				count++;
			}
		}
		return count;
	}
	//Calculates average time spent on quizzes based on number of quizzes taken
	private double averageQuizTime(){
		double averageQuizTime = 0.0;
		double numberCompletedQuizzes = countArray(completedQuizzes);
		switch((int)numberCompletedQuizzes){
			case 1: averageQuizTime = (elapsedTimeQuizzes[0]+elapsedTimeQuizzes[1]+elapsedTimeQuizzes[2]+
				elapsedTimeQuizzes[3]+elapsedTimeQuizzes[4]+elapsedTimeQuizzes[5])/1;
				break;
			case 2: averageQuizTime = (elapsedTimeQuizzes[0]+elapsedTimeQuizzes[1]+elapsedTimeQuizzes[2]+
					elapsedTimeQuizzes[3]+elapsedTimeQuizzes[4]+elapsedTimeQuizzes[5])/2;
				break;
			case 3: averageQuizTime = (elapsedTimeQuizzes[0]+elapsedTimeQuizzes[1]+elapsedTimeQuizzes[2]+
					elapsedTimeQuizzes[3]+elapsedTimeQuizzes[4]+elapsedTimeQuizzes[5])/3;
				break;
			case 4: averageQuizTime = (elapsedTimeQuizzes[0]+elapsedTimeQuizzes[1]+elapsedTimeQuizzes[2]+
					elapsedTimeQuizzes[3]+elapsedTimeQuizzes[4]+elapsedTimeQuizzes[5])/4;
				break;
			case 5: averageQuizTime = (elapsedTimeQuizzes[0]+elapsedTimeQuizzes[1]+elapsedTimeQuizzes[2]+
					elapsedTimeQuizzes[3]+elapsedTimeQuizzes[4]+elapsedTimeQuizzes[5])/5;
				break;
			case 6: averageQuizTime = (elapsedTimeQuizzes[0]+elapsedTimeQuizzes[1]+elapsedTimeQuizzes[2]+
					elapsedTimeQuizzes[3]+elapsedTimeQuizzes[4]+elapsedTimeQuizzes[5])/6;
					break;
			default: averageQuizTime = 0.0;
				break;
		}
		return averageQuizTime;
	}
	//Calculates average time spent on assignments based on number of assignments completed.
	private double averageAssignmentTime(){
		double averageAssignmentTime = 0.0;
		double numberCompletedAssignments = countArray(completedAssignments);
		switch((int)numberCompletedAssignments){
			case 1: averageAssignmentTime = (elapsedTimeAssignments[0]+elapsedTimeAssignments[1]+elapsedTimeAssignments[2]+
					elapsedTimeAssignments[3]+elapsedTimeAssignments[4]+elapsedTimeAssignments[5])/1;
				break;
			case 2: averageAssignmentTime = (elapsedTimeAssignments[0]+elapsedTimeAssignments[1]+elapsedTimeAssignments[2]+
					elapsedTimeAssignments[3]+elapsedTimeAssignments[4]+elapsedTimeAssignments[5])/2;
				break;
			case 3: averageAssignmentTime = (elapsedTimeAssignments[0]+elapsedTimeAssignments[1]+elapsedTimeAssignments[2]+
					elapsedTimeAssignments[3]+elapsedTimeAssignments[4]+elapsedTimeAssignments[5])/3;
				break;
			case 4: averageAssignmentTime = (elapsedTimeAssignments[0]+elapsedTimeAssignments[1]+elapsedTimeAssignments[2]+
					elapsedTimeAssignments[3]+elapsedTimeAssignments[4]+elapsedTimeAssignments[5])/4;
				break;
			case 5: averageAssignmentTime = (elapsedTimeAssignments[0]+elapsedTimeAssignments[1]+elapsedTimeAssignments[2]+
					elapsedTimeAssignments[3]+elapsedTimeAssignments[4]+elapsedTimeAssignments[5])/5;
				break;
			case 6: averageAssignmentTime = (elapsedTimeAssignments[0]+elapsedTimeAssignments[1]+elapsedTimeAssignments[2]+
					elapsedTimeAssignments[3]+elapsedTimeAssignments[4]+elapsedTimeAssignments[5])/6;
					break;
			default: averageAssignmentTime = 0.0;
				break;
		}
		return averageAssignmentTime;
	}
	//Determines progress quality of assignment history based on correct responses and time spent.
	private String assignmentProgress(){
		double numberAssignmentsCompleted = countArray(completedAssignments);
		double numberCorrectAssignmentResults = countArray(assignmentResults);
		double averageAssignmentTime = averageAssignmentTime();
		double ratio = numberCorrectAssignmentResults / numberAssignmentsCompleted;
		String progress = "Good";
		if((4.0/6.0) < ratio && ratio <= 1 && averageAssignmentTime <= 300){
			progress = "Good";
		}
		else if((2.0/6.0) < ratio && averageAssignmentTime <= 420){
			progress = "Bad";
		}
		else if(ratio >= 0.0){
			progress = "Terrible";
		}
		return progress;
	}
	//Counts number of true entries in bool array
	private double countArray(boolean[] arr){
		double count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i]){
				count++;
			}
		}
		return count;
	}
	//Updates companion state
	public void updateAll() throws IOException{
		read();
		react();
	}
	//Returns decision state
	public int getDecisionState() throws IOException{
		updateAll();
		return decisionState;
	}
}