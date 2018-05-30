package edu.asu.CSE360.recitation6.group6;
/*
 * This class loads slide images into a navigation window from array lists.
 * Assignment Number: Recitation Project 4
 * Completion Time: 2 additional Hours
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
//Public constructor
    public class ImageLoading extends JFrame {
		private JLabel label1;
		int totalImages;
		int currentImageNum;
		JButton nxtButton, prevButton;
		ArrayList<ImageIcon> imageList;
		private JButton ShowWebButton;
		String Url;
		WebFrame webShower;
		ImageLoading(ArrayList<ImageIcon> imageList, String Url){
			this.imageList = imageList;
			this.Url = Url;
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
			ShowWebButton = new JButton("Show Websites");
			nxtButton.addActionListener(new ButtonListner());
			prevButton.addActionListener(new ButtonListner());
			ShowWebButton.addActionListener(new ButtonListner());
			contnetPane.add(prevButton);
			contnetPane.add(nxtButton);
			contnetPane.add(ShowWebButton);
			setContentPane(contnetPane);	
		}	
		private class ButtonListner implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(nxtButton)) {
						currentImageNum = (currentImageNum + 1)%totalImages;
					}else if (e.getSource().equals(prevButton)) {
						currentImageNum = (totalImages + currentImageNum - 1)%totalImages;
					}else {
						try {
							webShower = new WebFrame(Url);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						webShower.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						webShower.setTitle("Website");
						webShower.setVisible(true);
					}
					label1.setIcon(imageList.get(currentImageNum));
			}
		}
	}