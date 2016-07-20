package equipment;

import battlemen.Fighter;

public class Utility extends Item{
	
	public int amount = 0;

	public Utility(String type, int amount){
		super("Utility", type);
		this.amount = amount;
	}
	
	public void setAmount(int newAmount){
		this.amount = newAmount;
	}
	
	public int getAmount(){
		return this.amount;
	}
	
	public void useUtility(Fighter fighter){
		switch (this.type.toString()) {
		case "potion":
			this.usePotion(fighter);
			break;
		}
	}
	
	public void usePotion(Fighter fighter) {
		//Decrement potion count
		this.setAmount(this.amount-1);
		
		//Heal fighter
		int healthDifference = fighter.fighterMaxHP - fighter.fighterHP;
		if (healthDifference > 3) {
			healthDifference = 3;
		}
		fighter.fighterHP += healthDifference;
		if (healthDifference == 1) {
			System.out.println(fighter.fighterName + " heals for 1 point!");
		} else {
			System.out.println(fighter.fighterName + " heals for " + healthDifference + " points!");
		}
		System.out.println(fighter.fighterName + " now has " + fighter.fighterHP + " health!");
	}
		
}
