// Student: Theodore Kim
// 10.20.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// CafeWall
// Draws rows and grids of alternating black and white squares.

import java.awt.*;
public class CafeWall {
    // Number of pixels between rows of a grid.
    public static final int MORTAR = 2;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics brush = panel.getGraphics();

        // Draws "row A".
        drawRow(brush, 0, 0, 4, 20);
        // Draws "row B".
        drawRow(brush, 50, 70, 5, 30);
        // Draws "grid C".
        drawGrid(brush, 400, 20, 2, 35, 35);
        // Draws "grid D".
        drawGrid(brush, 10, 150, 4, 25, 0);
        // Draws "grid E".
        drawGrid(brush, 250, 200, 3, 25, 10);
        // Draws "grid F".
        drawGrid(brush, 425, 180, 5, 20, 10);
    }

    // Draws a grid.
    // Parameters:
    //  Graphics brush - brush to draw on a panel.
    //  int x - x coordinate of a grid.
    //  int y - y coordinate of a grid.
    //  int pairs - number of pairs of rows/blocks in a grid/row.
    //  int size - size of a block.
    //  int offset - number of pixels offset to the right.
    public static void drawGrid(Graphics brush, int x, int y, int pairs, int size, int offset) {
        // Draws "pairs" of rows.
        for (int i = 0; i < pairs; i++) {
            // Draws the first row of a pair.
            drawRow(brush, x, y, pairs, size);
            y = y + size + MORTAR;

            // Draws the second row of a pair with offset.
            drawRow(brush, x + offset, y, pairs, size);
            y = y + size + MORTAR;
        }
    }

    // Draws a row.
    // Parameters:
    //  Graphics brush - brush to draw on a panel.
    //  int x - x coordinate of a row.
    //  int y - y coordinate of a row.
    //  int pairs - number of pairs of blocks in a row.
    //  int size - size of a block.
    public static void drawRow(Graphics brush, int x, int y, int pairs, int size) {
        // Draws "pairs" of blocks.
        for (int i = 0; i < pairs; i++) {
            // Draws the first block of a pair.
            drawBlackBlock(brush, x, y, size);
            x = x + size;

            // Draws the second block of a pair.
            drawBlock(brush, x, y, size, Color.WHITE);
            x = x + size;
        }
    }

    // Draws a black block with a blue 'X'.
    // Parameters:
    //  Graphics brush - brush to draw on a panel.
    //  int x - x coordinate of a black block.
    //  int y - y coordinate of a black block.
    //  int size - size of a black block.
    public static void drawBlackBlock(Graphics brush, int x, int y, int size) {
        // Draws a black square.
        drawBlock(brush, x, y, size, Color.BLACK);

        // Draws a blue X on a black square.
        brush.setColor(Color.BLUE);
        brush.drawLine(x, y, x + size, y + size);
        brush.drawLine(x + size, y, x, y+ size);
    }

    // Draws a block.
    // Parameters:
    //  Graphics brush - brush to draw on a panel.
    //  int x - x coordinate of a block.
    //  int y - y coordinate of a block.
    //  int size - size of a block.
    //  Color color - color of a block.
    public static void drawBlock(Graphics brush, int x, int y, int size, Color color) {
        brush.setColor(color);
        brush.fillRect(x, y, size, size);
    }
}