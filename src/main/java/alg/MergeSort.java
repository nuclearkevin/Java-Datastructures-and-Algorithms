// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// Based off of my group's submission for the second assignment in CSCI-2010U.
package alg;
public class MergeSort {

    public static void mergeSort(int[] arrayTOSort) {
        sort(arrayTOSort);
    }

    private static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int[] halfOne, halfTwo;

        if (array.length % 2 == 0) {
            halfOne = new int[(array.length / 2)];
            halfTwo = new int[(array.length / 2)];
            for (int i = 0; i < (array.length / 2); i++) {
                halfOne[i] = array[i];
            }
            for (int i = array.length / 2; i < array.length; i++) {
                halfTwo[i - (array.length / 2)] = array[i];
            }
        } else {
            halfOne = new int[(array.length / 2)];
            halfTwo = new int[(array.length / 2) + 1];
            for (int i = 0; i < (array.length / 2); i++) {
                halfOne[i] = array[i];
            }
            for (int i = (array.length / 2); i < array.length; i++) {
                halfTwo[i - (array.length / 2)] = array[i];
            }
        }
        sort(halfOne);
        sort(halfTwo);

        merge(array, halfOne, halfTwo);
    }

    private static void merge(int[] target, int[] halfOne, int[] halfTwo) {
        int i = 0;
        int j = 0;

        while(i + j < target.length) {
            if (j == halfTwo.length || (i < halfOne.length && halfOne[i] < halfTwo[j])) {
                target[i + j] = halfOne[i++];
            } else {
                target[i + j] = halfTwo[j++];
            }
        }
    }
}
