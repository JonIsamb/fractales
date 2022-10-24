package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

public class EnsembleMandelbrot implements SuitesStrategy {

    private IComplex z;


    @Override
    public IComplex getFirstElement() {
        return (z.multiply(z)).add(z);
    }

    @Override
    public IComplex calculateNextTerm(IComplex previousTerm) {
        return previousTerm.multiply(z.multiply(z)).add(z);
    }
}
