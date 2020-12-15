// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// Driver class to test the algorithms.
package alg;
public class AlgorithmsTest {
    public static void main(String[] args) {
        // Test the merge sort algorithm.
        int[] testArray = new int[] {1, 10, 5, 2, 8, 13, 100, 40, 30, 60};
        System.out.println("Testing merge sort!");
        System.out.println("Array before merge sorting:");
        for (int i = 0; i < testArray.length; i++) {
            System.out.printf("%d ", testArray[i]);
        }
        System.out.printf("\n");
        MergeSort.mergeSort(testArray);
        System.out.println("\nArray after merge sorting:");
        for (int i = 0; i < testArray.length; i++) {
            System.out.printf("%d ", testArray[i]);
        }
        System.out.printf("\n");

        // Testing the binary search algorithm.
        testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Testing binary search!\n8 is at index: "
                + BinarySearch.binarySearch(testArray, 8, 0, testArray.length - 1));

        // Testing divide and conquer min and max functions.
        testArray = new int[] {1, 10, 5, 2, 8, 13, 100, 40, 30, 60};
        System.out.println("Testing max function, largest value '100' is: " + MinMaxDC.MaxDC(testArray, 0, testArray.length - 1));
        System.out.println("Testing min function, smallest value '1' is: " + MinMaxDC.MinDC(testArray, 0, testArray.length - 1));

        // FFT test.
        double[] testData = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        Complex[] testFFT = FourierTransform.FFT(testData);

        System.out.println("FFT:");
        for (int i = 0; i < testFFT.length; i++) {
            System.out.printf("%s, ", testFFT[i]);
        }

        double[] testIFFT = FourierTransform.iFFT(testFFT);
        System.out.println("\nIFFT:");
        for (int i = 0; i < testIFFT.length; i++) {
            System.out.printf("%f, ", testIFFT[i]);
        }
    }
}
