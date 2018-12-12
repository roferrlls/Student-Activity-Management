import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SwingMenu {
	private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel; 



	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingMenu  swingMenuDemo = new SwingMenu();     
	      swingMenuDemo.showMenuDemo();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMenu window = new SwingMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void prepareGUI(){
	      mainFrame = new JFrame("STUDENT ACTIVITY MANAGEMENT");
	      mainFrame.setSize(800,800);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        
	      statusLabel.setSize(350,100);
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	    void showMenuDemo(){
	      //create a menu bar
	      final JMenuBar menuBar = new JMenuBar();

	      //create menus
	      JMenu ActivityMenu = new JMenu(" Activity");
//	      JMenu upcomingMenu = new JMenu("Upcoming Activity"); 
//	      final JMenu pastMenu = new JMenu("Past Activity");
	      final JMenu ParticipantMenu = new JMenu("My account");
	      final JMenu AddMenu = new JMenu("Add Activity");
	      final JMenu JudgeMenu = new JMenu("Judge Portal");
	      final JMenu UpdateMenu = new JMenu("Update Activity");
	     
	      menuBar.add(ActivityMenu);
//	      menuBar.add(upcomingMenu);
//	      menuBar.add(pastMenu);       
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

	/**
	 * Create the application.
	 */
	public SwingMenu() {
		initialize();
		prepareGUI();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1187, 879);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		
		Image img=new ImageIcon(this.getClass().getResource("/LNMIIT-2017-1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBounds(12, 75, 1204, 829);
	}

}
