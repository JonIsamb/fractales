package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

public class Circle implements IFigure{
    private String color;
    private IComplex pos;
    private int radius;

    public Circle(String color, IComplex pos, int radius) {
        this.color = color;
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public String repr() {
        return "<circle cx='"+pos.getRealPart()+"' cy='"+pos.getImaginaryPart()+"' r='"+radius+"' fill ='"+color+"'/>";
    }
}
