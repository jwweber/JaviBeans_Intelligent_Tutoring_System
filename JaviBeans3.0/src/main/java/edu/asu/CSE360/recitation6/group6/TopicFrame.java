package edu.asu.CSE360.recitation6.group6;
/*
 * This class loads slide images from a folder into array lists and organizes the data.
 * Added functionality to view helpful web sites to slide panels
 * Assignment Number: Recitation Project 4
 * Completion Time: 5 additional Hours
 * 
 *  @author Behnaz Sabbaghi
 * 	@version 2.0
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class TopicFrame extends JPanel {
	private JPanel contentPane;
	private JButton introB;
	private JButton varB;
	private JButton stringB;
	private JButton loopB;
	private JButton controlB;
	private JButton arrayB;
	private JLabel slidesLabel;
	private JPanel empty;
	ArrayList<ImageIcon> introImages;
	ArrayList<ImageIcon> varImages;
	ArrayList<ImageIcon> stringImages;
	ArrayList<ImageIcon> loopImages;
	ArrayList<ImageIcon> controlImages;
	ArrayList<ImageIcon> arrayImages;
	final int TotalIntroImages = 9;
	final int TotalVarImages = 4;
	final int TotalStringImages = 6;
	final int TotalLoopImages = 7;
	final int TotalControlImages = 8;
	final int TotalArrayImages = 6;
	final int numberOfTopics = 6;
	String [] Urls;
	ImageLoading slideViewer;
	/**
	 * Create the frame.
	 */
	public TopicFrame() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4,	 2));
		slidesLabel = new JLabel("Instructional Slides:");
		slidesLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(slidesLabel);
		empty = new JPanel();
		empty.setPreferredSize(new Dimension(200,100));
		contentPane.add(empty);
		introB = new JButton("Introduction");
		introB.addActionListener(new ButtonListener());
		contentPane.add(introB);
		introB.setPreferredSize(new Dimension(200,100));
		varB = new JButton("Variables");
		varB.addActionListener(new ButtonListener());
		contentPane.add(varB);
		stringB = new JButton("Strings");
		stringB.addActionListener(new ButtonListener());
		contentPane.add(stringB);
		loopB = new JButton("Loops");
		loopB.addActionListener(new ButtonListener());
		contentPane.add(loopB);
		controlB = new JButton("Control Statement");
		controlB.addActionListener(new ButtonListener());
		contentPane.add(controlB);
		arrayB = new JButton("Arrays");
		arrayB.addActionListener(new ButtonListener());
		contentPane.add(arrayB);
		this.add(contentPane);
		loadImagesAndUrls();
	}
	//Loads image files and URLs
	private void loadImagesAndUrls() {
		Urls = new String [numberOfTopics];
		Urls [0] ="https://docs.oracle.com/javase/tutorial/";
		Urls [1] ="https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html";
		Urls [2] ="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html";
		Urls [3] ="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html";
		Urls [4] ="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html";
		Urls [5] ="https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html";
		ImageIcon tempIcon;
		int imageNum;
		Image scaledImage;
		String prePath = "src/main/resources/Introduction/Slide";
		String postPath =".JPG";
		introImages = new ArrayList<ImageIcon>();
		varImages = new ArrayList<ImageIcon>();
		stringImages = new ArrayList<ImageIcon>();
		loopImages = new ArrayList<ImageIcon>();
		controlImages = new ArrayList<ImageIcon>();
		arrayImages = new ArrayList<ImageIcon>();
		for (int i = 0; i < TotalIntroImages; i++) {
			imageNum = i + 1;
			tempIcon = new ImageIcon(prePath + imageNum + postPath);
			
			scaledImage =  tempIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
			introImages.add(new ImageIcon(scaledImage));
		}
		prePath = "src/main/resources/Variables/Slide";
		for (int i = 0; i < TotalVarImages; i++) {
			imageNum = i + 1;
			tempIcon = new ImageIcon(prePath + imageNum + postPath);			
			scaledImage =  tempIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);	
			tempIcon = new ImageIcon(scaledImage);
			varImages.add(tempIcon);
		}
		prePath = "src/main/resources/Strings/Slide";
		for (int i = 0; i < TotalStringImages; i++) {
			imageNum = i + 1;
			tempIcon = new ImageIcon(prePath + imageNum + postPath);
			
			scaledImage =  tempIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
			stringImages.add(new ImageIcon(scaledImage));
		}
		
		prePath = "src/main/resources/loops/Slide";
		for (int i = 0; i < TotalLoopImages; i++) {
			imageNum = i + 1;
			tempIcon = new ImageIcon(prePath + imageNum + postPath);
			
			scaledImage =  tempIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
			loopImages.add(new ImageIcon(scaledImage));
		}
		prePath = "src/main/resources/Control-Statement/Slide";
		for (int i = 0; i < TotalControlImages; i++) {
			imageNum = i + 1;
			tempIcon = new ImageIcon(prePath + imageNum + postPath);
			
			scaledImage =  tempIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
			controlImages.add(new ImageIcon(scaledImage));
		}
		
		prePath = "src/main/resources/arrays/Slide";
		for (int i = 0; i < TotalArrayImages; i++) {
			imageNum = i + 1;
			tempIcon = new ImageIcon(prePath + imageNum + postPath);
			
			scaledImage =  tempIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
			arrayImages.add(new ImageIcon(scaledImage));
		}
	}
	//Listener
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton clickedButton = (JButton)e.getSource();
			if (clickedButton.equals(introB)) {
				slideViewer = new ImageLoading(introImages, Urls[0]);
			}else if (clickedButton.equals(varB)) {
				slideViewer = new ImageLoading(varImages,Urls[1]);
			}else if (clickedButton.equals(stringB)) {
				slideViewer = new ImageLoading(stringImages,Urls[2]);
			}else if (clickedButton.equals(loopB)) {
				slideViewer = new ImageLoading(loopImages,Urls[3]);
			}else if (clickedButton.equals(controlB)) {
				
				slideViewer = new ImageLoading(controlImages,Urls[4]);
			}else if (clickedButton.equals(arrayB)) {
				slideViewer = new ImageLoading(arrayImages,Urls[5]);
			}
			slideViewer.setTitle("SlideViewer");
			slideViewer.setVisible(true);
		}
	}
}
