package equipment;

public class Sword extends Item{
	
	public int dmgDie = 0;
	public String type = "";
	
	public Sword(String type){
		super("sword", type);
		init();
	}
	
	public void init(){
		switch(this.type){
			case "long":
				this.dmgDie = 8;
				break;
			case "short":
				this.dmgDie = 6;
				break;
			case "broad":
				this.dmgDie = 10;
				break;
		}
	}
}
