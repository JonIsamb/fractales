package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EnsembleMandelbrot implements SuitesStrategy {

    protected IComplex z;

    protected int maxIterations;


    public EnsembleMandelbrot(IComplex z, int maxIterations){
        this.z = z;
        this.maxIterations = maxIterations;
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return (z.multiply(z)).add(z);
        }
        return (previous.multiply(previous)).add(z);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }



}
