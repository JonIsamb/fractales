package fr.univartois.butinfo.fractals.complex;

import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;
import fr.univartois.butinfo.fractals.suites.IPointPlan;

/**
 * Déclaration de la classe Plan implémentant Iplan servant à représenter un Plan
 * @author Axel Poteau
 */
public class Plan implements IPlan{
    /**
     * Déclaration de l'attribut height
     */
    private int height;
    /**
     * Déclaration de l'attribut width
     */
    private int width;

    /**
     * Declaration du constructeur de plan
     * @param height Attribut height
     * @param width Attribut width
     */
    public Plan(int height, int width) {
        this.height = height;
        this.width = width;
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
        int row= (int) ((point.getX()+(width/2))-.5);
        int column= (int) (((height/2)+point.getY()-.5));
        return new Pixel(image,row,column);
    }
}
