// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// Probably the most beautiful divide and conquer algorithm!
package alg;
public class FourierTransform {
    // Fast Fourier Transform function to initialize the recursion stack.
    public static Complex[] fFT(double[] toFFT) {
        int n = 0;
        int j = 0;

        // Find the closest power of 2 >= the length of the array.
        while (n < toFFT.length) {
            n = (int) Math.pow(2, j);
            j++;
        }

        // Create a new array, copy over the elements from the data to be
        // transformed and fills the end with zeros. This allows for
        // datasets of sizes other than powers of two. Causes
        // inaccuracies in the resulting transform as a consequence.
        double[] massagedData;
        if (n != toFFT.length) {
            massagedData = new double[n];
            for (int i = 0; i < n; i++) {
                if (i < toFFT.length) {
                    massagedData[i] = toFFT[i];
                } else {
                    massagedData[i] = 0.0;
                }
            }
        } else {
            massagedData = toFFT;
        }

        // Initialize the recursion stack.
        Complex[] transformed = fFT(massagedData, n);

        // Remove the zeros added at the end and return the result of the FFT.
        if (transformed.length != toFFT.length) {
            Complex[] outData = new Complex[toFFT.length];

            for (int i = 0; i < toFFT.length; i++) {
                outData[i] = transformed[i];
            }

            return outData;
        } else {
            return transformed;
        }
    }

    // Actual recursive FFT.
    private static Complex[] fFT(double[] massagedData, int n) {
        // Base case.
        if (n == 1) {
            Complex[] P = new Complex[1];
            P[0] = new Complex(massagedData[0], 0);
            return P;
        }

        // Split the arrays, divide step.
        double[] even = new double[n / 2];
        double[] odd = new double[n / 2];
        for (int i = 0; i < n / 2; i++) {
            even[i] = massagedData[2 * i];
            odd[i] = massagedData[2 * i + 1];
        }

        // Take the FFT of both sides, conquer step.
        Complex[] complexEven = fFT(even, n / 2);
        Complex[] complexOdd = fFT(odd, n / 2);

        // Create an array to store the merged transformed data.
        Complex [] transformed = new Complex[n];

        // Performing a DFT on the half arrays using a twiddle factor, merge step.
        for (int i = 0; i < n / 2; i++) {
            transformed[i] = Complex.add(complexEven[i],
                    Complex.multiply(Complex.exp(i * 2 * Math.PI / n), complexOdd[i]));
            transformed[i + n / 2] = Complex.sub(complexEven[i],
                    Complex.multiply(Complex.exp(i * 2 * Math.PI / n), complexOdd[i]));
        }

        return transformed;
    }

    // Inverse Fast Fourier Transform function to initialize the recursion stack.
    public static double[] iFFT(Complex[] toIFFT) {
        int n = 0;
        int j = 0;

        // Find the closest power of 2 >= the length of the array.
        while (n < toIFFT.length) {
            n = (int) Math.pow(2, j);
            j++;
        }

        // Create a new array, copy over the elements from the data to be
        // transformed and fills the end with zeros. This allows for
        // datasets of sizes other than powers of two. Causes
        // inaccuracies in the resulting transform as a consequence.
        Complex[] massagedData;
        if (n != toIFFT.length) {
            massagedData = new Complex[n];
            for (int i = 0; i < n; i++) {
                if (i < toIFFT.length) {
                    massagedData[i] = toIFFT[i];
                } else {
                    massagedData[i] = new Complex(0.0, 0.0);
                }
            }
        } else {
            massagedData = toIFFT;
        }

        // Initialize the recursion stack.
        Complex[] transformed = iFFT(massagedData, n);

        // Remove the zeros added at the end, truncates the imaginary
        // component (as IFFT results should be in the real number domain)
        // and returns the result of the IFFT.
        double[] outData = new double[toIFFT.length];
        for (int i = 0; i < toIFFT.length; i++) {
            outData[i] = transformed[i].getReal() / (double) n;
        }
        return outData;
    }

    private static Complex[] iFFT(Complex[] massagedData, int n) {
        // Base case.
        if (n == 1) {
            return massagedData;
        }

        // Split the arrays, divide step.
        Complex[] even = new Complex[n / 2];
        Complex[] odd = new Complex[n / 2];
        for (int i = 0; i < n / 2; i++) {
            even[i] = massagedData[2 * i];
            odd[i] = massagedData[2 * i + 1];
        }

        // Take the IFFT of both sides, conquer step.
        Complex[] complexEven = iFFT(even, n / 2);
        Complex[] complexOdd = iFFT(odd, n / 2);

        // Create an array to store the merged transformed data.
        Complex [] transformed = new Complex[n];

        // Performing an IDFT on the half arrays using inverse twiddle factors, merge step.
        for (int i = 0; i < n / 2; i++) {
            transformed[i] = Complex.add(complexEven[i],
                    Complex.multiply(Complex.exp(-i * 2 * Math.PI / n), complexOdd[i]));
            transformed[i + n / 2] = Complex.sub(complexEven[i],
                    Complex.multiply(Complex.exp(-i * 2 * Math.PI / n), complexOdd[i]));
        }
        return transformed;
    }
}