package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import java.util.Iterator;

/**
 * Creation de la classe SuiteChaotiqueIterator qui va implementer un iterateur
 * de IPointPlan,cette classe permettra d'iterer les suites chaotiques
 * @author Bonsigne Amaury
 */
public class SuiteChaotiqueIterator implements Iterator<IPointPlan> {

    private int nbIterations=0;
    private int nbMaxIteration;
    private IPointPlan precedent;
    private SuitesChaotiqueStrategy suite;

    /**
     * Constructeur de la classe SuiteChaotiqueIterator qui permettra la création d'une instance
     * de SuiteChaotiqueIterator
     * @param suite instance de l'interface ISuiteChaotique
     * @param precedent instance de l'interface IPointPlan qui est un point du plan
     * @param nbMaxIteration int qui indique le nombre maximum d'iteration
     */
    public SuiteChaotiqueIterator(SuitesChaotiqueStrategy suite,IPointPlan precedent,int nbMaxIteration){
        this.suite=suite;
        this.nbMaxIteration=nbMaxIteration;
        this.precedent=precedent;
    }

    public int getNbIterations(){
        return this.nbIterations;
    }


    /**
     * Declaration de la methode hasNext qui verifiera si il y a un prochain point du plan
     * @return true si il existe un point au n+1 sinon false
     */
    @Override
    public boolean hasNext() {
        if (nbMaxIteration==nbIterations){return false;}
        return true;
    }

    /**
     * Declaration de la methode next qui renverra le prochain point du plan
     * @return le prochain point de l'iteration
     */
    @Override
    public IPointPlan next() {
        if (!hasNext()){return null;}
        nbIterations++;
        IPointPlan tmp=new IComplexAdapter(new Complex(precedent.getX(),suite.getNext(precedent)));
        return tmp;
    }
}
