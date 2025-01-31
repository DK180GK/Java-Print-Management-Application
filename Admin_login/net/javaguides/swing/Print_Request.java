package net.javaguides.swing;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class Print_Request extends JFrame {
	private String nameget;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField numbpg;
    private JTextField numb;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JTextField filefield;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private String s="";
    private String c="";
    private String p="";
    private String ffile="";
    private String name="";
    private JButton chosebtn; 
    private ActionListener ab;
    private  JLabel proc;
    private String filew="";
    private File filex;
    private int pc;
    JRadioButton option3;
    JRadioButton option4;
    JComboBox<String> cb;
    Statement statement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Print_Request frame = new Print_Request();
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
    public String temp() {

        Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");

			statement = connection.createStatement();

        String query = "select count(*) as counts from print_request";
        ResultSet resultSet;
			resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

        this.name = resultSet.getString("counts");
        return this.name;
       
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//executing query and storing result in ResultSet
		return "";
    }
    public Print_Request() throws SQLException {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Print Request");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        lblNewUserRegister.setBounds(362, 32, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Full Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 132, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Dep_Id");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 223, 110, 29);
        contentPane.add(lblNewLabel);
        lastname = new JTextField(UserLogin.depname);
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 215, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);
        
        

        JLabel lblEmailAddress = new JLabel("Document");
        JLabel lblEmailAddresss = new JLabel("Type");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddresss.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 304, 124, 36);
        lblEmailAddresss.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);
        contentPane.add(lblEmailAddresss);
        
        Connection connectionf = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "12345");//Crating connection with database
        statement = connectionf.createStatement();//crating statement object
        String queryf = "select name as nameget from fac_ac where department_id='"+UserLogin.depname+"'";
        ResultSet resultSetn = statement.executeQuery(queryf);//executing query and storing result in ResultSet
        while (resultSetn.next()) {

        nameget = resultSetn.getString("nameget");
        System.out.print(nameget)
;       
        }
        
        
        firstname = new JTextField(nameget);
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 131, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

       

        
 
        JRadioButton option5 = new JRadioButton("Personal");
        JRadioButton option6 = new JRadioButton("Official"); 
        option5.setActionCommand("Option 1");
        option6.setActionCommand("Option 2");
        option5.setBounds(214, 300, 228, 50);    
        option6.setBounds(214, 330, 228, 50);
        add(option5);
        add(option6);
        
        ButtonGroup group = new ButtonGroup();
        group.add(option5);
        group.add(option6);
        option5.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
      
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   
                }
            }
        });


        option6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                  
                  
                }
            }
        });
        
        
        JRadioButton option1 = new JRadioButton("Single Side");
        JRadioButton option2 = new JRadioButton("Double Side"); 
        option1.setActionCommand("Single Side");
        option2.setActionCommand("Double Side");
        option1.setBounds(532, 139, 99, 29);    
        option2.setBounds(700, 139, 99, 29);
        add(option1);
        add(option2);
        
        
     
        
        ButtonGroup groups = new ButtonGroup();
        groups.add(option1);
        groups.add(option2);
        option1.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
      
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   
                }
            }
        });


        option2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                  
                  
                }
            }
        });
     
        JLabel lbNewLabel = new JLabel("Page_size");
        lbNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNewLabel.setBounds(540, 199, 110, 29);
        contentPane.add(lbNewLabel);
        String[] choices = { "A3","A4", "A5","B1","B2","C1"};

        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        add(cb);
        cb.setBounds(700,199,99,24);
        JButton btn = new JButton("OK");
        btn.setBounds(820,199,99,24);
        add(btn);

        JRadioButton option3 = new JRadioButton("Black & White");
        JRadioButton option4 = new JRadioButton("Colour");    
        option3.setBounds(532, 270, 99, 29);    
        option4.setBounds(700, 270, 99, 29);
        add(option3);
        add(option4);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(option3);
        group1.add(option4);
        option3.addItemListener((ItemListener) new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Option 3 selected");
                }
            }
        });

        option4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Option 4 selected");
                }
            }
        });
        
        
//        JTextField filePath = new JTextField();
//        filePath.setBounds(532, 344, 330, 25);
//        add(filePath);
//
//        JButton openButton = new JButton("Open");
//        openButton.setBounds(864, 344, 70, 25);
//		add(openButton);
		
//		JLabel numberofpages = new JLabel("Number Of Pages");
//		numberofpages.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		numberofpages.setBounds(532, 344, 110, 29);
//        add(lblNewLabel);
//        
//        numb = new JTextField();
//        numb.setFont(new Font("Tahoma", Font.PLAIN, 32));
//        numb.setBounds(532, 344, 110, 29);
//        numb.add(numberofpages);
//        numb.setColumns(10);
        
        numbpg = new JTextField();
        numbpg.setFont(new Font("Tahoma", Font.PLAIN, 32));
        numbpg.setBounds(650, 340, 100, 30);
        contentPane.add(numbpg);
        numbpg.setColumns(10);

        JLabel lblpgnum = new JLabel("Number OF");
        JLabel lblpgnums = new JLabel("Pages");
        lblpgnum.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpgnums.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblpgnum.setBounds(532, 324, 124, 36);
        lblpgnums.setBounds(532, 346, 124, 36);
        contentPane.add(lblpgnum);
        contentPane.add(lblpgnums);
        
        JLabel process = new JLabel("Number of");
        JLabel numprocess = new JLabel("Process");
        process.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        numprocess.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        process.setBounds(800, 330, 124, 26);
        process.setForeground(Color.red);
        numprocess.setForeground(Color.red);
        numprocess.setBounds(800, 350, 124, 26);
        contentPane.add(process);
        contentPane.add(numprocess);
        
        temp();

       proc = new JLabel(temp());
       proc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
       proc.setBounds(900, 335, 124, 26);
       proc.setForeground(Color.red);
       contentPane.add(proc);
       
       
       JLabel file = new JLabel("Choose file");
       file.setFont(new Font("Tahoma", Font.PLAIN, 20));
       file.setBounds(50, 460, 110, 29);
       contentPane.add(file);
       contentPane.add(lastname);
       
       
       
//       JLabel filename = new JLabel("filename");
//       filename.setFont(new Font("Tahoma", Font.PLAIN, 20));
//       filename.setBounds(100, 460, 110, 29);
//       contentPane.add(filename);
       
       chosebtn = new JButton("Choose");
       chosebtn.setBounds(480, 460, 80, 25);
       contentPane.add(chosebtn);
       
       temp();
       chosebtn.addActionListener(new ActionListener() { 
//    	   public void actionPerformed2(ActionEvent e) {
//
////    		  System.out.print("Funda");
////
////    		  JFileChooser fileChooser = new JFileChooser();
////    		  System.out.print(fileChooser.showOpenDialog(null));
////    		  int response = fileChooser.showOpenDialog(null);
////    		  if(response ==JFileChooser.APPROVE_OPTION) {
////    			  File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
////    			  System.out.print(file);
////    		  }
//       
//    	  }

		@Override
		public void actionPerformed(ActionEvent e) {
			 JFileChooser fileChooser = new JFileChooser();
   		  System.out.print(fileChooser.showOpenDialog(null));
   		  int response = fileChooser.showOpenDialog(null);
   		  if(response ==JFileChooser.APPROVE_OPTION) {
   			  File filex = new File(fileChooser.getSelectedFile().getAbsolutePath());
   			
   			Path path = filex.toPath();
   			Path fileName = path.getFileName();
   			ffile =fileName.toString();
   			       
   	    
			// TODO Auto-generated method stub
			
		}
   		filefield = new JTextField(ffile);
	       filefield.setFont(new Font("Tahoma", Font.PLAIN, 12));
	       filefield.setBounds(210, 460, 280, 25);
	       filefield.setColumns(10);
   		add(filefield);
    		  
    	  }
		
       }
       
       );
       JTextField filefieldtemp = new JTextField(ffile);
       filefieldtemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
       filefieldtemp.setBounds(210, 460, 280, 25);
       filefieldtemp.setColumns(10);
		add(filefieldtemp);
       
       
   
	
       
       

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
				System.out.println(name);

                    if (option3.isSelected()) {
                 	   c = "Black and White";
                    }
                    else if(option4.isSelected()) {
                 	   c = "Color";
                 	   
                    }
                    if (option1.isSelected()) {
                  	   s = "Personal";
                     }
                     else if(option2.isSelected()) {
                  	   s = " Official";
                     }
                    
					if (option5.isSelected()) {
                   	   p = "SingleSide";
                      }
                      else if(option6.isSelected()) {
                   	   p = "DoubleSide";
                      }
					LocalDate mydate = LocalDate.now();
					DateTimeFormatter myformatdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String formatdate=mydate.format(myformatdate);// Create a date object
				    System.out.println(formatdate);
				    
				    LocalTime myObjtime = LocalTime.now();
				    DateTimeFormatter myformattime = DateTimeFormatter.ofPattern("HH:mm:ss");
				    String formattime=myObjtime.format(myformattime);
				    System.out.println(formattime);
				    
                
				   pc=Integer.parseInt(name);  
				    System.out.print(pc);
            
                int pages=Integer.parseInt(numbpg.getText());
                String Name = nameget;
                String Dep_Id = UserLogin.depname;
                String Doc_Type = s;
                String Side = p;
                String PgSize =(String) (cb.getSelectedItem());
                String Color = c;
//                String files="thund.pdf";
            
//                System.out.print(Dep_Id);
//                System.out.print(Doc_Type);
//                System.out.print(Side);
//                System.out.print(PgSize);
//                System.out.print(Color);
                int costofpages = 0;
                System.out.println(Side);
                System.out.println(Color);
                System.out.println(PgSize);
                if (Side=="SingleSide" && Color=="Black and White"&& PgSize=="A4" ) {
                costofpages = pages*2;
                }
                if (Side=="SingleSide" && Color=="Color" && PgSize=="A4") {
                    costofpages = pages*5;
                    }
                if (Side=="DoubleSide" && Color=="Color" && PgSize=="A4") {
                    costofpages = pages*4;
                    }
                if (Side=="DoubleSide" && Color=="Black and White" && PgSize=="A4") {
                    costofpages = pages*3;
                    }
                if (Side=="SingleSide" && Color=="Black and White" && PgSize=="A3") {
                    costofpages = pages*5;
                    }
                if (Side=="DoubleSide" && Color=="Black and White" && PgSize=="A3") {
                    costofpages = pages*8;}
                if (Side=="DoubleSide" && Color=="Color" && PgSize=="A3") {
                        costofpages = pages*7;
                    }
                if (Side=="SingleSide" && Color=="Color" && PgSize=="A3") {
                    costofpages = pages*8;
                    }
                if (Side=="SingleSide" && Color=="Black and White" &&( PgSize=="A5" || PgSize=="B1" || PgSize=="B2" || PgSize=="C1")) {
                    costofpages = pages*2;
                    }
                if (Side=="SingleSide" && Color=="Color" &&( PgSize=="A5" || PgSize=="B1" || PgSize=="B2" || PgSize=="C1")) {
                    costofpages = pages*3;
                    }
                if (Side=="DoubleSide" && Color=="Color" &&( PgSize=="A5" || PgSize=="B1" || PgSize=="B2" || PgSize=="C1")) {
                    costofpages = pages*5;
                    }
                if (Side=="DoubleSide" && Color=="Black and White" &&( PgSize=="A5" || PgSize=="B1" || PgSize=="B2" || PgSize=="C1")) {
                    costofpages = pages*3;
                    }
                System.out.println(costofpages);
     
                    int m=costofpages;
                
             
                    String msg = "" + Name;
                    msg += " \n";
                
                
                
                if (Name!="") {
                
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root","12345");
                    if (Name==null || Dep_Id==null || Doc_Type==null || Side==null || PgSize==null ||pages==0 || ffile==null || Color==null) {
                    	
                    	JOptionPane.showMessageDialog(btnNewButton, "Plese fill the form correctly");
                    }
                    
                    String query = "INSERT INTO print_request(name,dep_id,doc_type,page_side,page_size,page_color,number_of_pages,file,print_cost,print_date,print_time) values('" + Name + "','" + Dep_Id + "','" + Doc_Type + "','" +
                    		Side + "','" +PgSize+ "','"+Color+"','"+pages+"','"+ffile+"','"+m+"','"+formatdate+"','"+formattime+"')";
//                    System.out.print(costofpages);
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (Name=="" || Dep_Id=="" || Doc_Type=="" || Side=="" || PgSize=="" ||pages==0 || ffile=="" || m==0 ) {
                    	
                    	JOptionPane.showMessageDialog(btnNewButton, "Plese fill the form correctly");
                    }
                    
                    else if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else if(pc>=5) {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Ok, " + msg + "Your Printing Request is pendding for approvel");
                    }else if(pc<5) {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Ok, " + msg + "Your Printing Request is given for approvel");
                        }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
				 proc.setText(temp());
				 contentPane.revalidate();
				 contentPane.repaint();
			}

				// TODO Auto-generated method stub
				
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(630, 447, 259, 74);
        contentPane.add(btnNewButton);
        getContentPane().setBackground(Color.pink);
        
    }
}