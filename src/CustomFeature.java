import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CustomFeature {

	public JFrame frame;
	public int Aid  ;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement stmt1 = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CustomFeature window = new CustomFeature(11);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public CustomFeature(int val) {
		Aid=val;
		System.out.println(Aid);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(209, 24, 106, 21);
		frame.getContentPane().add(editorPane);
		
		JLabel lblNewLabel = new JLabel("Constaint");
		lblNewLabel.setBounds(30, 30, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		String[] val= {"String","Integer"};
		JComboBox comboBox = new JComboBox(val);
		comboBox.setBounds(209, 67, 116, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Data Type");
		lblNewLabel_1.setBounds(30, 72, 116, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Value");
		lblNewLabel_2.setBounds(30, 135, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(209, 121, 106, 21);
		frame.getContentPane().add(editorPane_1);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String constraint = editorPane.getText().toString();
				if(constraint.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Name field is empty");  
					return;
				}
				String datatype = String.valueOf(comboBox.getSelectedItem());
				if(datatype=="Integer")
				{
					datatype="int";
				}
				else
				{
					datatype="VARCHAR(100)";
				}
				String value = editorPane_1.getText().toString();
				if(value.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Name field is empty");  
					return;
				}
				 try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      stmt = conn.createStatement();
				      String sql;
				      System.out.println(constraint + " "  +datatype);
				      sql = "alter table Activity add " +constraint+ " " + datatype;
				      stmt.execute(sql);
				      System.out.println(constraint + " "  +Aid);
				      sql="update Activity set " + constraint + " = (?) where Aid = (?)";
				  
				      stmt1 = conn.prepareStatement(sql);
				      if(datatype=="int")
				      {
				    	  int num = Integer.parseInt(value);
				    	  stmt1.setInt(1,num);
					      stmt1.setInt(2, Aid);
				      }
				      else
				      {
				    	  stmt1.setString(1,value);
					      stmt1.setInt(2, Aid);
				      }
				      stmt1.executeUpdate();
				      stmt1.close();
				      stmt.close();
				      conn.close();

				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception ee){
				      //Handle errors for Class.forName
				      ee.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }
				 JOptionPane.showMessageDialog(frame,"Submited successfully");
					editorPane.setText("");
					editorPane_1.setText("");
					
			}
		});
		btnSubmit.setBounds(129, 194, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}