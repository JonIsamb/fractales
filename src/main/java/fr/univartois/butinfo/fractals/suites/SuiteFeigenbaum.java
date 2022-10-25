package fr.univartois.butinfo.fractals.suites;

public class SuiteFeigenbaum extends SuiteChaotique implements ISuitesChaotique{

    public SuiteFeigenbaum(IPointPlan premier, int nbMaxIterations) {
        super(premier, nbMaxIterations);
    }

    @Override
    public double getNext(IPointPlan point) {
        return (point.getX()* point.getY())*(1-point.getY());
    }
}
