package fr.univartois.butinfo.fractals.color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaletteMagenta implements IColor {
    private Color color;

    public PaletteMagenta(){
        this.color=Color.MAGENTA;
    }

    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        float nbIte = (float) nbIteration-1;
        float maxIte = (float) iterationsMax;
        float ratio = nbIte/maxIte;
        return new Color(ratio, (float) 0., ratio);
    }

    @Override
    public Color masque() {
        return color;
    }
}
