package character;

import java.util.List;

import equipment.Item;
import battlemen.Fighter;

public class Wizard extends Fighter{
	public Wizard(String name, int health, int strength, int dmgDice,
			int healthDie, List<Item> list) {
		super(name, health, strength, dmgDice, healthDie, list);
	}
}
