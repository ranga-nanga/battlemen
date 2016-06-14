package battlemen;

import hero.Hero;
import hero.Rogue;
import monster.Monster;

public class Battle {
	public static void main(String[] args) {
		//Initialize the hero and any monsters he will face
		Rogue Harlow = new Rogue(5, 5, 1);
		Hero Doraleous = new Hero(6, 6, 1);
		Monster Angorus = new Monster(20, 1);
		Monster Godzilla = new Monster(5, 1);
		while(Angorus.getMonsterHealth() >= 0){
			Harlow.sneakAttack(Angorus);
			Doraleous.attacksMonster(Angorus);
			Angorus.attacksHero(Harlow);
			System.out.println("Harlow health: " + Harlow.getHeroHealth());
			System.out.println("Doraleous health: " + Doraleous.getHeroHealth());
			int currentMonsterHealth = Angorus.getMonsterHealth();
			if(currentMonsterHealth > 0){
				System.out.println("Angorus health now at: " + Angorus.getMonsterHealth());
				System.out.println("Godzilla health now at: " + Godzilla.getMonsterHealth());
			} else {
				System.out.println("The monster has been slain!");
			}
		}
		Harlow.newMaxHeroHealth();
	}
	
}

