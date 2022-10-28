package fr.univartois.butinfo.fractals.color.masques;

import fr.univartois.butinfo.fractals.color.ColorDecorator;

import java.awt.*;

/**
 * Déclaration de la classe MasqueGreenDecorator qui extends la classe abtraite ColorDecorateur
 * @author Amaury Bonsigne
 */
public class MasqueGreenDecorator extends ColorDecorator {

    /**
     * Déclaration du constructeur de MasqueGreenDecorator qui reprend celui ColorDecorator
     * @param color Attribut color de ColorDecorator
     */
    public MasqueGreenDecorator(Color color) {
        super(color);
    }

    /**
     * Declaration de la methode getPalette
     * @param nbIteration Nombre d'iterations de la suite
     * @param iterationsMax Nombre d'iterations max de la suite
     * @return attribut Color de la classe
     */
    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        return this.getColor();
    }
    /**
     * Déclaration de la méthode Masque
     * @return L'attribut color en gardant que la composante verte du rgb
     */
    @Override
    public Color masque() {
        return new Color(0,this.getColor().getGreen(),0);
    }
}
