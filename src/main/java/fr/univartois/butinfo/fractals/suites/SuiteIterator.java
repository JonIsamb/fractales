package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.ArrayList;
import java.util.List;

public class SuiteIterator implements ComplexIterator {
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
        if (nbIterations <= maxIterations) {
            return (current.abs() <= 2);
        } else {
            return false;
        }
    }

    @Override
    public IComplex getNext(){
        if (!hasNext()){
            return null;
        }

        this.current = strategy.calculateNextTerm(this.current);

        nbIterations++;
        return this.current;
    }

    @Override
    public IComplex get(int indice) {
        IComplex complex = null;
        int compteur = 0;
        while(compteur < indice){
            complex = strategy.calculateNextTerm(complex);
            compteur++;
        }
        return complex;
    }

    @Override
    public void reset(){
        nbIterations = 0;
        current = null;
    }
}