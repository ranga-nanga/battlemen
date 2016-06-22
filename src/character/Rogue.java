package character;

import battlemen.Dice;
import battlemen.Fighter;

public class Rogue extends Fighter{
	
	/*
	 * This constructor calls the Hero constructor
	 * because this class extends Hero 
	 */
	public Rogue(String name, int maxHealth, int defense) {
		super(name, maxHealth, defense, 6);
	}

	public void sneakAttack(Fighter enemy){
		int roll = Dice.rollDice(20, 1);
		if (roll > enemy.getFighterDefense()){
		    System.out.println(this.fighterName + "'s attack hit!");
		    int damage = Dice.rollDice(this.fighterDmgDice, 1);
		    //double damage for sneakAttack
		    int newHealth = enemy.getFighterHealth() - damage*2;	
		    enemy.setFighterHealth(newHealth);
			System.out.println(enemy.getFighterName() + " took " + damage + " damage!");
			System.out.println(enemy.getFighterName() + " has " + enemy.getFighterHealth() + " health left!");
		}else{
		   System.out.println(this.fighterName + "'s attack missed!");
		}
		this.evaluate();
	}
	
	public void poisonStab(Fighter enemy){
		enemy.setPoison(true);
		enemy.setPoisonCounter(3);
		System.out.println(enemy.getFighterName() + " was poisoned!");
	}
}
