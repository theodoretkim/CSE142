// Student: Theodore Kim
// 10.13.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// SpaceNeedle
// Draws the Space Needle using ASCII characters.

public class SpaceNeedle {
    // Constant that determines the size of the Space Needle.
    public static final int SIZE = 4;

    public static void main(String[] args) {
        drawShaft();
        drawDeck();
        drawLoupe();
        drawShaft();
        drawSupport();
        drawDeck();
    }

    // Draws a shaft to a given SIZE.
    public static void drawShaft() {
        for (int line = 1; line <= SIZE; line++) {
            // Draws spaces.
            for (int space = 1; space <= 3 * SIZE; space++) {
                System.out.print(" ");
            }
            // Draws a line of a shaft.
            System.out.println("||");
        }
    }

    // Draws a deck to a given SIZE.
    public static void drawDeck() {
        // Draws an upper part of a deck.
        for (int line = 1; line <= SIZE; line++) {
            // Draws spaces.
            for (int space = 0; space < -3 * line + 3 * SIZE; space++) {
                System.out.print(" ");
            }
            // Draws a line of a upper deck.
            System.out.print("__/");
            for (int colon = 1; colon <= 3 * line - 3; colon++) {
                System.out.print(":");
            }
            System.out.print("||");
            for (int colon = 1; colon <= 3 * line - 3; colon++) {
                System.out.print(":");
            }
            System.out.println("\\__");
        }

        // Draws a lower part of a deck.
        System.out.print("|");
        for (int quotation = 1; quotation <= 6 * SIZE; quotation++) {
            System.out.print("\"");
        }
        System.out.println("|");
    }

    // Draws The Loupe to a given SIZE.
    public static void drawLoupe() {
        for (int line = 1; line <= SIZE; line++) {
            // Draws spaces.
            for (int space = 0; space < 2 * line - 2; space++) {
                System.out.print(" ");
            }
            // Draws a line of The Loupe.
            System.out.print("\\_");
            for (int mountain = 1; mountain <= -2 * line + 3 * SIZE + 1; mountain++) {
                System.out.print("/\\");
            }
            System.out.println("_/");
        }
    }

    // Draws a support to a given SIZE.
    public static void drawSupport() {
        for (int line = 1; line <= SIZE * SIZE; line++) {
            // Draws spaces.
            for (int space = 1; space <= 2 * SIZE + 1; space++) {
                System.out.print(" ");
            }
            // Draws a line of a support.
            System.out.print("|");
            for (int modulo = 0; modulo < SIZE - 2; modulo++) {
                System.out.print("%");
            }
            System.out.print("||");
            for (int modulo = 0; modulo < SIZE - 2; modulo++) {
                System.out.print("%");
            }
            System.out.println("|");
        }
    }

}