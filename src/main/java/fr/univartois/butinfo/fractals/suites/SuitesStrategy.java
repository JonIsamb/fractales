package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

public interface SuitesStrategy {
    IComplex calculateNextTerm(IComplex previous);


}