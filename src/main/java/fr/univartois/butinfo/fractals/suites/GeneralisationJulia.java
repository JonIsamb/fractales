package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class GeneralisationJulia extends EnsembleJulia {

    private BinaryOperator<IComplex> binaryOperator;


    public GeneralisationJulia(IComplex z, IComplex c, int maxIterations, BinaryOperator<IComplex> binaryOperator){
        super(z, c, maxIterations);
        this.binaryOperator = binaryOperator;
    }

    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return binaryOperator.apply(z, c);
        }
        return binaryOperator.apply(previous, c);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }
}
