package View;

import java.awt.EventQueue;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RateActivity {

	public int Aid;

	public int rating;
	public String check;
	public String rollNum;
	String check1;
	JFrame frame = new JFrame("RateActivity");
	private JPasswordField passwordField;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials

	   //static final String USER = "root";
	 //  static final String PASS = "root";

	   static final String USER = "root";
	   static final String PASS = "root";

	   Connection conn = null;
	   Statement stmt = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateActivity window = new RateActivity();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RateActivity() {
		initialize();
	}

	public RateActivity(int id) {
		Aid = id;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Rate Activity");

// 		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
// 		frame.getContentPane().setBackground(new Color(255, 250, 205));
// 		frame.setBounds(100, 100, 800, 800);

		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    frame.setSize(screenSize.width, screenSize.height);
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().setBackground(new Color(255, 250, 205));
		//frame.setBounds(100, 100, 800, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//roll number
		JEditorPane editorPaneRollNum = new JEditorPane();
		editorPaneRollNum.setFont(new Font("Dialog", Font.PLAIN, 14));
		editorPaneRollNum.setForeground(new Color(0, 0, 0));
		editorPaneRollNum.setBackground(Color.WHITE);
		editorPaneRollNum.setBounds(393, 62, 349, 28);
		frame.getContentPane().add(editorPaneRollNum);
		
		JLabel lblRollNum = new JLabel("Roll Number");
		lblRollNum.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRollNum.setBounds(52, 62, 142, 15);
		frame.getContentPane().add(lblRollNum);
		
		
		//password
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Serif", Font.PLAIN, 14));
		lblPass.setBounds(52, 123, 142, 15);
		frame.getContentPane().add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(393, 117, 345, 28);
		frame.getContentPane().add(passwordField);
		//passwordField.setEchoChar('*');

		
		JButton btnNewButton = new JButton("Rate");

// 		btnNewButton.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				rollNum = editorPaneRollNum.getText().toString();
				
				

		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				rollNum = editorPaneRollNum.getText().toString();
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

// 				      sql = "SELECT Aid from Enrolls where Pid = '" + rollNum + "'";
// 				      //System.out.println(sql);
// 				      ResultSet rs = stmt.executeQuery(sql);
// 				      if(!rs.next()) {
// 				    	  EventQueue.invokeLater(new Runnable() {
// 								public void run() {
// 									try {
// 										ErrorMessage window = new ErrorMessage();
// 										window.frame.setVisible(true);
// 									} catch (Exception e) {
// 										e.printStackTrace();
// 									}
// 								}
// 							});
// 				      }
// 				      else 
// 				    	  check1 = rs.getString("Aid");
// 				      rs.close();
// 				      stmt.close();
// 				      conn.close();
// 				   }catch(SQLException se){
// 				      //Handle errors for JDBC
// 				      se.printStackTrace();
// 				   }catch(Exception e2){
// 				      //Handle errors for Class.forName
// 				      e2.printStackTrace();
// 				   }finally{
// 				      //finally block used to close resources
// 				      try{
// 				         if(stmt!=null)
// 				            stmt.close();
// 				      }catch(SQLException se2){
// 				      }// nothing we can do
// 				      try{
// 				         if(conn!=null)
// 				            conn.close();
// 				      }catch(SQLException se){
// 				         se.printStackTrace();
// 				      }//end finally try
// 				   }

// 				if(Aid != Integer.parseInt(check1)) {
// 					EventQueue.invokeLater(new Runnable() {
// 						public void run() {
// 							try {
// 								ErrorMessage window = new ErrorMessage();
// 								window.frame.setVisible(true);
// 							} catch (Exception e) {
// 								e.printStackTrace();
// 							}
// 						}
// 					});
// 				}
				
				
				
				
				
				
				
// 				//String rating = editorPaneRating.getText().toString();
// 				String pass = new String(passwordField.getPassword());
// 				//System.out.println(rollNum);
// 				//System.out.println(pass);
// 				// checking for password in database
// 				try{
// 				      //STEP 2: Register JDBC driver
// 				      Class.forName("com.mysql.jdbc.Driver");

// 				      //STEP 3: Open a connection
// 				      System.out.println("Connecting to database...");
// 				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

// 				      //STEP 4: Execute a query
// 				      System.out.println("Creating statement...");
// 				      stmt = conn.createStatement();
// 				      String sql;
// 				      sql = "SELECT Password from Participant where Pid = '" + rollNum + "'";
// 				      //System.out.println(sql);
// 				      ResultSet rs = stmt.executeQuery(sql);
// 				      rs.next();
// 				      check = rs.getString("Password");

				      String s;
				      sql = "SELECT Aid from Enrolls where Pid = '" + rollNum + "'";
				      String pass = new String(passwordField.getPassword());
				      String query = "SELECT Password from Participant where Pid = '" + rollNum + "'";
				      ResultSet rs1 = stmt.executeQuery(query);
				      rs1.next();
				      String check2 = rs1.getString("Password");
				      if(!check2.equals(pass)) {
				    	  JOptionPane.showMessageDialog(frame,"NOt a Valid User");  
							return;
				      }
				
				      
				      ResultSet rs = stmt.executeQuery(sql);
				      
				   
				      
				      if(!rs.next()) {
				    	  JOptionPane.showMessageDialog(frame,"You are not enrolled for this activity");  
							return;
				      }
				      else {
				    	  System.out.println(check2);
				    	  String val = String.valueOf(Aid);
				    	  while(rs.next()) {
				    		  String check1 = String.valueOf(rs.getInt(1));
				    		  if(check1.equals(val)) {
				    			  JFrame frame = new JFrame();
				    			  JPanel panel = new JPanel();
							        StarRater starRater = new StarRater(5, 2, 1);
							        starRater.addStarListener(
							            new StarRater.StarListener()   {

							                public void handleSelection(int selection) {
							                    
							                	rating = selection;
							                	
												   try {  
												    
												      String sql;
												      PreparedStatement st=null;
												      System.out.println(Integer.toString(rating));
												      sql = "Update Enrolls set Rating = ? where Aid = ? and Pid = ?";
												      st=conn.prepareStatement(sql);
												      st.setInt(1, rating);
												      st.setInt(2, Aid);
												      st.setString(3, rollNum);
												      System.out.println(sql);
												      st.executeUpdate();
								                }catch(Exception se){
												      //Handle errors for JDBC
												      se.printStackTrace();
												  
												  }
													
												 

												   JOptionPane.showMessageDialog(frame,"Rating have been submitted successfully"); 
							                	
							                	

							                }
							            });
							        panel.add(starRater);
							        frame.getContentPane().add(panel);
							        frame.pack();
							        frame.setVisible(true);
							        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				    		  }
				    		  
				    	  }
				      }
				    	 // check1 = rs.getString("Aid");

				      rs.close();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e2){
				      //Handle errors for Class.forName
				      e2.printStackTrace();
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


// 				if(!check.equals(pass)) {
					
// 					EventQueue.invokeLater(new Runnable() {
// 						public void run() {
// 							try {
// 								ErrorMessage window = new ErrorMessage();
// 								window.frame.setVisible(true);
// 							} catch (Exception e) {
// 								e.printStackTrace();
// 							}
// 						}
// 					});
					
// 				}
// 				else {
// 					JFrame frame = new JFrame();
// 			        JPanel panel = new JPanel();
// 			        StarRater starRater = new StarRater(5, 2, 1);
// 			        starRater.addStarListener(
// 			            new StarRater.StarListener()   {

// 			                public void handleSelection(int selection) {
			                    
// 			                	rating = selection;
// 			                	try{
// 								      //STEP 2: Register JDBC driver
// 								      Class.forName("com.mysql.jdbc.Driver");

// 								      //STEP 3: Open a connection
// 								      System.out.println("Connecting to database...");
// 								      conn = DriverManager.getConnection(DB_URL,USER,PASS);

// 								      //STEP 4: Execute a query
// 								      System.out.println("Creating statement...");
// 								      stmt = conn.createStatement();
// 								      String sql;
// 								      PreparedStatement st=null;
// 								      System.out.println(Integer.toString(rating));
// 								      sql = "Update Enrolls set Rating = ? where Aid = ? and Pid = ?";
// 								      st=conn.prepareStatement(sql);
// 								      st.setInt(1, rating);
// 								      st.setInt(2, Aid);
// 								      st.setString(3, rollNum);
// 								      System.out.println(sql);
// 								      st.executeUpdate();
// 								      //rs.next();
// 								      //check = rs.getString("Password");
// 								      //rs.close();
// 								      stmt.close();
// 								      conn.close();
// 								   }catch(SQLException se){
// 								      //Handle errors for JDBC
// 								      se.printStackTrace();
// 								   }catch(Exception e2){
// 								      //Handle errors for Class.forName
// 								      e2.printStackTrace();
// 								   }finally{
// 								      //finally block used to close resources
// 								      try{
// 								         if(stmt!=null)
// 								            stmt.close();
// 								      }catch(SQLException se2){
// 								      }// nothing we can do
// 								      try{
// 								         if(conn!=null)
// 								            conn.close();
// 								      }catch(SQLException se){
// 								         se.printStackTrace();
// 								      }//end finally try
// 								   }


			                	
			                	

// 			                }
// 			            });
// 			        panel.add(starRater);
// 			        frame.getContentPane().add(panel);
// 			        frame.pack();
// 			        frame.setVisible(true);
// 			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        
			        
			        
			        
// 					//storing the rating now in database
			        
			        
			        
			        			     
			        
// 				}
				
				
				
				

				
				
								
// 			}
// 		});
// 		btnNewButton.setBounds(321, 264, 117, 25);
// 		frame.getContentPane().add(btnNewButton);
		
		
		

// 	}
// }

			}
		});
				
			btnNewButton.setBounds(321, 264, 117, 25);
			frame.getContentPane().add(btnNewButton);
		
			

			JMenuBar menuBar = new JMenuBar();
			//
//					      //create menus
					      JMenu ActivityMenu = new JMenu(" Activity");
//					      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//					      final JMenu pastMenu = new JMenu("Past Activity");
					       JMenu ParticipantMenu = new JMenu("My account");
					       JMenu AddMenu = new JMenu("Add Activity");
					       JMenu JudgeMenu = new JMenu("Judge Portal");
					       JMenu UpdateMenu = new JMenu("Update Activity");
					     
					      menuBar.add(ActivityMenu);
//					      menuBar.add(upcomingMenu);
//					      menuBar.add(pastMenu);       
					      menuBar.add(AddMenu);
					      menuBar.add(JudgeMenu);       
					      menuBar.add(UpdateMenu);
					      menuBar.add(ParticipantMenu);
					      //add menubar to the frame
					      frame.setJMenuBar(menuBar);
					      frame.setVisible(true);  
					    
					     // JMenuItem newMenuItem = new JMenuItem("New");
					      JMenuItem ActivityMenuItem = new JMenuItem("Current Activity");
					      MenuItemListener menuItemListener = new MenuItemListener();
					      ActivityMenuItem.setActionCommand("Current Activity");
					      ActivityMenuItem.addActionListener(menuItemListener);
					      ActivityMenu.add(ActivityMenuItem);
					      
					      JMenuItem ActivityMenuItem1 = new JMenuItem("Upcoming Activity");
					      
					      ActivityMenuItem1.setActionCommand("upcoming Activity");
					      ActivityMenuItem1.addActionListener(menuItemListener);
					      ActivityMenu.add(ActivityMenuItem1);
					      
					      JMenuItem ActivityMenuItem2 = new JMenuItem("Past Activity");
					      ActivityMenuItem2.setActionCommand("Past Activity");
					      ActivityMenuItem2.addActionListener(menuItemListener);
					      ActivityMenu.add(ActivityMenuItem2);
					      
					      JMenuItem AddMenuItem = new JMenuItem("open");
					      AddMenuItem.setActionCommand("Add Activity");
					      AddMenuItem.addActionListener(menuItemListener);
					      AddMenu.add(AddMenuItem);
					      
					      JMenuItem JudgeMenuItem = new JMenuItem("open");
					      JudgeMenuItem.setActionCommand("Judge");
					      JudgeMenuItem.addActionListener(menuItemListener);
					      JudgeMenu.add(JudgeMenuItem);
					      
					      JMenuItem UpdateMenuItem = new JMenuItem("open");
					      UpdateMenuItem.setActionCommand("Update Activity");
					      UpdateMenuItem.addActionListener(menuItemListener);
					      UpdateMenu.add(UpdateMenuItem);
					      
					      JMenuItem ActivityMenuItem3 = new JMenuItem("Login");
					      ActivityMenuItem3.setActionCommand("Login");
					      ActivityMenuItem3.addActionListener(menuItemListener);
					      ParticipantMenu.add(ActivityMenuItem3);
		

		
		
	
	}
	
	   
	   class MenuItemListener implements ActionListener {
		      public void actionPerformed(ActionEvent e) {    
		    	  if(e.getActionCommand().equals("Current Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									EventList window = new EventList();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  else if(e.getActionCommand().equals("upcoming Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									UpcomingEvent window = new UpcomingEvent();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  else if(e.getActionCommand().equals("Past Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									PastEvent window = new PastEvent();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  
		    	  else if(e.getActionCommand().equals("Add Activity")){
			    	  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									AuthorizedUser window = new AuthorizedUser(1);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  else if(e.getActionCommand().equals("Judge")){
		    		  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									JudgePortal window = new JudgePortal();
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  else if(e.getActionCommand().equals("Update Activity")){
		    		  EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									AuthorizedUser window = new AuthorizedUser(2);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
		    	  }
		    	  
		    	  else if(e.getActionCommand().equals("Login")){
		    		  EventQueue.invokeLater(new Runnable() {
		    				public void run() {
		    					try {
		    						Login window = new Login();
		    						window.frame.setVisible(true);
		    					} catch (Exception e) {
		    						e.printStackTrace();
	    					}
		    				}
		    			});
		    	  }
		      
		      }        
		   }
		}
	


