package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Classe representant l'ensemble de Mandelbrot
 * @author Jonathan Isambourg
 */
public class EnsembleMandelbrot implements SuitesStrategy {

    private IComplex z;

    private int maxIterations;

    /**
     *Constructeur
     * @param z Une instance de Icomplex
     * @param maxIterations nombre max d'iteration
     */
    public EnsembleMandelbrot(IComplex z, int maxIterations){
        this.z = z;
        this.maxIterations = maxIterations;
    }

    /**
     *calcule le prochain terme de la suite
     * @param previous une instance
     * @return renvoi le prochain terme
     */
    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return (z.multiply(z)).add(z);
        }
        return (previous.multiply(previous)).add(z);
    }

    /**
     *crée une nouvelle instance de SuiteIterator
     * @return une nouvelle instance de SuiteIterator
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }



}
