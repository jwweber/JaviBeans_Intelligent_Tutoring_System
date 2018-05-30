# JaviBeans_Intelligent_Tutoring_System
-To run this application, simply select the class called driver and click Run.
-A login window will appear. To create a new profile, enter a name and password and click register, followed by log in.
-If you do not wish to create a profile, enter "user" and "password" in the respective fields for a default account.
-The slider will allow you to navigate the application.

-Example programming assignment:
For assignment 1 (Introduction) write in text area:
public static void main(String[] args){
System.out.println("Hello World!");
}
and click submit or run.
-The system will write it to a class file, compile it, run it, and read the outputstream and match it to a key.

Additional Features for Project 4:
-The main user interface has had a massive overhaul
-The companion now speaks to the user via the text field on the left
-Companion speech is triggered by time. It follows the decorator pattern
-The motivational companion will recommend a break every 10 minutes.
-After 30 minutes, the motivational companion becomes the troll companion and taunts the user.(Can be adjusted or deleted)
-User may toggle guided companion. This follows the decorator pattern.
-When guided companion enabled, it will provide the user hints when the user clicks the next button on quizzes.
-If answers are correct, it will indicate so in the companion text panel.
-The control center now accounts for elapsed time. If you take longer than 5 minutes on a quiz or assignment, it will affect your standing.
-the control center is fully functional/will alter standing and face based on performance
-A total of 6 quizzes are now present and they save data to the user profile properly now.
-The content slides now contain buttons that will open helpful websites in a frame.
-Flash cards have been added to assist in studying.
-The user may view his/her progress via a panel containing progress bars.
-If all six quizzes and all six assignments have been completed, and the student is in good standing(happy face), the next time the progress panel
is accessed, it will display a certificate of completion in a frame.
-Universe and program clock follow the observer pattern
-Control Center, Companion Message Panel and Program Clock follow the singleton pattern.