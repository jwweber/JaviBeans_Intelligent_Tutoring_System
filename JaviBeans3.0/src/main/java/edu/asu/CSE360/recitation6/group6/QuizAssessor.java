package edu.asu.CSE360.recitation6.group6;
/*
 * This class reads a file and loads quiz content into array list
 * Made minor alterations to adapt to multiple quizzes
 * Assignment Number: Recitation Project 4
 * Completion Time: 30 additional minutes
 * 
 *  @author Rozhin Azima
 * 	@version 2.0
 */
import java.io.File;
import java.util.*;
class QuizAssessor {
	private String q;
	private String opt1,opt2,opt3,opt4, rightAnswer;
	//Reads content into array list
	public static ArrayList<QuizAssessor> getList(String readFile){
		ArrayList<QuizAssessor> list = new ArrayList<>();
		try{
	     	Scanner x = new Scanner(new File(readFile));
	     	for (int j = 0; j <5 ; j++){
				String q = x.nextLine().trim();
				String o1 = x.nextLine().trim();
				String o2 = x.nextLine().trim();
				String o3 = x.nextLine().trim();
				String o4 = x.nextLine().trim();
				String rightAnswer = x.nextLine().trim();

				QuizAssessor qu = new QuizAssessor();
				
				qu.setQuestion(q, o1, o2, o3, o4, rightAnswer);
				list.add(qu);
			}
	     	x.close();
		}
		catch(Exception e){
			System.out.println("could not find the file");
			return null;
		}
		return list;
	}
	//public constructor
	public QuizAssessor(){
		q = opt1 = opt2 = opt3 = opt4 = rightAnswer= null;
	}
	//question getter
	public String getQuestion(){
		return q;
	}
	//option getter
	public String getOpt1(){
		return opt1;
	}
	//option getter
	public String getOpt2(){
		return opt2;
	}
	//option getter
	public String getOpt3(){
		return opt3;
	}
	//option getter
	public String getOpt4(){
		return opt4;
	}
	//right answer getter
	public String rightAnswer(){
		return rightAnswer;
	}
	//question setter
	public void setQuestion(String q, String opt1, String opt2, String opt3, String opt4, String rightAnswer){
		this.q = q;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.rightAnswer = rightAnswer;
	}
	//toString
	public String toString(){
		return "Question : "+q+"\nOptions:\n"+opt1+"\n"+opt2+"\n"+opt3+"\n"+opt4+"\n";
	}
}
