// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// Simple point class for the closest distance algorithm.
package alg;
public class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters for the x and y components.
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
