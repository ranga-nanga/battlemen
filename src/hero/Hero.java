package hero;

import monster.Monster;

public class Hero {
	/*
	 * Default values for maxhealth, health and damage
	 * These values are initialized when you create a new Hero in your Battle class
	 */
		public int maxHeroHealth = 5;
		public int heroHealth = 5;
		public int heroDamage = 2;
			
		/*
		 * Constructor is called when initializing a new hero
		 * Pass in values for health and damage when creating to override default values
		 */
		public Hero(int maxHealth, int health, int dmg){
			this.maxHeroHealth = maxHealth;
			this.heroHealth = health;
			this.heroDamage = dmg;
		}
		
		public int getHeroHealth(){
			return this.heroHealth;
		}
		
		public void setHeroHealth(int newHealth){
			this.heroHealth = newHealth;
		}
		
		public int getHeroDamage(){
			return this.heroDamage;
		}
		
		public void setHeroDamage(int newDamage){
			this.heroDamage = newDamage;
		}
		
		public void attacksMonster(Monster monster){
			int newHealth = monster.getMonsterHealth() - this.heroDamage;	
			monster.setMonsterHealth(newHealth);
			System.out.println("The monster took " + this.heroDamage + " damage!");
		}
		
		public  void usePotion(){
			this.heroHealth += 3;
			System.out.print("You heal for 3 points!");
		}
		
		public void newMaxHeroHealth(){
			this.maxHeroHealth += 5;
			System.out.println("You leveled up! Your Max Health is now " + this.maxHeroHealth + " !");
			System.out.println("You currently have " + this.heroHealth + " HP out of " + this.maxHeroHealth);
		}
}
