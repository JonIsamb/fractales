package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

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
        this.binaryOperator = (prev, comp) -> (prev.multiply(prev).add(comp));
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return binaryOperator.apply(z, z);
        }
        return binaryOperator.apply(previous, z);
    }
}
