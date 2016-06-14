package battlemen;

import hero.Hero;
import hero.Rogue;
import monster.Monster;

public class Battle {
	public static void main(String[] args) {
		//Initialize the hero and any monsters he will face
		Rogue Harlow = new Rogue();
		Hero Doraleous = new Hero();
		Monster Angorus = new Monster();
		while(Angorus.getMonsterHealth() >= 0){
			Harlow.sneakAttack();
			Doraleous.attacksMonster();
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

