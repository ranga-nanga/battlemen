package battlemen;

import java.util.ArrayList;
import java.util.List;

import equipment.Item;

public class Enemy extends Fighter{

	static List<Item> equipment = new ArrayList<Item>();
	
	public Enemy(String enemyName, int health, int strength, int dmgDice){
		super(enemyName, health, strength, dmgDice, 0, equipment);
	}
}
