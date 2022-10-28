package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;
import fr.univartois.butinfo.fractals.suites.IComplexAdapter;
import fr.univartois.butinfo.fractals.suites.IPointPlan;

public class SumPlan implements IPlan{
    private IComplex cons;
    /**
     * Declaration de l'attribut plan instance de IPlan
     */
    private IPlan plan;



    public SumPlan(IPlan plan, IComplex cons) {
        this.cons = cons;
        this.plan = plan;
    }

    /**
     * Methode asComplex qui transforme un pixel en complex
     * @param row Abcisse
     * @param column ordonée
     * @return Un complexe
     */
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
