package fr.univartois.butinfo.fractals.complex;

public class SumPlan implements IPlan{
    private Complex cons;
    private IPlan plan;

    public SumPlan(Complex cons, IPlan plan) {
        this.cons = cons;
        this.plan = plan;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        return plan.asComplex(row,column).add(cons);
    }
}
