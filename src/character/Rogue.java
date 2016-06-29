package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Item;
import battlemen.Dice;
import battlemen.Fighter;

public class Rogue extends Fighter{
	
	static int health = 5;
	static int dmgDie = 8;
	static int healthDie = 6;
	static int strength = 6;
	static List<Item> equipment = new ArrayList<Item>();
	
	public static void initEquip(){
		equipment.add(new Item("sword", "short"));
		equipment.add(new Item("potion", "3"));
	}
	
	public Rogue(String name) {
		super(name, health, strength, dmgDie, healthDie, equipment);
	}

	public void sneakAttack(Fighter fighter){
		int roll = Dice.rollDice(20, 1);
		if (roll > fighter.getFighterDefense()){
		    System.out.println(this.fighterName + "'s attack hit " + fighter.getFighterName() + "!");
		    int damage = (Dice.rollDice(this.fighterDmgDice, 1)+this.fighterStrength)*2;
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
