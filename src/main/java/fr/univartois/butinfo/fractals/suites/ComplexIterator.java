package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;

public interface ComplexIterator {
    boolean hasNext();

    Complex getNext();

    void reset();
}