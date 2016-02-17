import java.awt.TextArea;
import javax.swing.JFrame;
 
public class ReceiptGUI {
    private String [] info;
    private int count;
    private String total;
    private JFrame frame;
    private TextArea text;
    
    public ReceiptGUI (String [] info, int count, String total){
        this.info = info;
        this.count = count;
        this.total = total;
        createGUI();
        appendText();
    }//constructor
     
    public void createGUI (){
        frame = new JFrame("Receipt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        text = new TextArea();
        text.setEditable(false);
        frame.getContentPane().add(text);
        frame.setVisible(true);
    }//createGUI
     
    public void appendText (){
        text.setText("ITEM \t PRICE\\LB \t POUNDS \t TOTAL");
        text.append("\n");
        for (int i=0; i<count; i++){
            text.append(info[i]);
            text.append("\n");
        }//for
        text.append("\t\t   TOTAL: $" + total);
    }//appendText
}//class
