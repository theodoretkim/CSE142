// Student: Theodore Kim
// 10.13.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// AsciiArt
// Draws a five-story building using ASCII characters.

public class AsciiArt {
    public static void main(String[] args) {
        // Draws the top fringe of the building.
        drawBuildingFringe();
        // Draws the body of the five-story building.
        drawBody();
        // Draws the base of the building.
        drawEmptyFloor();
        drawBuildingFringe(); // Draws the bottom fringe of the building.
    }
    // Draws a top/bottom fringe of a building.
    public static void drawBuildingFringe() {
        for (int dash = 1; dash <= 27; dash++) {
            System.out.print("-");
        }
        System.out.println();
    }
    // Draws a body of a five-story building.
    public static void drawBody() {
        for (int story = 1; story <= 5; story++) {
            drawEmptyFloor();
            drawWindowedFloor();
        }
    }
    // Draws an empty floor.
    public static void drawEmptyFloor() {
        for (int line = 1; line <= 5; line++) {
            System.out.print("|");
            for (int space = 1; space <= 25; space++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
    // Draws an windowed floor.
    public static void drawWindowedFloor() {
        drawWindowFringeLine();
        for (int line = 2; line <= 6; line++)
        {
            drawSideWindowFrameLine();
        }
        drawWindowFringeLine();
    }
    // Draws a line with top/bottom fringes of two windows.
    public static void drawWindowFringeLine() {
        System.out.print("|");
        drawWindowFringe();
        drawWindowFringe();
        drawFiveSpaces();
        System.out.println("|");
    }
    // Draws five spaces and a top/bottom window fringe.
    public static void drawWindowFringe() {
        drawFiveSpaces();
        for (int dash = 1; dash <= 5; dash++) {
            System.out.print("-");
        }
    }
    // Draws five spaces.
    public static void drawFiveSpaces() {
        for (int space = 1; space <= 5; space++) {
            System.out.print(" ");
        }
    }
    // Draws a line with side frames of two windows.
    public static void drawSideWindowFrameLine() {
        System.out.print("|");
        drawSideWindowFrame();
        drawSideWindowFrame();
        drawFiveSpaces();
        System.out.println("|");
    }

    // Draws fives spaces and a two side frames of a window.
    public static void drawSideWindowFrame() {
        drawFiveSpaces();
        System.out.print("|");
        for (int space = 1; space <= 3; space++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }
}