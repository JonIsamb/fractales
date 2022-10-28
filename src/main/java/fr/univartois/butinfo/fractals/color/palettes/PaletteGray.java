package fr.univartois.butinfo.fractals.color.palettes;

import fr.univartois.butinfo.fractals.color.IColor;

import java.awt.*;

/**
 * Déclaration de la classe PaletteGray qui implémente Icolor qui represente la palette grise
 * @author Jonathan Isambourg
 */
public class PaletteGray implements IColor {
    /**
     * Déclare l'attribut color representant la couleur de la palette
     */
    private Color color;

    /**
     * Constructeur de la classe PaletteGray qui donne la couleur grise a color
     */
    public PaletteGray(){
        this.color=Color.GRAY;
    }

    /**
     * Déclaration de la méthode getPalette
     * @param nbIteration Nombre d'iterations de la suite
     * @param iterationsMax Nombre d'iterations max de la suite
     * @return renvoie la nouvelle color donc les composantes sont le ratio entre nbIteration et iteratoonsMax
     */
    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        float nbIte = (float) nbIteration-1;
        float maxIte = (float) iterationsMax;
        float ratio = nbIte/maxIte;
        return new Color(ratio, ratio, ratio);
    }

    /**
     * Declaration de la methode masque
     * @return La color du constructeur
     */
    @Override
    public Color masque() {
        return color;
    }
}
