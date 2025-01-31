package net.javaguides.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Admin_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_home frame = new Admin_home();
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
	public Admin_home() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Account Settings");
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 15));
		btnNewButton.setBounds(51, 329, 627, 59);
		contentPane.add(btnNewButton);
		
		
		
		
		JButton btnShowRequests = new JButton("Show Print Requests");
		
		btnShowRequests.setBackground(SystemColor.infoText);
		btnShowRequests.setForeground(SystemColor.activeCaption);
		btnShowRequests.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 15));
		btnShowRequests.setBounds(51, 135, 627, 59);
		btnShowRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	tabelAdmin frame = new tabelAdmin();
//                frame.setVisible(true);
            }
        });
		contentPane.add(btnShowRequests);
		
	}

}
