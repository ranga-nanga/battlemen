package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Club;
import equipment.Item;
import equipment.Utility;
import battlemen.Fighter;

public class Barbarian extends Fighter{

	static int health = 15;
	static int dmgDie = 6;
	static int healthDie = 10;
	static int strength = 10;
	static List<Item> equipment = new ArrayList<Item>();
	
	public Barbarian(String name){
		super(name, health, strength, dmgDie, healthDie, equipment);
		initEquip();
		this.setEquipment(equipment); 
	}
	
	public static void initEquip(){
		equipment.add(new Club("mace"));
		equipment.add(new Utility("potion", 3));
	}
	
}
