package monster;

import character.Character;

public class Monster {
	/*
	 * Default values for monsterhealth and damage
	 * These values are initialized when you create a new Monster in your Battle class
	 */
		public int monsterHealth = 5;
		public int monsterDamage = 1;
		public boolean poison = false;
		
		/*
		 * Constructor is called when initializing a new hero
		 * Pass in values for health and damage when creating to override default values
		 */
		public Monster(int health, int dmg){
			this.monsterHealth = health;
			this.monsterDamage = dmg;
		}
	
		public int getMonsterHealth(){
			return this.monsterHealth;
		}
		
		public void setMonsterHealth(int newHealth){
			this.monsterHealth = newHealth;
		}
		
		public int getMonsterDamage(){
			return this.monsterDamage;
		}
		
		public void setMonsterDamage(int newDamage){
			this.monsterDamage = newDamage;
		}
		
		public void setPoison(boolean newPoison){
			this.poison = newPoison;
		}
		
		public void evaluate(){
			if(poison == true){
				this.monsterHealth--;
			}
		}
		
		public void attacksHero(Character hero){
			int newHealth = hero.getCharacterHealth() - this.monsterDamage;
			hero.setCharacterHealth(newHealth);
			System.out.println(hero.getCharacterName() + " took " + this.monsterDamage + " damage!");
			System.out.println(hero.getCharacterName() +" has " + hero.characterHealth + " health left!");
		}
		
		void newMHealth(int heroHealth){
			this.monsterHealth = 5;
		}
}
