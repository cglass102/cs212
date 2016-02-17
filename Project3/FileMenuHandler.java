import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener{
	JFrame jframe;
	TextArea myTextArea;
	//TextArea myTextArea = new TextArea();
	public FileMenuHandler (JFrame jf, TextArea ta) {
		jframe= jf;
		myTextArea = ta;
	}//constructor
	
	public void actionPerformed (ActionEvent event){
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals ("Open"))
			openFile();
		else if (menuName.equals("Quit"))
			System.exit(0);
	}//actionPerformed
	
	private void openFile(){
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)
			readSource(chooser.getSelectedFile());
		else
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	}//openFile
	
	/**
	 * opens the chosen file, reads in the file, and prints out a receipt
	 * @param chosenFile
	 */
	private void readSource(File chosenFile){
		String chosenFileName = chosenFile.getName();
		TextFileInput inFile = new TextFileInput(chosenFileName);
		Container myContentPane = jframe.getContentPane();
		//chosenFile TextArea myTextArea = new TextArea();
		myContentPane.add(myTextArea);
		
		int count = 0;
        float priceTotal = 0.0f;
        Database db = new Database("database2.txt");
		String [] transaction = new String [100];
        String line = inFile.readLine();
        DecimalFormat df = new DecimalFormat("#00.00");
        while (line != null) {
            StringTokenizer tokenized = new StringTokenizer(line, ",");
            String code = tokenized.nextToken();
            float weight = Float.parseFloat(tokenized.nextToken());  
            String name;
            float price;
            
           	try{
           		name = db.getName(code);
           		
            }
            catch(ItemNotFoundException e){
            	name = JOptionPane.showInputDialog(null,"Item " +code+ " not found. Enter Name: ");
            }
           	try{
           		price = db.getPrice(code);  
           	}
           	catch(ItemNotFoundException e){
           		price=Float.valueOf(JOptionPane.showInputDialog(null,"Price for " +name+ " not found. Enter price: "));
           	}
        	float itemTotal = weight*price;
           	priceTotal += itemTotal;         
           	transaction[count] = name + "\t" + price + "\t" + df.format(weight) + "\t $" + df.format(itemTotal);
           	count++;             
           	line = inFile.readLine();
            
        }//while
        myTextArea.setText("ITEM: \t PRICE\\LB: \t POUNDS: \t TOTAL:");
        myTextArea.append("\n");
        for (int i=0; i<count; i++){
            myTextArea.append(transaction[i]);
            myTextArea.append("\n");
        }
        myTextArea.append("\t\t   TOTAL: $" + df.format(priceTotal));
        jframe.setVisible(true);
	}//openFile
}//class FileMenuHandler
