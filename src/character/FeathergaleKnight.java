package character;

import battlemen.Fighter;

public class FeathergaleKnight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	static int health = 10;
	static int dmgDie = 6;
	static int healthDie = 8;
	static int strength = 8;
	
	public FeathergaleKnight(String name){
		super(name, health, strength, dmgDie, healthDie);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
