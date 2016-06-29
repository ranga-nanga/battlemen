package equipment;

public class Item {
	
	public String group = "";
	public String type = "";
	public int dmgDie = 0;

	public Item(String group, String type){
		this.group = group;
		this.type = type;
		init();
	}
	
	private void init(){
		switch(group){
			case "sword":	if(type.equals("long")){
								this.dmgDie = 8;
							} else if(type.equalsIgnoreCase("short")){
								this.dmgDie = 6;
							} else if(type.equalsIgnoreCase("broad")){
								this.dmgDie = 10;
							}
							break;
		}
	}
}
