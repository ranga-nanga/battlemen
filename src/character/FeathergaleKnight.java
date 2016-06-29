package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Item;
import battlemen.Fighter;

public class FeathergaleKnight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	static int health = 10;
	static int dmgDie = 6;
	static int healthDie = 8;
	static int strength = 8;
	static List<Item> equipment = new ArrayList<Item>();
	
	public static void initEquip(){
		equipment.add(new Item("sword", "broad"));
		equipment.add(new Item("potion", "3"));
	}
	
	public FeathergaleKnight(String name){
		super(name, health, strength, dmgDie, healthDie, equipment);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
