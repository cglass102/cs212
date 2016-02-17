import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DatabaseMenuHandler implements ActionListener {
	JFrame jframe;
	TextArea myTextArea;
	Database db;
	
	public DatabaseMenuHandler(JFrame jf, TextArea ta) {
		jframe = jf;
		myTextArea = ta;
		
	}//constructor
	
	public void actionPerformed(ActionEvent event){
		String menuName;
		menuName = event.getActionCommand();

		if (menuName.equals("Open")){
			db=openFile();
		}
		if (menuName.equals("Display Fruits")){
			
			openFruit(db);
		}
		if (menuName.equals("Display Vegetables")){
		
			openVegetable(db);
		}
		
	}//actionPerformed
	
	private Database openFile(){
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION){
			String chosenFile = chooser.getSelectedFile().getName();
			Database db = new Database(chosenFile);
			return db;
		}
		else
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
		return null;
			
	}//openFile
	
	/**
	 * prints out a list of only fruits
	 * @param db
	 */
	private void openFruit(Database db){
		Container myContentPane = jframe.getContentPane();
		//TextArea myTextArea = new TextArea();
		myContentPane.add(myTextArea);
		ProduceList pl = new ProduceList();
		pl=db.fruitList();
		ProduceNode p = new ProduceNode();
		p=pl.first.next;
		myTextArea.setText("FRUITS:");
		myTextArea.append("\n ITEM: \t PRICE:");
		myTextArea.append("\n");
		while(p!=null){
			myTextArea.append(p.data.getName()+"\t"+p.data.getPrice());
			myTextArea.append("\n");
			p=p.next;
		}
		jframe.setVisible(true);
	}//openFruit
	
	/**
	 * prints out a list of only vegetables
	 * @param db
	 */
	private void openVegetable(Database db){
		Container myContentPane = jframe.getContentPane();
		//TextArea myTextArea = new TextArea();
		myContentPane.add(myTextArea);
		ProduceList pl = new ProduceList();
		pl=db.vegetableList();
		ProduceNode p = new ProduceNode();
		p=pl.first.next;
		myTextArea.setText("VEGETABLES:");
		myTextArea.append("\n ITEM: \t PRICE:");
		myTextArea.append("\n");
		while(p!=null){
			 myTextArea.append(p.data.getName()+"\t"+p.data.getPrice());
			 myTextArea.append("\n");
			p=p.next;
		}
		jframe.setVisible(true);
	}//openVegetable
	
}//class DatabaseMenuHandler
