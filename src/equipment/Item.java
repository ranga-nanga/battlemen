package equipment;

public class Item {
	
	public String group = "";
	public Object type;

	public Item(String group, Object type){
		this.group = group;
		this.type = type;
	}
	
	public String getGroup(){
		return this.group;
	}
	
	public Object getType(){
		return this.type;
	}

	public void setType(Object newType){
		this.type = newType;
	}
	
}
