package fr.univartois.butinfo.fractals.complex;

public class Plan implements IPlan{
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Plan(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public IComplex asComplex(int row, int column) {
        double re = (column + .5) - (width / 2.);
        double im = (height / 2.) - (row + .5);
        return new Complex(re, im);
        }
}
