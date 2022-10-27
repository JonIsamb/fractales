package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

public interface SuitesStrategy extends Iterable<IComplex> {
    IComplex calculateNextTerm(IComplex previous);
}