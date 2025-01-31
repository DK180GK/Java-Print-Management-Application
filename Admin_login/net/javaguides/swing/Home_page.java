package net.javaguides.swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Home_page {
	private int count_ab=0;
	private int count_sp=0;
	private JLabel lblNewLabel_3;
	private String dashboard="Dashbaord";
	private String name;
	private String cost_tx;
	private String page_tx;
	private JButton support;
	private String msg;

	private JFrame frmPms;
	private static JTable table;
	private float page_tx_float;
	private JButton btnabout;
	private JButton refresh;
	private JTextField id_fileld;
	private JTextField emailfileld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("sun.java2d.uiScale","1.01");
					Home_page window = new Home_page();
					window.frmPms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Home_page() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 * @throws SQLException 
	 */
	
	public static void temp_t(){
try {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
                    "root", "12345");
			PreparedStatement st = con.prepareStatement("select * from printer_details");
			
			ResultSet rs=st.executeQuery();
			ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			
			int cols=rsmd.getColumnCount();
			String[] colName= new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			 
			String printer_id,printer_name,availability;
			while(rs.next()) {
				printer_id=rs.getString(1);
				printer_name=rs.getString(2);
				availability=rs.getString(3);
				
		
				
				String[] row= {printer_id,printer_name,availability};
				model.addRow(row);
				
				
			}
			
//			((Connection) st).close();
//			con.close();
			table.setModel(model);
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public
	 
	class
	 
	DatabaseConnection
	 
	{

	    public
	 
	static Connection getConnection()
	 
	throws SQLException {
	        // Load the MySQL JDBC driver
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Create a JDBC URL
	        String jdbcUrl = "jdbc:mysql://localhost:3306/swing_demo";

	        // Connect to the database
	        Connection connection = DriverManager.getConnection(jdbcUrl);

	        return connection;
	    }
	}
	
	private void initialize() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		frmPms = new JFrame();
		frmPms.setResizable(false);
		frmPms.getContentPane().setBackground(SystemColor.menu);
		frmPms.getContentPane().setLayout(null);
		
		JPanel supportpanel = new JPanel();
		supportpanel.setForeground(UIManager.getColor("Button.disabledShadow"));
		supportpanel.setBounds(237, 177, 1029, 506);
		frmPms.getContentPane().add(supportpanel);
		supportpanel.setLayout(null);
		
		JLabel depid_label = new JLabel("Department ID");
		depid_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		depid_label.setBounds(45, 50, 169, 47);
		supportpanel.add(depid_label);
		
		JLabel emailid_label = new JLabel("Email");
		emailid_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailid_label.setBounds(45, 107, 169, 47);
		supportpanel.add(emailid_label);
		
		JLabel pro_label = new JLabel("Write your problem");
		pro_label.setFont(new Font("Tahoma", Font.BOLD, 15));
		pro_label.setBounds(45, 164, 169, 47);
		supportpanel.add(pro_label);
		
		id_fileld = new JTextField();
		id_fileld.setBounds(173, 57, 269, 37);
		supportpanel.add(id_fileld);
		id_fileld.setColumns(10);
		
		emailfileld = new JTextField();
		emailfileld.setColumns(10);
		emailfileld.setBounds(173, 114, 269, 37);
		supportpanel.add(emailfileld);
		
		JTextArea pb_area = new JTextArea();
		pb_area.setBounds(45, 208, 835, 225);
		supportpanel.add(pb_area);
		
		JButton submit_btn = new JButton("Submit");
		submit_btn.addActionListener(new ActionListener() {

			

			public void actionPerformed(ActionEvent e) {
				
				String depid=id_fileld.getText();
				String emailid=emailfileld.getText();
				String pbfield=pb_area.getText();
				String querys = "INSERT INTO support values('" + depid + "','" + emailid + "','" + pbfield + "')";
				String check="select name from fac_ac where department_id=?";
				
				
				PreparedStatement statement;
				PreparedStatement statements;
				try {
					Connection connection_1 =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
		                    "root", "12345");
					PreparedStatement st = (PreparedStatement) connection_1
	                        .prepareStatement(check);
	                    
	                    st.setString(1,depid);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                    msg = rs.getString("name");
	                    if(pbfield.length()>5) {
	                    	if(msg!=null) {
				                    	 
				                    	statement = connection_1.prepareStatement(querys);
				       					 statement.executeUpdate();
				        					id_fileld.setText("");
				        					emailfileld.setText("");
				        					pb_area.setText("");
				        					
				        					JOptionPane.showMessageDialog(submit_btn,
				                                    "Ok, " + msg + "Your Printing Request is given for approvel");
				                    	
				                    }
				                    
	                    	}
	                    else {
	                    	JOptionPane.showMessageDialog(submit_btn,
                                    "Ok, " + "Write valid Reason");
	                    }
	                    }
	                    	else {
	                    		JOptionPane.showMessageDialog(submit_btn,
	                                    "Enter valid Department ID");
	                    	}
					
		
		
				}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
					
				
			}
		});
		submit_btn.setForeground(new Color(255, 255, 255));
		submit_btn.setBackground(new Color(0, 0, 153));
		submit_btn.setBounds(777, 443, 103, 31);
		supportpanel.add(submit_btn);
		supportpanel.setVisible(false);
		
		JPanel about_panel = new JPanel();
		about_panel.setBounds(237, 177, 1029, 506);
		frmPms.getContentPane().add(about_panel);
		about_panel.setLayout(null);
		
		JPanel app_info_panel = new JPanel();
		app_info_panel.setBounds(10, 10, 1009, 237);
		app_info_panel.setBackground(new Color(0, 0, 51));
		about_panel.add(app_info_panel);
		app_info_panel.setBorder(BorderFactory.createTitledBorder(null, "Application Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.BOLD,12), Color.white));
		app_info_panel.setLayout(null);
		
		JTextArea textArea = new JTextArea("This project aims to develop an automated system that will help to calculate the print cost so as to find the print expenses at the end of each month. ICTS department has the provision of five printers to print five different files at a time. The staff member can request for printing the required file. The files which have been printed, the details of the person who requested the print, date, and time of print are to be maintained. Each print job is assigned to clerical staff to verify if the printout request is valid, the staff who requested it is eligible, whether the request is official or personal, etc. based on which he/she takes the printout. One delivery person is responsible to deliver the printouts to the respective staff member after checking the personal details such as name, room no of the staff member, phone no. The print details such as type of paper used (A3, A4, etc.), single-page print or double side print, color print or not, etc. are also to be maintained. At a time, a file can be printed only on one printer ");
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(0, 0, 51));
		textArea.setBounds(10, 26, 989, 201);
		app_info_panel.add(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JPanel dev_panel = new JPanel();
		dev_panel.setBounds(10, 259, 1009, 237);
		dev_panel.setLayout(null);
		dev_panel.setBorder(BorderFactory.createTitledBorder(null, "Developers Info", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.BOLD,12), Color.white));
		dev_panel.setBackground(new Color(0, 0, 51));
		about_panel.add(dev_panel);
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\AYUSH BINIL AM.EN.U4CSE21015.png"));
		lblNewLabel_4_1.setBounds(335, 27, 123, 150);
		dev_panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\Devadath G K AM.EN.U4CSE21020.png"));
		lblNewLabel_4.setBounds(94, 27, 123, 150);
		dev_panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NAME: DEAVADTH G K");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(83, 175, 158, 30);
		dev_panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("ROLL NO:AM.EN.U4CSE21020");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(66, 197, 191, 30);
		dev_panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("NAME: AYUSH BINIL");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_2.setBounds(331, 175, 158, 30);
		dev_panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("ROLL NO:AM.EN.U4CSE21015");
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1_1.setBounds(298, 197, 191, 30);
		dev_panel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("New label");
		lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\Alfin 3.png"));
		lblNewLabel_4_1_1.setBounds(570, 27, 123, 150);
		dev_panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("NAME: ALFIN JOSEPH");
		lblNewLabel_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_2_1.setBounds(564, 175, 158, 30);
		dev_panel.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("ROLL NO:AM.EN.U4CSE21008");
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1_1_1.setBounds(531, 197, 191, 30);
		dev_panel.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("New label");
		lblNewLabel_4_1_1_1.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\Ajai J.png"));
		lblNewLabel_4_1_1_1.setBounds(794, 27, 123, 150);
		dev_panel.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("NAME: AJAI J");
		lblNewLabel_5_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_2_1_1.setBounds(817, 175, 158, 30);
		dev_panel.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("ROLL NO:AM.EN.U4CSE21076");
		lblNewLabel_5_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1_1_1_1.setBounds(757, 197, 191, 30);
		dev_panel.add(lblNewLabel_5_1_1_1_1);
		
		JPanel logopanel = new JPanel();
		logopanel.setBounds(0, 0, 237, 683);
		logopanel.setBackground(new Color(0, 0, 51));
		frmPms.getContentPane().add(logopanel);
		about_panel.setVisible(false);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
        PreparedStatement statement = connection.prepareStatement("select count(*) as counts_fac from fac_ac");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            name = resultSet.getString("counts_fac");
           
            }
        
        Connection connection_cost = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
        PreparedStatement statement_cost = connection.prepareStatement("select sum(print_cost) as cost from approve_print_request");
        ResultSet resultSet_cost = statement_cost.executeQuery();
        while (resultSet_cost.next()) {
            cost_tx = resultSet_cost.getString("cost");
           
            }
        
        Connection connection_pages = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
        PreparedStatement statement_pages= connection.prepareStatement("select sum(number_of_pages) as cost_page from approve_print_request");
        ResultSet resultSet_pages = statement_pages.executeQuery();
        while (resultSet_pages.next()) {
            page_tx = resultSet_pages.getString("cost_page");
            String s=page_tx;
             page_tx_float =Float.parseFloat(s);
           
            }
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setBounds(10, 25, 207, 96);
		ImageIcon icons = new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\Home page top icon.png");
		
		Image img = icons.getImage();
		Image newimg = img.getScaledInstance(207, 77,  java.awt.Image.SCALE_SMOOTH);
		icons = new ImageIcon(newimg);
		logopanel.setLayout(null);
		imagelabel.setIcon(icons);
		logopanel.add(imagelabel);
		
		JButton btnadmin = new JButton("ADMIN");
		btnadmin.setBounds(10, 147, 217, 41);
		btnadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_login_ui frame = new admin_login_ui();
				frame.setVisible(true);
				
			}
			
		});
		
		
		btnadmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnadmin.setForeground(new Color(255, 255, 255));
		btnadmin.setBackground(new Color(0, 0, 51));
		logopanel.add(btnadmin);
		btnadmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnadmin.setForeground(new Color(0, 0, 51));
				btnadmin.setBackground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnadmin.setForeground(new Color(255, 255, 255));
				btnadmin.setBackground(new Color(0, 0, 51));
			}
		});
		btnadmin.setFocusable(false);
		
		
		JButton btnuser = new JButton("USER");
		btnuser.setBounds(10, 212, 217, 41);
		btnuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userinterface frame = new userinterface();
                frame.setVisible(true);
			}
		});
		btnuser.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnuser.setForeground(new Color(255, 255, 255));
		btnuser.setBackground(new Color(0, 0, 51));
		logopanel.add(btnuser);
		btnuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnuser.setForeground(new Color(0, 0, 51));
				btnuser.setBackground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnuser.setForeground(new Color(255, 255, 255));
				btnuser.setBackground(new Color(0, 0, 51));
			}
		});
		btnuser.setFocusable(false);
		
		JButton btndelivery = new JButton("DELIVERY");
		btndelivery.setBounds(10, 280, 217, 41);
		btndelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deliveryboy frame = new Deliveryboy();
                frame.setVisible(true);
			}
		});
		btndelivery.setFont(new Font("Tahoma", Font.BOLD, 18));
		btndelivery.setForeground(new Color(255, 255, 255));
		btndelivery.setBackground(new Color(0, 0, 51));
		logopanel.add(btndelivery);
		btndelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btndelivery.setForeground(new Color(0, 0, 51));
				btndelivery.setBackground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btndelivery.setForeground(new Color(255, 255, 255));
				btndelivery.setBackground(new Color(0, 0, 51));
			}
		});
		btndelivery.setFocusable(false);
		 btnabout = new JButton("ABOUT");
		 btnabout.setBounds(10, 344, 217, 41);
		btnabout.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(count_sp%2==0) {
				count_ab+=1;
				if(count_ab%2==1) {
					about_panel.setVisible(true);
					lblNewLabel_3.setText("About");
					btnabout.setText("GO TO HOME");
					table.setVisible(false);
				}
				else {
					about_panel.setVisible(false);
					lblNewLabel_3.setText("Dashboard");
					btnabout.setText("ABOUT");
					table.setVisible(true);
					
				}
				}
			}
		});
		btnabout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnabout.setForeground(new Color(255, 255, 255));
		btnabout.setBackground(new Color(0, 0, 51));
		logopanel.add(btnabout);
		btnabout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnabout.setForeground(new Color(0, 0, 51));
				btnabout.setBackground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnabout.setForeground(new Color(255, 255, 255));
				btnabout.setBackground(new Color(0, 0, 51));
			}
		});
		btnabout.setFocusable(false);
		support = new JButton("SUPPORT");
		support.setBounds(10, 406, 217, 41);
		support.setForeground(Color.WHITE);
		support.setFont(new Font("Tahoma", Font.BOLD, 18));
		support.setFocusable(false);
		support.setBackground(new Color(0, 0, 51));
		logopanel.add(support);
		support.setFocusable(false);
		support.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				support.setForeground(new Color(0, 0, 51));
				support.setBackground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				support.setForeground(new Color(255, 255, 255));
				support.setBackground(new Color(0, 0, 51));
			}
		});
		
		support.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(count_ab%2==0) {
				count_sp+=1;
				if(count_sp%2==1) {
					supportpanel.setVisible(true);
					lblNewLabel_3.setText("Support");
					support.setText("GO TO HOME");
					table.setVisible(false);
				}
				else {
					supportpanel.setVisible(false);
					lblNewLabel_3.setText("Dashboard");
					support.setText("SUPPORT");
					table.setVisible(true);
					
				}
				}	
			}
		});
		
		JPanel dashpanel = new JPanel();
		dashpanel.setForeground(new Color(255, 255, 255));
		dashpanel.setBackground(new Color(0, 0, 139));
		dashpanel.setBounds(237, 0, 1029, 39);
		frmPms.getContentPane().add(dashpanel);
		dashpanel.setLayout(null);
		
		lblNewLabel_3 = new JLabel(dashboard);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(27, 16, 119, 13);
		dashpanel.add(lblNewLabel_3);
		
		refresh = new JButton("Refresh Page");
		refresh.setForeground(Color.WHITE);
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPms.setVisible(false);
				frmPms.dispose();
                main(null);
			}
		});
		refresh.setFocusable(false);
		refresh.setBackground(new Color(0, 0, 153));
		refresh.setBounds(874, 8, 133, 21);
		dashpanel.add(refresh);
		
		JPanel imagepanel = new JPanel();
		imagepanel.setBounds(237, 34, 1053, 145);
		frmPms.getContentPane().add(imagepanel);
		imagepanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\imagepanel1.png"));
		lblNewLabel_1.setBounds(0, 5, 1029, 140);
		imagepanel.add(lblNewLabel_1);
		
		JPanel statuspanel = new JPanel();
		statuspanel.setBackground(Color.WHITE);
		statuspanel.setBounds(260, 220, 337, 185);
		frmPms.getContentPane().add(statuspanel);
		statuspanel.setLayout(null);
		
		JLabel usertext = new JLabel("Users");
		usertext.setFont(new Font("Tahoma", Font.BOLD, 14));
		usertext.setBounds(10, 25, 108, 13);
		statuspanel.add(usertext);
		
		JLabel printerstext = new JLabel("Printers");
		printerstext.setFont(new Font("Tahoma", Font.BOLD, 14));
		printerstext.setBounds(10, 63, 108, 13);
		statuspanel.add(printerstext);
		
		JLabel costtest = new JLabel("Total Cost");
		costtest.setFont(new Font("Tahoma", Font.BOLD, 14));
		costtest.setBounds(10, 101, 108, 13);
		statuspanel.add(costtest);
		
		JLabel pagestext = new JLabel("Total Pages");
		pagestext.setFont(new Font("Tahoma", Font.BOLD, 14));
		pagestext.setBounds(10, 141, 108, 13);
		statuspanel.add(pagestext);
		
		JLabel usercount = new JLabel(name);
		usercount.setFont(new Font("Tahoma", Font.BOLD, 14));
		usercount.setBounds(273, 25, 108, 13);
		statuspanel.add(usercount);
		
		JLabel printer_count = new JLabel("5");
		printer_count.setFont(new Font("Tahoma", Font.BOLD, 14));
		printer_count.setBounds(273, 65, 108, 13);
		statuspanel.add(printer_count);
		
		JLabel cost_text = new JLabel(cost_tx);
		cost_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		cost_text.setBounds(273, 103, 108, 13);
		statuspanel.add(cost_text);
		
		JLabel total_page = new JLabel(page_tx);
		total_page.setFont(new Font("Tahoma", Font.BOLD, 14));
		total_page.setBounds(273, 143, 108, 13);
		statuspanel.add(total_page);
		
		JLabel lblNewLabel_2 = new JLabel("System Status");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(260, 197, 108, 13);
		frmPms.getContentPane().add(lblNewLabel_2);
		
		JLabel new_content = new JLabel("ICTS IMPLEMENTED 5 PRINTERS TO PMS");
		new_content.setForeground(Color.RED);
		new_content.setFont(new Font("Tahoma", Font.BOLD, 17));
		new_content.setBounds(630, 380, 542, 13);
		frmPms.getContentPane().add(new_content);
		
		JLabel newtxt = new JLabel("News");
		newtxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		newtxt.setBounds(630, 197, 108, 13);
		frmPms.getContentPane().add(newtxt);
		
		JLabel newsimage = new JLabel("New label");
		newsimage.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\News image4.png"));
		newsimage.setBounds(622, 221, 622, 185);
		frmPms.getContentPane().add(newsimage);
		
		JPanel newspanel = new JPanel();
		newspanel.setBackground(Color.WHITE);
		newspanel.setBounds(622, 221, 621, 185);
		frmPms.getContentPane().add(newspanel);
		newspanel.setLayout(null);
		
		JLabel news = new JLabel("News");
		news.setFont(new Font("Tahoma", Font.BOLD, 14));
		news.setBounds(622, 199, 108, 13);
		
		JPanel statuspanel_1 = new JPanel();
		statuspanel_1.setLayout(null);
		statuspanel_1.setBackground(Color.WHITE);
		statuspanel_1.setBounds(260, 490, 337, 160);
		frmPms.getContentPane().add(statuspanel_1);
		
		JLabel lblTreesCuted = new JLabel("Trees Cuted");
		lblTreesCuted.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTreesCuted.setBounds(10, 35, 108, 13);
		statuspanel_1.add(lblTreesCuted);
		
		JLabel lblCarbonEmition = new JLabel("Carbon Emition(KG)");
		lblCarbonEmition.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCarbonEmition.setBounds(10, 72, 144, 13);
		statuspanel_1.add(lblCarbonEmition);
		
		JLabel lblPower = new JLabel("Power Usage(mW-H)");
		lblPower.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPower.setBounds(10, 110, 163, 25);
		statuspanel_1.add(lblPower);
		
	

		double  number_tree_i=(page_tx_float*0.000123);
		String number_tree_f= Double.toString(number_tree_i);
		double number_carbon_i=(page_tx_float*0.027);
		String number_carbon_f= Double.toString(number_carbon_i);
		double power_use_i=((page_tx_float*7)+(page_tx_float*0.26));
		String power_use_f= Double.toString(power_use_i);
		
		JLabel trees_txt = new JLabel(number_tree_f);
		trees_txt.setFont(new Font("Tahoma", Font.BOLD, 14));
		trees_txt.setBounds(229, 35, 108, 13);
		statuspanel_1.add(trees_txt);
		
		JLabel carbon_txt = new JLabel(number_carbon_f);
		carbon_txt.setFont(new Font("Tahoma", Font.BOLD, 14));
		carbon_txt.setBounds(229, 72, 98, 13);
		statuspanel_1.add(carbon_txt);
		
		JLabel power_txt = new JLabel(power_use_f);
		power_txt.setFont(new Font("Tahoma", Font.BOLD, 14));
		power_txt.setBounds(229, 116, 98, 13);
		statuspanel_1.add(power_txt);
		
		JLabel lblPrinterStatus = new JLabel("Printer Status");
		lblPrinterStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrinterStatus.setBounds(622, 467, 108, 13);
		frmPms.getContentPane().add(lblPrinterStatus);
		
		JLabel lblEnvironmentalImpact = new JLabel("Environmental Impact");
		lblEnvironmentalImpact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnvironmentalImpact.setBounds(260, 467, 182, 13);
		frmPms.getContentPane().add(lblEnvironmentalImpact);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(622, 490, 621, 103);
		frmPms.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		frmPms.getContentPane().add(table.getTableHeader());
		
		JPanel content_panel = new JPanel();
		content_panel.setLayout(null);
		content_panel.setBounds(0, 0, 1, 1);
		frmPms.getContentPane().add(content_panel);
	
		frmPms.setBackground(new Color(128, 0, 128));
		
		
		temp_t();
		 
		
		
		
		frmPms.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\aboulogoimage-0.png"));
		frmPms.setTitle("PMS GROUP-14");
		frmPms.setBounds(150, 80, 1280, 720);
		frmPms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connection.close();
	}

		
}
