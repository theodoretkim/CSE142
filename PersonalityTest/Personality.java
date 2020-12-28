// Student: Theodore Kim
// 11.24.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Personality
// Processes Keirsey Temperament Sorter personality test responses
// stored in an input file and creates an output file with results.

import java.util.*;
import java.io.*;

public class Personality {
    // Number of dimensions.
    public static final int NUM_DIMENSIONS = 4;

    public static void main(String[] args) throws FileNotFoundException {
        printIntro();

        Scanner console = new Scanner(System.in);
        File inputFile = getInputFile(console);
        File outputFile = getOutputFile(console);

        Scanner fileScanner = new Scanner(inputFile);
        PrintStream output = new PrintStream(outputFile);
        while(fileScanner.hasNextLine()) {
            String name = fileScanner.nextLine();
            String response = fileScanner.nextLine();

            int[] aCount = new int[4];
            int[] bCount = new int[4];
            countAB(response, aCount, bCount);

            int[] bPercentages = evalBPercentage(aCount, bCount);

            String personalityType = evalPersonalityType(bPercentages);

            output.println(name + ": " + Arrays.toString(bPercentages) + " = " + personalityType);
        }
    }

    // Prints an introduction of the program.
    public static void printIntro() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    // Prompts and retrieves an input file.
    // Returns an input file.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    public static File getInputFile(Scanner console) throws FileNotFoundException {
        System.out.print("input file name? ");
        File inputFile = new File(console.nextLine());
        
        return inputFile;
    }

    // Prompts and retrieves an output file.
    // Returns an output file.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    public static File getOutputFile(Scanner console) throws FileNotFoundException {
        System.out.print("output file name? ");

        return (new File(console.nextLine()));
    }

    // Counts As and Bs in each dimension of personality.
    // Parameters:
    //  String response - string with responses.
    //  int[] aCount - array to save A responses in each dimension.
    //  int[] bCount - array to save B responses in each dimension.
    public static void countAB(String response, int[] aCount, int[] bCount) {
        for(int i = 0; i < 70; i++) {
            if(Character.toLowerCase(response.charAt(i)) == 'a') {
                aCount[evalDimension(i)]++;
            } else if(Character.toLowerCase(response.charAt(i)) == 'b') {
                bCount[evalDimension(i)]++;
            }
        }
    }

    // Evaluates which dimension of personality a response belongs to.
    // Returns a dimension of personality:
    //  (0 - E vs I; 1 - S vs N; 2 - T vs F; 3 - J vs P).
    // Parameters:
    //  int index - index of a response.
    public static int evalDimension(int index) {
        int dimension = -1;
        
        if(index % 7 == 0) {
            dimension = 0;
        } else if (index % 7 == 1 || index % 7 == 2) {
            dimension = 1;
        } else if (index % 7 == 3 || index % 7 == 4) {
            dimension = 2;
        } else {
            dimension = 3;
        }

        return dimension;
    }

    // Evaluates a percentage of B responses.
    // Returns an array of B response percentages in each dimension.
    // Parameters:
    //  int[] aCount: Count of A responses in each dimension.
    //  int[] bCount: Count of B responses in each dimension.
    public static int[] evalBPercentage(int[] aCount, int[] bCount) {
        int[] bPercentages = new int[NUM_DIMENSIONS];
        
        for(int i = 0; i < NUM_DIMENSIONS; i++) {
            double percentage = bCount[i] * 100.0 / (aCount[i] + bCount[i]);
            bPercentages[i] = (int)Math.round(percentage);
        }

        return bPercentages;
    }

    // Evaluates a personality type based on B percentages.
    // Returns personality type.
    // Parameters:
    //  int[] bPercnetages - B responses in percentages.
    public static String evalPersonalityType(int[] bPercentages) {
        char[] personality = {'X', 'X', 'X', 'X'};
        char[] personalityArray = {'E', 'I', 'S', 'N', 'T', 'F', 'J', 'P'};

        for(int i = 0; i < NUM_DIMENSIONS; i++) {
            if(bPercentages[i] < 50) {
                personality[i] = personalityArray[i * 2];
            } else if (bPercentages[i] > 50) {
                personality[i] = personalityArray[i * 2 + 1];
            }
        }

        String personalityType = new String(personality);

        return personalityType;
    }
}
