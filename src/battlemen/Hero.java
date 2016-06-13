package battlemen;

public class Hero {
		static int maxHeroHealth = 5;
		static int heroHealth = 5;
		static int heroDamage = 2;
			
		 static void attacksMonster(){
			Monster.monsterHealth = Monster.monsterHealth - heroDamage;	
			System.out.println("The monster took " + heroDamage + " damage!");
		}
		static void usePotion(){
			heroHealth = heroHealth + 3;
			System.out.print("You heal for 3 points!");
		}
		
		void newMHealth(int monsterHealth){
			monsterHealth = Monster.monsterHealth;
		}
		static void newMaxHeroHealth(int maxHeroHealth){
			maxHeroHealth = (heroHealth = 5) + 5;
			System.out.println("You leveled up! Your Max Health is now " + maxHeroHealth + " !");
			System.out.println("You currently have " + heroHealth + " HP out of " + maxHeroHealth);
		}
}
