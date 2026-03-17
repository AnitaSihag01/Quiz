package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Rules extends JFrame implements ActionListener {

	String name;
	JButton back, start;

	Rules(String name) {
		this.name = name;
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(800, 650);
		setLocation(350, 100);
		setVisible(true);

		JLabel heading = new JLabel(" Welcome " + name + " to Simple Minds");
		heading.setBounds(50, 20, 700, 30);
		heading.setFont(new Font("Times new Roman", Font.BOLD, 28));
		heading.setForeground(new Color(30, 144, 254));
		add(heading);

		JLabel rules = new JLabel();
		rules.setBounds(20, 90, 700, 350);
		rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rules.setForeground(Color.BLACK);
		add(rules);
		rules.setText("<html>" + "1. Answer the question by selecting one of the 4 answer choices." + "<br><br>"
								+ "3. 2 question can be worth 10 points." + "<br><br>" + "3. A complete quiz consists of 20 questions.."
				+ "<br><br>" + "4. Scores can be viewed at the end of the quiz." + "<br><br>"
				+ "5. You have given lifeline for only 1 question." + "<br><br>"
				+ "6. Click on Submit button to save yur data in databse." + "<br><br>"
				+  "<html>");

		back = new JButton("Back");
		back.setBounds(250, 500, 100, 30);
		back.setBackground(new Color(30, 144, 254));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		start = new JButton("Start");
		start.setBounds(400, 500, 100, 30);
		start.setBackground(new Color(30, 144, 254));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);

	}

	public static void main(String[] args) {
		new Rules("User");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			setVisible(false);
			new Quiz(name);

		} else if (e.getSource() == back) {
			setVisible(false);
			new Login();
		}

	}
}