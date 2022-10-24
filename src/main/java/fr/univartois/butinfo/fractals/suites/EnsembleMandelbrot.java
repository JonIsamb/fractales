package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

public class EnsembleMandelbrot implements SuitesStrategy {

    private IComplex z;

    private int maxIterations;

    private SuiteIterator iterator;

    public EnsembleMandelbrot(IComplex z, int maxIterations){
        this.z = z;
        this.maxIterations = maxIterations;
        this.iterator = new SuiteIterator(this, maxIterations);
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return (z.multiply(z)).add(z);
        }
        return previous.multiply(z.multiply(z)).add(z);
    }
}
