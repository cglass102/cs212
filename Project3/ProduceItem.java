public abstract class ProduceItem {
    private String code;
    private String name;
    private float price;
    
    ProduceItem(){
		this("","",0.0f);
	}//constructor
    
    /**
     * ProduceItem constructor
     * @ param C is the code of the produce item
     * @ param N is the name of the produce item
     * @ param P is the price of the produce item
     */
    public ProduceItem(String C, String N, float P){
        code = C;
        name = N;
        price = P;
    }//constructor
     
    /**
     * @ return code
     */
    public String getCode () {  
    	return code; 
    }
    
    /**
     * @ return name
     */
    public String getName () {  
    	return name; 
    }
    
    /**
     * @ return price
     */
    public float getPrice () {  
    	return price; 
    }
     
    /**
     * @ param code code to set
     */
    public void setCode (String c) { 
    	code = c; 
    }
    
    /**
     * @ param name name to set
     */
    public void setName (String n) { 
    	name = n; 
    }
    
    /**
     * @ param price price to set
     */
    public void setPrice (float p) { 
    	price = p; 
    }
    
	public String toString(){
		return code+"\t"+name+"\t"+price;
	}
	
	/**
	 * overrides equals() for class ProduceItems
	 * @param other
	 */
	public boolean equals(ProduceItem other){
		boolean result;
		if(other==null || getClass() != other.getClass())
			result=false;
		else{
			result= code.equals(other.code) && name.equals(other.name) && (Float.toString(price)).equals(other.price);	
		}
		return result;
	}//equals
     
}//class
