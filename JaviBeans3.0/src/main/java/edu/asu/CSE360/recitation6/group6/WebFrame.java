package edu.asu.CSE360.recitation6.group6;
/*
 * This class loads helpful websites into a JFrame
 * Assignment Number: Recitation Project 4
 * Completion Time: 3 Hours
 * 
 *  @author Behnaz Sabbaghi
 * 	@version 1.0
 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class WebFrame extends JFrame{
	private JEditorPane ep1;
	//public constructor
	public WebFrame(String url) throws IOException{
		JPanel contnetPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		ScrollPane scrollingPane = new ScrollPane();
		ep1 = new JEditorPane();
		ep1.setPage(url);
		ep1.setEditable(false);
		ep1.setVisible(true);
		scrollingPane.add(ep1);
		setContentPane(scrollingPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
}