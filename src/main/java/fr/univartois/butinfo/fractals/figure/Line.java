package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;

public class Line implements IFigure{

    private Object color;
    private Complex posx;
    private Complex posy;


    public Line(Object color, Complex posx, Complex posy) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
    }


    @Override
    public String repr() {
        return "<line x1="+posx.getRealPart()+" x2="+posx.getImaginaryPart()+" y1="+posy.getRealPart()+" y2="+posy.getImaginaryPart()+" stroke=black stroke-width=5/>";


    }
}
