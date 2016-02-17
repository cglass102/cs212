import javax.swing.*;
import java.awt.*;
public class Project3GUI extends JFrame{
	
	TextArea myTextArea = new TextArea();
	JMenuBar menuBar = new JMenuBar();
	
	public Project3GUI (String title, int height, int width){
		
		setTitle(title);
		setSize(height,width);
		setLocation (400,200);
		setSize(500,500);
		createFileMenu(myTextArea);
		createDatabaseMenu(myTextArea);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}//project3GUI
	
	/**
	 * creates a menu called File with items Open and Quit
	 */
	private void createFileMenu(TextArea myTextArea){
		JMenuItem item;
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this,myTextArea);

		item = new JMenuItem("Open");
		item.addActionListener(fmh);
		fileMenu.add(item);
		
		fileMenu.addSeparator();
		
		item = new JMenuItem("Quit");
		item.addActionListener(fmh);
		fileMenu.add(item);
		
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
	}//create FileMenu
	
	/**
	 * creates a menu called Database with items Open, Display Fruits and Display Vegetable
	 */
	private void createDatabaseMenu(TextArea myTextArea){
		
		JMenuItem item;
		JMenu databaseMenu = new JMenu("Database");
		DatabaseMenuHandler dmh = new DatabaseMenuHandler(this, myTextArea);
		
		
		item= new JMenuItem("Open");
		item.addActionListener(dmh);
		databaseMenu.add(item);
		
		databaseMenu.addSeparator();
		
		item= new JMenuItem("Display Fruits");
		item.addActionListener(dmh);
		databaseMenu.add(item);
		
		databaseMenu.addSeparator();
		
		item = new JMenuItem("Display Vegetables");
		item.addActionListener(dmh);
		databaseMenu.add(item);
		
		setJMenuBar(menuBar);
		menuBar.add(databaseMenu);
	}//createDatabaseMenu
}//Project3GUI
