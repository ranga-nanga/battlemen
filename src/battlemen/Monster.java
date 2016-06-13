package battlemen;

public class Monster {

	static int monsterHealth = 5;
	static int monsterDamage = 1;
	
	public static void attacksHero(){
		Hero.heroHealth = Hero.heroHealth - monsterDamage;
		System.out.println("You took " + monsterDamage + " damage!");
		System.out.println("You have " + Hero.heroHealth + " health left!");
	}
	void newHHealth(int heroHealth){
		heroHealth = Hero.heroHealth;
	}
}
