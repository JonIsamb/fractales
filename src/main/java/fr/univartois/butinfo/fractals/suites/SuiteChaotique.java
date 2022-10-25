package fr.univartois.butinfo.fractals.suites;

import java.util.Iterator;

/**
 * Creation de la classe abstraite SuiteChaotique qui implementera l'interface ISuiteChaotique
 * et l'interface Iterable qui permettera l'iteration de la suite
 * @author Bonsigne Amaury
 */
public abstract class SuiteChaotique implements ISuitesChaotique,Iterable<IPointPlan>{
    private IPointPlan premier;
    private int nbMaxIterations;

    /**
     * Constructeur de la classe abstraite SuiteChaotique
     * @param premier Paramètre de type IPointPlan qui est un point du plan
     * @param nbMaxIterations Nombre maximum d'iterations de la suite
     */
    public SuiteChaotique(IPointPlan premier,int nbMaxIterations){
        this.nbMaxIterations=nbMaxIterations;
        this.premier=premier;
    }

    /**
     * Methode renvoyant à l'iterateur des suites chaotiques
     * @return l'instance de l'iterateur d'une suite chaotiques
     */
    public Iterator<IPointPlan> iterator(){
        return new SuiteChaotiqueIterator(this,premier,nbMaxIterations);
    }

    /**
     * declaration de la methode abstract getNext
     * @param point Point du plan
     */
    public abstract double getNext(IPointPlan point);
}
