package fr.univartois.butinfo.fractals.complex;

import java.util.Objects;

public class Complex implements IComplex{
    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return re +
                " + " + im + "i";
    }

    @Override
    public double getRealPart() {
        return 0;
    }

    @Override
    public double getImaginaryPart() {
        return 0;
    }

    @Override
    public double abs() {
        return 0;
    }

    @Override
    public IComplex negate() {
        return null;
    }

    @Override
    public IComplex conjugate() {
        return null;
    }

    @Override
    public IComplex add(IComplex other) {
        return null;
    }

    @Override
    public IComplex subtract(IComplex other) {
        return null;
    }

    @Override
    public IComplex multiply(double value) {
        return null;
    }

    @Override
    public IComplex multiply(IComplex other) {
        return null;
    }

    @Override
    public IComplex divide(IComplex other) {
        return null;
    }
}

