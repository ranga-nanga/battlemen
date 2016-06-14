package hero;

import monster.Monster;

public class Hero {
	/*
	 * Default values for maxhealth, health and damage
	 * These values are initialized when you create a new Hero in your Battle class
	 */
		public static int maxHeroHealth = 5;
		public static int heroHealth = 5;
		public static int heroDamage = 2;
			
		public int getHeroHealth(){
			return heroHealth;
		}
		
		public void setHeroHealth(int newHealth){
			heroHealth = newHealth;
		}
		
		public int getHeroDamage(){
			return heroDamage;
		}
		
		public void setHeroDamage(int newDamage){
			heroDamage = newDamage;
		}
		
		public void attacksMonster(){
			Monster.monsterHealth = Monster.monsterHealth - heroDamage;	
			System.out.println("The monster took " + heroDamage + " damage!");
		}
		
		public  void usePotion(){
			heroHealth += 3;
			System.out.print("You heal for 3 points!");
		}
		
		public void newMaxHeroHealth(){
			maxHeroHealth += 5;
			System.out.println("You leveled up! Your Max Health is now " + maxHeroHealth + " !");
			System.out.println("You currently have " + heroHealth + " HP out of " + maxHeroHealth);
		}
}
