package character;

import equipment.Club;
import equipment.Item;
import equipment.Utility;
import battlemen.Fighter;

public class Wizard extends Fighter{

	static int LVL = 0;
	static int XP = 0;
	static int VIT = 0;
	static int HP = 0;
	static int STR = 0;
	static int healthDie = 0;
	static int MND = 0;
	static int MP = 0;
	static int AGI = 0;
	static Item[] equipment = new Item[10];
	
	public Wizard(String name) {
		super(name, LVL, XP, VIT, HP, STR, healthDie, MND, MP, AGI, equipment);
		this.WeaponSlot = new Club("staff");
		equipment[0] = new Utility("potion", 3);
		this.setEquipment(equipment);
	}
}
