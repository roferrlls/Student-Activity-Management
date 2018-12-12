package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Judge;

public class JudgeDetailsController {
	static Statement stmt = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   static Connection conn = null;
	
	public static void insertDetails(JFrame frame,Judge jg,int Aid) {
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      Statement stmt1 = conn.createStatement();
		      Statement stmt2 = conn.createStatement();
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      String q2 = "select * from Judge where Email = '" + jg.getEmail() + "'";
		      ResultSet rs  =stmt2.executeQuery(q2);
		      String sql;
		      if(!rs.next()) {
			      sql = "insert into Judge values(' " + jg.getEmail() + "' , '" + jg.getName() + "' ," + jg.getPhone() + " ,'" + jg.getPass() + "')";
			      stmt.executeUpdate(sql);
		      }    
		      String query = "insert into Contains values('" + jg.getEmail() + "' ,"+ Aid + ")";
		      stmt1.executeUpdate(query);
		      stmt.close();
		      stmt1.close();
		      stmt2.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      
		      
		   }catch(Exception ee){
		      //Handle errors for Class.forName
//		      ee.printStackTrace();
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
//		         se.printStackTrace();
		      }//end finally try
		   }
		JOptionPane.showMessageDialog(frame,"Judge Added Successfully");
	}

}
