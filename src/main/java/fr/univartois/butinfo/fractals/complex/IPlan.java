package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;
import fr.univartois.butinfo.fractals.suites.IPointPlan;

public interface IPlan {
    IComplex asComplex(int row, int column);
    Pixel asPixel(IComplex complex, IFractalImage image);
    Pixel asPixel(IPointPlan point, IFractalImage image);
}
