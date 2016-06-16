package character;

import monster.Monster;

public class Rogue extends Character{
	
	public static int rogueDamage;
	
	/*
	 * This constructor calls the Hero constructor
	 * because this class extends Hero 
	 */
	public Rogue(String name, int maxHealth, int health, int dmg) {
		super(name, maxHealth, health, dmg);
		rogueDamage = dmg * 2;
	}

	public void sneakAttack(Monster monster){
		this.setHeroDamage(rogueDamage);
		this.attacksMonster(monster);
		this.setHeroDamage(characterDamage);
		//System.out.println("The monster took " + rogueDamage + " damage!");
	}
}