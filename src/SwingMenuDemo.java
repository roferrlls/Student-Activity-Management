import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JComboBox;


import java.awt.*;
import java.awt.event.*;

public class SwingMenuDemo {
   private JFrame mainFrame;
   private JLabel statusLabel;

   public SwingMenuDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingMenuDemo  swingMenuDemo = new SwingMenuDemo();     
      swingMenuDemo.showMenuDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("STUDENT ACTIVITY MANAGEMENT");
      mainFrame.setSize(800,800);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setBounds(0, 519, 800, 259);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });
      mainFrame.getContentPane().setLayout(null);
      mainFrame.getContentPane().add(statusLabel);
      
      JLabel lblNewLabel = new JLabel("New label");
      Image img=new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
      lblNewLabel.setBounds(0, 26, 800, 752);
      mainFrame.getContentPane().add(lblNewLabel);
      mainFrame.setVisible(true);  
   }
   private void showMenuDemo(){
      //create a menu bar
      final JMenuBar menuBar = new JMenuBar();

      //create menus
      JMenu ActivityMenu = new JMenu(" Activity");
//      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//      final JMenu pastMenu = new JMenu("Past Activity");
      final JMenu ParticipantMenu = new JMenu("My account");
      final JMenu AddMenu = new JMenu("Add Activity");
      final JMenu JudgeMenu = new JMenu("Judge Portal");
      final JMenu UpdateMenu = new JMenu("Update Activity");
     
      menuBar.add(ActivityMenu);
//      menuBar.add(upcomingMenu);
//      menuBar.add(pastMenu);       
      menuBar.add(AddMenu);
      menuBar.add(JudgeMenu);       
      menuBar.add(UpdateMenu);
      menuBar.add(ParticipantMenu);
      //add menubar to the frame
      mainFrame.setJMenuBar(menuBar);
      mainFrame.setVisible(true);  
    
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
							addActivity window = new addActivity();
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
							Verification window = new Verification();
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