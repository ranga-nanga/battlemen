package character;

import java.util.ArrayList;
import java.util.List;

import equipment.Blade;
import equipment.Item;
import equipment.Utility;
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
	
	public FeathergaleKnight(String name){
		super(name, health, strength, dmgDie, healthDie, equipment);
		initEquip();
		this.setEquipment(equipment); 
	}
	
	public static void initEquip(){
		equipment.add(new Blade("broadsword"));
		equipment.add(new Utility("potion", 3));
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
