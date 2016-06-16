package battlemen;

import java.lang.reflect.Method;
import java.util.Scanner;

import character.Rogue;
import character.Hero;
import monster.Monster;

public class Battle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Initialize the heroes and any monsters they will face
		System.out.print("How many players?: ");
		String in = input.nextLine().trim();

		// Setup all heroes
		Hero[] players = new Hero[Integer.parseInt(in)];
		for (int i = 0; i < Integer.parseInt(in); i++) {
			System.out.print('\n' + "Name player " + (i + 1) + ": ");
			String name = input.nextLine().trim();
			System.out.print("Set " + name + "'s health: ");
			int health = Integer.parseInt(input.nextLine().trim());
			System.out.print("Set " + name + "'s damage: ");
			int damage = Integer.parseInt(input.nextLine().trim());
			System.out.print("Pick " + name + "'s class(Hero, Rogue): ");
			String playerClass = input.nextLine().trim();
			switch (playerClass) {
			case "Hero":
				players[i] = new Hero(name, health, health, damage);
				break;
			case "Rogue":
				players[i] = new Rogue(name, health, health, damage);
				break;
			}
		}
		Monster Angorus = new Monster(20, 1);
		while (Angorus.getMonsterHealth() >= 0) {
			for (int i = 0; i < players.length; i++) {
				System.out.println("What will you do?");
				System.out.println('\n' + "1. " + players[i].getHeroName() + " attacksMonster");
				System.out.println("2. " + players[i].getHeroName() + " usePotion");
				Method[] actions = players[i].getClass().getDeclaredMethods();
					if (!players[i].getClass().getName().equals("hero.Hero")) {
					int j = 1;
					for (Method method : actions) {System.out.println(j + ". " + players[i].getHeroName() + " " + method.getName());
					j++;
				}

			}

		}
		/*
		 * Rogue Harlow = new Rogue("Harlow", 5, 5, 1); Hero Doraleous = new
		 * Hero("Doraleous", 6, 6, 1); Monster Angorus = new Monster(20, 1); int
		 * action = 0;
		 * 
		 * //Choose an action on player turn while(Angorus.getMonsterHealth() >=
		 * 0){ System.out.println("1. Harlow attacks");
		 * System.out.println("2. Harlow heals");
		 * System.out.println("3. Doraleous attacks");
		 * System.out.println("4. Doraleous heals");
		 * System.out.print("What will you do?: "); in =
		 * input.nextLine().trim(); switch(in){ case "1":
		 * if(Harlow.getHeroHealth() > 0){ Harlow.sneakAttack(Angorus);
		 * System.out.println("Angorus health now at: " +
		 * Angorus.getMonsterHealth()); }else{
		 * System.out.println("Harlow is currently unable to fight at this time."
		 * ); } break; case "2": Harlow.usePotion(); break; case "3":
		 * if(Doraleous.getHeroHealth() > 0){ Doraleous.attacksMonster(Angorus);
		 * System.out.println("Angorus health now at: " +
		 * Angorus.getMonsterHealth()); }else{
		 * System.out.println("Doraleous is currently unable to fight at this time."
		 * ); } break; case "4": Doraleous.usePotion(); break; }
		 * System.out.println("Harlow health: " + Harlow.getHeroHealth());
		 * System.out.println("Doraleous health: " + Doraleous.getHeroHealth());
		 * int currentMonsterHealth = Angorus.getMonsterHealth();
		 * if(currentMonsterHealth > 0){ System.out.println("Angorus attacks");
		 * Angorus.attacksHero(Harlow); } else {
		 * System.out.println("The monster has been slain!"); } }
		 * Harlow.newMaxHeroHealth();
		 */
	}
}
}