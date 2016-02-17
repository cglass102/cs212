
public class ProduceNode {
	ProduceItem data;
	ProduceNode next;
	
	public ProduceNode(ProduceItem d, ProduceNode n){
		data=d;
		next=n;
	}//constructor
	
	public ProduceNode(){
		data=null;
		next=null;
	}//constructor
	
	public ProduceNode(ProduceItem d){
		data=d;
		next=null;
	}//constructor
}//class
