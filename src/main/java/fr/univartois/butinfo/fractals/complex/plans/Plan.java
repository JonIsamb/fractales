package fr.univartois.butinfo.fractals.complex.plans;

import fr.univartois.butinfo.fractals.complex.points.Complex;
import fr.univartois.butinfo.fractals.complex.points.IComplex;
import fr.univartois.butinfo.fractals.complex.points.IPointPlan;
import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;

/**
 * Déclaration de la classe Plan implémentant Iplan servant à représenter un Plan
 * @author Axel Poteau
 */
public class Plan implements IPlan {
    /**
     * Déclaration de l'attribut height
     */
    private int height;
    /**
     * Déclaration de l'attribut width
     */
    private int width;


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    private Complex focus;

    public Plan(int height, int width, Complex focus) {

        this.height = height;
        this.width = width;
        this.focus = focus;
    }

    /**
     * Declaration de la methode asComplex
     * @param row Abcisse
     * @param column Ordonné
     * @return un complexe
     */
    public IComplex asComplex(int row, int column) {
        double re = (column + .5) - (width / 2.);
        double im = (height / 2.) - (row + .5);
        return new Complex(re, im);
    }

    /**
     * Declaration de la methode asPixel pour un complex
     * @param complex complexe a transformer
     * @param image l'image servant a la création du pixel
     * @return Un Pixel
     */
    public Pixel asPixel(IComplex complex, IFractalImage image) {
        int row= (int) ((complex.getRealPart()+(width/2))-.5);
        int column= (int) (((height/2)+complex.getImaginaryPart()-.5));
        return new Pixel(image,row,column);
    }

    /**
     * Declaration de la methode asPixel pour un point
     * @param point Point a transformer
     * @param image l'image servant a la création du pixel
     * @return un Pixel
     */
    @Override
    public Pixel asPixel(IPointPlan point, IFractalImage image) {
        Complex c = (Complex) point.getComplex();

        int column = (int) ((c.getRealPart()+(width/2.))-.5);
        int row = (int) (((height/2) - c.getImaginaryPart()-.5));

        return new Pixel(image, row, column);
    }
}
