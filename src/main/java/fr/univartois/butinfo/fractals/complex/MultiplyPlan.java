package fr.univartois.butinfo.fractals.complex;

/**
 * Declaration de la classe MultiplyPlan qui etend le Plan et qui implemente l'interface IPlan
 * @author Axel Poteau
 */
public class MultiplyPlan extends Plan implements IPlan {
    /**
     * Declaration d'un double zoom
     */
    private double zoom;
    /**
     * déclaration d'une instance de IPlan plan
     */
    private IPlan plan;


    /**
     * Déclaration du constructeur de MultiplyPlan
     * @param zoom Attribut zoom
     * @param plan Attribut plan
     * @param height Attribut height récupere via super
     * @param width Attribut width recuperer via super
     */
    public MultiplyPlan(double zoom, IPlan plan, int height, int width) {
        super(height,width);
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
}
