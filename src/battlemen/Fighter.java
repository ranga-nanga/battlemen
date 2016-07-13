package battlemen;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import equipment.Armor;
import equipment.Item;
import equipment.Weapon;
import battlemen.Dice;

public class Fighter {
	/*
	 * Default values for maxhealth, health and damage These values are
	 * initialized when you create a new Hero in your Battle class
	 */

	public String fighterName = "";
	public int fighterLVL = 0, fighterMaxLVL = 99;
	public int fighterXP = 0, fighterMaxXP = 0;
	public int fighterVIT = 0, fighterMaxVIT = 255;
	public int fighterHP = 0, fighterMaxHP = 0;
	public int healthDie = 0;
	public int fighterSTR = 0, fighterMaxSTR = 255;
	public int fighterMND = 0, fighterMaxMND = 255;
	public int fighterMP = 0, fighterMaxMP = 0;
	public int fighterAGI = 0, fighterMaxAGI = 255;
	public boolean poison = false;
	public boolean hidden = false;
	public int poisonCounter = 0;
//TODO: Add more equipment slots eventually?
	public Weapon WeaponSlot = new Weapon("","");
	public Armor ArmorSlot = new Armor("","");
	public List<Item> equipment = new ArrayList<Item>();
	//TODO: create formulas for MaxHP and MaxMP.

	public Fighter(String name, int LVL, int XP, int VIT, int HP, int STR, 
			int healthDie, int MND, int MP, int AGI, List<Item> list) {
		this.fighterName = name;
		this.fighterLVL = LVL;
		this.fighterXP = XP;
		//TODO: Need to find out how we're going to do level up XP. this.fighterLVLUP?
		this.fighterVIT = VIT;
		this.fighterHP = HP;
		this.healthDie = healthDie;
		this.fighterSTR = STR;
		this.fighterMND = MND;
		this.fighterMP = MP;
		this.fighterAGI = AGI;
		this.equipment.addAll(list);
	}

	public int getFighterLVL() {
		return this.fighterLVL;
	}

	public void setFighterLVL(int newFighterLVL) {
		this.fighterLVL = newFighterLVL;
	}

	public int getFighterXP() {
		return this.fighterXP;
	}

	public void setFighterXP(int newFighterXP) {
		this.fighterXP = newFighterXP;
	}

	public int getFighterVIT() {
		return this.fighterVIT;
	}

	public void setFighterVIT(int newFighterVIT) {
		this.fighterVIT = newFighterVIT;
	}

	public int getFighterHP() {
		return this.fighterHP;
	}

	public void setFighterHP(int newFighterHP) {
		this.fighterHP = newFighterHP;
	}

	public int getFighterMaxHP() {
		return this.fighterMaxHP;
	}

	public void setFighterMaxHP(int newFighterMaxHP) {
		this.fighterMaxHP = newFighterMaxHP;
	}

	public int getFighterSTR() {
		return this.fighterSTR;
	}

	public void setFighterSTR(int newFighterSTR) {
		this.fighterSTR = newFighterSTR;
	}

	public int getFighterMND() {
		return this.fighterMND;
	}

	public void setFighterMND(int newFighterMND) {
		this.fighterMND = newFighterMND;
	}

	public int getFighterMP() {
		return this.fighterMP;
	}

	public void setFighterMP(int newFighterMP) {
		this.fighterMP = newFighterMP;
	}

	public int getFighterMaxMP() {
		return this.fighterMaxMP;
	}

	public void setFighterMaxMP(int newFighterMaxMP) {
		this.fighterMaxMP = newFighterMaxMP;
	}

	public int getFighterAGI() {
		return this.fighterAGI;
	}

	public void setFighterAGI(int newFighterAGI) {
		this.fighterAGI = newFighterAGI;
	}

	public void setEquipment(List<Item> items) {
		this.equipment.addAll(items);
	}

	public String getFighterName() {
		return fighterName;
	}

	public void setFighterName(String newName) {
		this.fighterName = newName;
	}

	public void setPoison(boolean newPoison) {
		this.poison = newPoison;
	}

	public void setPoisonCounter(int newPoisonCounter) {
		this.poisonCounter = newPoisonCounter;
	}
	
	public void setHidden(boolean newHidden){
		this.hidden = newHidden;
	}
	
	public boolean THEO(Fighter enemy){
		if(enemy.getFighterAGI() == 0){
			return true;
		}else if(this.fighterAGI/enemy.getFighterAGI() >= Dice.rollDice(100,1)){
			return true;
		}else{
			System.out.println("Attack Misses!");
			return false;
		}
	}
	
//TODO: create armorBonus percentages and defense values of different armors.

	public void PAttacks(Fighter fighter) {
		int fighterPAttack = 0, enemyPDefense = 0;
		if (THEO(fighter) == true) {
			fighterPAttack = ((this.getFighterSTR()/2) + ((this.getFighterLVL()/2) + (this.getFighterAGI()/10)) + WeaponSlot.dmgDie);
			
			enemyPDefense = ((fighter.getFighterAGI()/10)+ (fighter.getFighterSTR()/5) + (fighter.getFighterVIT()/10));
				
			int pDamage = ((fighterPAttack * (255 - enemyPDefense)) / 256 )+1;
			int newHealth = fighter.getFighterHP() - pDamage;

			// prevent negative health
			if (newHealth < 0) {
				fighter.setFighterHP(0);
			} else {
				fighter.setFighterHP(newHealth);
			}
			System.out.println(fighter.getFighterName() + " took " + pDamage
					+ " damage!");
			System.out.println(fighter.getFighterName() + " has "
					+ fighter.getFighterHP() + " health left!");
		}
		this.evaluate();
	}

	public void inventory() {
		for (Item i : equipment) {
			System.out.println(i.getType() + " " + i.getGroup());
		}
	}

	public void useItem(String item) {
		switch (item) {
		case "potion":
			usePotion();
			break;
		}
	}

	public void usePotion() {
		int healthDifference = fighterMaxHP - fighterHP;
		if (healthDifference > 3) {
			healthDifference = 3;
		}
		fighterHP += healthDifference;
		if (healthDifference == 1) {
			System.out.println(this.fighterName + " heals for 1 point!");
		} else {
			System.out.println(this.fighterName + " heals for "
					+ healthDifference + " points!");
		}
		System.out.println(this.fighterName + " now has " + this.fighterHP
				+ " health!");
		for (Item item : equipment) {
			if (item.getGroup().equalsIgnoreCase("potion")) {
				int count = Integer.valueOf((String) item.getType());
				item.setType(count - 1);
				if (count == 0) {
					System.out
							.println("It would seem as though that you don't have one...");
				} else {

				}
			}
		}
	}

	public void newMaxFighterHealth() {
		this.fighterMaxHP += Dice.rollDice(healthDie, 1);
		System.out.println("You leveled up! Your Max Health is now "
				+ this.fighterMaxHP + " !");
		this.fighterHP = this.fighterMaxHP;
		System.out.println("You currently have " + this.fighterHP
				+ " HP out of " + this.fighterMaxHP);
	}

	public void evaluate() {
		if (this.poisonCounter == 0) {
			this.poison = false;
		}
		if (poison == true) {
			this.fighterHP--;
			this.poisonCounter--;
			System.out.println(this.fighterName + " took poison damage!");
			System.out.println(this.fighterName + "'s health is now at "
					+ this.fighterHP);
		}
	}

}




