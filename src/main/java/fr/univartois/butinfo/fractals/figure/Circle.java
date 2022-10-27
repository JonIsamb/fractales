package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

public class Circle implements IFigure{
    private Color color;
    private IComplex pos;
    private double radius;

    public Circle(Color color, IComplex pos, double radius) {
        this.color = color;
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public String repr() {
        return "<circle cx='"+pos.getRealPart()+"' cy='"+pos.getImaginaryPart()+"' r='"+radius+"' fill ='rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")'/>";
    }

    @Override
    public IComplex getPos() {
        return pos;
    }
}
