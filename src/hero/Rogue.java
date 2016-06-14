package hero;

import monster.Monster;

public class Rogue extends Hero{
	
	public static int rogueDamage;
	
	/*
	 * This constructor calls the Hero constructor
	 * because this class extends Hero 
	 */
	public Rogue(int maxHealth, int health, int dmg) {
		super(maxHealth, health, dmg);
		rogueDamage = dmg * 2;
	}

	public void sneakAttack(Monster monster){
		this.setHeroDamage(rogueDamage);
		this.attacksMonster(monster);
		this.setHeroDamage(heroDamage);
		//System.out.println("The monster took " + rogueDamage + " damage!");
	}
}
