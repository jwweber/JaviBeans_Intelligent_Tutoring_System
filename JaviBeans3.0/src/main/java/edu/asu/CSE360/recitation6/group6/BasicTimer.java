package edu.asu.CSE360.recitation6.group6;
/*
 * This class is a multipurpose timer.
 * Assignment Number: Recitation Project 4
 * Completion Time: 30 Minutes * 
 *  @author Jamison Weber 
 * 	@version 1.0
 */
public class BasicTimer implements Runnable{
	private double secondsElapsed;
	//public constructor
	public BasicTimer(){
		System.out.println("Clock started");
		secondsElapsed = 0.0;
	}
	@Override
	public void run() {
		while(true){
			secondsElapsed++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//seconds getter
	public double getElapsedSeconds(){
		return secondsElapsed;
	}
}