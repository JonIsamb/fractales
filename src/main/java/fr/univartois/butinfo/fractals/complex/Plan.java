package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;
import fr.univartois.butinfo.fractals.suites.IPointPlan;

public class Plan implements IPlan{
    private int height;
    private int width;

    public Plan(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public IComplex asComplex(int row, int column) {
        double re = (column + .5) - (width / 2.);
        double im = (height / 2.) - (row + .5);
        return new Complex(re, im);
        }


    public Pixel asPixel(IComplex complex, IFractalImage image) {
        int row= (int) ((complex.getRealPart()+(width/2))-.5);
        int column= (int) (((height/2)+complex.getImaginaryPart()-.5));
        return new Pixel(image,row,column);
    }

    @Override
    public Pixel asPixel(IPointPlan point, IFractalImage image) {
        int row= (int) ((point.getX()+(width/2))-.5);
        int column= (int) (((height/2)+point.getY()-.5));
        return new Pixel(image,row,column);
    }
}
