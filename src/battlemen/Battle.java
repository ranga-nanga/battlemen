package battlemen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

import character.Barbarian;
import character.FeathergaleKnight;
import character.Rogue;
import battlemen.Fighter;

public class Battle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Initialize the Characteres and any monsters they will face
		System.out.print("How many players?: ");
		String in = input.nextLine().trim();

		// Setup all Characteres
		Fighter[] players = new Fighter[Integer.parseInt(in)];
		for (int i = 0; i < Integer.parseInt(in); i++) {
			System.out.print('\n' + "Name player " + (i + 1) + ": ");
			String name = input.nextLine().trim();
			System.out.print("Set " + name + "'s health: ");
			int health = Integer.parseInt(input.nextLine().trim());
			System.out.print("Set " + name + "'s damage: ");
			int defense = Integer.parseInt(input.nextLine().trim());
			System.out.print("Set " + name + "'s defense: ");
			int damage = Integer.parseInt(input.nextLine().trim());
			System.out.print("Pick " + name
					+ "'s class(FeathergaleKnight, Rogue, Barbarian): ");
			String playerClass = input.nextLine().trim();
		
			switch (playerClass) {
				case "FGK":
					players[i] = new FeathergaleKnight(name, health, damage, defense);
					break;
				case "Rogue":
					players[i] = new Rogue(name, health, damage, defense);
					break;
				case "Barbarian":
					players[i] = new Barbarian(name, health, damage, defense);
					break;
			}
		}
		Fighter Angorus = new Fighter("Angorus", 20, 1, 10);
		while (Angorus.getFighterHealth() > 0) {
			for (int i = 0; i < players.length; i++) {
				System.out.println('\n' + "1. "+ players[i].getFighterName()+ " attack");
				System.out.println("2. " + players[i].getFighterName()+ " usePotion");
				Method[] actions = players[i].getClass().getDeclaredMethods();
				int j = 1;
				for (Method method : actions) {
					System.out.println(j + ". " + players[i].getFighterName() + " " + method.getName());
					j++;
				//moved below bracket to current position this was looping around the rest of the code
				}
				boolean actionFound = false;
				while (actionFound == false) {
					System.out.print("What will you do?: ");
					in = input.nextLine().trim();
					
					if (in.contains("attack")){
						players[i].attacks(Angorus);
						actionFound = true;
					} else if(in.contains("usePotion")){
						players[i].usePotion();
						actionFound = true;
					} else {
						for (Method action : actions) {
							//Have to call Character methods directly
							if (action.getName().contains(in)) {
								//Fixed errors using catch statements
								try {
									action.invoke(players[i], Angorus);
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
								actionFound = true;
							}
						}
						if(actionFound == false){
							System.out.println(players[i].getFighterName() + " can't do that!");
						}
					}
				}
				
			}
			//makes it to where monster attacks a random person on the field
			System.out.println('\n' + "The monster is attacking!");
			Angorus.attacks(players[new Random().nextInt(players.length)]);
		}
		
		//Body count to show how many died fighting the monster(s)
		System.out.println("RIP:");
		for(Fighter player: players){
			if(player.getFighterHealth() == 0){
				System.out.println(player.getFighterName() + " died in combat.");
			}
		}
		
		System.out.println("Congratulations to the survivors, you have defeated the Monster!");
		for(Fighter player : players){player.newMaxFighterHealth();
		}	
		System.out.println("But what horrors await you in the days to come...?");
		
	}
	
}

