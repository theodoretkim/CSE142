// Student: Theodore Kim
// 12.08.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Critters
// A class to represent a Vulture in a 2D simulation of critters.
// Constructor - defines a Vulture.
// Behavior:
//	Movement - A Vulture moves north, east, south, and west 
//				three times respectively and repeats.
//	Eating - A Vulture eats when it encounters first food or after each fight.
//	Fighting - A Vulture roars if it encounters an ant ("%"). Pounce otherwise.
// 				A Vulture gets hungry after each fight.
//	Color - A Vulture is black all the time.
//	String - A Vulture is represented "^" (north), ">" (east),
//	 			"V" (south), "<" (west) depending on its last move.

import java.util.*;
import java.awt.*;

public class Vulture extends Bird {
	private boolean isHungry; // Represents if a Bird is hungry.

	// Constructs a new Vulture.
	public Vulture() {
		isHungry = true;
	}

	// A Vulture eats when it encounters first food or after each fight.
	// Returns a boolean value to indicate eat or not.
	public boolean eat() {
		boolean isEating = false;

		if(isHungry) {
			isEating = true;
			isHungry = false;
		}

		return isEating;
	}

	// A Vulture roars if it encounters an ant ("%"). Pounce otherwise.
	// 	A Vulture gets hungry after each fight.
	// Returns an Attack value to indicate how to attack.
	// Parameters:
	//	String opponent: opponent's appearance in String value.
	public Attack fight(String opponent) {
		isHungry = true;

        return super.fight(opponent);
	}

	// A Vulture is black all the time.
	// Returns a color of a critter.
	public Color getColor() {
		return Color.BLACK;
	}

}
