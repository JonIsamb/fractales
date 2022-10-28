package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;
import fr.univartois.butinfo.fractals.suites.IComplexAdapter;
import fr.univartois.butinfo.fractals.suites.IPointPlan;

public class MultiplyPlan implements IPlan {
    private double zoom;
    private IPlan plan;


    public MultiplyPlan(double zoom, IPlan plan) {
        this.zoom= zoom;
        this.plan = plan;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).multiply(zoom);
    }

    @Override
    public Pixel asPixel(IComplex complex, IFractalImage image) {
        return plan.asPixel(complex.divide(new Complex(zoom, 0)), image);
    }

    @Override
    public Pixel asPixel(IPointPlan point, IFractalImage image) {
        Complex comp = new Complex(point.getComplex().getRealPart()/zoom,point.getComplex().getImaginaryPart()/zoom);
        return plan.asPixel(new IComplexAdapter(comp),image);
    }
}
