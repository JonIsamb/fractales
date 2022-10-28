package fr.univartois.butinfo.fractals.complex.plans;

import fr.univartois.butinfo.fractals.complex.points.IComplex;
import fr.univartois.butinfo.fractals.complex.points.IPointPlan;
import fr.univartois.butinfo.fractals.image.IFractalImage;
import fr.univartois.butinfo.fractals.image.Pixel;

/**
 * Declaration de l'interface Iplan
 * @author Axel Poteau
 */
public interface IPlan {
    /**
     * Declaration de la methode asComplex qui transforme une abcisse et une ordonnée en complexe
     * @param row Abcisse
     * @param column Ordonné
     * @return Un complexe
     */
    IComplex asComplex(int row, int column);

    /**
     * Methode asPixel tansformant un complex en pixel
     * @param complex complexe a transformer
     * @param image l'image servant a la création du pixel
     * @return un pixel
     */
    Pixel asPixel(IComplex complex, IFractalImage image);

    /**
     * Methode asPixel tansformant un point en pixel
     * @param point Point a transformer
     * @param image l'image servant a la création du pixel
     * @return un Pixel
     */
    Pixel asPixel(IPointPlan point, IFractalImage image);
}
