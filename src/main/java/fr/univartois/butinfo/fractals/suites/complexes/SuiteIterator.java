package fr.univartois.butinfo.fractals.suites.complexes;

import fr.univartois.butinfo.fractals.complex.points.IComplex;

import java.util.Iterator;
import java.util.function.Consumer;

public class SuiteIterator implements Iterator<IComplex> {
    private SuitesStrategy strategy;

    private int nbIterations = 0;

    private int maxIterations;

    private IComplex current;

    public SuiteIterator(SuitesStrategy strategy, int maxIterations){
        this.strategy = strategy;
        this.maxIterations = maxIterations;
    }

    @Override
    public boolean hasNext() {
        if (nbIterations == 0){
            return true;
        } else if (nbIterations <= maxIterations) {
            return (this.current.abs() <= 2);
        } else {
            return false;
        }
    }

    @Override
    public IComplex next() {
        if (!hasNext()){
            return null;
        }

        this.current = strategy.calculateNextTerm(this.current);

        nbIterations++;
        return this.current;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super IComplex> action) {
        Iterator.super.forEachRemaining(action);
    }

    public int getNbIterations(){
        return this.nbIterations;
    }
}