package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

/**
 * Déclaration de la class FigureDecorator qui sert de décorateur pour une Figure
 * @author Axel Poteau
 */
public class FigureDecorator{

    /**
     * Declaration de la méthode translation
     * @param x Une representation d'une figure
     * @param co L'endroit ou en veut placer le point
     * @return la representation de la figure a son nouvelle emplacement
     */
    public static String translation(String x, IComplex co){
        x="<g transform=\"translate("+co.getRealPart()+","+co.getImaginaryPart()+")\" >"+x+"</g>";
        return x;
    }

    /**
     * Declaration de la methode rotate
     * @param x Une representation d'un figure
     * @param degree Le degree par lequel on veut tourner la figure
     * @return la figure avec son nouvel emplacement
     */
    public static String Rotate(String x, double degree, double posx, double posy){
        x = "<g transform=\"rotate("+degree+","+posx+","+posy+")\" >"+x+"</g>";
        return x;
    }

    /**
     * Declaration de la methode
     * @param x Une representation de la figure
     * @param scale La nouvelle echelle
     * @return la representation de la figure a la nouvelle echelle
     */
    public static String scale(String x, double scale){
        x = "<g transform=\"scale("+scale+")\" >"+x+"</g>";
        return x;
    }


}
