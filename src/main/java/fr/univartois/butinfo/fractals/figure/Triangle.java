package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

/**
 * Creation de la classe Triangle implementant IFigure qui sert à representer un triangle
 */
public class Triangle implements IFigure{
    /**
     * Declaration d'une Instance de Color color
     */
    private Color color;
    /**
     * Declaration d'une Instance de IComplex posx
     */
    private IComplex posx;
    /**
     * Declaration d'une Instance de IComplex posy
     */
    private IComplex posy;
    /**
     * Declaration d'une Instance de IComplex posz
     */
    private IComplex posz;

    /**
     * Declaration du constructeur de Triangle
     * @param color Instance de color
     * @param posx Instance Icomplex
     * @param posy Instance Icomplex
     * @param posz Instance Icomplex
     */
    public Triangle(Color color, IComplex posx, IComplex posy, IComplex posz) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
        this.posz=posz;
    }


    /**
     * Getter de posx
     * @return l'attribut posx
     */
    public IComplex getPosx() {
        return posx;
    }

    /**
     * Getter de posy
     * @return l'attribut posy
     */
    public IComplex getPosy() {
        return posy;
    }

    /**
     * Getter de posz
     * @return l'attribut posz
     */
    public IComplex getPosz() {
        return posz;
    }

    /**
     * Declaration de la methode repr qui represente une figure en String
     * @return Une representation d'un figure
     */
    @Override
    public String repr() {
        return "<polygon points='"+posx.getRealPart()+", "+posx.getImaginaryPart()+" "+posy.getRealPart()+", "+posy.getImaginaryPart()+" "+posz.getRealPart()+", "+posz.getImaginaryPart()+"' fill ='rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")'/>";



    }

    /**
     * getter de pos
     * @return null
     */
    @Override
    public IComplex getPos() {
        return null;
    }
}
