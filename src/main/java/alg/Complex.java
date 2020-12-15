// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// Required for the FFT algorithm implementation since Java doesn't have a complex number library.
package alg;
public class Complex {
    private double real, imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Methods for fetching properties of the current complex number.
    // Get the real part of the complex number.
    public double getReal() {
        return this.real;
    }

    // Get the imaginary part of the complex number.
    public double getImaginary() {
        return this.imaginary;
    }

    // Get the conjugate of the complex number.
    public Complex conjugate() {
        return new Complex(this.real, this.imaginary * -1);
    }

    // Get the reciprocal of the complex number.
    public Complex reciprocal() {
        return new Complex(this.conjugate().getReal() / (this.modulus() * this.modulus()),
                this.conjugate().getImaginary() / (this.modulus() * this.modulus()));
    }

    // Get the magnitude of the complex number.
    public double modulus() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    // Get the argument of the complex number.
    public double arg() {
        if (this.real > 0 || this.imaginary != 0) {
            return 2 * Math.atan(this.imaginary /
                    (Math.sqrt(this.real * this.real + this.imaginary * this.imaginary) + this.real));
        } else if (this.real < 0 && this.imaginary == 0) {
            return Math.PI;
        } else {
            return 1/0;
        }
    }

    // Multiply by a real.
    public Complex byScalar(double scalar) {
        return new Complex(this.real * scalar, this.imaginary * scalar);
    }

    // Round off very small numbers to zero.
    public Complex truncate(double band) {
        double real, imaginary;

        if (this.real > 0.0 && this.real <= band) {
            real = 0;
        } else if (this.real < 0 && this.real >= -band) {
            real = 0;
        } else {
            real = this.real;
        }

        if (this.imaginary > 0.0 && this.imaginary <= band) {
            imaginary = 0;
        } else if (this.imaginary < 0 && this.imaginary >= -band) {
            imaginary = 0;
        } else {
            imaginary = this.imaginary;
        }

        return new Complex(real, imaginary);
    }

    // toString() for debugging.
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }

    // Basic functions for algebraic manipulation of complex numbers.
    // Add 2 complex numbers. a + b
    public static Complex add(Complex a, Complex b) {
        return new Complex(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
    }

    // Subtracts 2 complex numbers. a - b.
    public static Complex sub(Complex a, Complex b) {
        return new Complex(a.getReal() - b.getReal(), a.getImaginary() - b.getImaginary());
    }

    // Multiply 2 complex numbers. a * b
    public static Complex multiply(Complex a, Complex b) {
        return new Complex((a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary()),
                (a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal()));
    }

    // Divide 2 complex numbers. a / b
    public static Complex divide(Complex a, Complex b) {
        return multiply(a, b.reciprocal());
    }

    // More advanced functions for complex numbers.
    // Complex exponential function with a complex input.
    public static Complex exp(Complex a) {
        return new Complex(Math.exp(a.getReal()) * Math.cos(a.getImaginary()),
                Math.exp(a.getReal()) * Math.sin(a.getImaginary()));
    }

    // Complex exponential function with an imaginary input.
    public static Complex exp(double a) {
        return new Complex(Math.cos(a), Math.sin(a));
    }
}