package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {
    JButton next, back;
    JTextField tfname;
    String name;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);

        // Heading setup
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 600, 45);
        heading.setFont(new Font("Times new Roman", Font.BOLD, 30));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        // Name input prompt setup
        JLabel nameLabel = new JLabel("Enter your name");
        nameLabel.setBounds(810, 150, 300, 20);
        nameLabel.setFont(new Font("Times new Roman", Font.BOLD, 18));
        nameLabel.setForeground(new Color(30, 144, 254));
        add(nameLabel);

        // Text field setup for name
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        // Next button setup
        next = new JButton("Next");
        next.setBounds(735, 270, 120, 25);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        // Back button setup
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Window settings
        setVisible(true);
        setLocation(200, 150);
        setSize(1200, 500);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            name = tfname.getText().trim(); // Get the text entered by the user
            
            // Regex for valid name (only letters and spaces)
            String regex = "^[a-zA-Z\\s]+$"; // 
            
            // Check if the name is empty or doesn't match the regex
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!name.matches(regex)) {
                JOptionPane.showMessageDialog(this, "Name can only contain letters and spaces.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                setVisible(false);  // Hide the login screen
                new Rules(name);  // Proceed to the Rules screen (make sure Rules class is correctly implemented)
            }
        } else if (e.getSource() == back) {
            // Handle the back button action (you can modify this as needed)
            JOptionPane.showMessageDialog(this, "Going back to the previous screen.");
            // Logic for going back (could be closing the window or navigating to another frame)
        }
    }
}
