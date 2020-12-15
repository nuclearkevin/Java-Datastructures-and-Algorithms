// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package alg;
public class QuickSort {
    // Quick sort to initialize the recursion stack.
    public static void quickSort(double[] values) {
        quickSort(values, 0, values.length - 1);
    }

    // Recursive quick sort.
    private static void quickSort(double[] values, int start, int end) {
        // Recursive case (easier than a base case).
        if (start < end) {
            // Divide into 2 halves, divide step.
            int partition = partition(values, start, end);

            // Recursively call quick sort on each half, conquer step.
            quickSort(values, start, partition);
            quickSort(values, partition + 1, end);
        }
    }

    // Function to generate a partition and to perform the actual sort.
    private static int partition(double[] values, int start, int end) {
        double pivot = values[(end + start) / 2];
        int i = start;
        int j = end;

        while (i < j) {
            if (values[i] < pivot) {
                i++;
            }
            if (values[j] > pivot) {
                j--;
            }
            swap(values, i, j);
        }
        return j;
    }

    // Helper function to swap variables.
    private static void swap(double values[], int i, int j) {
        double temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
