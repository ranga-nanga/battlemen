package battlemen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import character.Barbarian;
import character.FeathergaleKnight;
import character.Rogue;
import equipment.Item;
import battlemen.Fighter;

public class Battle {
	static Fighter[] players;
	//TODO: create dynamic monster generation
	Enemy Angorus = new Enemy("Angorus", 20, 1, 1);
	Scanner input = new Scanner(System.in);
	String in = "";
	
	public static void main(String[] args) {
		Battle b = new Battle();
		b.setupPlayers();
		//do-while looping the next three methods if input is yes or y, print theres something in the darkness, investigate?: 
		b.turnSystem();
		b.bodyCount();
		b.levelUp();
	}	
	
	public void setupPlayers(){
		// Initialize the Characters and any monsters they will face
		System.out.print("How many players?: ");
		in = input.nextLine().trim();
		//if the input was empty, or if the input was not all digits, loop until it is
		while(in.equals("") || !in.matches("[0-9]+")){
			System.out.print("Please enter a number: ");
			in = input.nextLine().trim();
		} 

		// Setup all Characters
		players = new Fighter[Integer.parseInt(in)];
		for (int i = 0; i < Integer.parseInt(in); i++) {
			System.out.print('\n' + "Name player " + (i + 1) + ": ");
			String name = input.nextLine().trim();
			boolean classDefined = false;
			while(classDefined == false){
				System.out.print("Pick " + name
						+ "'s class(FGK, Rogue, Barbarian): ");
				String playerClass = input.nextLine().trim();
			
				switch (playerClass) {
					case "FGK":
						players[i] = new FeathergaleKnight(name);
						classDefined = true;
						break;
					case "Rogue":
						players[i] = new Rogue(name);
						classDefined = true;
						break;
					case "Barbarian":
						players[i] = new Barbarian(name);
						classDefined = true;
						break;
					default:
						System.out.println("That is not a defined player class, pick another." + '\n');
						break;
				}
			}
		}
	}
	
	public void turnSystem(){
		while (Angorus.getFighterHealth() > 0) {
			//TODO: add break if no one is alive, skip players that are dead
			for (int i = 0; i < players.length; i++) {
				System.out.println('\n' + "1. "+ players[i].getFighterName()+ " [a]ttack");
				System.out.println("2. " + players[i].getFighterName()+ " [i]nventory");
				System.out.println("3. " + players[i].getFighterName()+ " use [item]");
				Method[] actions = players[i].getClass().getDeclaredMethods();
				int j = 4;
				for (Method method : actions) {
					System.out.println(j + ". " + players[i].getFighterName() + " " + method.getName());
					j++;
				}
				boolean actionFound = false;
				while (actionFound == false) {
					System.out.println(players[i].getFighterName() + "'s health: " + players[i].getFighterHealth());
					System.out.println(Angorus.getFighterName() + "'s health: " + Angorus.getFighterHealth());
					System.out.print("What will you do?: ");
					in = input.nextLine().trim();
					
					if (in.equals("a")){
						players[i].attacks(Angorus);
						actionFound = true;
					} else if(in.equals("i")){
						players[i].inventory();
					} else if(in.contains("use")){
						players[i].useItem(in.substring(4));
						actionFound = true;
					} else {
						for (Method action : actions) {
							//Have to call Character methods directly
							if (action.getName().contains(in)) {
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
			
			if(Angorus.getFighterHealth() <= 0){
				break;
			}
			//makes it to where monster attacks a random person on the field
			System.out.println('\n' + "The monster is attacking!");
			Angorus.attacks(players[new Random().nextInt(players.length)]);
		}
	}
	
	public void bodyCount(){
		//Body count to show how many died fighting the monster(s)
		System.out.println('\n' + "RIP:");
		for(Fighter player: players){
			if(player.getFighterHealth() == 0){
				//TODO: remove players that died from the array
				System.out.println(player.getFighterName() + " died in combat.");
			}
		}
	}

	public void levelUp(){
		//TODO: add exp point system?
		System.out.println("Congratulations to the survivors, you have defeated the Monster!");
		for(Fighter player : players){
			//TODO: set health = maxHealth healing leveled up players
			player.newMaxFighterHealth();
		}	
		System.out.println("But what horrors await you in the days to come...?");
	}
}

