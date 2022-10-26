package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

public class Rectangle implements IFigure{

    private String color;
    private IComplex pos;

    private int width;
    private int height;

    public Rectangle(String color, IComplex pos, int width, int height) {
        this.color = color;
        this.pos = pos;
        this.width=width;
        this.height=height;
    }


    @Override
    public String repr() {
        return "<rect x='"+pos.getRealPart()+"' y='"+pos.getImaginaryPart()+"' width='"+width+"' height='"+height+"' fill ='"+color+"'/>";


    }
}
