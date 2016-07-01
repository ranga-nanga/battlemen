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
	//public static JFrame frame = new JFrame("RPG");
	
	static Fighter[] players;
	//TODO: create dynamic monster generation
	Enemy Angorus = new Enemy("Angorus", 20, 1, 1);
	static Scanner input = new Scanner(System.in);
	static String in = "";
	
//	public Battle(){
//		 try {
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//         }
//		 
//		//Setup Frame
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new BorderLayout());
//         frame.pack();
//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//	}
	
	public static void main(String[] args) {
		//new Battle();
		setupPlayers();
		encounter();
	}
	
	public static void encounter(){
		Battle b = new Battle();
		while(true){
			System.out.print("Something lurks within the Darkness. Venture forth and investigate?");
			in = input.nextLine();
			if(in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("y")){
				b.turnSystem();
				b.bodyCount();
				b.levelUp();
			}
		}
	}
	
	public static void setupPlayers(){
		// Setup all Characters
		int playerNum = 3;
		players = new Fighter[playerNum];
		for (int i = 0; i < playerNum; i++) {
			System.out.print('\n' + "Name player " + (i + 1) + ": ");
			String name = input.nextLine().trim();
			switch (i) {
				case 0:
					players[i] = new FeathergaleKnight(name);
					break;
				case 1:
					players[i] = new Rogue(name);
					break;
				case 2:
					players[i] = new Barbarian(name);
					break;
				case 3:
					//players[i] = new Wizard(name);
			}
		}
//		final int i = 0;
//		final JTextArea playerNamePrompt = new JTextArea();
//		final JTextField playerNameEntry = new JTextField();
//		JButton playerNameConfirm = new JButton();
//		JFrame namePrompt = new JFrame("Name player");
//		 playerNamePrompt.setText("Player " + (i+1));
//		 namePrompt.add(playerNamePrompt, BorderLayout.WEST);
//		 namePrompt.add(playerNameConfirm, BorderLayout.SOUTH);
//		 namePrompt.add(playerNameEntry, BorderLayout.EAST);
//		 namePrompt.pack();
//		 namePrompt.setLayout(new BorderLayout());
//		 namePrompt.setLocationRelativeTo(null);
//		 namePrompt.setVisible(true);
//		 playerNameConfirm.setText("Confirm");
//		 playerNameConfirm.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				players[i].setFighterName(playerNameEntry.getText());
//				if(i >= players.length){
//					i++;
//					playerNamePrompt.setText("Player " + (i+1));
//					playerNameEntry.setText("");
//				}
//				setupPlayers();
//			}
//		 });
//		 Dimension d = new Dimension(50, 10);
//		 playerNameEntry.setPreferredSize(d);
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
							if(Angorus.getFighterHealth() < 0){
								break;
							}
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
			
			if(Angorus.getFighterHealth() < 0){
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

