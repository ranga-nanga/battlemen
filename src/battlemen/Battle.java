package battlemen;

import battlemen.Hero;
import battlemen.Monster;

public class Battle {
	public static void main(String[] args) {
		//Initialize the hero and any monsters he will face
		Hero Harlow = new Hero();
		Monster Angorus = new Monster();
		while(Angorus.getMonsterHealth() >= 0){
			Harlow.attacksMonster();
			Angorus.attacksHero();
			int currentMonsterHealth = Angorus.getMonsterHealth();
			if(currentMonsterHealth > 0){
				System.out.println("Monster health now at: " + Angorus.getMonsterHealth());
			} else {
				System.out.println("The monster has been slain!");
			}
		}
		Harlow.newMaxHeroHealth();
	}
	
}

