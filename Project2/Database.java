import java.util.StringTokenizer;
 
public class Database {
    private ProduceList items;
    int count;
    public Database (String filename){
        items = new ProduceList();
        count = 0;
        readFromFile(filename);
    }//constructor
     
    /**
     * reads from database file and creates a new fruit or vegetable
     * @param filename
     */
    public void readFromFile (String filename){
        TextFileInput input = new TextFileInput(filename);
        String line = input.readLine();
        while (line != null) {
            StringTokenizer token = new StringTokenizer(line, ",");
            String type = token.nextToken();
            String code = token.nextToken();
            String name = token.nextToken();
            float price = Float.parseFloat(token.nextToken());
            ProduceItem item;
            if (type.equals("F")){
            	item = new Fruit(code, name, price);
        	}
        	else
        		item = new Vegetable(code, name, price);
            items.append(item);
            line = input.readLine();
        }//while
    }//readFromFile
     
    /**
     * takes in code and returns name of the associated produce item
     * @param code produce item code
     * @return
     */
    public String getName (String code){
    	ProduceNode p= items.first.next;
    	while (p!=null && !((p.data).getCode().equals(code))){
    		p=p.next;
    	}
    	if ((p.data).getCode().equals(code))
    		return (p.data).getName();
    	else
    		return "None";
    }//getName
    
    /**
     *  takes in code and returns price of the associated produce item
     * @param code produce item code
     * @return
     */
    public float getPrice (String code){
    	ProduceNode p= items.first.next;
    	while (p!=null && (!(p.data).getCode().equals(code))){
    		p=p.next;
    	}//while
    	if((p.data).getCode().equals(code))
    		return (p.data).getPrice();
    	else
    		return 0.0f;
    }//getPrice    
}//class
