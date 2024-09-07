package net.javaguides.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.Timer;
public class temp {
   
	public static void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("SQL Input/Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the input and output components
        JPanel panel = new JPanel();

        // Create a label for the input field
        JLabel inputLabel = new JLabel("Enter SQL Command:");

        // Create a text field for input
        JTextField inputField = new JTextField(20);

        // Create a button to submit the input
        JButton submitButton = new JButton("Submit");

        // Create a label for the output field
        JLabel outputLabel = new JLabel("Output:");

        // Create a text area for the output
        JTextArea outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);

        // Add the input and output components to the panel
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(outputLabel);
        panel.add(outputArea);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Set the size of the frame and display it
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input from the text field
                String input = inputField.getText();

                // Execute the input as a SQL command
                executeSQL(input, outputArea);
            }
        });
    }

    public static void executeSQL(String input, JTextArea outputArea) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the input as a SQL query
            ResultSet rs = stmt.executeQuery(input);

            // Process the results
            outputArea.setText("");
            while (rs.next()) {
                // Add each row of the result set to the output area
                outputArea.append(rs.getString(1) + "\n");
            }

            // Close the connection
            conn.close();
        } catch (SQLException ex) {
            // Print any errors that occurred
            outputArea.setText("Error: ");
        }
    }
}