package edu.asu.CSE360.recitation6.group6;
/*
 * This class creates a frame to hold the certificate image
 * Assignment Number: Recitation Project 4
 * Completion Time: 3 Hours
 * 
 *  @author Rozhin Azima
 * 	@version 2.0
 */
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Certificate extends JFrame{
		private ImageIcon img;
		private JLabel lab;
		private JPanel pan;
		//pubic constructor
		public Certificate(){
			this.pack();
			this.setLocation(400,130);
			this.setSize(1250,730);
	        this.setResizable(false);
			img = new ImageIcon("src/main/resources/Certificate.jpg");
			lab =  new JLabel("",img,JLabel.CENTER);
			pan = new JPanel(new BorderLayout());
			pan.add(lab,BorderLayout.CENTER);
			this.setContentPane(pan);
			this.setVisible(true);
		}
}