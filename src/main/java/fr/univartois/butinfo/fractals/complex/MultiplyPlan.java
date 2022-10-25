package fr.univartois.butinfo.fractals.complex;

public class MultiplyPlan extends Plan implements IPlan {
    private IComplex cons;
    private IPlan plan;


    public MultiplyPlan(IComplex cons, IPlan plan, int height, int width) {

        super(height,width);
        this.cons = cons;
        this.plan = plan;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).multiply(cons);
    }
}
