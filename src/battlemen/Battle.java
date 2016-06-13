package battlemen;

import battlemen.Hero;
import battlemen.Monster;

public class Battle {
	public static void main(String[] args) {
		while(Monster.monsterHealth >= 0){
			Hero.attacksMonster();
			Monster.attacksHero();
		}
		Hero.newMaxHeroHealth(0);
	}
	
}

