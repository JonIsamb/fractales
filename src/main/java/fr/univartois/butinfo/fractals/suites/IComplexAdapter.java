package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Declaration de la classe IComplexAdapter qui implemente IPointPlan
 * la classe va adapter un complex en point du plan
 * @author Bonsigne Amaury
 */
public class IComplexAdapter implements IPointPlan{

    private final IComplex complex;

    /**
     * Declaration du constructeur de la classe IComplexAdapter
     * @param complex Instance de la classe Icomplex
     */
    public IComplexAdapter(IComplex complex) {
        this.complex = complex;
    }

    /**
     * Implementation de la méthode getX
     * @return La partie reel du complex qui est aussi l'abcisse du point du plan
     */
    @Override
    public double getX() {
        return this.complex.getRealPart();
    }

    /**
     * Implementation de la méthode getY
     * @return La partie Imaginaire du complex qui est aussi l'ordonnée du point du plan
     */
    @Override
    public double getY() {
        return this.complex.getImaginaryPart();
    }

    /**
     * Implementation de la méthode distancePoint
     * @return La distance en double qui represente la distance entre deux points du plan
     */
    @Override
    public double distancePoint(IPointPlan other) {
        return Math.sqrt(Math.pow(this.getX()-other.getX(),2)+Math.pow(this.getY()- other.getY(),2));
    }

    /**
     * Implementation de la methode getComplex
     * @return renvoie le complex
     */
    @Override
    public IComplex getComplex() {
        return this.complex;
    }

    /**
     *
     * @param point Point a transformer en complex
     * @return le point du plan en complex
     */
    @Override
    public IComplex pointPlanToComplex(IPointPlan point) {
        return new Complex(point.getX(),point.getY());
    }
}