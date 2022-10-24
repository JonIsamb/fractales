package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;

import java.util.ArrayList;
import java.util.List;

public class SuiteIterator implements ComplexIterator {
    private SuitesStrategy strategy;

    private int nbIterations = 0;

    private int iterationsLimit;

    private List<Complex> complexes = new ArrayList<>();


    public SuiteIterator(SuitesStrategy strategy, int iterationsLimit){
        this.strategy = strategy;
        this.iterationsLimit = iterationsLimit;
    }

    @Override
    public boolean hasNext() {
        if (nbIterations < iterationsLimit) {
            if (nbIterations == 0) {
                return (strategy.getFirstElement().abs() <= 2);
            } else {
                return (complexes.get(nbIterations).abs() <= 2);
            }
        } else {
            return false;
        }
    }

    @Override
    public Complex getNext(){
        if (!hasNext()){
            return null;
        }

        Complex next;
        if (nbIterations == 0){
            next = strategy.getFirstElement();
        } else {
            Complex previous = complexes.get(nbIterations);
            next = strategy.calculateNextTerm(previous);
        }

        complexes.add(next);
        nbIterations++;
        return next;
    }

    @Override
    public void reset(){
        nbIterations = 0;
    }
}