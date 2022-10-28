package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;
import fr.univartois.butinfo.fractals.suites.IComplexAdapter;
import fr.univartois.butinfo.fractals.suites.IPointPlan;

public class SumPlan implements IPlan{
    private IComplex cons;
    private IPlan plan;



    public SumPlan(IPlan plan, IComplex cons) {
        this.cons = cons;
        this.plan = plan;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).add(cons);
    }

    @Override
    public Pixel asPixel(IComplex complex, IFractalImage image) {
        return plan.asPixel(complex.subtract(cons), image);
    }

    @Override
    public Pixel asPixel(IPointPlan point, IFractalImage image) {
        return plan.asPixel(new IComplexAdapter(point.getComplex().subtract(cons)), image);
    }
}
