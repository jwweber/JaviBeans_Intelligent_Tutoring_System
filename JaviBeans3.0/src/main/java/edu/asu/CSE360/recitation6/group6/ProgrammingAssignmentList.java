package edu.asu.CSE360.recitation6.group6;
/*
 * This class reads the data relating to assignment content from a file and loads it into a linked list.
 * Assignment Number: Recitation Project 3
 * Completion Time: 1 Hour
 * 
 *  @author Jamison Weber
 * 	@version 1.0
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ProgrammingAssignmentList extends LinkedList<String>{
	private BufferedReader br;
	private String line;
	//public constructor
	public ProgrammingAssignmentList() throws IOException{
		readFile();
	}
	//Reads and writes data from file linked list
	private void readFile() throws IOException{
		br = new BufferedReader(new FileReader("src/main/resources/programming_assignment_key.txt"));
		while((line = br.readLine()) != null){
			this.add(line);
		}
		br.close();
	}
}
