// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package alg;
public class MinMaxDC {

    public static int MaxDC(int array[], int start, int end) {
        // Base cases.
        if (end == start) {
            return array[end];
        }
        if (end - start == 1) {
            return max(start, end);
        }

        // Divide.
        int middle = (end + start) / 2;

        // Conquer.
        if ((end + start) % 2 == 0) {
            return max(MaxDC(array, start, middle), MaxDC(array, middle + 1, end));
        } else {
            return max(MaxDC(array, start, middle - 1), MaxDC(array, middle, end));
        }
    }

    public static int MinDC(int array[], int start, int end) {
        // Base cases.
        if (end == start) {
            return array[end];
        }
        if (end - start == 1) {
            return min(start, end);
        }

        // Divide.
        int middle = (end + start) / 2;

        // Conquer.
        if ((end + start) % 2 == 0) {
            return min(MinDC(array, start, middle), MinDC(array, middle + 1, end));
        } else {
            return min(MinDC(array, start, middle - 1), MinDC(array, middle, end));
        }
    }

    private static int max(int i, int j) {
        return (i > j) ? i : j;
    }

    private static int min(int i, int j) {
        return (i < j) ? i : j;
    }
}
