package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	   static final String USER = "kritika";
	   static final String PASS = "lnmiit";
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
		frame.getContentPane().setBackground(new Color(255, 192, 203));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(751, 24, 260, 40);
		frame.getContentPane().add(editorPane);
		
		JLabel lblNewLabel = new JLabel("Constaint");
		lblNewLabel.setBounds(431, 30, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		String[] val= {"String","Integer"};
		JComboBox comboBox = new JComboBox(val);
		comboBox.setBounds(751, 103, 260, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Data Type");
		lblNewLabel_1.setBounds(431, 108, 116, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Value");
		lblNewLabel_2.setBounds(431, 194, 70, 15);
		frame.getContentPane().add(lblNewLabel_2);
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(751, 194, 260, 40);
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
					datatype="VARCHAR(50)";
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
				      sql = "alter table Activity add " +constraint+ " " +datatype;
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
		btnSubmit.setBounds(592, 310, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		
		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setPreferredSize(new Dimension(0, 50));
		//
//			      //create menus
			      JMenu ActivityMenu = new JMenu(" Activity");
			      ActivityMenu.setForeground(Color.WHITE);
//			      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//			      final JMenu pastMenu = new JMenu("Past Activity");
			      final JMenu ParticipantMenu = new JMenu("My account");
			      ParticipantMenu.setForeground(Color.WHITE);
			      final JMenu AddMenu = new JMenu("Add Activity");
			      AddMenu.setForeground(Color.WHITE);
			      final JMenu JudgeMenu = new JMenu("Judge Portal");
			      JudgeMenu.setForeground(Color.WHITE);
			      final JMenu UpdateMenu = new JMenu("Update Activity");
			      UpdateMenu.setForeground(Color.WHITE);
			     
			      menuBar.add(ActivityMenu);
//			      menuBar.add(upcomingMenu);
//			      menuBar.add(pastMenu);       
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