package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

public class EnsembleJulia implements SuitesStrategy {

    private IComplex z;

    private IComplex c;

    private int maxIterations;

    private SuiteIterator iterator;

    public EnsembleJulia(IComplex z, IComplex c, int maxIterations){
        this.z = z;
        this.c = c;
        this.maxIterations = maxIterations;
        this.iterator = new SuiteIterator(this, maxIterations);
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return (z.multiply(z)).add(c);
        }
        return (previous.multiply(previous)).add(c);
    }
}
