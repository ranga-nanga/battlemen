package character;

import equipment.Blade;
import equipment.Item;
import equipment.Utility;
import battlemen.Fighter;

public class Knight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	static int healthDie = 6;
	static int LVL = 1;
	static int XP = 0;
	static int VIT = 5;
	static int HP = 7;
	static int STR = 5;
	static int MND = 7;
	static int MP = 9;
	static int  AGI = 10;
	static Item[] equipment = new Item[10];
	
	public Knight(String name){
		super(name, LVL, XP, VIT, HP, STR, healthDie, MND, MP, AGI, equipment);
		this.initEquip();
	}
	
	private void initEquip(){
		equipment[0] = new Blade("broadsword");
		equipment[1] = new Utility("potion", 3);
		this.setEquipment(equipment);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
