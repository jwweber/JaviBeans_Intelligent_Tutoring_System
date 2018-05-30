package edu.asu.CSE360.recitation6.group6;
/*
 * This class loads slide images into a navigation window from array lists.
 * Assignment Number: Recitation Project 4
 * Completion Time: 15 Hours
 * 
 *  @author Behnaz Sabbaghi
 * 	@version 2.0
 */
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.BorderLayout;
//import ImageLoadingFlashcard.ButtonListner;
public class ImageLoadingFlashcard extends JFrame {
private JLabel label1;
int totalImages;
int currentImageNum;
JButton nxtButton, prevButton,showBackButton;
ArrayList<ImageIcon> imageList;
boolean showBackClicked = false;
int slideNumber;
//public constructor
ImageLoadingFlashcard(ArrayList<ImageIcon> imageList){
	this.imageList = imageList;
	totalImages = imageList.size();
	setSize(900,900);
	// showing the first image
	label1 = new JLabel(imageList.get(0));
	currentImageNum = 0;
	//JPanel contnetPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	JPanel contnetPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	contnetPane.add(label1);
	nxtButton = new JButton("Next Slide");
	prevButton = new JButton("Previous Slide");
	showBackButton=new JButton("Show Back");
	nxtButton.addActionListener(new ButtonListner());
	prevButton.addActionListener(new ButtonListner());
	showBackButton.addActionListener(new ButtonListner());
	contnetPane.add(prevButton);
	contnetPane.add(nxtButton);
	contnetPane.add(showBackButton);
	setContentPane(contnetPane);
}
//Button Listener
private class ButtonListner implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(nxtButton)) {
				if (showBackClicked) {
					currentImageNum = (currentImageNum + 1)%totalImages;
					showBackClicked = false;
				}else {
					currentImageNum = (currentImageNum + 2)%totalImages;
				}
			}else if (e.getSource().equals(prevButton)) {
				if (showBackClicked) {
					currentImageNum = (totalImages + currentImageNum - 3)%totalImages;
					showBackClicked = false;
				}else {
					currentImageNum = (totalImages + currentImageNum - 2)%totalImages;
				}
			}else {
				showBackClicked = !showBackClicked;
				if (showBackClicked) {
					slideNumber = currentImageNum;
					currentImageNum= (totalImages+currentImageNum+1)%totalImages;
				}else {
					currentImageNum= (totalImages+currentImageNum-1)%totalImages;
				}
			}
			label1.setIcon(imageList.get(currentImageNum));
	}
}
}