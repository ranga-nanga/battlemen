package character;

import battlemen.Dice;
import battlemen.Fighter;

public class Rogue extends Fighter{
	
	/*
	 * This constructor calls the Hero constructor
	 * because this class extends Hero 
	 */
	public Rogue(String name, int defense) {
		super(name, 5, defense, 6);
	}

	public void sneakAttack(Fighter fighter){
		int roll = Dice.rollDice(20, 1);
		if (roll > fighter.getFighterDefense()){
		    System.out.println(this.fighterName + "'s attack hit " + fighter.getFighterName() + "!");
		    int damage = Dice.rollDice(this.fighterDmgDice, 1)*2;
		    int newHealth = fighter.getFighterHealth() - damage;	
		    if(newHealth < 0){
		    	fighter.setFighterHealth(0);
		    } else {
		    	fighter.setFighterHealth(newHealth);
		    }
			System.out.println(fighter.getFighterName() + " took " + damage + " damage!");
			System.out.println(fighter.getFighterName() + " has " + fighter.getFighterHealth() + " health left!");
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
