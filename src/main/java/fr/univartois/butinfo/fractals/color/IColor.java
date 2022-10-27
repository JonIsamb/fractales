package fr.univartois.butinfo.fractals.color;

import java.awt.*;

/**
 * Déclaration de l'interface IColor qui va permettre de creer les différentes palettes de couleur
 * @author Amaury Bonsigne
 */
public interface IColor {
    /**
     * Declaration de la méthode abstraite getPalette
     * @param nbIteration Nombre d'iterations de la suite
     * @param iterationsMax Nombre d'iterations max de la suite
     * @return Une instance de Color
     */
    abstract Color getPalette(int nbIteration, int iterationsMax);

    /**
     * déclaration de la méthode masque
     * @return une instance de Color
     */
    Color masque();

}
