package battlemen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import character.Barbarian;
import character.Knight;
import character.Rogue;
import character.Wizard;
import dungeon.Main;
import equipment.Item;
import equipment.Utility;
import battlemen.Fighter;

public class Battle {
	
	static Fighter[] players;
	//TODO: create dynamic monster generation, see line 39
	Enemy Angorus = new Enemy("Angorus");
	static Scanner input = new Scanner(System.in);
	static String in = "";
	
	public static void main(String[] args) {
		setupPlayers();
		encounter();
	}
	
	public static void encounter(){
		Battle b = new Battle();
		while(true){
			System.out.print("Something lurks within the Darkness. Venture forth and investigate?: ");
			in = input.nextLine();
			if(in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("y")){
				System.out.println("It's a hostile creature!");
				//TODO: generate creature dynamically
				b.turnSystem();
				b.bodyCount();
				b.levelUp();
			}
		}
	}
	
	public static void setupPlayers(){
		// Setup all Characters
		int playerNum = 4;
		players = new Fighter[playerNum];
		for (int i = 0; i < playerNum; i++) {
			System.out.print('\n' + "Name player " + (i + 1) + ": ");
			String name = input.nextLine().trim();
			switch (i) {
				case 0:
					players[i] = new Rogue(name);
					break;
				case 1:
					players[i] = new Knight(name);
					break;
				case 2:
					players[i] = new Barbarian(name);
					break;
				case 3:
					players[i] = new Wizard(name);
					break;
			}
		}
	}
	
	public void turnSystem(){
		while (Angorus.getFighterHP() > 0) {
			for (int i = 0; i < players.length-1; i++) {
				if(players[i].getFighterHP() <= 0){
					System.out.println(players[i].getFighterName()+" has given into the darkness and cannot fight.");
				} else if(Angorus.getFighterHP() <= 0){
					break;
				}else{
					System.out.println('\n' + "1. "+ players[i].getFighterName()+ " [a]ttack");
					System.out.println("2. " + players[i].getFighterName()+ " [i]nventory");
					System.out.println("3. " + players[i].getFighterName()+ " use [item]");
					System.out.println("4. " + players[i].getFighterName()+ " equip [weapon]");
					Method[] actions = players[i].getClass().getDeclaredMethods();
					int j = 4;
					for (Method method : actions) {
						System.out.println(j + ". " + players[i].getFighterName() + " " + method.getName());
						j++;
					}
					boolean actionFound = false;
					while (actionFound == false) {
						System.out.println('\n' + players[i].getFighterName() + "'s health: " + players[i].getFighterHP());
						System.out.println(Angorus.getFighterName() + "'s health: " + Angorus.getFighterHP());
						System.out.print("What will you do?: ");
						in = input.nextLine().trim();
						
						if (in.equals("a")){
							players[i].PAttacks(Angorus);
							actionFound = true;
						} else if(in.equals("i")){
							players[i].inventory();
						} else if(in.contains("use")){
							//Loop through players inventory, check for item, invoke useItem on it
							boolean itemFound = false;
							Item[] inv = players[i].characterInventory;
							for(int k = 0; k <=inv.length-1; k++){
								if(inv[k] != null && inv[k].getType().equals(in.substring(4))){
									if(inv[k].getClass().getName().contains("Utility")){
										Utility u = (Utility) inv[k];
										u.useUtility(players[i]);
									}
									itemFound = true;
								}
							}
							if(itemFound == false){
								System.out.println("It would seem you don't have one of those...");
							}
							actionFound = true;
						} else if(in.contains("equip")){
							if(players[i].equip(in.substring(6))){
								System.out.println(in.substring(6) + " equipped!");
								players[i].inventory();
								actionFound = true;
							} else {
								System.out.println(in.substring(6) + " not found in inventory/not a weapon");
							}
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
			}
			
			if(Angorus.getFighterHP() <= 0){
				System.out.println("The monster is dead!");
				break;
			} else {
				//monster attacks a random character
				int randomPlayer = new Random().nextInt(players.length);
				while(players[randomPlayer].getFighterHP() <= 0){
					randomPlayer = new Random().nextInt(players.length);
				}
				System.out.println('\n' + "The monster is attacking " + players[randomPlayer].getFighterName() + "!");
				Angorus.PAttacks(players[randomPlayer]);
			}
		}
	}
	
	public void bodyCount(){
		//Body count to show how many died fighting the monster(s)
		System.out.println('\n' + "RIP:");
		List<Fighter> survivors = new ArrayList<Fighter>();
		//loop through players finding survivors
		for(Fighter player: players){
			if(player.getFighterHP() <= 0){
				System.out.println(player.getFighterName() + " died in combat.");
			} else {
				survivors.add(player);
			}
		}
		//update players array with survivors
		players = survivors.toArray(new Fighter[survivors.size()]);
	}

	//TODO: put level up in playerStats class
	public void levelUp(){
		//TODO: add exp point system?
		//TODO: add money/gil/gold system for eventual shop?
		System.out.println("Congratulations to the survivors, you have defeated the Monster!");
		for(Fighter player : players){
			player.newMaxFighterHealth();
		}	
		System.out.println("But what horrors await you in the days to come...?");
	}
}

