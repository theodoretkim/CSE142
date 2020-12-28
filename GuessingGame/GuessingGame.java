// Student: Theodore Kim
// 11.04.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// GuessingGame
// Prints whether a pseudorandom integer matches or
// is higher/lower than a player's guessed integer.
// Also prints overall game results.

import java.util.*;

public class GuessingGame {

    // A max value of a pseudorandom integer.
    public static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        printIntro();

        int totalGames = 0; // Initializes a total number of games played.
        int totalGuesses = 0; // Initializes a total number of guesses needed in all games.
        int bestGame = 0; // Initiazlies a minimum number of guesses needed in all games.
        Scanner console = new Scanner(System.in);
        Random r = new Random();

        String playAgain = "y"; // Loop priming.
        while(playAgain.toLowerCase().startsWith("y")) {
            int guessCount = playSingleGame(console, 1 + r.nextInt(MAX_VALUE));
            totalGames++;
            totalGuesses += guessCount;

            // Updates bestGame.
            if(bestGame == 0) { // If it was the first game played.
                bestGame = guessCount;
            } else {
                if(guessCount < bestGame) {
                    bestGame = guessCount;
                }
            }

            System.out.print("Do you want to play again? ");
            playAgain = console.next();
            System.out.println();
        }

        printStat(totalGames, totalGuesses, bestGame);
    }

    // Prints an introduction.
    public static void printIntro() {
        // Prints an introduction in the form of a haiku.
        System.out.println("Predict a number");
        System.out.println("Tell you higher or lower");
        System.out.println("Until you are right");
        System.out.println();
    }

    // Plays a single game.
    // Returns a number of guesses needed in a single game.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    //  int ranNum - pesudorandum number a player needs to guess.
    public static int playSingleGame(Scanner console, int ranNum) {
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");

        int guessCount = 0;

        int guessNum = 0; // Loop priming.
        while(ranNum != guessNum) {
            System.out.print("Your guess? ");
            guessNum = console.nextInt();
            guessCount++;

            if(ranNum > guessNum) {
                System.out.println("It's higher.");
            } else if(ranNum < guessNum) {
                System.out.println("It's lower.");
            }
        }

        if(guessCount == 1) {
            System.out.println("You got it right in 1 guess!");
        } else {
            System.out.println("You got it right in " + guessCount + " guesses!");
        }

        return guessCount;
    }

    // Prints overall statistics of all games played.
    // Parameters:
    //  int totalGames - total number of games played.
    //  int totalGuesses - total number of guesses needed in all games.
    //  int bestGame - minimum number of guesses needed in all games.
    public static void printStat(int totalGames, int totalGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/game  = " + round1(totalGuesses * 1.0 / totalGames));
        System.out.println("Best game     = " + bestGame);
    }

    // Rounds a number to the nearest tenth.
    // Returns a rounded number.
    // Parameter:
    //  double number - a number to be rounded.
    public static double round1(double number) {
        return Math.round(number * 10.0) / 10.0;
    }
}