package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class GeneralisationJulia extends EnsembleJulia {

    private BinaryOperator<IComplex> binaryOperator;

    /**
     * Constructeur
     * @param z Une instance de Icomplex
     * @param c Une instance de Icomplex constante
     * @param maxIterations nb max d'iteration
     * @param binaryOperator un operateur binaire
     */
    public GeneralisationJulia(IComplex z, IComplex c, int maxIterations, BinaryOperator<IComplex> binaryOperator){
        super(z, c, maxIterations);
        this.binaryOperator = binaryOperator;
    }

    /**
     * calcul le terme suivant de l'ensemble
     * @param previous
     * @return
     */
    @Override
    public IComplex calculateNextTerm(IComplex previous) {
        if (previous == null){
            return binaryOperator.apply(z, c);
        }
        return binaryOperator.apply(previous, c);
    }

    /**
     *  cree une nouvelle instance de SuiteIterator
     * @return une nouvelle instance de SuiteIterator
     */

    @Override
    public Iterator<IComplex> iterator() {
        return new SuiteIterator(this, maxIterations);
    }
}
