package fr.univartois.butinfo.fractals.suites;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CouleurPixel extends SuiteChaotique implements Iterable<IPointPlan>{
    private int nbMaxIterations;
    private IPointPlan premier;
    /**
     * Constructeur de la classe abstraite SuiteChaotique
     *
     * @param premier         Paramètre de type IPointPlan qui est un point du plan
     * @param nbMaxIterations Nombre maximum d'iterations de la suite
     */
    public CouleurPixel(IPointPlan premier, int nbMaxIterations) {
        super(premier, nbMaxIterations);
    }

    @Override
    public Iterator<IPointPlan> iterator() {
        return new SuiteChaotiqueIterator(this, premier, nbMaxIterations);
    }

    public int distanceConvergente(int k,double e){
        if ((e<1.)&&(e>0.)){return 0;}
        List<IPointPlan> points= (List<IPointPlan>) iterator();
        List<IPointPlan> termes= new ArrayList<IPointPlan>(k);
        int nbInterations=0;
        for (IPointPlan point : points) {
            if (termes.size()!=k){
                termes.add(point);
            } else{
                termes.remove(0);
                termes.add(point);
                double differences=point.getY()-(termes.get(0).getY());
                if (differences<e){
                    return nbInterations;
                }
            }
            nbInterations++;
        }
        return this.nbMaxIterations;
    }
}
