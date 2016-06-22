package battlemen;
import battlemen.Dice;

public class Fighter {
	/* Default values for maxhealth, health and damage
	 * These values are initialized when you create a new Hero in your Battle class
	 */
		public int maxFighterHealth = 5;
		public int fighterHealth = 5;
		public String fighterName = "";
		public boolean poison = false;
		public int poisonCounter = 0;
		public int fighterDefense = 0;
		public int fighterDmgDice = 0;
		/*
		 * Constructor is called when initializing a new hero
		 * Pass in values for health and damage when creating to override default values
		 */
		public Fighter(String name, int maxHealth, int defense, int dmgDice){
			this.fighterName = name;
			this.maxFighterHealth = maxHealth;
			this.fighterHealth = maxHealth;
			this.fighterDefense = defense;
			this.fighterDmgDice = dmgDice;
		}
		
		public int getFighterDefense(){
			return this.fighterDefense;
		}
		
		public void setFighterDefense(int newFighterDefense){
			this.fighterDefense = newFighterDefense;
		}

		public String getFighterName(){
			return fighterName;
		}
		
		public void setFighterName(String newName){
			this.fighterName = newName;
		}
		
		public int getFighterHealth(){
			return this.fighterHealth;
		}
		
		public void setFighterHealth(int newHealth){
			this.fighterHealth = newHealth;
		}
		
		public int getFighterDmgDice(){
			return this.fighterDmgDice;
		}
		
		public void setFighterDmgDice(int newDmgDice){
			this.fighterDmgDice = newDmgDice;
		}
		
		public void setPoison(boolean newPoison){
			this.poison = newPoison;
		}
		
		public void setPoisonCounter(int newPoisonCounter){
			this.poisonCounter = newPoisonCounter;
		}
		
		public void attacks(Fighter fighter){
			int roll = Dice.rollDice(20, 1);
			if (roll > fighter.getFighterDefense()){
			    System.out.println(this.fighterName + "'s attack hit " + fighter.getFighterName() + "!");
			    int damage = Dice.rollDice(this.fighterDmgDice, 1);
			    if(roll == 20){
					System.out.println("Critical Hit!");
					damage = damage*2;
				}
			    int newHealth = fighter.getFighterHealth() - damage;	
			    if(newHealth < 0){
			    	fighter.setFighterHealth(0);
			    } else {
			    	fighter.setFighterHealth(newHealth);
			    }
				System.out.println(fighter.getFighterName() + " took " + damage + " damage!");
				System.out.println(fighter.getFighterName() + " has " + fighter.getFighterHealth() + " health left!");
			}else{
			   System.out.println(this.fighterName + "'s attack missed!");
			}
			this.evaluate();
		}
		
		public  void usePotion(){
			int healthDifference = maxFighterHealth - fighterHealth;
			if (healthDifference > 3){
				healthDifference = 3;
			}
			fighterHealth += healthDifference;
			if(healthDifference == 1){
				System.out.println(this.fighterName + " heals for 1 point!");
			} else {
				System.out.println(this.fighterName + " heals for " + healthDifference + " points!");
			}
			System.out.println(this.fighterName + " now has " + this.fighterHealth + " health!");
		}
		
		public void newMaxFighterHealth(){
			this.maxFighterHealth += 5;
			System.out.println("You leveled up! Your Max Health is now " + this.maxFighterHealth + " !");
			System.out.println("You currently have " + this.fighterHealth + " HP out of " + this.maxFighterHealth);
		}
		
		public void evaluate(){
			if(this.poisonCounter == 0){
				this.poison = false;
			}
			if(poison == true){
				this.fighterHealth--;
				this.poisonCounter--;
				System.out.println(this.fighterName + " took poison damage!");
				System.out.println(this.fighterName + "'s health is now at " + this.fighterHealth);
			}
		}
	
}
