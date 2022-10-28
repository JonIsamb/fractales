package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

public class Rectangle implements IFigure{

    private Color color;
    private IComplex pos;

    private double width;
    private double height;

    public Rectangle(Color color, IComplex pos, double width, double height) {
        this.color = color;
        this.pos = pos;
        this.width=width;
        this.height=height;
    }

    public IComplex getPos() {
        return pos;
    }

    @Override
    public String repr() {
        return "<rect x='"+pos.getRealPart()+"' y='"+pos.getImaginaryPart()+"' width='"+width+"' height='"+height+"' fill ='rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")'/>\n";


    }
}
