// Student: Theodore Kim
// 12.08.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Critters
// A class to represent a Bird in a 2D simulation of critters.
// Construtor - Defines a Bird.
// Behavior:
//	Movement - A Bird moves north, east, south, and west 
//				three times respectively and repeats.
//	Eating - A Bird does not eat all the time.
//	Fighting - A Bird roars if it encounters an ant ("%"). Pounce otherwise.
//	Color - A Bird is blue all the time.
//	String - A Bird is represented "^" (north), ">" (east),
//	 			"V" (south), "<" (west) depending on its last move.

import java.util.*;
import java.awt.*;

public class Bird extends Critter {
    private int numMove; // Represents number of moves a Bird made.

    // Constructs a new Bird.
    public Bird() {
        numMove = 0;
    }

    // A Bird roars if it encounters an ant ("%"). Pounce otherwise.
	// Returns an Attack value to indicate how to attack.
	// Parameters:
	//	String opponent: opponent's appearance in String value.
	public Attack fight(String opponent) {
		Attack attack = Attack.FORFEIT;

        if(opponent.equals("%")) {
            attack = Attack.ROAR;
        } else {
            attack = Attack.POUNCE;
        }

        return attack;
	}

	// A Bird is blue all the time.
	// Returns a color of a critter.
	public Color getColor() {
		return Color.BLUE;
	}

	// A Bird moves north, east, south, and west 
	//	three times respectively and repeats.
	// Returns a Direction to move.
	public Direction getMove() {
		Direction nextMove = Direction.NORTH;

		if (numMove % 12 < 3) {
			nextMove = Direction.NORTH;
		} else if (numMove % 12 < 6) {
			nextMove = Direction.EAST;
		} else if (numMove % 12 < 9) {
			nextMove = Direction.SOUTH;
		} else if (numMove % 12 < 12) {
			nextMove = Direction.WEST;
		}

		numMove++;

		return nextMove;
	}

	// A Bird is represented "^" (north), ">" (east),
	//	"V" (south), "<" (west) depending on its last move.
	// Returns a string value to represent apperance of a critter.
	public String toString() {
		String string = "^";
		int prevNumMove = numMove - 1;
		
        if (prevNumMove % 12 < 3) {
            string = "^";
        } else if (prevNumMove % 12 < 6) {
            string = ">";
        } else if (prevNumMove % 12 < 9) {
            string = "V";
        } else if (prevNumMove % 12 < 12) {
            string = "<";
        }

        return string;
	}    
}
