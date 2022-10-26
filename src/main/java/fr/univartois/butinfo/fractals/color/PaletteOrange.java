package fr.univartois.butinfo.fractals.color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaletteOrange implements IColor {
    private Color color;
    public static final int NB_NUANCE=20;

    public PaletteOrange(){
        this.color=Color.ORANGE;
    }

    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        float nbIte = (float) nbIteration-1;
        float maxIte = (float) iterationsMax;
        float ratio = nbIte/maxIte;
        return new Color(1, ratio, (float) 0.);
    }

    @Override
    public Color masque() {
        return color;
    }
}
