package hero;

import monster.Monster;

public class Rogue extends Hero{
	
	public static int rogueDamage = heroDamage * 2;
	
	public void sneakAttack(){
		Monster.monsterHealth = Monster.monsterHealth - rogueDamage;	
		System.out.println("The monster took " + rogueDamage + " damage!");
	}
}
