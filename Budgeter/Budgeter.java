// Student: Theodore Kim
// 10.27.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Budgeter
// Calculates total income/total expenses/daily average income and expenses/
// net income/net income category based on user input
// and prints them with a net income category custom message.

import java.util.*;
public class Budgeter {
    // A default number of days in a month.
    public static final int DAYS_IN_MONTH = 31;

    public static void main(String[] args) {
        printIntro();

        Scanner console = new Scanner(System.in);

        double totalIncome = computeTotal(console, "income", 1);

        int expenseFreq = getExpenseFreq(console);
        double totalExpenses = computeTotal(console, "expense", expenseFreq);

        printTotalAmount(totalIncome, totalExpenses);

        printNetIncome(totalIncome - totalExpenses);
    }

    // Prints a net income, a net income cateogry and a net income category custom message.
    // Parameters:
    //  double difference: difference between total income and total expenses.
    public static void printNetIncome(double difference) {
        String earnedOrSpent = "";
        String saverOrSpender = "";
        String moreThan = "";
        String customMessage = "";

        // If earned more than spent.
        if (difference > 0) {
            earnedOrSpent = "earned";
            moreThan = "spent";
            if (difference > 250) {
                saverOrSpender = "big saver";
                customMessage = "Invest big in your present!";
            } else {
                saverOrSpender = "saver";
                customMessage = "Invest in your present!";
            }
            // If spent more than earned or spent as much as earned.
        } else {
            earnedOrSpent = "spent";
            moreThan = "earned";
            if (difference <= -250) {
                saverOrSpender = "big spender";
                customMessage = "Invest big in your future!";
            } else {
                saverOrSpender = "spender";
                customMessage = "Invest in your future!";
            }
        }

        // Prints whether a user earned or spent more.
        // An absolute value of a difference rounded to the nearest hundreath.
        System.out.println("You " + earnedOrSpent + " $"
                + Math.abs(round2(difference))
                + " more than you " + moreThan + " this month.");
        // Prints a net income category.
        System.out.println("You're a " + saverOrSpender + ".");
        // Prints a net income custom message.
        System.out.println(customMessage);
    }

    // Rounds a number to the nearest hundreath.
    // Returns a double rounded number.
    // Parameter:
    //  double num - number to be rounded.
    public static double round2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

    // Prints total monthly and daily average budgets rounded to the nearest hundreath.
    // Parameters:
    //  String budgetType - budget type.
    //  double total - total budget.
    public static void printTotal(String budgetType, double total) {
        System.out.println("Total " + budgetType + " = $" + round2(total)
                + " ($" + round2(total / DAYS_IN_MONTH) + "/day)");
    }

    // Prints total amount of budgets.
    // Parameters:
    //  int totalIncome - total income amount.
    //  int totalExpenses - total expenses amount.
    public static void printTotalAmount(double totalIncome, double totalExpenses) {
        printTotal("income", totalIncome);
        printTotal("expenses", totalExpenses);
        System.out.println();
    }

    // Gets a frequency of expenses based on input (int 1 - monthly / int 2 - daily).
    // Returns int frequency of expenses.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    public static int getExpenseFreq(Scanner console) {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        // return frequency of expenses.
        return console.nextInt();
    }

    // Computes a total budget based on input.
    // Returns double total budget.
    // Parameters:
    //  Scanner console - console to retrieve input from.
    //  String budgetType - budget type to prompt.
    //  int frequency - frequency of budget (int 1 - monthly / int 2 - daily).
    public static double computeTotal(Scanner console, String budgetType, int frequency) {
        // Prompts and retrieves a number of budget categories.
        System.out.print("How many categories of " + budgetType + "? ");
        int numOfCats = console.nextInt();

        // Promopts and retrieves budget amounts and calculates a sum.
        double sum = 0;
        for(int i = 0; i < numOfCats; i++) {
            System.out.print("    Next " + budgetType + " amount? $");
            sum += console.nextDouble();
        }
        System.out.println();

        double total = 0;
        // For monthly budget.
        if(frequency == 1) {
            total = sum;
            // For daily budget.
        } else if (frequency == 2) {
            total = sum * DAYS_IN_MONTH;
        }

        return total;
    }

    // Prints an introduction of the program.
    public static void printIntro() {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }
}