package text_n;

public class Han_dynasty {  
    
   
    private String id;  
    private String name;  
    private String posthumous_title;  
    private int reign;  
    
    public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosthumous_title() {
		return posthumous_title;
	}


	public void setPosthumous_title(String posthumous_title) {
		this.posthumous_title = posthumous_title;
	}


	public int getReign() {
		return reign;
	}


	public void setReign(int reign) {
		this.reign = reign;
	}


	
   
 
    @Override  
    public String toString() {  
        return "Emperor [id=" + id + ", name=" + name + 
        		", posthumous_title=" + posthumous_title +
        		", reign=" + reign +  "]";  
    }  
          
}  
