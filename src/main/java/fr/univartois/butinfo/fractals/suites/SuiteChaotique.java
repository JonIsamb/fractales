package fr.univartois.butinfo.fractals.suites;

import java.util.Iterator;

/**
 * Creation de la classe abstraite SuiteChaotique qui implementera l'interface ISuiteChaotique
 * et l'interface Iterable qui permettera l'iteration de la suite
 * @author Bonsigne Amaury
 */
public abstract class SuiteChaotique implements SuitesChaotiqueStrategy{
    protected IPointPlan premier;
    protected int nbMaxIterations;

    protected int k;

    protected float e;

    /**
     * Constructeur de la classe abstraite SuiteChaotique
     * @param premier Paramètre de type IPointPlan qui est un point du plan
     * @param nbMaxIterations Nombre maximum d'iterations de la suite
     */
    public SuiteChaotique(IPointPlan premier,int nbMaxIterations, int k, float e){
        this.nbMaxIterations=nbMaxIterations;
        this.premier=premier;
        this.k = k;
        this.e = e;
    }

    /**
     * Methode renvoyant à l'iterateur des suites chaotiques
     * @return l'instance de l'iterateur d'une suite chaotiques
     */
    public Iterator<IPointPlan> iterator(){
        return new SuiteChaotiqueIterator(this,premier,nbMaxIterations, k, e);
    }

    /**
     * declaration de la methode abstract getNext
     * @param point Point du plan
     */
    public abstract double getNext(IPointPlan point);
}
