package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public class ColorDecorator implements IColor{
    private Color color;

    public ColorDecorator(Color color){
        this.color=color;
    }

    @Override
    public Color getColor(int nbIteration) {
        return color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Color masque() {
        return null;
    }
}
