package fr.univartois.butinfo.fractals.complex;

public class MultiplyPlan extends Plan implements IPlan {
    private int zoom;
    private IPlan plan;


    public MultiplyPlan(int zoom, IPlan plan, int height, int width) {

        super(height,width);
        this.zoom= zoom;
        this.plan = plan;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).multiply(zoom);
    }
}
