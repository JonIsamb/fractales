package fr.univartois.butinfo.fractals.complex.points;

/**
 * Declaration de l'interface IPointPlan qui servira a la representation des points du plan
 * @author Bonsigne Amaury
 */
public interface IPointPlan {

    /**
     * Declaration de la méthode getX
     * @return La valeur de l'abcisse du point du plan
     */
    double getX();

    /**
     * Declaration de la méthode getY
     * @return La valeur de l'ordonnée du point du plan
     */
    double getY();

    /**
     * Declaration de la méthode distancePoint
     * @return La valeur qui represente la distance entre deux pounts du plan
     */
    double distancePoint(IPointPlan other);

    /**
     * declaration de la méthode getComplex
     * @return le point du plan en complex
     */
    IComplex getComplex();

    /**
     * Declaration de la méthode pointPlanToComplex
     * @param point Point a transformer en complex
     * @return Le point en complex
     */
    IComplex pointPlanToComplex(IPointPlan point);
}
