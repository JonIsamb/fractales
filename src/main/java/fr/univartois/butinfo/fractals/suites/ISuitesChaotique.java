package fr.univartois.butinfo.fractals.suites;

/**
 * Interface ISuiteChaotique qui servira a la création des suites chaotiques
 * @author Bonsigne Amaury
 */
public interface ISuitesChaotique {
    /**
     * Declaration de la méthode getNext qu'on implementera dans les classes
     * @param point Point du plan
     * @return Prochain point du plan
     */
    double getNext(IPointPlan point);
}
