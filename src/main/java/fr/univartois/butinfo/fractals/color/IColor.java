package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public interface IColor {
    abstract Color getPalette(int nbIteration, int iterationsMax);
    Color masque();

}
