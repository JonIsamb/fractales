package fr.univartois.butinfo.fractals.suites;

public class SuiteCirculaire extends SuiteChaotique implements ISuitesChaotique{
    public SuiteCirculaire(IPointPlan premier, int nbMaxIterations) {
        super(premier, nbMaxIterations);
    }

    @Override
    public double getNext(IPointPlan point) {
        return point.getY()+(point.getX()*Math.sin(2*Math.PI* point.getY())/2*Math.PI)+1/3;
    }
}
