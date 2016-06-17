package battlemen;

import java.lang.reflect.Method;
import java.util.Scanner;

import character.FeathergaleKnight;
import character.Rogue;
import character.Character;
import monster.Monster;

public class Battle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Initialize the Characteres and any monsters they will face
		System.out.print("How many players?: ");
		String in = input.nextLine().trim();

		// Setup all Characteres
		Character[] players = new Character[Integer.parseInt(in)];
		for (int i = 0; i < Integer.parseInt(in); i++) {
			System.out.print('\n' + "Name player " + (i + 1) + ": ");
			String name = input.nextLine().trim();
			System.out.print("Set " + name + "'s health: ");
			int health = Integer.parseInt(input.nextLine().trim());
			System.out.print("Set " + name + "'s damage: ");
			int damage = Integer.parseInt(input.nextLine().trim());
			System.out.print("Pick " + name
					+ "'s class(FeathergaleKnight, Rogue): ");
			String playerClass = input.nextLine().trim();
		
			switch (playerClass) {
			case "FeathergaleKnight":
				players[i] = new FeathergaleKnight(name, health, health, damage);
				break;
			case "Rogue":
				players[i] = new Rogue(name, health, health, damage);
				break;
			}
		}
			Monster Angorus = new Monster(20, 1);
			while (Angorus.getMonsterHealth() >= 0) {
				for (int i = 0; i < players.length; i++) {
					System.out.println('\n' + "1. "+ players[i].getCharacterName()+ " attacksMonster");
					System.out.println("2. " + players[i].getCharacterName()+ " usePotion");
					Method[] actions = players[i].getClass().getDeclaredMethods();
					int j = 1;
					for (Method method : actions) {
						System.out.println(j + ". " + players[i].getCharacterName() + " " + method.getName());
						j++;
					System.out.print("What will you do?: ");
					in = input.nextLine().trim();
					boolean actionFound = false;
					while (actionFound == false) {
						for (Method action : actions) {
							if (action.equals(in)) {
								if (in.contains("attacksMonster")
										|| (in.contains("sneakAttack"))) {
									
				//getting weird errors that i'm not familiar with.
				//not sure if you got this or not earlier, maybe i messed up the code somewhere else..?
									action.invoke(players[i], Angorus);

								} else {
									action.invoke(players[i]);
								}

				//please tell me how to fix above code.				
							} else if (action.equals(in)) {
								actionFound = true;
							} else {
								System.out.println(players[i].getCharacterName()+ " can't do that!");
							}

						}
					}
				}
			}
			}
		}
	
}

