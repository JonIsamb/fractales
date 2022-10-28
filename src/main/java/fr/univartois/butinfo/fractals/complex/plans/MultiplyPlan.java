package fr.univartois.butinfo.fractals.complex.plans;

import fr.univartois.butinfo.fractals.complex.points.Complex;
import fr.univartois.butinfo.fractals.complex.points.IComplex;
import fr.univartois.butinfo.fractals.complex.points.IComplexAdapter;
import fr.univartois.butinfo.fractals.complex.points.IPointPlan;
import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;

public class MultiplyPlan implements IPlan {
    private double zoom;
    /**
     * déclaration d'une instance de IPlan plan
     */
    private IPlan plan;


    public MultiplyPlan(double zoom, IPlan plan) {
        this.zoom= zoom;
        this.plan = plan;
    }

    /**
     * Implementation de la méthode asComplex qui transforme une colonne et une rangée en complexe
     * @param row Abcisse
     * @param column Ordonné
     * @return Un complexe
     */
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
