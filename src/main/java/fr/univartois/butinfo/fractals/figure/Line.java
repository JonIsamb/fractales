package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

/**
 * Création de la class Line implementant IFigure servant à representer une ligne
 * @author Axel Poteau
 */
public class Line implements IFigure{
    /**
     * Declaration d'une instance De Color color
     */
    private Color color;
    /**
     * Declaration d'une instance de IComplex posx
     */
    private IComplex posx;
    /**
     * Declaration d'une instance de IComplex posy
     */
    private IComplex posy;


    /**
     * Déclaration du constructeur de Line
     * @param color Instance de Color
     * @param posx Instance de IComplex
     * @param posy Instance de IComplex
     */
    public Line(Color color, IComplex posx, IComplex posy) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
    }


    /**
     * Declaration de la methode repr qui represente une figure en String
     * @return Une representation d'un figure
     */
    @Override
    public String repr() {
        return "<line x1='"+posx.getRealPart()+"' x2='"+posy.getRealPart()+"' y1='"+posx.getImaginaryPart()+"' y2='"+posy.getImaginaryPart()+"' stroke='rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")' stroke-width='5'/>";


    }

    /**
     * Getter de posx
     * @return l'attribut posx
     */
    @Override
    public IComplex getPos() {
        return posx;
    }

    /**
     * Getter de posy
     * @return l'attribut posy
     */
    public IComplex getPosy(){
        return posy;
    }
}
