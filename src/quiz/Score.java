package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

@SuppressWarnings("serial")
public class Score extends JFrame implements ActionListener {

	// Instance variables to hold name and score
	String name;
	int score,attempted_ans,unattempted_ans,correct_ans;
	JButton submit;

	public Score(String name, int score, int attemptedQuestions, int correctAnswers, int unattemptedQuestions) {
		this.name = name; // This sets the value of 'name' passed as an argument to the constructor
		this.score = score;
		this.attempted_ans=attemptedQuestions;
		this.unattempted_ans=unattemptedQuestions;
		this.correct_ans=correctAnswers;

		getContentPane().setBackground(Color.WHITE);
		setBounds(400, 150, 750, 550);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 200, 300, 250);
		add(image);
		setVisible(true);

		JLabel heading = new JLabel(" Thank you " + name + " for playing Simple Minds ");
		heading.setBounds(115, 30, 700, 30);
		heading.setForeground(new Color(30,144,254));
		heading.setFont(new Font("Times new Roman", Font.BOLD, 26));
		add(heading);

		JLabel total_score = new JLabel("Your score is " + score);
		total_score.setBounds(350, 250, 300, 30);
		total_score.setForeground(new Color(30,144,254));
		total_score.setFont(new Font("Times new Roman", Font.BOLD, 28));
		add(total_score);
		
		JLabel ansgiven = new JLabel("questions attempted = " + attempted_ans);
		ansgiven.setBounds(150, 120, 300, 30);
		ansgiven.setFont(new Font("Times new Roman", Font.PLAIN, 24));
	//	ansgiven.setForeground(new Color(30,144,254));
		add(ansgiven);
		
		JLabel ans_ungiven = new JLabel("questions unattempted = " + unattempted_ans);
		ans_ungiven.setBounds(410, 120, 300, 30);
		ans_ungiven.setFont(new Font("Times new Roman", Font.PLAIN, 24));
	//	ans_ungiven.setForeground(new Color(30,144,254));
		add(ans_ungiven);
		
		JLabel correct = new JLabel("correct answers = " + correctAnswers);
		correct.setBounds(410, 150, 300, 30);
	//	correct.setForeground(new Color(30,144,254));
		correct.setFont(new Font("Times new Roman", Font.PLAIN, 24));
		add(correct);

		submit = new JButton("Submit");
		submit.setBounds(370, 380, 150, 30);
		submit.setBackground(new Color(30, 144, 254));
		submit.setFont(new Font("Times new Roman", Font.BOLD, 20));
		add(submit);
		submit.addActionListener(this);
		submit.setForeground(Color.WHITE);
	}

	public static void main(String[] args) {
		new Score("User", 0,0,0,0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet generatedKeys = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3309/quiz", "root", "root");

				// Check for null or empty name
				if (name == null || name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Name field cannot be empty.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				stmt = con.prepareStatement("INSERT INTO register (mName, score) VALUES (?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, name);
				stmt.setInt(2, score);

				// Execute the insert operation
				stmt.executeUpdate();

				// Retrieve the generated keys
				generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					int id = generatedKeys.getInt(1);
					JOptionPane.showMessageDialog(this, "Registered successfully with ID: " + id);
				} else {
					JOptionPane.showMessageDialog(this, "No ID obtained.", "Error", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (generatedKeys != null)
						generatedKeys.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (SQLException ignored) {
				}
			}
			System.out.println(attempted_ans);
			setVisible(false);
			// new Login(); // Assuming Login is another class to go back to
		}
	}
}
