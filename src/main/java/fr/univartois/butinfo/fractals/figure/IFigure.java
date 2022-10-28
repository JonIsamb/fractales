package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.IComplex;

/**
 * Declatration de l'interface IFigure
 * @author Axel Poteau
 */
public interface IFigure {

    /**
     * Declaration de la méthode repr qui sert a representer la figure
     * @return La représentation de la figure en String
     */
    public String repr();

    /**
     * Déclaration de la méthode getPos qui donne la position
     * @return un complexe representant la position
     */
    IComplex getPos();
}
