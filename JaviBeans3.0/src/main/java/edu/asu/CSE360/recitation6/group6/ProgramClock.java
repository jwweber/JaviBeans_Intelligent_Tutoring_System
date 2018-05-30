package edu.asu.CSE360.recitation6.group6;
/*
 * Singleton clock that counts elapsed seconds for application after launch
 * Assignment Number: Recitation Project 4
 * Completion Time: 2 Hours
 * 
 *  @author Jamison Weber
 * 	@version 1.0
 */
import java.util.Observable;
//Public constructor
public class ProgramClock extends Observable implements Runnable{
	private static int secondsElapsed;
	private static ProgramClock instance;
	private ProgramClock(){
		System.out.println("Clock started");
		secondsElapsed = 0;
	}
	//run method for multithreaded
	@Override
	public void run() {
		while(true){
			secondsElapsed++;
			setChanged();
			notifyObservers();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Required method for singleton pattern
	public static ProgramClock getInstance(){
		if(instance == null){
			instance = new ProgramClock();
		}
		return instance;
	}
	//getter for elapsed time
	public static int getElapsedSeconds(){
		return secondsElapsed;
	}
}
