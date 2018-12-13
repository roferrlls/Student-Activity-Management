import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import java.awt.Color;
import java.awt.Dimension;


public class PastEvent {

	public JFrame frame;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/s";

	   //  Database credentials
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
	   Connection conn = null;
	   Statement stmt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//PastEvent  swingMenuDemo = new PastEvent();     
	     // swingMenuDemo.showMenuDemo();
		
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

	/**
	 * Create the application.
	 */
	public PastEvent() {
		prepareGUI();
	}

	
	
	
	private void prepareGUI(){
	
	      frame = new JFrame("EventList");
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    frame.setSize(screenSize.width, screenSize.height);
			//frame.setBounds(100, 100, 800, 800);
			DefaultListModel<String> l1 = new DefaultListModel<>();   
	        try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);


// 		      //STEP 4: Execute a query
// 		      System.out.println("Creating statement...");
// 		      stmt = conn.createStatement();
// 		      String sql;
// 		      sql = "SELECT * from Activity where Date < CURDATE()";
// 		      ResultSet rs = stmt.executeQuery(sql);
// 		      while(rs.next()){
// 			         //Retrieve by column name
// 			        String name = rs.getString("Name");
// 			        int id = rs.getInt("Aid");
// 			         System.out.println( id);
// 			         String str = "(" + id + ")" + " " + name;
// 			         l1.addElement(str);
			       
// 			      }
// 		      rs.close();
// 		      stmt.close();
// 		      conn.close();
// 		   }catch(SQLException se){
// 		      //Handle errors for JDBC
// 		      se.printStackTrace();
// 		   }catch(Exception e){
// 		      //Handle errors for Class.forName
// 		      e.printStackTrace();
// 		   }finally{
// 		      //finally block used to close resources
// 		      try{
// 		         if(stmt!=null)
// 		            stmt.close();
// 		      }catch(SQLException se2){
// 		      }// nothing we can do
// 		      try{
// 		         if(conn!=null)
// 		            conn.close();
// 		      }catch(SQLException se){
// 		         se.printStackTrace();
// 		      }//end finally try
// 		   }
//         JList<String> list = new JList<>(l1);  
//         list.setBackground(new Color(255, 250, 205));
//         list.setBounds(12,34, 721,510);  
//         frame.getContentPane().add(list);  
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		frame.getContentPane().setLayout(null);
		
// 		JButton btnViewDetails = new JButton("VIEW DETAILS");
// 		btnViewDetails.setBackground(new Color(135, 206, 235));
// 		btnViewDetails.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent arg0) {
// 				EventQueue.invokeLater(new Runnable() {
// 					public void run() {
// 						try {
// 							String dest= list.getSelectedValue();
// 							String id = "";
// 							int i =1;
// 							while(dest.charAt(i) != ')') {
// 								id += dest.charAt(i);
// 								i++;

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * from Activity where Date < CURDATE()";
			      ResultSet rs = stmt.executeQuery(sql);
			      while(rs.next()){
				         //Retrieve by column name
				        String name = rs.getString("Name");
				        int id = rs.getInt("Aid");
				         System.out.println( id);
				         String str = "(" + id + ")" + " " + name;
				         l1.addElement(str);
				       
				      }
			      rs.close();
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
	        JList<String> list = new JList<>(l1);  
	        list.setBackground(new Color(255, 192, 203));
	        list.setOpaque(false);
	        list.setBounds(0,12, 1293,510);  
	        frame.getContentPane().add(list);  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JButton btnViewDetails = new JButton("VIEW DETAILS");
			btnViewDetails.setBackground(new Color(135, 206, 235));
			btnViewDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								String dest= list.getSelectedValue();
								String id = "";
								int i =1;
								while(dest.charAt(i) != ')') {
									id += dest.charAt(i);
									i++;
								}
								int val = Integer.parseInt(id);
								ActivityProfile window = new ActivityProfile(val,2);
								
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();

							}
						}

// 					}
// 				});
// 			}
// 		});	
// 		btnViewDetails.setBounds(204, 625, 273, 43);
// 		frame.getContentPane().add(btnViewDetails);
// 		JButton btnNewButton = new JButton("BACK");
// 		btnNewButton.setBackground(new Color(135, 206, 235));
// 		btnNewButton.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				frame.dispose();
// 			}
// 		});
// 		btnNewButton.setBounds(202, 677, 275, 43);
// 		frame.getContentPane().add(btnNewButton);
// 	}

					});
				}
			});	
			btnViewDetails.setBounds(208, 546, 273, 43);
			frame.getContentPane().add(btnViewDetails);
			JButton btnNewButton = new JButton("BACK");
			btnNewButton.setBackground(new Color(135, 206, 235));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnNewButton.setBounds(705, 534, 275, 43);
			frame.getContentPane().add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(0, 0, 1317, 707);
			frame.getContentPane().add(lblNewLabel);
			Image img=new ImageIcon(this.getClass().getResource("/img2.jpg")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			lblNewLabel.setSize(screenSize.width, screenSize.height-100);
			//Image img=new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
			
			
			
			final JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(Color.WHITE);
			menuBar.setBackground(Color.BLACK);
			menuBar.setPreferredSize(new Dimension(0, 50));
			//
//				      //create menus
				      JMenu ActivityMenu = new JMenu(" Activity");
				      ActivityMenu.setForeground(Color.WHITE);
//				      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//				      final JMenu pastMenu = new JMenu("Past Activity");
				      final JMenu ParticipantMenu = new JMenu("My account");
				      ParticipantMenu.setForeground(Color.WHITE);
				      final JMenu AddMenu = new JMenu("Add Activity");
				      AddMenu.setForeground(Color.WHITE);
				      final JMenu JudgeMenu = new JMenu("Judge Portal");
				      JudgeMenu.setForeground(Color.WHITE);
				      final JMenu UpdateMenu = new JMenu("Update Activity");
				      UpdateMenu.setForeground(Color.WHITE);
				      menuBar.add(ActivityMenu);
//				      menuBar.add(upcomingMenu);
//				      menuBar.add(pastMenu);       
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
 
	
	
	/**
	 * Initialize the contents of the frame.
	 */


}
