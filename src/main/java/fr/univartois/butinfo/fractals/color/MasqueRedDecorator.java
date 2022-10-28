package fr.univartois.butinfo.fractals.color;

import java.awt.*;

/**
 * Déclaration de la classe MasqueRedDecorator qui extends la classe abtraite ColorDecorateur
 * @author Amaury Bonsigne
 */
public class MasqueRedDecorator extends ColorDecorator{

    /**
     * Déclaration du constructeur de MasqueRedDecorator qui reprend celui ColorDecorator
     * @param color Attribut color de ColorDecorator
     */
    public MasqueRedDecorator(Color color) {
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
     * @return L'attribut color en gardant que la composante rouge du rgb
     */
    @Override
    public Color masque() {
        return new Color(this.getColor().getRed(),0,0);
    }

}
