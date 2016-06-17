package character;

import java.util.Scanner;

import monster.Monster;

public class Character {
	/*
	 * Default values for maxhealth, health and damage
	 * These values are initialized when you create a new Hero in your Battle class
	 */
		public int maxCharacterHealth = 5;
		public int characterHealth = 5;
		public int characterDamage = 2;
		public String characterName = "";
			
		/*
		 * Constructor is called when initializing a new hero
		 * Pass in values for health and damage when creating to override default values
		 */
		public Character(String name, int maxHealth, int health, int dmg){
			this.characterName = name;
			this.maxCharacterHealth = maxHealth;
			this.characterHealth = health;
			this.characterDamage = dmg;
		}

		public String getCharacterName(){
			return characterName;
		}
		
		public void setCName(String newName){
			this.characterName = newName;
		}
		
		public int getCharacterHealth(){
			return this.characterHealth;
		}
		
		public void setCharacterHealth(int newHealth){
			this.characterHealth = newHealth;
		}
		
		public int getCharacterDamage(){
			return this.characterDamage;
		}
		
		public void setCharacterDamage(int newDamage){
			this.characterDamage = newDamage;
		}
		
		public void attacksMonster(Monster monster){
			int newHealth = monster.getMonsterHealth() - this.characterDamage;	
			monster.setMonsterHealth(newHealth);
			System.out.println("The monster took " + this.characterDamage + " damage!");
		}
		
		public  void usePotion(){
			this.characterHealth += 3;
			System.out.print("You heal for 3 points!");
		}
		
		public void newMaxHeroHealth(){
			this.maxCharacterHealth += 5;
			System.out.println("You leveled up! Your Max Health is now " + this.maxCharacterHealth + " !");
			System.out.println("You currently have " + this.characterHealth + " HP out of " + this.maxCharacterHealth);
		}
	
		}

