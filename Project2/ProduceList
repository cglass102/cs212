public class ProduceList {
	private int length=0;
	public ProduceNode first;
	private ProduceNode last;
	
	public ProduceList(){
		ProduceNode pn = new ProduceNode();
		first=pn;
		last=pn;
		length=0;
	}//constructor
	
	public void append (ProduceItem s){
		ProduceNode n= new ProduceNode(s);
		last.next = n;
		last=n;
		length++;
	}// append
}
