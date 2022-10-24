package fr.univartois.butinfo.fractals.suites;

public interface SuitesStrategy {
    Complex calculateNextTerm(Complex previousTerm);

    public Complex getFirstElement(Complex z);
}