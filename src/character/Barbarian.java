package character;

import battlemen.Fighter;

public class Barbarian extends Fighter{

	static int health = 15;
	static int dmgDie = 6;
	static int healthDie = 10;
	static int strength = 10;
	
	public Barbarian(String name){
		super(name, health, strength, dmgDie, healthDie);
	}
	
}
