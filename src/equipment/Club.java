package equipment;

public class Club extends Weapon{
	
	public Club(String type){
		super("club", type);
		init();
	}
	
	public void init(){
		switch(String.valueOf(this.type)){
			case "blunt":
				this.dmgDie = 6;
				break;
			case "mace":
				this.dmgDie = 8;
				break;
			case "axe":
				this.dmgDie = 10;
				break;
		}
	}
}
