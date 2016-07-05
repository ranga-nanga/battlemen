package battlemen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import equipment.Item;
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
	public int fighterPAttack = 0;
	public int fighterPDefense = 0;
	public int fighterMND = 0, fighterMaxMND = 255;
	public int fighterMP = 0, fighterMaxMP = 0;
	public int fighterMAttack = 0;
	public int fighterMDefense = 0;
	public int fighterEVA = 0, fighterMaxEVA = 255;
	public int fighterAGI = 0, fighterMaxAGI = 255;
	public int fighterDmgDice = 0;
	public boolean poison = false;
	public int poisonCounter = 0;
	public List<Item> equipment = new ArrayList<Item>();

	public Fighter(String name, int health, int strength, int dmgDice,
			int healthDie, List<Item> list) {
		this.fighterName = name;
		this.fighterHP = health;
		this.fighterHP = health;
		this.fighterSTR = strength;
		this.fighterPDefense = (strength + health) / 2;
		this.fighterDmgDice = dmgDice;
		this.healthDie = healthDie;
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

	public int getFighterPAttack() {
		return this.fighterPAttack;
	}

	public void setFighterPAttack(int newFighterPAttack) {
		this.fighterPAttack = newFighterPAttack;
	}

	public int getFighterPDefense() {
		return this.fighterPDefense;
	}

	public void setFighterPDefense(int newFighterPDefense) {
		this.fighterPDefense = newFighterPDefense;
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

	public int getfighterMAttack() {
		return this.fighterMAttack;
	}

	public void setFighterMAttack(int newFighterMAttack) {
		this.fighterMAttack = newFighterMAttack;
	}

	public int getfighterMDefense() {
		return this.fighterMDefense;
	}

	public void setFighterMDefense(int newFighterMDefense) {
		this.fighterMDefense = newFighterMDefense;
	}

	public int getFighterEVA() {
		return this.fighterEVA;
	}

	public void setFighterEVA(int newFighterEVA) {
		this.fighterEVA = newFighterEVA;
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

	public int getFighterDmgDice() {
		return this.fighterDmgDice;
	}

	public void setFighterDmgDice(int newDmgDice) {
		this.fighterDmgDice = newDmgDice;
	}

	public void setPoison(boolean newPoison) {
		this.poison = newPoison;
	}

	public void setPoisonCounter(int newPoisonCounter) {
		this.poisonCounter = newPoisonCounter;
	}

	public static boolean THEO(Fighter enemy){
		if(this.fighterAGI/enemy.getFighterEVA >= Dice.rollDice(100,1)){
		return true;
		}else{
		System.out.println("Attack Misses!");
		return false;
		}

	public void attacks(Fighter fighter) {
		boolean hit = fighter.THEO(enemy);
		if (hit == true) {
			int damage = STR / 2 + (this.fighterLVL / 2);
			int newHealth = fighter.getFighterHP() - damage;

			// prevent negative health
			if (newHealth < 0) {
				fighter.setFighterHP(0);
			} else {
				fighter.setFighterHP(newHealth);
			}
			System.out.println(fighter.getFighterName() + " took " + damage
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
				// TODO: make sure game doesn't crash after using a potion when
				// have none
				// tried to add code to stop game from failing if used too many
				// potions
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
