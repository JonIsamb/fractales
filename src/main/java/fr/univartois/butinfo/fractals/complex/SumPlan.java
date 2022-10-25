package fr.univartois.butinfo.fractals.complex;

public class SumPlan extends Plan implements IPlan{
    private IComplex cons;
    private IPlan plan;



    public SumPlan(int height, int width, IComplex cons, IPlan plan) {

        super(height,width);
        this.cons = cons;
        this.plan = plan;

    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).add(cons);
    }
}
