package net.javaguides.swing;
import java.sql.Connection;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextField;


public class tabelAdmin extends JFrame {
	private Statement statement;
	private Statement statements;
	private JLabel printer_count;
	private  String printer_a;
	
	private DefaultTableModel model;
	private JPanel outputArea;
	private JTable table;
	private Statement st;
	private Statement stq;
	private String name="";
	private static java.sql.Connection con;
	private int width;
	private String approved="approved";
	private String runout="";
	private String printers="";
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
	private String formatdate_r="";
	private String formattime_r="";
	private String prcount="";
	private String problems_1;
	
	private int id=0;
	private String printerids[]= {"HP LaserJet 4200","Samsung Xpress SL","Canon PIXMA G570","Epson LX 310","Brother HL-B2000D"};
	
private DefaultTableCellRenderer cellRenderer;
private JTextField sqlcmd;
private String f_printers;
private String f_problems_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabelAdmin frame = new tabelAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public String temps() throws SQLException {

		 Connection connection_pr = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
	        PreparedStatement statement_pr = connection_pr.prepareStatement("select count(*) as printers from printer_details where availability='available'");
	        ResultSet resultSet_pr = statement_pr.executeQuery();
	   
	        while (resultSet_pr.next()) {
	        	printers=resultSet_pr.getString("printers");
	             this.f_printers="Number of Printer Available "+printers+"/5";
	            return this.f_printers;
	       
	            }
		return "";
    }
	
	public String temp_p() throws SQLException {

		 Connection connection_pr = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
	        PreparedStatement statement_pro = connection_pr.prepareStatement("select count(*) as problems from support");
	        ResultSet resultSet_prs = statement_pro.executeQuery();
	        while (resultSet_prs.next()) {
	        	problems_1=resultSet_prs.getString("problems");
	            this.f_problems_1=problems_1;
	            return this.f_problems_1;
	       
	            }
		return "";
   }
	
	
	
	public tabelAdmin() throws SQLException {
		setResizable(false);
		setTitle("PMS (Admin Panel)");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\aboulogoimage-0.png"));
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 917, 702);
		outputArea = new JPanel();
		outputArea.setBackground(SystemColor.activeCaption);
		outputArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(outputArea);
		int numb = 0;
		JButton btnShow = new JButton("Display Details");
		btnShow.setBounds(50, 149, 192, 50);
		btnShow.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 13));
		btnShow.setBackground(Color.BLACK);
		btnShow.setForeground(Color.LIGHT_GRAY);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
        PreparedStatement statement = connection.prepareStatement("select count(*) as counts from print_request");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            name = resultSet.getString("counts");
           
            }
//        Connection connection_pr = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
//        PreparedStatement statement_pr = connection_pr.prepareStatement("select count(*) as printers from printer where availability='1'");
//        ResultSet resultSet_pr = statement_pr.executeQuery();
//        while (resultSet_pr.next()) {
//            printers = resultSet_pr.getString("printers");
//           
//            }
       
		btnShow.addActionListener(new ActionListener() {
//			private AbstractButton tblData;

			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				try {
					
					Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
	                        "root", "12345");
					PreparedStatement st = con.prepareStatement("select * from print_request");
					
					ResultSet rs=st.executeQuery();
					ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					 
					String name,dep_id,doc_type,page_side,page_side1,page_color,number_of_pages,file,print_cost,print_date,print_time;
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
						print_date=rs.getString(11);
						print_time=rs.getString(12);
						

						
						String s=String.valueOf(id);
						
						String[] row= {s,name,dep_id,doc_type,page_side,page_side1,page_color,number_of_pages,file,print_cost,print_date,print_time};
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
		
		
		outputArea.setLayout(null);
		outputArea.add(btnShow);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(279, 149, 604, 341);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		outputArea.add(scrollPane_1);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				TableModel model =table.getModel();
				idpr=model.getValueAt(i,0).toString();
				 Name=model.getValueAt(i,1).toString();
				 Dep_Id=model.getValueAt(i,2).toString();
				 Doc_Type=model.getValueAt(i,3).toString();
				 Side=model.getValueAt(i,4).toString();
				 PgSize=model.getValueAt(i,5).toString();
				 color=model.getValueAt(i,6).toString();
				 pages=model.getValueAt(i,7).toString();
				 ffile=model.getValueAt(i,8).toString();
				 m=model.getValueAt(i,9).toString();
				 formatdate=model.getValueAt(i,10).toString();
				 formattime=model.getValueAt(i,11).toString();
				 
				
				
			}
		});
		scrollPane_1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		
		
		
		JButton btnClear = new JButton("Clear Display");
		btnClear.setBounds(50, 240, 192, 50);
		btnClear.setForeground(Color.PINK);
		btnClear.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 13));
		btnClear.setBackground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
//			private AbstractButton tblData;

			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}

});
		
		outputArea.add(btnClear);
		
		JButton appbtn = new JButton("Approve");
		appbtn.addActionListener(new ActionListener() {
			
			private Connection connection_pa;
			

			public void actionPerformed(ActionEvent e) {
				try {
					revalidate();
					repaint();
					table.setModel(new DefaultTableModel());
					connection_pa = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");
					 PreparedStatement statement_pa = connection_pa.prepareStatement("select  printer_id as printers_a from printer_details where availability='available' limit 1");
				        ResultSet resultSet_pa = statement_pa.executeQuery();
				        while (resultSet_pa.next()) {
				        
				             printer_a = resultSet_pa.getString(1);
				             System.out.print(printer_a);
				           
				            }
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}//Crating connection with database
				try {
					printer_count.setText(temps());
					revalidate();
					repaint();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				LocalDate mydate = LocalDate.now();
				DateTimeFormatter myformatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String formatdate_r=mydate.format(myformatdate);// Create a date object
			    System.out.println(formatdate);
			    
			    LocalTime myObjtime = LocalTime.now();
			    DateTimeFormatter myformattime = DateTimeFormatter.ofPattern("HH:mm:ss");
			    String formattime_r=myObjtime.format(myformattime);
			    System.out.println(formattime);
				 
				System.out.print(idpr+Dep_Id+formattime);
				
				String querys = "INSERT INTO approve_print_request values('" + idpr + "','" + Name + "','" + Dep_Id + "','" + Doc_Type + "','" +
                		Side + "','" +PgSize+ "','"+color+"','"+pages+"','"+m+"','"+ffile+"','"+printer_a+"','"+formatdate+"','"+formattime+"','"+formatdate_r+"','"+formattime_r+"','"+approved+"')";
				PreparedStatement statement;
				PreparedStatement statements;
				String delete ="delete from print_request where pr_id='"+idpr+"'";
				
				 Connection connection_pa;
				
			       
				
				try {
					statement = connection.prepareStatement(querys);
					 statement.executeUpdate();
					 statements = connection.prepareStatement(delete);
					 statements.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				String upadate_pr ="update printer_details set availability='not available' where printer_id='"+printer_a+"'";
				try {
					 PreparedStatement statement_up = connection.prepareStatement(upadate_pr);
					 statement_up.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		       
		       

				
				
			}	
		});
		temps();
		temp_p();
		appbtn.setBounds(50, 320, 192, 50);
		appbtn.setForeground(Color.GREEN);
		appbtn.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 13));
		appbtn.setBackground(Color.BLACK);
		outputArea.add(appbtn);
		
		JButton btnReject = new JButton("Reject");
		btnReject.setBounds(50, 403, 192, 50);
		btnReject.setForeground(Color.RED);
		btnReject.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 13));
		btnReject.setBackground(Color.BLACK);
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(idpr+Dep_Id+formattime);
				String querys = "INSERT INTO reject_print_request values('" + idpr + "','" + Name + "','" + Dep_Id + "','" + Doc_Type + "','" +
                		Side + "','" +PgSize+ "','"+color+"','"+pages+"','"+ffile+"','"+m+"','"+formatdate+"','"+formattime+"')";
				PreparedStatement statement;
				PreparedStatement statements;
				
				String delete ="delete from print_request where pr_id='"+idpr+"'";
				try {
					statement = connection.prepareStatement(querys);
					 statement.executeUpdate();
					 statements = connection.prepareStatement(delete);
					 statements.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
		       

				
				
			}	
		});
		outputArea.add(btnReject);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setBounds(28, 20, 230, 126);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Deekey\\Downloads\\Java Project\\Admin logopng.png"));
		outputArea.add(lblNewLabel);
		lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(224, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(50, 518, 833, 55);
		outputArea.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Write Custom Sql Command");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Montserrat Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 10, 222, 32);
		panel.add(lblNewLabel_1);
		
		sqlcmd = new JTextField();
		sqlcmd.setBounds(228, 10, 595, 35);
		panel.add(sqlcmd);
		sqlcmd.setColumns(10);
		
		JButton btnRun = new JButton("Run");
		btnRun.setForeground(new Color(255, 255, 0));
		btnRun.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 13));
		btnRun.setBackground(Color.BLACK);
		btnRun.setBounds(50, 591, 192, 50);
		outputArea.add(btnRun);
		JTextArea textArea = new JTextArea(10,20);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Montserrat", Font.BOLD, 15));
		textArea.setBounds(773, 604, 101, 25);
		outputArea.add(textArea);
		btnRun.addActionListener(new ActionListener() {
//			private AbstractButton tblData;

			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				String cmd=sqlcmd.getText();
				
				System.out.print(cmd);
			       try {
			            // Connect to the database
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");

			            // Create a statement
			            PreparedStatement stmt = conn.prepareStatement(cmd);

			            // Execute the input as a SQL query
			            ResultSet rs = stmt.executeQuery();

			            // Process the results
			            textArea.setText("");
			            while (rs.next()) {
			                // Add each row of the result set to the output area
			            	textArea.append(rs.getString(1) + "\n");
			            }

			            // Close the connection
			            conn.close();
			        } catch (SQLException ex) {
			            // Print any errors that occurred
			        	textArea.setToolTipText("Error: ");
			        }
			}

});
		

		JLabel prctext = new JLabel("Total Number Of Requests "+name);
		prctext.setFont(new Font("Tahoma", Font.BOLD, 13));
		prctext.setBounds(279, 108, 221, 13);
		outputArea.add(prctext);
		
		 printer_count = new JLabel(temps());
		printer_count.setFont(new Font("Tahoma", Font.BOLD, 13));
		printer_count.setBounds(653, 119, 221, 13);
		outputArea.add(printer_count);
		
		JLabel problems = new JLabel("Total Number Of Problems "+temp_p());
		problems.setFont(new Font("Tahoma", Font.BOLD, 13));
		problems.setBounds(279, 126, 273, 13);
		outputArea.add(problems);
		
		


	}
}
