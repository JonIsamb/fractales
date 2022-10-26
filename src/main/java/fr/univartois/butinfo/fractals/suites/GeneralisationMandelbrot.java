package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class GeneralisationMandelbrot implements SuitesStrategy{

    private IComplex z;

    private int maxIterations;

    private SuiteIterator iterator;

    private BinaryOperator<IComplex> binaryOperator;


    public GeneralisationMandelbrot(IComplex z, int maxIterations, BinaryOperator<IComplex> binaryOperator){
        this.z = z;
        this.maxIterations = maxIterations;
        this.iterator = new SuiteIterator(this, maxIterations);
        this.binaryOperator = binaryOperator;
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return binaryOperator.apply(z, z);
        }
        return binaryOperator.apply(previous, z);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }
}
