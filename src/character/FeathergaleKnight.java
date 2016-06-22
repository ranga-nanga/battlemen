package character;

import battlemen.Fighter;

public class FeathergaleKnight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	public FeathergaleKnight(String name, int maxHealth, int defense){
		super(name, maxHealth, defense, 10);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
