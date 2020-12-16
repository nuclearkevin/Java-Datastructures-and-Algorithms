// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package alg;
public class ClosestPoints {
    // Closest point function to initialize the recursion stack.
    public static double findClosestDistance(Point[] points) {
        // Mergesort to sort the points by x coordinates (the nlog(n) part).
        mergeSort(points);

        // Initiate the recursive calls (the log(n) part).
        return findClosestDistance(points, 0, points.length - 1);
    }

    // Actual recursive minimum distance function.
    private static double findClosestDistance(Point[] points, int start, int end) {
        // Base case. Return infinity for a subarray of size 1 because a self distance is invalid.
        if (end == start) {
            return Double.POSITIVE_INFINITY;
        } else if (end - start == 1) {
            return distance(points[end], points[start]);
        }

        // Compute middle index, divide step.
        int middle = (start + end) / 2;

        // Find the closest distance between the points in the sublists, conquer step.
        double leftD = findClosestDistance(points, start, middle);
        double rightD = findClosestDistance(points, middle + 1, end);

        // Return the minimum distance, merge step.
        return min(leftD, rightD);
    }

    // Helper function to compute distance between 2 points.
    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    // Merge sort to sort the points.
    private static void mergeSort(Point[] array) {
        if (array.length < 2) {
            return;
        }
        Point[] halfOne, halfTwo;

        if (array.length % 2 == 0) {
            halfOne = new Point[(array.length / 2)];
            halfTwo = new Point[(array.length / 2)];
            for (int i = 0; i < (array.length / 2); i++) {
                halfOne[i] = array[i];
            }
            for (int i = array.length / 2; i < array.length; i++) {
                halfTwo[i - (array.length / 2)] = array[i];
            }
        } else {
            halfOne = new Point[(array.length / 2)];
            halfTwo = new Point[(array.length / 2) + 1];
            for (int i = 0; i < (array.length / 2); i++) {
                halfOne[i] = array[i];
            }
            for (int i = (array.length / 2); i < array.length; i++) {
                halfTwo[i - (array.length / 2)] = array[i];
            }
        }
        mergeSort(halfOne);
        mergeSort(halfTwo);

        merge(array, halfOne, halfTwo);
    }

    private static void merge(Point[] target, Point[] halfOne, Point[] halfTwo) {
        int i = 0;
        int j = 0;

        while(i + j < target.length) {
            if (j == halfTwo.length || (i < halfOne.length && halfOne[i].getX() < halfTwo[j].getX())) {
                target[i + j] = halfOne[i++];
            } else {
                target[i + j] = halfTwo[j++];
            }
        }
    }

    private static double min(double i, double j) {
        return (i < j) ? i : j;
    }
}
