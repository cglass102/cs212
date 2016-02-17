import java.text.DecimalFormat;
import java.util.StringTokenizer;
 
public class Project2 {
    public static void main (String [] args){
    	int count = 0;
        float priceTotal = 0.0f;
        Database db = new Database("database2.txt");
        String [] transaction = new String [100];
        TextFileInput in = new TextFileInput("transactions2.txt");
        String line = in.readLine();
        DecimalFormat df = new DecimalFormat("#00.00");
        while (line != null) {
            StringTokenizer tokenized = new StringTokenizer(line, ",");
            String code = tokenized.nextToken();
            float weight = Float.parseFloat(tokenized.nextToken());             
            String name = db.getName(code);
            float price = db.getPrice(code);             
            float itemTotal = weight * price;
            priceTotal += itemTotal;             
            transaction[count] = name + "\t" + price + "\t" + df.format(weight) + "\t $" + df.format(itemTotal);
            count++;             
            line = in.readLine();
        }//while
        new ReceiptGUI(transaction, count, df.format(priceTotal));
    }//main
}//class
