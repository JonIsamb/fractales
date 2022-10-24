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
        return this.subtract((Complex) o).abs()<0.0001;
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
        return this.re;
    }

    @Override
    public double getImaginaryPart() {
        return this.im;
    }

    @Override
    public double abs() {
        double sum = this.getRealPart()*this.getRealPart()+this.getImaginaryPart()*this.getImaginaryPart();
        return Math.sqrt(sum);
    }

    @Override
    public IComplex negate() {
        IComplex result = this.multiply(-1);
        return result;
    }

    @Override
    public IComplex conjugate() {
        double im = this.getImaginaryPart()*-1;
        Complex result = new Complex(this.getRealPart(),im);
        return result;
    }

    @Override
    public IComplex add(IComplex other) {
        double re = other.getRealPart()+this.getRealPart();
        double im = other.getImaginaryPart()+this.getImaginaryPart();
        Complex result = new Complex(re,im);
        return result;
    }

    @Override
    public IComplex subtract(IComplex other) {
        double re = this.getRealPart()-other.getRealPart();
        double im = this.getImaginaryPart()-other.getImaginaryPart();
        Complex result = new Complex(re,im);
        return result;
    }

    @Override
    public IComplex multiply(double value) {
        double re = value*this.getRealPart();
        double im = value*this.getImaginaryPart();
        Complex result = new Complex(re,im);
        return result;
    }

    @Override
    public IComplex multiply(IComplex other) {
        double re = this.getRealPart()* other.getRealPart()-this.getImaginaryPart()*other.getImaginaryPart();
        double im = this.getRealPart()*other.getImaginaryPart()+this.getImaginaryPart()*other.getRealPart();
        Complex result = new Complex(re,im);
        return result;
    }

    @Override
    public IComplex divide(IComplex other) {
        double quotien = other.getRealPart()*other.getRealPart()+other.getImaginaryPart()*other.getImaginaryPart();
        double re = this.getRealPart()* other.getRealPart()+this.getImaginaryPart()*other.getImaginaryPart();
        double im = this.getImaginaryPart()*other.getRealPart()-this.getRealPart()*other.getImaginaryPart();
        re = re/quotien;
        im = im/quotien;

        Complex result = new Complex(re,im);
        return result;
    }
}

