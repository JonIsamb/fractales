package fr.univartois.butinfo.fractals.color;

import java.awt.*;

/**
 * Déclaration de la classe abstraite ColorDecorator en tant que décorateur de l'interface IColor
 * @author Amaury Bonsigne
 */
public abstract class ColorDecorator implements IColor{
    /**
     * Declaration d'une Color appelé color
     */
    private Color color;

    /**
     * Déclaration du constructeur de la classe abstraite ColorDecorator
     * @param color Instance de Color
     */
    public ColorDecorator(Color color){
        this.color=color;
    }

    /**
     * Declaration de la méthode abstraite getPalette
     * @param nbIteration Nombre d'iterations de la suite
     * @param iterationsMax Nombre d'iterations max de la suite
     * @return Une instance de Color
     */
    @Override
    public abstract Color getPalette(int nbIteration, int iterationsMax);

    /**
     * Getter de l'attribut color
     * @return L'attribut color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Déclaration de la méthode masque
     * @return null
     */
    @Override
    public Color masque() {
        return null;
    }
}
