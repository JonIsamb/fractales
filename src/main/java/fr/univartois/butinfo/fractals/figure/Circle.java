package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;

public class Circle implements IFigure{
    private Object color;
    private Complex pos;
    private int radius;

    public Circle(Object color, Complex pos, int radius) {
        this.color = color;
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public String repr() {
        return "<circle cx="+pos.getRealPart()+" cy="+pos.getImaginaryPart()+" r="+radius+" stroke ="+color+"/>";
    }
}
