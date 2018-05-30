package edu.asu.CSE360.recitation6.group6;
/*
 * This class writes results to text file.
 * updated for multiple quizzes
 * Assignment Number: Recitation Project 4
 * Completion Time: 2 additional Hours
 * 
 *  @author Rozhin Azima
 * 	@version 2.0
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {
	private BufferedWriter bw;
	private BufferedReader br;
	private File file;
	private File dumpFile;
	private double elapsedTime;
	private String directory;
	private int userID;
	private int moduleNumber;
	private String[] names = {"src/main/resources/Quiz1.txt","src/main/resources/Quiz2.txt","src/main/resources/Quiz3.txt","src/main/resources/Quiz4.txt","src/main/resources/Quiz5.txt","src/main/resources/Quiz6.txt"};
	public void writeToFile(int score, String writeFile, boolean[] results, double elapsedTime, int userID, int moduleNumber ){
		this.elapsedTime = elapsedTime;
		this.userID = userID;
		this.moduleNumber = moduleNumber;
		try{
			dumpFile = new File("src/main/resources/scoreCard.txt");
			file = new File(writeFile);
			bw = new BufferedWriter(new PrintWriter(file));
			bw.write("Yes\r\n");
			for(int i=0;i<5;i++){
				if(results[i]){
					bw.write("Right\r\n");
				}
				else{
					bw.write("Wrong\r\n");
				}
			}
			bw.write(elapsedTime+"\r\n");
			bw.close();
			String dumpString = "";
			for(String s : names){
				file = new File(s);
				br = new BufferedReader(new FileReader(file));
				String sa = "";
				while((sa = br.readLine()) != null)
					dumpString = dumpString + sa+"\r\n";
				dumpString += "\r\n";
			}
			bw = new BufferedWriter(new PrintWriter(dumpFile));
			bw.write(dumpString);
			bw.close();
			
			BufferedReader file = new BufferedReader(new FileReader("src/main/resources/user_profiles/UserProfile"+userID+".txt"));
			String line;
			int lineCounter = 0;
			StringBuffer inputBuffer = new StringBuffer();
			moduleNumber--;
			while ((line = file.readLine()) != null) {
				lineCounter++;
				if(lineCounter == (4 + (7 * moduleNumber))){
				    line = "Yes";
				    inputBuffer.append(line);
					inputBuffer.append(System.getProperty("line.separator"));
				 }
				 else if(lineCounter == (5 + (7 * moduleNumber))){
					if(results[0]){
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
				 else if(lineCounter == (6 + (7 * moduleNumber))){
					if(results[1]){
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
				 else if(lineCounter == (7 + (7 * moduleNumber))){
						if(results[2]){
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
				 else if(lineCounter == (8 + (7 * moduleNumber))){
						if(results[3]){
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
				 else if(lineCounter == (9 + (7 * moduleNumber))){
						if(results[4]){
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
				 else if(lineCounter == (10 + (7 * moduleNumber))){
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
			//write to user profile
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public void init(){
		for(String s: names){
			try{
				file = new File(s);
				br = new BufferedReader(new FileReader(file));
				
			}
			catch(FileNotFoundException fnfe){
				try{
					bw = new BufferedWriter(new PrintWriter(file));
					bw.write("Score IS : NULL\r\n");
					bw.write(s.substring(0,s.indexOf('.'))+" No\r\n");
					for(int i=0;i<5;i++){
						bw.write("Wrong\r\n");
					}
					bw.close();
					//fnfe.printStackTrace();
				}catch(FileNotFoundException e){
					System.out.println(e.getLocalizedMessage());
					e.printStackTrace();
				}
				catch(IOException io){
					System.out.println(io.getMessage());
					io.printStackTrace();
				}
			}
		}
	}
}

