package net.javaguides.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class statusofnotapproved extends JFrame {

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
					statusofnotapproved frame = new statusofnotapproved();
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
	public statusofnotapproved() throws SQLException {
		setTitle("Request Status");
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
					PreparedStatement st = con.prepareStatement("select * from print_request where dep_id='"+dep_id+"'");
					
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
						file=rs.getString(9);
						print_cost=rs.getString(10);
						requested_date=rs.getString(11);
						requested_time=rs.getString(12);
						
					
						String[] row= {prid,name,depid,doc_type,page_side,page_size,page_color,number_of_pages,
								file,print_cost,requested_date,requested_time};
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
				String delete ="delete from print_request where pr_id='"+prid+"'";
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
				System.out.print(status);
				
			}
			
		});
		scrollPane.setViewportView(table);
		 request = new JButton("Show not approved Request");
		 request.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		request.setFont(new Font("Tahoma", Font.BOLD, 15));
		request.setBackground(SystemColor.inactiveCaptionBorder);
		request.setBounds(408, 281, 282, 38);
		request.setVisible(false);
		panel.add(request);
		
		
		
	}
}

