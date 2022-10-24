package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

public interface ComplexIterator {
    boolean hasNext();

    IComplex getNext();

    IComplex get(int indice);

    void reset();
}