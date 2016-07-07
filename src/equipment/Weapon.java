package equipment;

public class Weapon extends Item{
	
	public int timesRolled = 0;
	public int dmgDie = 0;
	
	public Weapon(String group, String type){
		super(group, type);
	}
	
	public int getDmgDie(){
		return this.dmgDie;
	}
}
