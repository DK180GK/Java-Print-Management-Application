package net.javaguides.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class statusandmore extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String prid;
	private String status;
	private JButton request;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statusandmore frame = new statusandmore();
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
	public statusandmore() throws SQLException {
		
		setTitle("Status");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Deekey\\Downloads\\Java Project\\main_logo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1123, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 1099, 334);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Display Request");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel());
				try {
					String dep_id = UserLogin.depname;
					Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
	                        "root", "12345");
					PreparedStatement st = con.prepareStatement("select * from approve_print_request where dep_id='"+dep_id+"'");
					
					ResultSet rs=st.executeQuery();
					ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					 
					String name,depid,doc_type,page_side,page_size,page_color,number_of_pages,print_cost,
					file,printer_id,approve_date,approve_time,requested_date,requested_time;
					while(rs.next()) {
						prid=rs.getString(1);
						name=rs.getString(2);
						depid=rs.getString(3);
						doc_type=rs.getString(4);
						page_side=rs.getString(5);
						page_size=rs.getString(6);
						page_color=rs.getString(7);
						number_of_pages=rs.getString(8);
						print_cost=rs.getString(9);
						file=rs.getString(10);
						printer_id=rs.getString(11);
						approve_date=rs.getString(12);
						approve_time=rs.getString(13);
						requested_date=rs.getString(14);
						requested_time=rs.getString(15);
						status=rs.getString(16);
						
					
						String[] row= {prid,name,depid,doc_type,page_side,page_size,page_color,number_of_pages,print_cost,
								file,printer_id,approve_date,approve_time,requested_date,requested_time,status};
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
		btnNewButton.setBackground(SystemColor.text);
		btnNewButton.setBounds(10, 10, 139, 21);
		panel.add(btnNewButton);
		
		JButton btnClearIt = new JButton("Clear page");
		btnClearIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());

			}
		});
		btnClearIt.setBackground(new Color(255, 255, 255));
		btnClearIt.setBounds(159, 10, 106, 21);
		panel.add(btnClearIt);
		
		JButton btnNewButton_2 = new JButton("Cancel Request");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delete ="delete from approve_print_request where pr_id='"+prid+"'";
				
				
				
			    if(status!="marked")  { 
				
				try {
					Connection conpa =  DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo",
	                        "root", "12345");
					 PreparedStatement statements = conpa.prepareStatement(delete);
					 statements.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    }
			    
			    else if(status=="marked"){
			    	JOptionPane.showMessageDialog(btnNewButton, "Iteam send to delivery,Contact admin");
			    }
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_2.setBounds(923, 281, 166, 38);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 1079, 225);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TableModel models = table.getModel();
				int i=table.getSelectedRow();
				 String name_bg = models.getValueAt(i,0).toString();
				 String status = models.getValueAt(i,15).toString();
				System.out.print(status);
				
			}
			
		});
		scrollPane.setViewportView(table);
		 request = new JButton("Show not approved Request");
		 request.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					statusofnotapproved frame = new statusofnotapproved();
					frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 		
		 	}
		 });
		request.setFont(new Font("Tahoma", Font.BOLD, 15));
		request.setBackground(SystemColor.inactiveCaptionBorder);
		request.setBounds(408, 281, 282, 38);
		request.setVisible(false);
		panel.add(request);
		
		Connection connectionf = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
        Statement statement_a = connectionf.createStatement();//crating statement object
        String queryf = "select count(*) as nameget from print_request where dep_id='"+UserLogin.depname+"'";
        ResultSet resultSetn = statement_a.executeQuery(queryf);//executing query and storing result in ResultSet
        while (resultSetn.next()) {

        String nameget = resultSetn.getString("nameget");
        int i=Integer.parseInt(nameget);  
        
        if(i!=0) {
        	request.setVisible(true);
        	System.out.print(nameget);
        	
        	
        	
        }
;       
        }
		
		
	}
}
