package equipment;

public class Blade extends Weapon{
	
	public Blade(String type){
		super("blade", type);
		init();
	}

	public void init(){
		switch(String.valueOf(this.type)){
		case "longsword": 
			this.accuracy=1;
			this.dmgDie = 8;
			break;
		case "shortsword":
			this.accuracy=0;
			this.dmgDie = 6;
			break;
		case "broadsword":
			this.accuracy=2;
			this.dmgDie = 8;
			break;
		case "rapier":
			this.accuracy=-1;
			this.dmgDie = 10;
			break;
		case "axe":
			this.accuracy = -1;
			this.dmgDie = 10;
			break;
		}
	}
}
