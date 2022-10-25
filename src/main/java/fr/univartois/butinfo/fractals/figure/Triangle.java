package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;

public class Triangle implements IFigure{
    private Object color;
    private Complex posx;
    private Complex posy;
    private Complex posz;


    public Triangle(Object color, Complex posx, Complex posy,Complex posz) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
        this.posz=posz;
    }


    @Override
    public String repr() {
        return "<polygon points='"+posx.getRealPart()+", "+posx.getImaginaryPart()+" "+posy.getRealPart()+", "+posy.getImaginaryPart()+" "+posz.getRealPart()+", "+posz.getImaginaryPart()+"'stroke ="+color+"/>";



    }
}
