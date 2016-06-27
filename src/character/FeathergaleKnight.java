package character;

import battlemen.Fighter;

public class FeathergaleKnight extends Fighter{
	/*
	 * HUZZAH!
	 */
	
	public FeathergaleKnight(String name, int defense){
		super(name, 10, defense, 10);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
