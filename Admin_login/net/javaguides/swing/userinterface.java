package net.javaguides.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class userinterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userinterface frame = new userinterface();
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
	public userinterface() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\aboulogoimage-0.png"));
		setTitle("Faculty Interface(PMS)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login ");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setIcon(null);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(267, 43, 135, 36);
		contentPane.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	UserLogin frame = new UserLogin();
                frame.setVisible(true);
            }
        });
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(267, 106, 135, 36);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	UserRegistration frame = new UserRegistration();
                frame.setVisible(true);
            }
        });
		contentPane.add(btnNewButton);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.setBackground(SystemColor.menu);
		btnGoBack.setForeground(SystemColor.textText);
		btnGoBack.setBounds(267, 171, 135, 36);
		btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
		
		contentPane.add(btnGoBack);
		
		
		JLabel lblNewLabel = new JLabel("FACULTY ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\fac_icon.png"));
		lblNewLabel.setBounds(27, 22, 205, 204);
		contentPane.add(lblNewLabel);
	}
}
