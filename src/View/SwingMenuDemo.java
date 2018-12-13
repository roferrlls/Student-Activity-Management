package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

import javax.swing.ImageIcon;


import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;



import java.awt.*;
import java.awt.event.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class SwingMenuDemo {
   private JFrame mainFrame;
   private JLabel statusLabel;
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

   public SwingMenuDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingMenuDemo  swingMenuDemo = new SwingMenuDemo();     
      swingMenuDemo.showMenuDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("STUDENT ACTIVITY MANAGEMENT");
      mainFrame.setBackground(new Color(0, 0, 0));
      //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    mainFrame.setSize(screenSize.width, screenSize.height);
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
      lblNewLabel.setBackground(new Color(0, 0, 0));
      lblNewLabel.setLocation(0, -19);
      Image img=new ImageIcon(this.getClass().getResource("/img1.jpg")).getImage();
	lblNewLabel.setIcon(new ImageIcon(img));
	//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	lblNewLabel.setSize(screenSize.width, screenSize.height-100);
     // lblNewLabel.setBounds(0, 26, 800, 752);
      mainFrame.getContentPane().add(lblNewLabel);
      mainFrame.setVisible(true);  
   }
   public void showMenuDemo(){
      //create a menu bar
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
//      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//      final JMenu pastMenu = new JMenu("Past Activity");
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
//      menuBar.add(upcomingMenu);
//      menuBar.add(pastMenu);       
      menuBar.add(AddMenu);
      menuBar.add(JudgeMenu);       
      menuBar.add(UpdateMenu);
      menuBar.add(ParticipantMenu);
      menuBar.add(SignupMenu);
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
      
      JMenuItem ActivityMenuItem4 = new JMenuItem("Signup");
      ActivityMenuItem4.setActionCommand("Signup");
      ActivityMenuItem4.addActionListener(menuItemListener);
      SignupMenu.add(ActivityMenuItem4);
    //  menuBar.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ActivityMenu, ActivityMenuItem, ActivityMenuItem1, ActivityMenuItem2, AddMenu, AddMenuItem, JudgeMenu, JudgeMenuItem, UpdateMenu, UpdateMenuItem, ParticipantMenu, ActivityMenuItem3,ActivityMenuItem4}));
      
    
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
    	  
    	  else if(e.getActionCommand().equals("Signup")){
    		  EventQueue.invokeLater(new Runnable() {
    				public void run() {
    					try {
    						PartcipantForm window = new PartcipantForm();
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