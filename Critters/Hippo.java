// Student: Theodore Kim
// 12.08.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Critters
// A class to represent a Hippo in a 2D simulation of critters.
// Constructor - Defines a Hippo with given hunger.
// Behavior:
//	Movement - A Hippo Moves in a random direction 5 times
//				then chooses another random direction and repeats.
//	Eating - A Hippo eats if it is still hungry, doesn't eat otherwise.
//			 (A Hippo is hungry if "int hunger" (variable) is greater than 0)
//	Fighting - A Hippo scratches if it is hungry, pounce otherwise.
//	Color - A Hippo is grey if it is hungry, white otherwise.
//	String - A Hippo is represented with int value of "hunger" variable.

import java.util.*;
import java.awt.*;

public class Hippo extends Critter {
	private Direction lastMove; // Represents last direction a Hippo moved.
    private int numMove; // Represents number of moves a Hippo made in one direction.
	private Random rnd; // Represents a random object to be used to choose a random direction.
	private int hunger; // Represents amount of food a Hippo can eat.

	// Constructs a new Hippo.
	// Parameters:
	//	int hunger - amount of food a Hippo can eat.
	public Hippo(int hunger) {
		lastMove = Direction.CENTER;
		numMove = 5;
		rnd = new Random();
		this.hunger = hunger;
	}

	// A Hippo scratches if it is hungry, pounce otherwise.
	// Returns a boolean value to indicate eat or not.
	public boolean eat() {
		boolean isEating = false;

		if(hunger > 0) {
			hunger--;
			isEating = true;
		}

		return isEating;
	}

	// A Hippo scratches if it is hungry, pounce otherwise.
	// Returns an Attack value to indicate how to attack.
	// Parameters:
	//	String opponent: opponent's appearance in String value.
	public Attack fight(String opponent) {
		Attack attack = Attack.POUNCE;

		if(hunger > 0) {
			attack = Attack.SCRATCH;
		}

		return attack;
	}

	// A Hippo is grey if it is hungry, white otherwise.
	// Returns a color of a critter.
	public Color getColor() {
		Color color = Color.WHITE;

		if(hunger > 0) {
			color = Color.GRAY;
		}

		return color;
	}

	// A Hippo Moves in a random direction 5 times
	//	then chooses another random direction and repeats.
	// Returns a Direction to move.
	public Direction getMove() {
		Direction nextMove = lastMove;

		if(numMove == 5) {
			numMove = 1;
			nextMove = Direction.values()[rnd.nextInt(4)];
			lastMove = nextMove;
		} else {
			numMove++;
		}

		return nextMove;
	}
	
	// A Hippo is represented with int value of "hunger" variable.
	// Returns a string value to represent apperance of a critter.
	public String toString() {
		return "" + hunger;
	}
}
