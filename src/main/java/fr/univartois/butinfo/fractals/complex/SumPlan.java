package fr.univartois.butinfo.fractals.complex;

/**
 * Création de la classe SumPlan qui extends Plan et implements Iplan, elle sert a faire des translations dans un plan
 * @author Axel Poteau
 */
public class SumPlan extends Plan implements IPlan{
    /**
     * Declaration de l'attribut cons instance de IComplex
     */
    private IComplex cons;
    /**
     * Declaration de l'attribut plan instance de IPlan
     */
    private IPlan plan;


    /**
     * Déclaration du constructeur de SumPlan de la classe SumPlan
     * @param height Attribut Height via le super
     * @param width attribut width via le super
     * @param cons attribut cons
     * @param plan attribut plan
     */
    public SumPlan(int height, int width, IComplex cons, IPlan plan) {

        super(height,width);
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
}
