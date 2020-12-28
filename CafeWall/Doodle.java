// Student: Theodore Kim
// 10.20.2020
// CSE 142 Section BO
// TA: Sandy Cheng
// Doodle
// Draws a reversed flag with a canton, seven red stripes and six white stripes.

import java.awt.*;
public class Doodle {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(1900, 1000);
        panel.setBackground(Color.GRAY);
        Graphics brush = panel.getGraphics();

        drawStripes(brush, 0, Color.RED, 7);
        drawStripes(brush, 77, Color.WHITE, 6);
        drawCanton(brush);
    }

    // Draws a canton.
    // Parameters:
    //  Graphics brush - brush to draw on a panel.
    public static void drawCanton(Graphics brush) {
        brush.setColor(Color.BLUE);
        brush.fillRect(1900 - 760, 0, 760, 539);
    }

    // Draws stripes.
    // Parameters:
    //  Graphics brush - brush to draw on a panel.
    //  int y - y coordinate of a stripe.
    //  Color color - color of a stripe.
    //  numStripes - number of stripes.
    public static void drawStripes(Graphics brush, int y, Color color, int numStripes)
    {
        brush.setColor(color);
        for (int i = 0; i < numStripes; i++) {
            brush.fillRect(0, y, 1900, 77);
            y = y + 77 * 2;
        }
    }
}