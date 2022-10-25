package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.function.BinaryOperator;

public class GeneralisationJulia implements SuitesStrategy {

    private IComplex z;

    private IComplex c;

    private int maxIterations;

    private SuiteIterator iterator;

    private BinaryOperator<IComplex> binaryOperator;


    public GeneralisationJulia(IComplex z, IComplex c, int maxIterations, BinaryOperator<IComplex> binaryOperator){
        this.z = z;
        this.c = c;
        this.maxIterations = maxIterations;
        this.binaryOperator = binaryOperator;
        this.iterator = new SuiteIterator(this, maxIterations);
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return binaryOperator.apply(z, c);
        }
        return binaryOperator.apply(previous, c);
    }
}
