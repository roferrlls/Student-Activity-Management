package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JTextPane;

import dbAccess.ActivityProfileController;
import Model.Activity;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class ActivityProfile {

	public JFrame frame;
	public int flag;
	public  int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ActivityProfile(int id,int val) {
		this.id = id;
		flag = val;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ActivityProfile");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		frame.getContentPane().setBackground(new Color(255, 192, 203));
		//frame.setBounds(100, 100, 800, 800);

		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Serif", Font.PLAIN, 14));

		lblName.setBounds(47, 76, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblDate = new JLabel("DATE(yyyy - mm - dd)");
		lblDate.setFont(new Font("Serif", Font.PLAIN, 14));

		lblDate.setBounds(48, 122, 208, 28);
		frame.getContentPane().add(lblDate);
		
		JLabel lblDateyyyytimeDd = new JLabel("TIME(hh:mm::ss)");
		lblDateyyyytimeDd.setToolTipText("");
		lblDateyyyytimeDd.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDateyyyytimeDd.setBounds(48, 188, 208, 28);
		frame.getContentPane().add(lblDateyyyytimeDd);
		
		JLabel lblVenue = new JLabel("VENUE");
		lblVenue.setFont(new Font("Serif", Font.PLAIN, 14));
		lblVenue.setBounds(47, 248, 70, 15);
		frame.getContentPane().add(lblVenue);
		
		JLabel lblExpectedAudience = new JLabel("EXPECTED AUDIENCE");
		lblExpectedAudience.setFont(new Font("Serif", Font.PLAIN, 14));
		lblExpectedAudience.setBounds(47, 302, 173, 15);
		frame.getContentPane().add(lblExpectedAudience);
		
		JLabel lblContactDetails = new JLabel("CONTACT DETAILS");
		lblContactDetails.setFont(new Font("Serif", Font.PLAIN, 14));
		lblContactDetails.setBounds(47, 351, 173, 15);
		frame.getContentPane().add(lblContactDetails);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 14));
		lblDescription.setBounds(47, 421, 173, 15);
		frame.getContentPane().add(lblDescription);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRating = new JLabel("RATING");
		lblRating.setFont(new Font("Serif", Font.PLAIN, 14));
		lblRating.setBounds(47, 475, 70, 15);
		frame.getContentPane().add(lblRating);

		JLabel lblDeadline = new JLabel("DEADLINE");
	      lblDeadline.setFont(new Font("Serif", Font.PLAIN, 14));
	      lblDeadline.setBounds(47, 516, 123, 15);
	      frame.getContentPane().add(lblDeadline);
	      
	      

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(443, 61, 265, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(443, 121, 265, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(443, 176, 265, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(443, 233, 265, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(443, 287, 265, 30);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(443, 336, 265, 30);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(443, 122, 345, 592);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("New label");

		label_6.setBounds(443, 475, 265, 15);
		frame.getContentPane().add(label_6);
		
		JLabel lbldeadline = new JLabel("New label");
	      lbldeadline.setBounds(443, 522, 123, 15);
	      frame.getContentPane().add(lbldeadline);
		
		JButton btnNewButton_1 = new JButton("Show Result");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Result window = new Result(id);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnNewButton_1.setBounds(300, 554, 212, 25);

			if(flag == 2)
			frame.getContentPane().add(btnNewButton_1);
			
//			JButton btnNewButton_2 = new JButton("Show Participant");
//			btnNewButton_2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//				}
//			});
//			btnNewButton_2.setBounds(257, 628, 208, 25);
//			frame.getContentPane().add(btnNewButton_2);
//			JButton btnNewButton_2 = new JButton("Show Participants");
//			btnNewButton_2.setBackground(new Color(135, 206, 235));
//			btnNewButton_2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					
//				}
//			});
			
			
			
			
			
			JButton btnNewButton_2 = new JButton("Show Participants");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ParticipantList window = new ParticipantList(id);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			btnNewButton_2.setBounds(7, 554, 212, 25);
			frame.getContentPane().add(btnNewButton_2);
			
			
			
			
			
			JButton btnNewButton_3 = new JButton("Rate Activity");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								RateActivity window = new RateActivity(id);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			btnNewButton_3.setBounds(857, 554, 212, 25);
			if(flag == 2)
				frame.getContentPane().add(btnNewButton_3);
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActivityProfileController.checkForDeadLine(frame, id);
			}
		});
		btnNewButton.setBounds( 600, 576, 200, 25);
		if(flag  == 1) 
			frame.getContentPane().add(btnNewButton);
			
			
		//}	
		
			  Activity rs = ActivityProfileController.getDetails(id);
		     
			         //Retrieve by column name
		    	  	 
			        
			        
			         lblNewLabel.setText(rs.getName());
			         label.setText(rs.getDate());
			         label_1.setText(rs.getTime());
			         label_2.setText(rs.getVenue());
			         label_3.setText(rs.getEx_aud());
			         label_4.setText(rs.getContact());
			         label_5.setText(rs.getDescription());

			         lbldeadline.setText(rs.getDeadline());
			         if(rs.getDeadline() == null) {
			        	 lbldeadline.setText("No Deadline");
			         }
			  
		
		      
		     
		
		
		
		
		//calculating rating now
		      String val = ActivityProfileController.getRating(id); 
//		      System.out.println("Rating = " + calcRating);
//		      System.out.println("Count = " + cnt);
		      label_6.setText(val);
		      
		      JButton btnBack = new JButton("BACK");
		      btnBack.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		frame.dispose();
		      	}
		      });
		      btnBack.setBounds(1100, 554, 212, 25);
		      frame.getContentPane().add(btnBack);
		      
//		
		final JMenuBar menuBar = new JMenuBar();
	      menuBar.setPreferredSize(new Dimension(0, 50));
	      menuBar.setBounds(new Rectangle(0, 100, 100, 100));
	      menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		    menuBar.setSize(screenSize.width, screenSize.height);

	    //  menuBar.setBounds(100, 100, 150, 101);
	      menuBar.setForeground(Color.WHITE);
	      menuBar.setMargin(new Insets(0, 100, 0, 0));
	      menuBar.setEnabled(false);
	      menuBar.setBorderPainted(false);
	      menuBar.setBackground(Color.BLACK);

	      //create menus
	      JMenu ActivityMenu = new JMenu(" Activity");
	      ActivityMenu.setSize(new Dimension(0, 10));
	      ActivityMenu.setForeground(Color.WHITE);
//	      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//	      final JMenu pastMenu = new JMenu("Past Activity");
	      JMenu ParticipantMenu = new JMenu("My account");
	      ParticipantMenu.setBackground(Color.BLACK);
	      ParticipantMenu.setForeground(Color.WHITE);
	      final JMenu AddMenu = new JMenu("Add Activity");
	      AddMenu.setForeground(Color.WHITE);
	      final JMenu JudgeMenu = new JMenu("Judge Portal");
	      JudgeMenu.setForeground(Color.WHITE);
	      final JMenu UpdateMenu = new JMenu("Update Activity");
	      UpdateMenu.setForeground(Color.WHITE);
	      final JMenu SignupMenu = new JMenu("Signup");
	      SignupMenu.setForeground(Color.WHITE);
	     
			     
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
