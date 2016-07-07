package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Blade;
import equipment.Item;
import equipment.Utility;
import battlemen.Dice;
import battlemen.Fighter;

public class Rogue extends Fighter{
	
	static int healthDie = 6;
	static int LVL = 1;
	static int XP = 0;
	static int VIT = 5;
	static int HP = 7;
	static int STR = 5;
	static int MND = 7;
	static int MP = 9;
	static int  AGI = 10;
	static List<Item> equipment = new ArrayList<Item>();
	
	public Rogue(String name) {
		super(name, LVL, XP, VIT, HP, STR, healthDie, MND, MP, AGI, equipment);
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
