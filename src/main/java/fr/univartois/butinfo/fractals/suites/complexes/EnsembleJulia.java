package fr.univartois.butinfo.fractals.suites.complexes;

import fr.univartois.butinfo.fractals.complex.points.IComplex;

import java.util.Iterator;

/**
 * Classe representant l'ensemble de julia
 * @author Jonathan Isambourg
 */
public class EnsembleJulia implements SuitesStrategy {

    protected IComplex z;

    protected IComplex c;

    protected int maxIterations;

    /**
     *Constructeur
     * @param z Une iteration de Icomplex
     * @param c Une iteration de Icomplex, qui est une constante
     * @param maxIterations le nombre maximum d'iteration
     */
    public EnsembleJulia(IComplex z, IComplex c, int maxIterations){
        this.z = z;
        this.c = c;
        this.maxIterations = maxIterations;
    }

    /**
     *Calcule le prochain terme de l'ensemble
     * @param previous une instance de IComplex
     * @return previous multiplier par lui meme avec l'ajout de la constante
     */
    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return (z.multiply(z)).add(c);
        }
        return (previous.multiply(previous)).add(c);
    }

    /**
     *creer une nouvelle instance de SuiteIterator
     * @return une nouvelle instance de SuiteIterator
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }
}
