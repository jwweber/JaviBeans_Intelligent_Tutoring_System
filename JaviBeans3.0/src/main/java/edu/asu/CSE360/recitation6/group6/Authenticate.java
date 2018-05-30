package edu.asu.CSE360.recitation6.group6;
/*
 * This class provides login and registration service and launches application.
 * Assignment Number: Recitation Project 3
 * Completion Time: 35 Hours
 * 
 *  @author Behnaz Sadat
 * 	@version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
/**
 * Created by behnaz on 10/11/17.
 */
public class Authenticate extends JPanel {
    //Parent panel for cardlayout
    private JPanel bigPanel = new JPanel();
    //child panel for login/register buttons and username/password fields
    private JPanel panel = new JPanel();
    private JButton loginB = new JButton("Login");
    private JButton signupB = new JButton("Register");
    private JTextField username = new JTextField(15);
    private JPasswordField password = new JPasswordField(15);
    //child panel for action message
    private JPanel panel2 = new JPanel();
    private JLabel message = new JLabel("");
    //child panel for displaying user information
    private JPanel panel3 = new JPanel();
    private JLabel numQuiz = new JLabel("Quizzes taken: ");
    private JLabel avgQuiz = new JLabel("Average quiz score: ");
    private JLabel progressPerc = new JLabel("Progress: ");
    private JLabel currSlide = new JLabel("Current slide number: ");
    private CardLayout cl = new CardLayout();
    private String mes = "";
    private int userNum = 0;
    private File profileNumber = new File("src/main/resources/user_profiles/userNum.txt");
    private Scanner p;
    private int userID;
//Public constructor
    public Authenticate() throws IOException {
        bigPanel.setLayout(cl);
        bigPanel.setPreferredSize(new Dimension(800,700));
        panel.setPreferredSize(new Dimension(800,175));
        panel2.setPreferredSize(new Dimension(800, 175));
        panel3.setPreferredSize(new Dimension(800,300));
        loginB.setBounds(70,65,150,20);
        signupB.setBounds(70,65,150,20);
        username.setBounds(50,45,35,20);
        password.setBounds(50,45,35,20);
        message.setBounds(70,90,150,20);
        message.setFont(new Font("Verdana",1,20));
        panel.add(loginB);
        panel.add(signupB);
        panel.add(username);
        panel.add(password);
        panel2.add(message);
        panel3.add(numQuiz);
        panel3.add(avgQuiz);
        panel3.add(progressPerc);
        panel3.add(currSlide);
        this.add(panel, "panel");
        this.add(panel2, "panel2");
        this.add(panel3, "panel3");
        cl.show(bigPanel, "panel");
        bigPanel.revalidate();
        //actionlistener for login button
        loginB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userNum = login();
                load(userNum);
                message.setText(mes);
                cl.show(bigPanel, "panel2");
                bigPanel.revalidate();
                try {
					Universe u = new Universe(getUserNum(), ProgramClock.getInstance());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        } );
        //actionlistener for register button
        signupB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (profileNumber.isFile()) {
                        p = new Scanner(profileNumber);
                        int number = p.nextInt();
                        mes = register(number);

                    } else {
                        mes = register(0);
                    }
                }
                catch(IOException ex) {
                    ex.printStackTrace();
                }
                message.setText(mes);
                cl.last(bigPanel);
                bigPanel.revalidate();
            }
        } );
    }
    //login method, authenticates and displays user information if login is successful
    public int login() {
        String name = "userProfile";
        String u;
        String p;
        String msg = "";
        Scanner pr;
        File profile;
        String asgmntAttempt = "";
        String progress = "";
        String slideNum = "";
        int num = 0;
        try {

            for (int m = 1; m < 6; m++) {
                name = name + m + ".txt";
                profile = new File(name);
                if (profile.isFile()) {
                    pr = new Scanner(profile);
                    pr.nextLine();
                    System.out.println(userID);
                    u = pr.nextLine();
                    p = pr.nextLine();
                    if (username.getText().equals(u) && password.getText().equals(p)) {
                        message.setText("Login Successfull!");
                        num = m;
                    }
                    else {
                        message.setText("Login Failed!");
                    }
                }
                else {
                    message.setText("User not found.");
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return num;
    }
    //loads profile from file
    public void load(int num) {
        String name = "userProfile";
        String u;
        String p;
        String msg = "";
        int quizNum = 0;
        int quizGrade = 0;
        double sum = 0;
        double quizAvg = 0.0;
        int asgmntNum = 0;
        int asgmntRes = 0;
        Scanner pr;
        File profile;
        String asgmntAttempt = "";
        String progress = "";
        String slideNum = "";
        try {
            name = name + num + ".txt";
            profile = new File(name);
            if (profile.isFile()) {
                pr = new Scanner(profile);
                pr.nextLine();
                u = pr.nextLine();
                p = pr.nextLine();
                while (pr.hasNextLine()) {
                    for (int i = 1; i <= 6; i++) {
                        if (pr.nextLine().equals("Yes")) {
                            quizNum++;
                            for (int j = 1; j <= 5; j++) {
                                if (pr.nextLine().equals("Right")) {
                                    quizGrade++;
                                }
                            }
                            sum += quizGrade;
                            quizGrade = 0;
                        }
                    }
                    for (int k = 1; k <= 6; k++) {
                        if (pr.nextLine().equals("Yes")) {
                            asgmntNum++;
                            if (pr.nextLine().equals("Right")) {
                                asgmntAttempt = pr.nextLine();
                            }
                        }
                    }
                    quizAvg = sum / quizNum;
                    progress = pr.nextLine();
                    slideNum = pr.nextLine();
                }
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        numQuiz.setText("Quizzes taken: " + quizNum);
        avgQuiz.setText("Average quiz score: " + quizAvg);
        progressPerc.setText("Progress: " + progress + "%");
        currSlide.setText("Most recent slide number: " + slideNum);
    }
    //returns current user ID
    public int getUserNum(){
    	File profileNum = new File("src/main/resources/user_profiles/userNum.txt");
    	Scanner pf;
    	int num = 0;
    	try{
    		if(profileNum.isFile()){
    			pf = new Scanner(profileNum);
    			num = pf.nextInt();
    		}
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	return num;
    }
    //register method, created a userprofile
    public String register(int profNum) {
        int num = profNum + 1;
        String fName = "src/main/resources/user_profiles/userProfile" + num + ".txt";
        String msg = "";
        File temp = new File(fName);
        File userNum = new File("src/main/resources/user_profiles/userNum.txt");
        try {
            BufferedWriter wrt = new BufferedWriter(new FileWriter(temp));
            BufferedWriter prof = new BufferedWriter(new FileWriter(userNum));
            wrt.write(num + System.getProperty("line.separator"));
            wrt.write(username.getText() + System.getProperty("line.separator"));
            wrt.write(password.getText() + System.getProperty("line.separator"));
            for (int i = 1; i <= 6; i++) {
                wrt.write("No" + System.getProperty("line.separator"));
                for (int j = 1; j <= 5; j++) {
                    wrt.write("Wrong" + System.getProperty("line.separator"));
                }
                wrt.write("0.0" + System.getProperty("line.separator"));
            }
            for (int m = 1; m <= 6; m++) {
                wrt.write("No" + System.getProperty("line.separator"));
                wrt.write("Wrong" + System.getProperty("line.separator"));
                wrt.write("0.0" + System.getProperty("line.separator"));
            }
            prof.write(num + System.getProperty("line.separator"));
            wrt.close();
            prof.close();

            msg = "Registration Successful! Welcome to JaviBeans";
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
