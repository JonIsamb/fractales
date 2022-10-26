package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public class MasqueBlueDecorator extends ColorDecorator{
    public MasqueBlueDecorator(Color color) {
        super(color);
    }
    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        return this.getColor();
    }
    @Override
    public Color masque() {
        return new Color(0,0,this.getColor().getBlue());
    }
}
