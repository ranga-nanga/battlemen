package battlemen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import equipment.Item;
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
		public int fighterStrength = 0;
		public int healthDie = 0;
		public List<Item> equipment = new ArrayList<Item>();
		
		public Fighter(String name, int health, int strength, int dmgDice, int healthDie, List<Item> list){
			this.fighterName = name;
			this.maxFighterHealth = health;
			this.fighterHealth = health;
			this.fighterStrength = strength;
			this.fighterDefense = (strength+health)/2;
			this.fighterDmgDice = dmgDice;
			this.healthDie = healthDie;
			this.equipment.addAll(list);
		}
		
		public void setEquipment(List<Item> items){
			this.equipment.addAll(items);
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
			System.out.println("Attack Roll: " + roll);
			System.out.println(fighter.getFighterName() + "'s defense: " + fighter.getFighterDefense());
			if (roll + this.fighterStrength > fighter.getFighterDefense()){
			    System.out.println(this.fighterName + "'s attack hit " + fighter.getFighterName() + "!");
			    //calculate damage
			    int damage = Dice.rollDice(this.fighterDmgDice, 1); /*+ this.fighterStrength;*/
			    if(roll == 20){
					System.out.println("Critical Hit!");
					damage = damage*2;
				}
			    
			    //deal damage
			    int newHealth = fighter.getFighterHealth() - damage;	
			    
			    //prevent negative health
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
		
		public void inventory(){
			for(Item i : equipment){
				System.out.println(i.getType() + " " + i.getGroup());
			}
		}
		
		public void useItem(String item){
			switch(item){
				case "potion":
					usePotion();
					break;
			}
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
			for(Item item : equipment){
				if(item.getGroup().equalsIgnoreCase("potion")){
					int count = Integer.valueOf((String) item.getType());
					item.setType(count-1);
				}
			}
		}
		
		public void newMaxFighterHealth(){
			this.maxFighterHealth += Dice.rollDice(healthDie, 1);
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
