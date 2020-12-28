// Student: Theodore Kim
// 12.08.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Critters
// A class to represent an ant in a 2D simulation of critters.
// Constructor - Defines an Ant with given directions it can move.
// Behavior:
//	Movement - An Ant moves south and east alternatively when walkSouth is true.
//			   An Ant moves north and east alternatively when walkSouth is false.
//	Eating - An Ant eats all the time.
//	Fighting - An Ant scratches all the time.
//	Color - An Ant is red all the time.
//	String - An Ant is displayed by "%" all the time.

import java.util.*;
import java.awt.*;

public class Ant extends Critter {
	private boolean walkSouth; // Represents which directions an Ant can move.
	private Direction lastMove; // Represents last direction an Ant moved.

	// Constructs a new Ant.
	// Parameters:
	//	boolean walkSouth - determines which directions an ant can move.
	public Ant(boolean walkSouth) {
		this.walkSouth = walkSouth;
		lastMove = Direction.EAST;
	}

	// An Ant eats all the time.
	// Returns a boolean value to indicate eat or not.
	public boolean eat() {
		return true;
	}

	// An Ant scratches all the time.
	// Returns an Attack value to indicate how to attack.
	// Parameters:
	//	String opponent: opponent's appearance in String value.
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}

	// An Ant is red all the time.
	// Returns a color of a critter.
	public Color getColor() {
		return Color.RED;
	}

	// An Ant moves south and east alternatively when walkSouth is true.
	// An Ant moves north and east alternatively when walkSouth is false.
	// Returns a Direction to move.
	public Direction getMove() {
        Direction nextMove = lastMove;
        if(walkSouth) {
            if(lastMove == Direction.EAST) {
                nextMove = Direction.SOUTH;
            } else {
                nextMove = Direction.EAST;
            }
        } else {
            if(lastMove == Direction.EAST) {
                nextMove = Direction.NORTH;
            } else {
                nextMove = Direction.EAST;
            }
        }

        lastMove = nextMove;

        return nextMove;
	}

	// An Ant is displayed by "%" all the time.
	// Returns a string value to represent apperance of a critter.
	public String toString() {
		return "%";
	}
}
