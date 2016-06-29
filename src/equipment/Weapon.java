package equipment;

public class Weapon extends Item{
	
	public int dmgDie = 0;
	public int accuracy = 0;
	
	public Weapon(String group, String type){
		super(group, type);
	}
	
	public int getDmgDie(){
		return this.dmgDie;
	}
	
	public int getAccuracy(){
		return this.accuracy;
	}
}
