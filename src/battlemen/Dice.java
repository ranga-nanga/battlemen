package battlemen;
import java.util.Random;

//int rollNum = 0; : the number of dice rolled
//int rollTotal = 0; : the total result of all dice rolled.
// While the number or dice rolled is less than the amount of dice to roll, roll the dice
//rollTotal is equal to the number rolled on the dice
//roll again if still less than required rolls
//return the value of all the dice added up.

public  class Dice {
	
	public static int rollD2(int numDice) {
		int rollNum = 0;
		int rollTotal = 0;
		while ( rollNum < numDice ) {
			int roll = new Random().nextInt(2)+1;
			rollTotal += roll;
			rollNum++;
		}
		return rollTotal;
	}

public static int rollD3(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(3)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}
	
public static int rollD4(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(4)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}

public static int rollD6(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(6)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}

public static int rollD8(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(8)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}

public static int rollD10(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(10)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}

public static int rollD12(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(12)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}

public static int rollD20(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(20)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}


public static int rollD100(int numDice) {
	int rollNum = 0;
	int rollTotal = 0;
	while ( rollNum < numDice ) {
		int roll = new Random().nextInt(100)+1;
		rollTotal += roll;
		rollNum++;
	}
	return rollTotal;
}

}
