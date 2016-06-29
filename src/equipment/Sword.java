package equipment;

public class Sword extends Weapon{
	
	public Sword(String type){
		super("sword", type);
		init();
	}
	
	public void init(){
		switch(String.valueOf(this.type)){
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