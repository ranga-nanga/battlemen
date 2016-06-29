package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Item;
import battlemen.Fighter;

public class Barbarian extends Fighter{

	static int health = 15;
	static int dmgDie = 6;
	static int healthDie = 10;
	static int strength = 10;
	static List<Item> equipment = new ArrayList<Item>();
	
	public static void initEquip(){
		equipment.add(new Item("sword", "long"));
		equipment.add(new Item("potion", "3"));
	}
	
	public Barbarian(String name){
		super(name, health, strength, dmgDie, healthDie, equipment);
	}
	
}
