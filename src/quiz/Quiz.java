package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class Quiz extends JFrame implements ActionListener {

	private String[][] questions = new String[20][5]; // Example initialization
	private String[][] useranswers = new String[20][1];
	private String[][] answers = new String[20][2];

    
    JLabel question, qno;
    JRadioButton opt1, opt2, opt3, opt4; 
    JButton next, lifeline, submit;
    ButtonGroup group;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0; 
    public static int score = 0;
    
    public static int attemptedQuestions = 0;
    public static int correctAnswers = 0;
    public static int unattemptedQuestions = 20;  // Since there are 20 questions initially

    
    String name;

    // Constructor
    Quiz(String name) {
        this.name = name;

        getContentPane().setBackground(Color.WHITE);
        setBounds(200, 50, 1200, 750);
        setResizable(false);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1200, 300);
        add(image);
        setVisible(true);

        qno = new JLabel();
        qno.setBounds(100, 370, 50, 30);
        qno.setFont(new Font("Times new Roman", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 370, 900, 30);
        question.setFont(new Font("Times new Roman", Font.PLAIN, 24));
        add(question);

        // Question 1
        		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        		questions[0][1] = "JVM";
        		questions[0][2] = "JDB";
        		questions[0][3] = "JDK";
        		questions[0][4] = "JRE";
        
        		  
        		  questions[1][0] ="What is the return type of the hashCode() method in the Object class?";
        		  questions[1][1] = "int"; 
        		  questions[1][2] = "Object";
        		  questions[1][3] ="long"; 
        		  questions[1][4] = "void";
        		 
        		  questions[2][0] = "Which package contains the Random class?"; 
        		  questions[2][1] = "java.util package"; 
        		  questions[2][2] = "java.lang package"; 
        		  questions[2][3] = "java.awt package"; 
        		  questions[2][4] = "java.io package";
        		 
        		  questions[3][0] = "An interface with no fields or methods is known as?";
        		  questions[3][1] = "Runnable Interface";
        		  questions[3][2] ="Abstract Interface"; 
        		  questions[3][3] = "Marker Interface";
        		  questions[3][4] ="CharSequence Interface";
        		  
        		  questions[4][0] = "In which memory a String is stored, when we create a string using new operator?" ;
        		  questions[4][1] = "Stack"; 
        		  questions[4][2] = "String memory";
        		  questions[4][3] = "Random storage space"; 
        		  questions[4][4] = "Heap memory";
        		  
        		  questions[5][0] = "Which of the following is a marker interface?";
        		  questions[5][1] = "Runnable interface"; 
        		  questions[5][2] = "Remote interface";
        		  questions[5][3] = "Readable interface"; 
        		  questions[5][4] = "Result interface";
        		  
        		  questions[6][0] = "Which keyword is used for accessing the features of a package?";
        		  questions[6][1] = "import"; 
        		  questions[6][2] = "package"; 
        		  questions[6][3] ="extends";
        		  questions[6][4] = "export";
        		  
        		  questions[7][0] = "In java, jar stands for?"; 
        		  questions[7][1] ="Java Archive Runner";
        		  questions[7][2] = "Java Archive"; 
        		  questions[7][3] = "Java Application Resource"; 
        		  questions[7][4] = "Java Application Runner";
        		  
        		  questions[8][0] = "Which of the following is a mutable class in java?";
        		  questions[8][1] = "java.lang.StringBuilder"; 
        		  questions[8][2] = "java.lang.Short"; 
        		  questions[8][3] = "java.lang.Byte"; 
        		  questions[8][4] = "java.lang.String";
        		  
        		  
        		  questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        		  questions[9][1] = "Bytecode is executed by JVM"; 
        		  questions[9][2] ="The applet makes the Java code secure and portable"; 
        		  questions[9][3] ="Use of exception handling"; 
        		  questions[9][4] = "Dynamic binding between objects";
        		  	
        		  questions[10][0] = "Which of these is a valid declaration of a String?";
        	        questions[10][1] = "String s = 'Hello';";
        	        questions[10][2] = "String s = new String('Hello');";
        	        questions[10][3] = "String s = new String(\"Hello\");";
        	        questions[10][4] = "String s = Hello;";
        	        
        	        questions[11][0] = "Which of the following is the super class of all the classes in Java?";
        	        questions[11][1] = "Object";
        	        questions[11][2] = "String";
        	        questions[11][3] = "Class";
        	        questions[11][4] = "Serializable";
        	        
        	        questions[12][0] = "Which method is used to start a thread in Java?";
        	        questions[12][1] = "run()";
        	        questions[12][2] = "start()";
        	        questions[12][3] = "begin()";
        	        questions[12][4] = "init()";
        	        
        	        questions[13][0] = "What does JVM stand for?";
        	        questions[13][1] = "Java Virtual Machine";
        	        questions[13][2] = "Java Variable Machine";
        	        questions[13][3] = "Java Verified Machine";
        	        questions[13][4] = "Java Virtual Mode";
        	        
        	        questions[14][0] = "Which keyword is used to prevent the method from being overridden in Java?";
        	        questions[14][1] = "static";
        	        questions[14][2] = "final";
        	        questions[14][3] = "abstract";
        	        questions[14][4] = "private";

        	        questions[15][0] = "Which method is used to stop a thread in Java?";
        	        questions[15][1] = "stop()";
        	        questions[15][2] = "halt()";
        	        questions[15][3] = "terminate()";
        	        questions[15][4] = "suspend()";

        	        questions[16][0] = "Which of the following is used to create a thread in Java?";
        	        questions[16][1] = "Thread class";
        	        questions[16][2] = "Runnable interface";
        	        questions[16][3] = "Thread and Runnable interface";
        	        questions[16][4] = "None of the above";

        	        questions[17][0] = "Which keyword is used to define a constant in Java?";
        	        questions[17][1] = "final";
        	        questions[17][2] = "const";
        	        questions[17][3] = "constant";
        	        questions[17][4] = "static";

        	        questions[18][0] = "Which of the following is not a valid keyword in Java?";
        	        questions[18][1] = "interface";
        	        questions[18][2] = "extends";
        	        questions[18][3] = "super";
        	        questions[18][4] = "interfacee";

        	        questions[19][0] = "Which of these is not a primitive data type in Java?";
        	        questions[19][1] = "int";
        	        questions[19][2] = "boolean";
        	        questions[19][3] = "String";
        	        questions[19][4] = "char";


        	       
        	   // Correct answers
        		 answers[0][1] = "JDB"; 
        		 answers[1][1] = "int"; 
        		 answers[2][1] ="java.util package"; 
        		 answers[3][1] = "Marker Interface"; 
        		 answers[4][1] ="Heap memory"; 
        		 answers[5][1] = "Remote interface"; 
        		 answers[6][1] = "import";
        		 answers[7][1] = "Java Archive"; 
        		 answers[8][1] = "java.lang.StringBuilder";
        		 answers[9][1] = "Bytecode is executed by JVM";
        		 answers[10][1] = "String s = new String(\"Hello\");";
        	     answers[11][1] = "Object";
        	     answers[12][1] = "start()";
        	     answers[13][1] = "Java Virtual Machine";
        	     answers[14][1] = "final";
        	     answers[15][1] = "stop()"; 
     	        answers[16][1] = "Thread and Runnable interface";
     	        answers[17][1] = "final";
     	        answers[18][1] = "interfacee";  // Incorrect keyword as the answer
     	        answers[19][1] = "String";  // String is a reference type, not a primitive

        	     
        	     
        	     
        	     
        	     
        	     
        	     
        	     
        	     

        opt1 = new JRadioButton();
        opt1.setBackground(Color.WHITE);
        opt1.setBounds(170, 430, 700, 30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBackground(Color.WHITE);
        opt2.setBounds(170, 470, 700, 30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBackground(Color.WHITE);
        opt3.setBounds(170, 510, 700, 30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBackground(Color.WHITE);
        opt4.setBounds(170, 550, 700, 30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        
        
        
        //  BUTTONS 
        
        
        next = new JButton("Next");
        next.setBounds(960, 450, 200, 40);
        next.setBackground(new Color(30, 144, 254));
        next.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(next);
        next.addActionListener(this);
        next.setForeground(Color.WHITE);

		
		  lifeline = new JButton("50-50 lifeline");
		  lifeline.setBounds(960, 510, 200,40); 
		  lifeline.setBackground(new Color(30, 144, 254)); 
		  lifeline.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		  add(lifeline);
		  lifeline.addActionListener(this); 
		  lifeline.setForeground(Color.WHITE);
		 

        submit = new JButton("submit");
        submit.setBounds(960, 570, 200, 40);
        submit.setBackground(new Color(30, 144, 254));
        submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);
        submit.setEnabled(false);

        start(count);
    }

    // Timer and paint method

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left = " + timer + " seconds";

        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        // Show the timer on the screen 
        if (timer > 0) {
            g.drawString(time, 880, 400);
        } else {
            g.drawString("Time's up!!", 880, 400);
        }

        timer--;

        try {
            Thread.sleep(1000); // Wait for 1 second before updating the timer
            repaint(); // Call paint() again to update the screen
        } catch(Exception e) {
            System.out.println(e);
        }

        // If time is up and an answer hasn't been selected, handle the question transition
        if (timer < 0) {
            timer = 15;  // Reset timer for the next question

            // Handle the user answer when time is up (if no answer is selected)
            if (group.getSelection() == null) {
                useranswers[count][0] = ""; // No answer selected
            } else {
                useranswers[count][0] = group.getSelection().getActionCommand(); // Answer selected
            }

            count++; // Increment to the next question

            if (count < 20) {
                start(count); // Move to the next question
            } else {
                // After last question, show score screen
                setVisible(false);
                new Score(name, score, attemptedQuestions, correctAnswers, unattemptedQuestions);  // Show final result
            }
        }
    }



    // Method to start each question
    public void start(int count) {
        // Reset all options to enabled before displaying the next question
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);

        // Now set the question and options
        qno.setText("" + (count + 1) + ".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        // Clear any previous selections
        group.clearSelection();
    }


    // Main method
    public static void main(String[] args) {
        new Quiz("User");
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            // If an answer is selected, increase attemptedQuestions.
            if (group.getSelection() != null) {
                useranswers[count][0] = group.getSelection().getActionCommand();
                attemptedQuestions++;  // Increment attempted
            } else {
                useranswers[count][0] = "";  // No answer selected
            }

            // Check if the current answer is correct
            if (useranswers[count][0].equals(answers[count][1])) {
                correctAnswers++;
            }

            // Update the number of unattempted questions
            unattemptedQuestions = 20 - attemptedQuestions;

            // Disable next button and enable submit on the second to last question
            if (count == 18) {
                next.setEnabled(false);
                submit.setEnabled(true);  // Enable submit button
            }
            timer=15;
            count++;
            start(count);  // Move to the next question
        } else if (e.getSource() == submit) {
            // Handle the final question answer
            ans_given = 1;

            // If no answer is selected, mark as unattempted
            if (group.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = group.getSelection().getActionCommand();
                attemptedQuestions++;  // Increment if answered
            }

            // Final scoring for all answers
            if (useranswers[count][0].equals(answers[count][1])) {
                correctAnswers++;
            }

            // Update unattempted questions
            unattemptedQuestions = 20 - attemptedQuestions;

            // Calculate total score
            int totalScore = 0;
            for (int i = 0; i < 20; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    totalScore += 10;  // Correct answer adds 10 points
                }
            }

            // Show final score screen
            setVisible(false);
            new Score(name, totalScore, attemptedQuestions, correctAnswers, unattemptedQuestions);  // Show final result
        } 
        
        
        // LIFELINE BUTTON 
        
        
        else if (e.getSource() == lifeline) {
        	opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            // Handle the lifeline logic
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                // Disable option 2 and 3 for these specific questions
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                // Disable option 1 and 4 for all other questions
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }

            // Disable the lifeline button after it has been used
            lifeline.setEnabled(false);
        }


        
        
        else {
            // Handle answer selection
            ans_given = 1;

            // Increment attempted if user selects an answer
            if (group.getSelection() != null) {
                useranswers[count][0] = group.getSelection().getActionCommand();
                attemptedQuestions++;
            }

            // Final score calculation
            
            int score = 0;
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }

         //    Print score 
            System.out.println("Score so far: " + score);
            
            // Show results
            setVisible(false);
            new Score(name, score, attemptedQuestions, correctAnswers, unattemptedQuestions);  // Show final results
        }
    }

}
