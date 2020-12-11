// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package alg;
public class BinarySearch {
    public static int binarySearch(int[] array, int toFind, int startIndex, int endIndex) {
        if (startIndex < endIndex && startIndex < array.length && endIndex < array.length
                && startIndex > -1 && endIndex > -1) {
            return search(array, toFind, startIndex, endIndex);
        } else {
            return -1;
        }
    }

    private static int search(int[] array, int toFind, int startIndex, int endIndex) {
        // Element not found, killing the recursion.
        if (endIndex < startIndex) {
            return -1;
        }
        // Divide.
        int middleIndex = (endIndex + startIndex) / 2;

        if (array[middleIndex] == toFind) {
            return middleIndex;
        } else if (toFind < array[middleIndex]) {
            return search(array, toFind, startIndex, middleIndex - 1);
        } else {
            return search(array, toFind, middleIndex + 1, endIndex);
        }
    }
}
