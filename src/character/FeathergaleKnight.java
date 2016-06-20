package character;

public class FeathergaleKnight extends Character{
	/*
	 * HUZZAH!
	 */
	
	public FeathergaleKnight(String name, int maxHealth, int health, int dmg){
		super(name, maxHealth, health, dmg);
	}
	
	public void moralBoost(){
		System.out.println("HUZZAH!");
		
	}
}
