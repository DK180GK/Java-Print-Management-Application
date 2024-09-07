package net.javaguides.swing;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class about extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public about() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a panel for the developer information
        JPanel developersPanel = new JPanel();
        developersPanel.setLayout(new BoxLayout(developersPanel, BoxLayout.Y_AXIS));
        developersPanel.setBorder(BorderFactory.createTitledBorder("Developers"));
        developersPanel.setBackground(new Color(163, 168, 146));

        // JPanel panel=new JPanel();

        // Add developer information and photos to the panel
        JLabel developer1 = new JLabel("Devadath G K(AM.EN.U4CSE21020) : Main Developer");
        JLabel developer2 = new JLabel("Ayush binil(AM.EN.U4CSE21015) : Co- Developer");
        JLabel developer3 = new JLabel("Alfin Joseph(AM.EN.U4CSE21020) : Co- Developer");
        JLabel developer4 = new JLabel("Ajai J (AM.EN.U4CSE21020) : Co- Developer");
        developer1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        developer2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        developer3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        developer4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        developersPanel.add(developer1);
        developersPanel.add(developer2);
        developersPanel.add(developer3);
        developersPanel.add(developer4);
        developersPanel.setForeground(new Color(195, 255, 0));

        // Create a panel for the application information
        JPanel appInfoPanel = new JPanel();
        appInfoPanel.setLayout(new BorderLayout());
        appInfoPanel.setBorder(BorderFactory.createTitledBorder("Application Information"));

        // Add text and description of the application to the panel
        JTextArea appDescription = new JTextArea(
                "This project aims to develop an automated system that will help to calculate the print cost so as to find the print expenses at the end of each month. ICTS department has the provision of five printers to print five different files at a time. The staff member can request for printing the required file. The files which have been printed, the details of the person who requested the print, date, and time of print are to be maintained. Each print job is assigned to clerical staff to verify if the printout request is valid, the staff who requested it is eligible, whether the request is official or personal, etc. based on which he/she takes the printout. One delivery person is responsible to deliver the printouts to the respective staff member after checking the personal details such as name, room no of the staff member, phone no. The print details such as type of paper used (A3, A4, etc.), single-page print or double side print, color print or not, etc. are also to be maintained. At a time, a file can be printed only on one printer ");
        appDescription.setLineWrap(true);
        appDescription.setWrapStyleWord(true);
        appInfoPanel.add(appDescription, BorderLayout.CENTER);
        appDescription.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        appInfoPanel.setBackground(new Color(126, 103, 156));
        mainPanel.setBackground(new Color(103, 114, 156));
        // Add the developer and application information panels to the main panel
        mainPanel.add(developersPanel, BorderLayout.WEST);
        mainPanel.add(appInfoPanel, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        ImageIcon icons = new ImageIcon("bg.jpeg");
        JLabel imageLabel = new JLabel(icons);
        imagePanel.add(imageLabel);

        // Create a frame to hold the main panel
        JFrame frame = new JFrame("About Section");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(0, 0, 1280, 720);
        frame.setTitle("About-PMS(Printing Management System)");
        Image iecon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\main_logo.png");
        frame.setIconImage(iecon);

    }
}