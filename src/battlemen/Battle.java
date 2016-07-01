package battlemen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import character.Barbarian;
import character.FeathergaleKnight;
import character.Rogue;
import equipment.Item;
import battlemen.Fighter;

public class Battle {
	//gui components
	public static JFrame frame = new JFrame("RPG");
	
	static Fighter[] players;
	//TODO: create dynamic monster generation
	Enemy Angorus = new Enemy("Angorus", 20, 1, 1);
	static Scanner input = new Scanner(System.in);
	static String in = "";
	String playerCountNum = "";
	
	public Battle(){
		 try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
         }
		 JTextArea playerCountPrompt = new JTextArea();
		 playerCountPrompt.setText("How many players?:");
		 final JTextField playerCount = new JTextField();
		 JButton playerCountConfirm = new JButton();
		 playerCountConfirm.setText("Confirm");
		 playerCountConfirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				playerCountNum = playerCount.getText();
				frame.dispose();
				setupPlayers(playerCountNum);
			}
		 });
		 Dimension d = new Dimension(50, 10);
		 playerCount.setPreferredSize(d);
		 playerCount.setText("0");
		 
		//Setup Frame
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(new BorderLayout());
         frame.add(playerCountPrompt, BorderLayout.WEST);
         frame.add(playerCount, BorderLayout.EAST);
         frame.add(playerCountConfirm, BorderLayout.SOUTH);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
         
         
	}
	
	public static void main(String[] args) {
		Battle b = new Battle();
		new Battle();
		//do-while looping the next three methods if input is yes or y, print there's something in the darkness, investigate?: 
		while(true){
			System.out.println("Something lurks within the Darkness. Venture forth and investigate?");
			in = input.nextLine();
			if(in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("y")){
				b.turnSystem();
				b.bodyCount();
				b.levelUp();
			}
		}
	}
	
	public void setupPlayers(String playerCount){
		//if the input was empty, or if the input was not all digits, loop until it is
		while(playerCount.equals("") || !playerCount.matches("[0-9]+")){
			System.out.print("Please enter a number: ");
			playerCount = input.nextLine().trim();
		} 

		// Setup all Characters
		players = new Fighter[Integer.parseInt(playerCount)];
		for (int i = 0; i < Integer.parseInt(playerCount); i++) {
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
			//Added code to skip player if dead
			for (int i = 0; i < players.length; i++) {
				if(players[i].getFighterHealth() <= 0){
					System.out.println(players[i].getFighterName()+" has given into the darkness. They cannot fight.");
				}else{
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
			}
			
			if(Angorus.getFighterHealth() <= 0){
				break;
			}
			//makes it to where monster attacks a random person on the field
			System.out.println('\n' + "The monster is attacking!");
			Angorus.attacks(players[new Random().nextInt(players.length)]);
			
			}
	}
	
	//TODO: check if player died after the attack. and to print out that they died so it doesn't print out
	
	//might have to delete from here
	//public int target(){
	//players[new Random().nextInt(players.length)] ;
	//}
	//to here
	
	
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
		//TODO: add money/gil/gold system for eventual shop?
		System.out.println("Congratulations to the survivors, you have defeated the Monster!");
		for(Fighter player : players){
			player.newMaxFighterHealth();
			player.fighterHealth = player.maxFighterHealth;
		}	
		System.out.println("But what horrors await you in the days to come...?");
	}
}

