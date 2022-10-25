package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

public class IComplexAdapter implements IPointPlan{

    private final IComplex complex;

    public IComplexAdapter(IComplex complex) {
        this.complex = complex;
    }

    @Override
    public double getX() {
        return this.complex.getRealPart();
    }

    @Override
    public double getY() {
        return this.complex.getImaginaryPart();
    }

    @Override
    public double distancePoint(IPointPlan other) {
        return Math.sqrt(Math.pow(this.getX()-other.getX(),2)+Math.pow(this.getY()- other.getY(),2));
    }

    @Override
    public IComplex getComplex() {
        return this.complex;
    }

    @Override
    public IComplex pointPlanToComplex(IPointPlan point) {
        return new Complex(point.getX(),point.getY());
    }
}