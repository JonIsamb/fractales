package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public class PaletteGray implements IColor {
    private Color color;

    public PaletteGray(){
        this.color=Color.GRAY;
    }

    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        float nbIte = (float) nbIteration-1;
        float maxIte = (float) iterationsMax;
        float ratio = nbIte/maxIte;
        return new Color(ratio, ratio, ratio);
    }

    @Override
    public Color masque() {
        return color;
    }
}
