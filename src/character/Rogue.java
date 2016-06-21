package character;

import battlemen.Fighter;

public class Rogue extends Fighter{
	
	public static int rogueDamage;
	
	/*
	 * This constructor calls the Hero constructor
	 * because this class extends Hero 
	 */
	public Rogue(String name, int maxHealth, int dmg) {
		super(name, maxHealth, dmg);
		rogueDamage = dmg * 2;
	}

	public void sneakAttack(Fighter enemy){
		int tempDmg = this.getFighterDamage();
		this.setFighterDamage(rogueDamage);
		this.attacks(enemy);
		this.setFighterDamage(tempDmg);
	}
	
	public void poisonStab(Fighter enemy){
		enemy.setPoison(true);
		enemy.setPoisonCounter(3);
		System.out.println(enemy.getFighterName() + " was poisoned!");
	}
}
