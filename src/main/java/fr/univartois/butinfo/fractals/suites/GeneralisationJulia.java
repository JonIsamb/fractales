package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.function.BinaryOperator;

public class GeneralisationJulia implements SuitesStrategy {

    private IComplex z;

    private int maxIterations;

    private SuiteIterator iterator;

    private BinaryOperator<IComplex> binaryOperator = (prev, z) -> (prev.multiply(prev).add(z));


    public GeneralisationJulia(IComplex z, int maxIterations){
        this.z = z;
        this.maxIterations = maxIterations;
        this.iterator = new SuiteIterator(this, maxIterations);
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return binaryOperator.apply(z, z);
        }
        return binaryOperator.apply(previous, z);
    }
}
