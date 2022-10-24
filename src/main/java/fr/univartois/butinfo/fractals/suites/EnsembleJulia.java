package fr.univartois.butinfo.fractals.suites;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

public class EnsembleJulia implements SuitesStrategy {

    private IComplex z;

    private IComplex c;

    @Override
    public IComplex getFirstElement() {
        return (z.multiply(z)).add(c);
    }

    @Override
    public IComplex calculateNextTerm(IComplex previousTerm) {
        return previousTerm.multiply(z.multiply(z)).add(c);
    }


}
