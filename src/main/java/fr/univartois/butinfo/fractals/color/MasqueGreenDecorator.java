package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public class MasqueGreenDecorator extends ColorDecorator{

    public MasqueGreenDecorator(Color color) {
        super(color);
    }
    @Override
    public Color getColor(int nbIteration) {
        return this.getColor();
    }
    @Override
    public Color masque() {
        return new Color(0,this.getColor().getGreen(),0);
    }
}