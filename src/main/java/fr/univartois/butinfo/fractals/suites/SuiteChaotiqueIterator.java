package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import java.util.Iterator;

public class SuiteChaotiqueIterator implements Iterator<IPointPlan> {

    private static int nbIterations=0;
    private int nbMaxIteration;
    private IPointPlan precedent;
    private ISuitesChaotique suite;

    public SuiteChaotiqueIterator(ISuitesChaotique suite,IPointPlan precedent,int nbMaxIteration){
        this.suite=suite;
        this.nbMaxIteration=nbMaxIteration;
        this.precedent=precedent;
    }

    @Override
    public boolean hasNext() {
        if (nbMaxIteration==nbIterations){return false;}
        return true;
    }

    @Override
    public IPointPlan next() {
        if (!hasNext()){return null;}
        nbIterations++;
        IPointPlan tmp=new IComplexAdapter(new Complex(precedent.getX(),suite.getNext(precedent)));
        return tmp;
    }
}
