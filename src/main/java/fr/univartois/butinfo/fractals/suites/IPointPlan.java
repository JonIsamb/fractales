package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

public interface IPointPlan {
    double getX();
    double getY();
    double distancePoint(IPointPlan other);
    IComplex getComplex();
    IComplex pointPlanToComplex(IPointPlan point);
}
