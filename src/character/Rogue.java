package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Blade;
import equipment.Item;
import equipment.Utility;
import battlemen.Dice;
import battlemen.Fighter;

public class Rogue extends Fighter{
	
	static int health = 5;
	static int dmgDie = 8;
	static int healthDie = 6;
	static int strength = 6;
	static List<Item> equipment = new ArrayList<Item>();
	
	public Rogue(String name) {
		super(name, health, strength, dmgDie, healthDie, equipment);
		this.initEquip();
	}
	
	private void initEquip(){
		equipment.add(new Blade("rapier"));
		equipment.add(new Utility("potion", 3));
		this.setEquipment(equipment);
	}

	public void sneakAttack(Fighter fighter){
		int roll = Dice.rollDice(20, 1);
		if (roll > fighter.getFighterPDefense()){
		    System.out.println(this.fighterName + "'s attack hit " + fighter.getFighterName() + "!");
		    int damage = (Dice.rollDice(this.fighterDmgDice, 1)+this.fighterSTR)*2;
		    int newHealth = fighter.getFighterHP() - damage;	
		    if(newHealth < 0){
		    	fighter.setFighterHP(0);
		    } else {
		    	fighter.setFighterHP(newHealth);
		    }
			System.out.println(fighter.getFighterName() + " took " + damage + " damage!");
			System.out.println(fighter.getFighterName() + " has " + fighter.getFighterHP() + " health left!");
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
