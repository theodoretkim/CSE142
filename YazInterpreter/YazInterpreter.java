// Student: Theodore Kim
// 11.17.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// YazInterpreter
// Interprets a YazLang program and outputs a result to a file.

import java.util.*;
import java.io.*;

public class YazInterpreter {
    public static void main(String[] args) throws FileNotFoundException {
        printIntro();

        Scanner console = new Scanner(System.in);

        String option = ""; // Loop priming.
        while(!option.equals("Q")) {
            option = getMenuOption(console);
            if(option.equals("I") || option.equals("V")) {
                File inputFile = getInputFile(console);

                if(option.equals("I")) {
                    File outputFile = getOutputFile(console);
                    interpret(inputFile, outputFile);
                    System.out.println("YazLang interpreted and output to a file!");
                    System.out.println();
                } else if(option.equals("V")) {
                    view(inputFile);
                    System.out.println();
                }
            } 
        }
    }

    // Prints an introduction of the program.
    public static void printIntro() {
        System.out.println("Welcome to YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a file or view a previously");
        System.out.println("interpreted YazLang program.");
        System.out.println();
    }

    // Prompts and retrieves a menu option.
    // Returns a menu option.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    public static String getMenuOption(Scanner console) {
        System.out.print("(I)nterpret YazLang program, (V)iew output, (Q)uit? ");
        String option = console.nextLine().toUpperCase();

        return option;
    }

    // Prompts and retrieves an input file.
    // Returns an input file.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    public static File getInputFile(Scanner console) throws FileNotFoundException {
        System.out.print("Input file name: ");
        File inputFile = new File(console.nextLine());

        while(!inputFile.exists()) {
            System.out.print("File not found. Try again: ");
            inputFile = new File(console.nextLine());
        }

        return inputFile;
    }

    // Prompts and retrieves an output file.
    // Returns an output file.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    public static File getOutputFile(Scanner console) throws FileNotFoundException {
        System.out.print("Output file name: ");
        return (new File(console.nextLine()));
    }

    // Interprets an YazLang program from an inputFile and write a result to an outputFile.
    // Parameters:
    //  File inputFile - inputFile to read a YazLang program from.
    //  File outputFile - outputFile to write an interpreted YazLang program to.
    public static void interpret(File inputFile, File outputFile) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(inputFile);
        PrintStream output = new PrintStream(outputFile);

        while(fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());

            while(lineScanner.hasNext()) {
                String command = lineScanner.next();
                String outputLine = "";

                if(command.equals("CONVERT")) {
                    outputLine = convert(lineScanner);
                } else if (command.equals("RANGE")) {
                    outputLine = range(lineScanner);
                } else if (command.equals("REPEAT")) {
                    outputLine = repeat(lineScanner);
                }

                output.println(outputLine);
            }
        }
    }

    // Converts a temperature from Celsius to Fahernheit or vice versa.
    // Returns a temperature in Celsius or Fahrenheit.
    // Parameters:
    //  Scanner lineScanner - lineScanner to retrieve arguments from.
    public static String convert(Scanner lineScanner) {
        int arg1 = lineScanner.nextInt();
        String arg2 = lineScanner.next();
        String outputLine = "";

        if(arg2.equals("C")) {
            int fahrenheit = (int) (1.8 * arg1 + 32);
            outputLine = fahrenheit + "F";
        } else if(arg2.equals("F")) {
            int celsius = (int) ((arg1 - 32) / 1.8);
            outputLine = celsius + "C";
        }

        return outputLine;
    }

    // Ranges numbers from the 1st argument (inclusive) and the 2nd argument (exclusive)
    //  increased by the 3rd argument.
    // Returns a string of numbers between the 1st argument (inclusive) 
    //  and the 2nd argument (exclusive) increased by the 3rd argument.
    // Parameters:
    //  Scanner lineScanner - lineScanner to retrieve arguments from.
    public static String range(Scanner lineScanner) {
        int arg1 = lineScanner.nextInt();
        int arg2 = lineScanner.nextInt();
        int arg3 = lineScanner.nextInt();
        String outputLine = "";
                    
        for(int i = arg1; i < arg2; i += arg3) {
            outputLine += (i + " ");
        }

        return outputLine;
    }

    // Repeats each string by the indicated number.
    // Returns a String with repeated substrings.
    // Parameters:
    //  Scanner lineScanner - lineScanner to retrieve arguments from.
    public static String repeat(Scanner lineScanner) {
        String output = "";

        while(lineScanner.hasNext()) {
            String arg1 = lineScanner.next();
            arg1 = arg1.replace("_", " ");
            arg1 = arg1.substring(1, arg1.length()-1);
            int arg2 = lineScanner.nextInt();

            for(int i = 0; i < arg2; i++) {
                output += arg1;
            }
        }

        return output;
    }

    // Prints all lines of an inputFile.
    //  Parameters:
    //  File inputFile - inputFile to read all lines from.
    public static void view(File inputFile) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(inputFile);
        System.out.println();
        while(fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
    }

    
}
