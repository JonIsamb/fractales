package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;

public interface SuitesStrategy {
    Complex calculateNextTerm(Complex previousTerm);

    Complex getFirstElement();
}