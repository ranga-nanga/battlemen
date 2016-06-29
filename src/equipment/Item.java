package equipment;

public class Item {
	
	public String group = "";
	public String type = "";

	public Item(String group, String type){
		this.group = group;
		this.type = type;
	}
	
	public String getGroup(){
		return this.group;
	}
	
	public String getType(){
		return this.type;
	}
}
