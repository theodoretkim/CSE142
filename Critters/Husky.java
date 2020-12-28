// Student: Theodore Kim
// 12.08.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Critters
// A class to represent a husky in a 2D simulation of critters.
// Constructor - defines a husky.
// Behavior:
//	Movement - A Husky moves East all the time.
//	Eating - A Husky eats all the time.
//	Fighting - A Husky roars all the time.
//	Color - A Husky is green all the time.
//	String - A husky is represented with "T" all the time.

import java.util.*;
import java.awt.*;

public class Husky extends Critter {
	
	// Constructs a new Husky.
    public Husky() {
    }

	// A Husky eats all the time.
	// Returns a boolean value to indicate eat or not.
    public boolean eat() {
		return true;
	}

	// A Husky roars all the time.
	// Returns an Attack value to indicate how to attack.
	// Parameters:
	//	String opponent: opponent's appearance in String value.
	public Attack fight(String opponent) {
		return Attack.ROAR;
	}

	// A Husky is green all the time.
	// Returns a color of a critter.
	public Color getColor() {
		return Color.GREEN;
	}

	// A Husky moves East all the time.
	// Returns a Direction to move.
	public Direction getMove() {
		return Direction.EAST;
	}

	// A husky is represented with "T" all the time.
	// Returns a string value to represent apperance of a critter.
	public String toString() {
		return "T";
	}
}
