package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    private int k;

    private float e;

    private List<IPointPlan> points;

    /**
     * Constructeur de la classe SuiteChaotiqueIterator qui permettra la création d'une instance
     * de SuiteChaotiqueIterator
     * @param suite instance de l'interface ISuiteChaotique
     * @param precedent instance de l'interface IPointPlan qui est un point du plan
     * @param nbMaxIteration int qui indique le nombre maximum d'iteration
     */
    public SuiteChaotiqueIterator(SuitesChaotiqueStrategy suite,IPointPlan precedent,int nbMaxIteration, int k, float e){
        this.suite=suite;
        this.nbMaxIteration=nbMaxIteration;
        this.precedent=precedent;
        this.k = k;
        this.e = e;
        this.points = new ArrayList<>();
        points.add(this.precedent);
    }

    public int getNbIterations(){
        return this.nbIterations;
    }

    public double getYPrecedent(){
        return this.precedent.getY();
    }


    /**
     * Declaration de la methode hasNext qui verifiera si il y a un prochain point du plan
     * @return true si il existe un point au n+1 sinon false
     */
    @Override
    public boolean hasNext() {
        if (nbMaxIteration==nbIterations){
            return false;
        } else if (distanceConvergente()){
            return false;
        }
        return true;
    }

    private boolean distanceConvergente() {
        if (this.points.size() < 2){
            return false;
        }

        boolean converge = true;
        for (int i=0; i < this.points.size()-1; i++){
            if (points.get(i).distancePoint(points.get(i+1)) > e){
                converge = false;
            }
        }
        return converge;
    }

    /**
     * Declaration de la methode next qui renverra le prochain point du plan
     * @return le prochain point de l'iteration
     */
    @Override
    public IPointPlan next() {
        if (!hasNext()){
            return null;
        }
        this.nbIterations++;
        this.precedent = new IComplexAdapter(new Complex(precedent.getX(),suite.getNext(precedent)));
        if (points.size() >= k) {
            points.remove(0);
        }
        points.add(precedent);

        return precedent;
    }
}
