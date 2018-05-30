package edu.asu.CSE360.recitation6.group6;
/*
 * Simple driver
 * Project 1
 * author: Jamison Weber
 */
import java.io.IOException;

import javax.swing.JFrame;
public class Driver {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
        frame.setSize(600,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        new FileIO().init();
        Authenticate ca = new Authenticate();
        frame.add(ca);
        frame.setVisible(true);
	}
}
