package net.javaguides.swing;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.event.*;
import java.awt.*;

public class mainpage {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // main logo image and "PMS" text.
        ImageIcon icon = new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\main_logo.png");
        JLabel label = new JLabel();
        label.setText("PMS");
        label.setFont(new Font("montserrat", Font.PLAIN, 50));
        label.setForeground(Color.white);
        label.setIcon(icon);
        label.setBounds(100, 80, 700, 600);
        
        //images
        ImageIcon adminicon = new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\Admin logopng.png");
        ImageIcon facicon = new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\fac_icon.png");
        ImageIcon decicon = new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\deli_con.png");
        ImageIcon abcicon = new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\abicon.png");
        // buttons
        
        Border border = BorderFactory.createLineBorder(Color.orange,3);

        JButton button_a = new JButton("FACULTY");
        button_a.setFont(new Font("montserrat", Font.PLAIN, 20));
        button_a.setVerticalAlignment(JButton.CENTER);
        button_a.setIcon(facicon);
        JButton button_b = new JButton("CLERK");
        button_b.setFont(new Font("montserrat", Font.PLAIN, 20));
        button_b.setVerticalAlignment(JButton.CENTER);
        button_b.setIcon(adminicon);
        JButton button_d = new JButton("DELIVERY");
        button_d.setFont(new Font("montserrat", Font.PLAIN, 20));
        button_d.setVerticalAlignment(JButton.CENTER);
        button_d.setIcon(decicon);
        button_d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Deliveryboy frame = new Deliveryboy();
                frame.setVisible(true);
            }
        });
        JButton button_g = new JButton("ABOUT");
        button_g.setFont(new Font("montserrat", Font.PLAIN, 20));
        button_g.setVerticalAlignment(JButton.CENTER);
        button_g.setIcon(abcicon);

        button_a.setBorder(border);
        button_b.setBorder(border);
        button_d.setBorder(border);
        button_g.setBorder(border);
        
        
        button_a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	userinterface frame = new userinterface();
                frame.setVisible(true);
            }
        });

        button_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AdminUserLogin frame = new AdminUserLogin();
                frame.setVisible(true);
            }
        });
        
        button_g.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		new about();
            }
        });
        
        
        
        // panels
        JPanel logopanel = new JPanel();
        logopanel.setBackground(Color.orange);
        logopanel.setBounds(0, 0, 940, 830);
        logopanel.setLayout(null);

        JPanel btpanel = new JPanel();
        btpanel.setBackground(Color.pink);
        btpanel.setBounds(940, 0, 605, 210);
        btpanel.setLayout(new BorderLayout());

        JPanel btpanelf = new JPanel();
        btpanelf.setBackground(Color.pink);
        btpanelf.setBounds(940, 200, 605, 210);
        btpanelf.setLayout(new BorderLayout());

        JPanel btpanelg = new JPanel();
        btpanelg.setBackground(Color.pink);
        btpanelg.setBounds(940, 600, 605, 230);
        btpanelg.setLayout(new BorderLayout());

        JPanel btpaneld = new JPanel();
        btpaneld.setBackground(Color.pink);
        btpaneld.setBounds(940, 400, 605, 230);
        btpaneld.setLayout(new BorderLayout());
        // ImageIcon icon = new ImageIcon("main_logo.png");
        // JLabel label = new JLabel();
        // label.setText("Hi");
        // label.setIcon(icon);

        // Create an image icon from a file
        

        
        
        
        
        
       
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.add(logopanel);
        frame.add(btpanelf);
        frame.add(btpaneld);
        frame.add(btpanelg);
        logopanel.add(label);
        btpanelg.add(button_g);
        btpanelf.add(button_a);
        btpanel.add(button_b);
        btpaneld.add(button_d);
        frame.add(btpanel);
        frame.setTitle("PMS(Printing Management System (User Registration)");
        Image iecon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\main_logo.png");
        frame.setIconImage(iecon);
        
    }
}

