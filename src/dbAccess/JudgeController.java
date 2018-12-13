package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Contains;
import Model.Judge;

public class JudgeController {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";
	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   static Connection conn = null;
	   static Statement stmt = null;
	   PreparedStatement stmt1 = null;
	   
	   public static void insertJudgeDtail(Judge jg,Contains cn) {
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
			      String sql,query;
			      Boolean v=rs.next();
			      if(!v) {
				      sql = "insert into Judge values('" + jg.getEmail() + "' , '" + jg.getName() + "' ," + jg.getPhone() + " ,'" + jg.getPass() + "')";
				      stmt.executeUpdate(sql);
				      System.out.println(" IN CONTROLLER " + cn.getAid());
				      query = "insert into Contains values('" + cn.getJemail() + "' ,"+ cn.getAid() + ")";
				      
			      }
			      else
			      {
			    	  query = "insert into Contains values('" + cn.getJemail() + "' ,"+ cn.getAid() + ")";
			    	  
			      }
			      
			      stmt1.executeUpdate(query);
			      stmt.close();
			      stmt1.close();
			      stmt2.close();
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
	   }
	
}
