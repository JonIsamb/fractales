package fr.univartois.butinfo.fractals.complex;

public class SumPlan extends Plan implements IPlan{
    private Complex cons;
    private IPlan plan;

    public SumPlan(Complex cons, IPlan plan,int height,int width) {
        super(height,width);
        this.cons = cons;
        this.plan = plan;

    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).add(cons);
    }
}
