package character;

import battlemen.Fighter;

public class FeathergaleKnight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	public FeathergaleKnight(String name, int maxHealth, int dmg, int defense){
		super(name, maxHealth, dmg, defense);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
