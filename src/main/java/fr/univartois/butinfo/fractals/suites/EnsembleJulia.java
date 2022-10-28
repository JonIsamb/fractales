package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.function.Consumer;

public class EnsembleJulia implements SuitesStrategy {

    protected IComplex z;

    protected IComplex c;

    protected int maxIterations;


    public EnsembleJulia(IComplex z, IComplex c, int maxIterations){
        this.z = z;
        this.c = c;
        this.maxIterations = maxIterations;
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return (z.multiply(z)).add(c);
        }
        return (previous.multiply(previous)).add(c);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }
}
