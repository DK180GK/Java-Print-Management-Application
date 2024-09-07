package net.javaguides.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class clientdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientdetails frame = new clientdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public clientdetails() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(37, 42, 75, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastname.setBounds(37, 100, 75, 32);
		contentPane.add(lblLastname);
		
		textField = new JTextField();
		textField.setBounds(228, 50, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 108, 96, 19);
		contentPane.add(textField_1);
		
		JLabel lblDateOfBerthddmmyy = new JLabel("Date of birth(DD/MM/YYY)");
		lblDateOfBerthddmmyy.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfBerthddmmyy.setBounds(37, 155, 198, 32);
		contentPane.add(lblDateOfBerthddmmyy);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 163, 96, 19);
		contentPane.add(textField_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(37, 197, 75, 32);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(228, 205, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(228, 245, 96, 19);
		contentPane.add(textField_4);
		
		JLabel lblLastname_1_1 = new JLabel("Phone Number");
		lblLastname_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastname_1_1.setBounds(37, 237, 107, 32);
		contentPane.add(lblLastname_1_1);
	}
}
