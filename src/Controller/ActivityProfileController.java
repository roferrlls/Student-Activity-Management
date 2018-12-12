package Controller;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Activity;
import View.*;

public class ActivityProfileController {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   static Connection conn = null;
		public static void checkForDeadLine(JFrame frame,int id) {
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						//STEP 2: Register JDBC driver
					      Class.forName("com.mysql.jdbc.Driver");
	
					      //STEP 3: Open a connection
					      System.out.println("Connecting to database...");
					      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
					      //STEP 4: Execute a query
					      System.out.println("Creating statement...");
						String sql="select * from Activity where Aid = "+id;
						Statement st=conn.createStatement();
						ResultSet rs=st.executeQuery(sql);
						rs.next();
						Date dt=rs.getDate("Deadline");
						Date currd=new Date();
						System.out.println(dt);
	
						System.out.println(currd);
						if(currd.after(dt))
						{
							JOptionPane.showMessageDialog(frame,"Registrations Closed!");  
	
						}
						else
						{	
							EnterRoll window = new EnterRoll(id);
							window.frame.setVisible(true);
						}
					} catch(SQLException se){
					      //Handle errors for JDBC
					      se.printStackTrace();
					   }catch(Exception e){
					      //Handle errors for Class.forName
					      e.printStackTrace();
					   }finally{
					      //finally block used to close resources
					      
					      try{
					         if(conn!=null)
					            conn.close();
					      }catch(SQLException se){
					         se.printStackTrace();
					      }//end finally try
					   }
				}
			});
		}
		
		public static Activity getDetails(int id) {
			 ResultSet rs = null;
			 PreparedStatement stmt = null;
			 Activity activity = null;
			try{
				
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			     
			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String query = "select * from Activity where Aid = "  + "?";
			      stmt = conn.prepareStatement(query);
			      
			      stmt.setInt(1, id);
			      rs = stmt.executeQuery();
			      while(rs.next()){
				         //Retrieve by column name
			    	  	 
				         String name = rs.getString("Name");
				         String venue = rs.getString("Venue");
				         String date=rs.getString("Date");
				         String time=rs.getString("Time");
				         String ex_aud=rs.getString("Expected_Audience");
				         String contact=rs.getString("Contact_Details");
				         String desc=rs.getString("Description");
				         String deadl = rs.getString("Deadline");
				         System.out.println(name + " " + venue );
				         activity =new Activity(name,time, date, venue, desc, ex_aud, "",
				     			"", contact, deadl);
				         
				         
				         
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
			return activity;
			
			
		}
		
		public static String getRating(int id) {
			float calcRating = 0;
		      int cnt = 0;
		      PreparedStatement stmt = null;
			try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String query = "select Rating from Enrolls where Aid = "  + "?";
			      stmt = conn.prepareStatement(query);
			      
			      stmt.setInt(1, id);
			      ResultSet rs = stmt.executeQuery();
			      
			      while(rs.next()){
			    	  int temp = rs.getInt("Rating");
				      	 calcRating  += temp;
				      	 if(temp != 0) {
				      		 cnt++;
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
				return (Float.toString(calcRating/cnt));
		}
}

