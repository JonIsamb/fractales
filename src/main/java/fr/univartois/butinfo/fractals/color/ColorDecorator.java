package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public abstract class ColorDecorator implements IColor{
    private Color color;

    public ColorDecorator(Color color){
        this.color=color;
    }

    @Override
    public abstract Color getPalette(int nbIteration, int iterationsMax);

    public Color getColor() {
        return color;
    }

    @Override
    public Color masque() {
        return null;
    }
}
