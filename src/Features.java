import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.Color;

public class Features implements ActionListener{

	public JFrame frame;
	public static int Aid;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   JComboBox comboBox;
	   String value = "";
	   public String x;
	   JLabel lblNewLabel;
	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement stmt1 = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
				Features window = new Features(13);
				window.frame.setVisible(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Features(int val) {
		Aid = val+1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(216, 191, 216));
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] val = new String[100];
		
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String sql;
		      sql = "select distinct column_name from information_schema.columns where table_name='Activity'";
		      int count = 0;
		      int j = 0;
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()) {
		    	  count++;
		    	  String str = rs.getString(1);
		    	  if(count > 12) {
		    		  val[j] = str;
		    		  j++;
		    	  }
		    		  
		      }
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
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
		comboBox = new JComboBox(val);
		comboBox.setBounds(178, 38, 257, 24);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(this);
		
		
		
		JButton btnAddCustomFeatures = new JButton("ADD CUSTOM FEATURES");
		btnAddCustomFeatures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CustomFeature window = new CustomFeature(Aid);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAddCustomFeatures.setBounds(178, 433, 239, 25);
		frame.getContentPane().add(btnAddCustomFeatures);
		x="Seats";
		
		lblNewLabel = new JLabel("Seats");
		lblNewLabel.setBounds(50, 131, 143, 85);
		frame.getContentPane().add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(269, 122, 106, 24);
		frame.getContentPane().add(editorPane);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = editorPane.getText().toString();
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
				      String sql1;
				      sql1="select data_type from information_schema.columns where table_name='Activity' and column_name = '" + x+"'";      
				      System.out.println(x);
				      //stmt1.setString(2,x);
				      ResultSet rs = stmt.executeQuery(sql1);
				      String datatype = "";
				      while(rs.next()) {
				    	  datatype = rs.getString(1);
				      }
				      System.out.println(datatype);
				      sql = "update Activity set " +x+" = (?) where Aid = (?)";
				      
				      stmt1 = conn.prepareStatement(sql);
				      if(datatype=="int")
				      {
				    	  try {
					    	  int num = Integer.parseInt(value);
					    	  stmt1.setInt(1,num);
						      stmt1.setInt(2, Aid);
				    	  }catch(Exception ee) {
				    		  JOptionPane.showMessageDialog(frame,"Enter integer value please");  
								return;
				    	  }
				      }
				      else
				      {
				    	  stmt1.setString(1,value);
					      stmt1.setInt(2, Aid);
				      }
				      stmt1.executeUpdate();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
					   JOptionPane.showMessageDialog(frame,"Enter integer value please");  
				      se.printStackTrace();
				      return;
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
				
			}
				
		});
		btnNewButton.setBounds(508, 126, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		x = String.valueOf(comboBox.getSelectedItem());
		System.out.println(x);
		lblNewLabel.setText(x);		
		
		
	}
}
