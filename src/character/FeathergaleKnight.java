package character;

import battlemen.Fighter;

public class FeathergaleKnight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	public FeathergaleKnight(String name, int maxHealth, int dmg){
		super(name, maxHealth, dmg);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
