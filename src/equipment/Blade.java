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
		case "sickle":
			this.accuracy = -1;
			this.dmgDie = 4;
			break;
		case "kukri":
			this.accuracy = +3;
			this.dmgDie = 4;
			break;
		case "ranseur":
			this.accuracy = +1;
			this.dmgDie = 6;
			break;
		case "sai":
			this.accuracy = +5;
			this.dmgDie = 4;
			break;
		case "dagger":
			this.accuracy = +2;
			this.dmgDie = 6;
			break;
		case "katar":
			this.accuracy = -2;
			this.dmgDie = 8;
			break;
		case "battleaxe":
			this.accuracy = -2;
			this.dmgDie = 8;
			break;
		case "scimitar":
			this.accuracy = +3;
			this.dmgDie = 8;
			break;
		case "waraxe":
			this.accuracy =-5;
			this.dmgDie = 12;
			break;
		case "falchion":
			this.accuracy = +3;
			this.dmgDie = 8;
			break;
		case "scythe":
			this.accuracy = -2;
			this.dmgDie = 8;
			break;
		case "bastardsword":
			this.accuracy = +3;
			this.dmgDie =10;
			break;
		case "urgrosh":
			this.accuracy = +3;
			this.dmgDie =10;
			break;
		case "halberd":
			this.accuracy = +3;
			this.dmgDie = 6;
			break;
		case "giserne":
			this.accuracy = +2;
			this.dmgDie = 8;
			break;
		case "greatsword":
			this.accuracy = +5;
			this.dmgDie = 10;
			break;
		case "greataxe":
			this.accuracy = +3;
			this.dmgDie = 10;
			break;
		case "glaive":
			this.accuracy = +2;
			this.dmgDie = 8;
			break;
		case "zweihander":
			this.accuracy = +10;
			this.dmgDie = 12;
			//this.description = "make them eat dirt"
			break;
		}
	}
}
