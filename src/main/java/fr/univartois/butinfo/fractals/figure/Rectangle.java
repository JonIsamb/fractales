package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;

public class Rectangle implements IFigure{

    private Object color;
    private Complex pos;

    private int width;
    private int height;

    public Rectangle(Object color, Complex pos, int width, int height) {
        this.color = color;
        this.pos = pos;
        this.width=width;
        this.height=height;
    }


    @Override
    public String repr() {
        return "<rect x="+pos.getRealPart()+" y="+pos.getImaginaryPart()+" width="+width+" height="+width+"/>";


    }
}
