package net.javaguides.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Deliveryboy extends JFrame {
private TableModel models;
private String finaltextbox="";
private JTextArea bigtxtarea;
	private JPanel contentPane;
	private String filename;
	private String printer_id;
	private String s;
	private String name_bg,dpid_bg;
	private String  pid_s;
	private String rm_bg;
	private JPanel panel_1;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private Statement statement;
	private Statement statements;
	private JTable table;
	private JLabel filepath_txt;
private DefaultTableModel model;
	private JPanel outputArea;
	private Statement st;
	private String ph_bg;
	private Statement stq;
	private String name="";
	private static java.sql.Connection con;
	private int width;
	private JPanel panel;
	private String runout="";
	private String idpr="";
	private String uname="";
	private String dep_id="";
	private String Name="";
	private String Dep_Id="";
	private String Doc_Type="";
	private String Side="";
	private String PgSize="";
	private String color="";
	private String pages="";
	private String ffile="";
	private String m="";
	private String formatdate="";
	private String formattime="";
	private String Room_number="";
	private String mobile_number="";
	private int id=0;
	private JTextField nametextField;
	private JTextField depid;
	private JTextField phtext;
	private JTextField roomnumber;
	private JTextField printerid;
	private JTextField docname;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deliveryboy frame = new Deliveryboy();
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
	public Deliveryboy() {
		setBackground(new Color(75, 0, 130));
		setResizable(false);
		setTitle("PMS (Delivery Window)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\aboulogoimage-0.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(75, 0, 130));
		panel_1.setBounds(10, 10, 988, 633);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 82, 866, 258);
		panel_1.add(scrollPane);
		
		table = new JTable();
		
		
		
		JButton btnNewButton_1 = new JButton("Display Data");
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				try {
					
					Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
	                        "root", "12345");
					PreparedStatement st = con.prepareStatement("select * from approve_print_request where status='approved'");
					
					ResultSet rs=st.executeQuery();
					ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					 
					String name,dep_id,doc_type,page_side,page_side1,page_color,number_of_pages,file,print_cost,print_time,approve_date,approve_time;
					while(rs.next()) {
						id=rs.getInt(1);
						name=rs.getString(2);
						dep_id=rs.getString(3);
						doc_type=rs.getString(4);
						page_side=rs.getString(5);
						page_side1=rs.getString(6);
						page_color=rs.getString(7);
						number_of_pages=rs.getString(8);
						file=rs.getString(9);
						print_cost=rs.getString(10);
						printer_id=rs.getString(11);
						print_time=rs.getString(12);
						approve_date=rs.getString(14);
						approve_time=rs.getString(15);
						 s=String.valueOf(id);
						 System.out.print("");
						
						String[] row= {s,name,dep_id,doc_type,page_side,page_side1,page_color,number_of_pages,file,print_cost,printer_id,print_time,approve_date,approve_time};
						model.addRow(row);
						
						
					}
					
//					((Connection) st).close();
//					con.close();
					table.setModel(model);
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

			}
		});
				
				
				
		
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1.setBounds(53, 30, 137, 42);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear Data");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
			
		});
		btnNewButton_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1_1.setBounds(208, 30, 137, 42);
		panel_1.add(btnNewButton_1_1);
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				
				models =table.getModel();
				int i=table.getSelectedRow();
				nametextField.setText(models.getValueAt(i,1).toString());
				 name_bg=models.getValueAt(i,1).toString();
				depid.setText(models.getValueAt(i,2).toString());
				 dpid_bg=models.getValueAt(i,2).toString();
				nametextField.setText(models.getValueAt(i,1).toString());
				nametextField.setText(models.getValueAt(i,1).toString());
				docname.setText(models.getValueAt(i,9).toString());
				String docname_bg=models.getValueAt(i,9).toString();
				String number_bg=models.getValueAt(i,7).toString();
				
				
				
				try {
					Connection connection2 =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
					        "root", "12345");
					System.out.println(dep_id);
					PreparedStatement str = connection2.prepareStatement("select room_number,mobile_number from fac_ac where department_id=?");
					str.setString(1,models.getValueAt(i, 2).toString());
						ResultSet rsm = str.executeQuery();
						
	    				if (rsm.next()) {
	    					phtext.setText(rsm.getString("mobile_number"));
	    					roomnumber.setText(rsm.getString("room_number"));
	    					 ph_bg=rsm.getString("mobile_number");
	    					  rm_bg = rsm.getString("room_number");
	    					
	    					contentPane.revalidate();
	    				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
			        PreparedStatement statement = connection.prepareStatement("select printer_id from approve_print_request where pr_id='"+s+"'");
			        ResultSet resultSet = statement.executeQuery();
			        while (resultSet.next()) {
			             pid_s = resultSet.getString("printer_id");
			           printerid.setText(pid_s);
			           
			           
			            }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bigtxtarea.setText("NAME: "+name_bg+'\n'+"DEPATMENT ID: "+dpid_bg+'\n'+"ROOM NUMBER: "+rm_bg+'\n'+"PHONE NUMBER: "+ph_bg+'\n'+"PRINTER ID: "+pid_s
						+'\n'+"DOCUMENT NAME: "+docname_bg+'\n'+"NUMBER OF PAGES: "+number_bg);
				 filename=bigtxtarea.getText();
				System.out.print(filename);
				   
                    
				
				
				
			
				
				System.out.print(color);
				
			}
		});
		JButton btnNewButton_1_1_1 = new JButton("Mark For Delivery");
		btnNewButton_1_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String upadate_pr ="update printer_details set availability='available' where printer_id='"+printer_id+"'";
				String upadate_pr_st="update approve_print_request set status='marked' where status='approved'  and pr_id='"+s+"'" ;
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");
					 PreparedStatement statement_up = connection.prepareStatement(upadate_pr);
					 statement_up.executeUpdate();
					 
					 PreparedStatement statement_up_status = connection.prepareStatement(upadate_pr_st);
					 statement_up_status.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				String filePath = "C:\\Users\\Deekey\\Downloads\\Java Project\\Delivery Details\\"+name_bg+dpid_bg+".txt";

		        try {
		            File file = new File(filePath);
		            if (!file.exists()) {
		                file.createNewFile();
		            }

		            FileWriter fw = new FileWriter(file.getAbsoluteFile());
		            BufferedWriter bw = new BufferedWriter(fw);
		            bw.write(filename);
		            bw.close();

		            System.out.println("File saved at: " + filePath);
		            filepath_txt.setText("File saved at: " + filePath);
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				
				System.out.print(name);
			}
		});
		scrollPane.setViewportView(table);
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1_1_1.setBounds(416, 569, 170, 42);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel dname = new JLabel("Name");
		dname.setForeground(new Color(255, 255, 0));
		dname.setFont(new Font("Tahoma", Font.BOLD, 16));
		dname.setBounds(54, 366, 91, 27);
		panel_1.add(dname);
		
		JLabel ddid = new JLabel("Department ID");
		ddid.setForeground(new Color(255, 255, 0));
		ddid.setFont(new Font("Tahoma", Font.BOLD, 16));
		ddid.setBounds(53, 420, 126, 27);
		panel_1.add(ddid);
		
		JLabel dph = new JLabel("Phone Number");
		dph.setForeground(new Color(255, 255, 0));
		dph.setFont(new Font("Tahoma", Font.BOLD, 16));
		dph.setBounds(321, 366, 126, 27);
		panel_1.add(dph);
		
		JLabel droom = new JLabel("Room Number");
		droom.setForeground(new Color(255, 255, 0));
		droom.setFont(new Font("Tahoma", Font.BOLD, 16));
		droom.setBounds(321, 420, 126, 27);
		panel_1.add(droom);
		
		JLabel lblPrinterId = new JLabel("Printer ID");
		lblPrinterId.setForeground(new Color(255, 255, 0));
		lblPrinterId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrinterId.setBounds(651, 366, 81, 27);
		panel_1.add(lblPrinterId);
		
		JLabel lblDocumentName = new JLabel("Document Name");
		lblDocumentName.setForeground(new Color(255, 255, 0));
		lblDocumentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDocumentName.setBounds(595, 420, 137, 27);
		panel_1.add(lblDocumentName);
		
		nametextField = new JTextField();
		nametextField.setBounds(112, 366, 172, 19);
		panel_1.add(nametextField);
		nametextField.setColumns(10);
		
		
		depid = new JTextField();
		depid.setColumns(10);
		depid.setBounds(187, 424, 111, 19);
		panel_1.add(depid);
		
		phtext = new JTextField();
		phtext.setColumns(10);
		phtext.setBounds(457, 366, 172, 19);
		panel_1.add(phtext);
		
		roomnumber = new JTextField();
		roomnumber.setColumns(10);
		roomnumber.setBounds(457, 426, 111, 19);
		panel_1.add(roomnumber);
		
		
		
		printerid = new JTextField();
		printerid.setColumns(10);
		printerid.setBounds(742, 366, 177, 19);
		panel_1.add(printerid);
		
		docname = new JTextField();
		docname.setColumns(10);
		docname.setBounds(742, 420, 177, 19);
		panel_1.add(docname);
		
		
		
		panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(10, 10, 988, 633);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setFocusable(true);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\delicon.png"));
		lblNewLabel.setBounds(109, 142, 309, 349);
		panel.add(lblNewLabel);
		
	
		
		txtUserName = new JTextField(Name);
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUserName.getText().equals("User ID")) {
					txtUserName.setText("");
					
					
				}
				txtUserName.setBackground(Color.yellow);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().equals("")) {
					txtUserName.setText("User ID");
					
				}
				txtUserName.setBackground(Color.white);
				
			}
		});
		txtUserName.setForeground(UIManager.getColor("Button.disabledForeground"));
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUserName.setText("User ID");
		txtUserName.setBounds(553, 199, 222, 38);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		
		txtPassword.setText("Password");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(SystemColor.textInactiveText);
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(553, 278, 222, 38);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setText("");
				}
				txtPassword.setBackground(Color.yellow);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
				}
				txtPassword.setBackground(Color.white);
			}
		});
		panel.add(txtPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String userName = txtUserName.getText();
	                String password = txtPassword.getText();
	                try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
	                        "root", "12345");

	                    PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select d_id,password from Delivery_boy where d_id=? and password=?");

	                    st.setString(1, userName);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	        
	                    if (rs.next()) {
	                        
	                        panel_1.setVisible(true);
	        				panel.setVisible(false);
	                       
	                        
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
				
			}
		});
		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnNewButton.setBackground(Color.blue);
				btnNewButton.setForeground(Color.yellow);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				btnNewButton.setBackground(Color.yellow);
				btnNewButton.setForeground(Color.blue);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(553, 376, 222, 46);
		panel.add(btnNewButton);
		panel_1.setVisible(false);
		JButton btnlogout = new JButton("Logout");
		btnlogout.setBackground(Color.WHITE);
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		                int a = JOptionPane.showConfirmDialog(btnlogout, "Are you sure?");
		                // JOptionPane.setRootFrame(null);
		                if (a == JOptionPane.YES_OPTION) {
		             
		                	dispose();
		                	Deliveryboy frame = new Deliveryboy();
		                    frame.setVisible(true);
		                    
		                }
		                
		                

		                panel_1.setVisible(true);

		            }
		    
			
		});
		btnlogout.setBounds(834, 30, 85, 21);
		panel_1.add(btnlogout);
		
		 bigtxtarea = new JTextArea();
		 bigtxtarea.setFont(new Font("Monospaced", Font.BOLD, 14));
		bigtxtarea.setBounds(51, 462, 355, 149);
		panel_1.add(bigtxtarea);
		
		 filepath_txt = new JLabel("");
		filepath_txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		filepath_txt.setForeground(new Color(255, 255, 255));
		filepath_txt.setBackground(new Color(255, 255, 255));
		filepath_txt.setBounds(596, 591, 323, 19);
		panel_1.add(filepath_txt);
		
	}
}
