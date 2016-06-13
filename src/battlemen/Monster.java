package battlemen;

public class Monster {
	/*
	 * Default values for monsterhealth and damage
	 * These values are initialized when you create a new Monster in your Battle class
	 */
	static int monsterHealth = 5;
	static int monsterDamage = 1;
	
	public int getMonsterHealth(){
		return monsterHealth;
	}
	
	public void setMonsterHealth(int newHealth){
		monsterHealth = newHealth;
	}
	
	public int getMonsterDamage(){
		return monsterDamage;
	}
	
	public void setMonsterDamage(int newDamage){
		monsterDamage = newDamage;
	}
	
	public void attacksHero(){
		Hero.heroHealth = Hero.heroHealth - monsterDamage;
		System.out.println("You took " + monsterDamage + " damage!");
		System.out.println("You have " + Hero.heroHealth + " health left!");
	}
	
	void newMHealth(int heroHealth){
		monsterHealth = 5;
	}
}
