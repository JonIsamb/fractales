package fr.univartois.butinfo.fractals.suites.complexes;

import fr.univartois.butinfo.fractals.complex.points.IComplex;

public interface SuitesStrategy extends Iterable<IComplex> {
    IComplex calculateNextTerm(IComplex previous);
}