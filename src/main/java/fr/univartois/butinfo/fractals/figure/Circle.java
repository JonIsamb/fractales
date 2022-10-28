package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

/**
 * Creation de la class Circle implementant  IFigure servant a representer Circle
 * @author Axel Poteau
 */
public class Circle implements IFigure{
    /**
     * Declaration d'une Color color
     */
    private Color color;
    /**
     * Declaration d'un IComplex pos
     */
    private IComplex pos;
    /**
     * Declaration d'un double radius
     */
    private double radius;

    /**
     * Declaration du constructeur de Circle
     * @param color Instance de Color et attribut color
     * @param pos Instance de IComplex et attribut pos
     * @param radius Attribut de radius
     */
    public Circle(Color color, IComplex pos, double radius) {
        this.color = color;
        this.pos = pos;
        this.radius = radius;
    }

    /**
     * Declaration de la methode repr qui represente une figure en String
     * @return Une representation d'un figure
     */
    @Override
    public String repr() {
        return "<circle cx='"+pos.getRealPart()+"' cy='"+pos.getImaginaryPart()+"' r='"+radius+"' fill ='rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")'/>";
    }

    /**
     * Getter de l'attribut de pos
     * @return attribut pos
     */
    @Override
    public IComplex getPos() {
        return pos;
    }
}
