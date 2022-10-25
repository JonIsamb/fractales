package fr.univartois.butinfo.fractals.color;

import java.awt.*;

public interface IColor {
    Color getColor(int nbIteration);
    Color masque();

}
