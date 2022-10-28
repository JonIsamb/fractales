package fr.univartois.butinfo.fractals.figure.formes;

import fr.univartois.butinfo.fractals.complex.points.IComplex;

import java.awt.*;

/**
 * Declaration de la classe Rectangle implementant IFugre qui sert à representer un rectangle
 * @author Axel Poteau
 */
public class Rectangle implements IFigure {

    /**
     * Declaration d'une instance Color color
     */
    private Color color;
    /**
     * Declaration d'une instance IComplexe pos
     */
    private IComplex pos;

    /**
     * declaration d'un double width
     */
    private double width;
    /**
     * Declaration d'un double height
     */
    private double height;

    /**
     * Declaration du constructeur de rectangle
     * @param color Instance de Color
     * @param pos Instance de IComplex
     * @param width double
     * @param height double
     */
    public Rectangle(Color color, IComplex pos, double width, double height) {
        this.color = color;
        this.pos = pos;
        this.width=width;
        this.height=height;
    }

    /**
     * Getter de Pos
     * @return l'attribut pos
     */
    public IComplex getPos() {
        return pos;
    }

    /**
     * Declaration de la methode repr qui represente une figure en String
     * @return Une representation d'un figure
     */
    @Override
    public String repr() {
        return "<rect x='"+pos.getRealPart()+"' y='"+pos.getImaginaryPart()+"' width='"+width+"' height='"+height+"' fill ='rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")'/>\n";


    }
}
