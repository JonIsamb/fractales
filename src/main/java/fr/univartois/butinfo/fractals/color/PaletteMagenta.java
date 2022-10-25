package fr.univartois.butinfo.fractals.color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaletteMagenta implements IColor {
    private Color color;
    public static final int NB_NUANCE=20;

    public PaletteMagenta(){
        this.color=Color.MAGENTA;
    }

    @Override
    public Color getColor(int nbIteration) {
        return new Color(color.getRed()/(nbIteration/NB_NUANCE),color.getGreen()/(nbIteration/NB_NUANCE),color.getBlue()/(nbIteration/NB_NUANCE));
    }

    @Override
    public Color masque() {
        return color;
    }
}
