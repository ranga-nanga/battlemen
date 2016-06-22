package monster;

import battlemen.Fighter;

public class Scorpion extends Fighter{

	public Scorpion(String name, int maxHealth, int defense, int dmgDice) {
		super(name, maxHealth, defense, dmgDice);
	}
	
	public void poisonStab(Fighter enemy){
		enemy.setPoison(true);
		enemy.setPoisonCounter(3);
		System.out.println(enemy.getFighterName() + " was poisoned!");
	}
}
