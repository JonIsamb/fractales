package fr.univartois.butinfo.fractals.suites;

import java.util.Iterator;

public abstract class SuiteChaotique implements ISuitesChaotique,Iterable<IPointPlan>{
    private IPointPlan premier;
    private int nbMaxIterations;

    public SuiteChaotique(IPointPlan premier,int nbMaxIterations){
        this.nbMaxIterations=nbMaxIterations;
        this.premier=premier;
    }

    public Iterator<IPointPlan> iterator(){
        return new SuiteChaotiqueIterator(this,premier,nbMaxIterations);
    }

    public abstract double getNext(IPointPlan point);
}
