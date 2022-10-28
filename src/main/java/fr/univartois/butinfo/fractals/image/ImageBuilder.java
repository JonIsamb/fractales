package fr.univartois.butinfo.fractals.image;


import fr.univartois.butinfo.fractals.color.*;
import fr.univartois.butinfo.fractals.complex.*;
import fr.univartois.butinfo.fractals.figure.Sierpinski;
import fr.univartois.butinfo.fractals.suites.EnsembleJulia;
import fr.univartois.butinfo.fractals.suites.EnsembleMandelbrot;
import fr.univartois.butinfo.fractals.suites.SuiteIterator;
import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.MultiplyPlan;
import fr.univartois.butinfo.fractals.complex.Plan;
import fr.univartois.butinfo.fractals.suites.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Déclaration de la classe ImageBuilder qui permet de générer l'image
 * @author Jonathan Isambourg
 */
public class ImageBuilder {

    /**
     * Declaration de l'attribut witdh qui represente la largeur de l'image
     */
    private int width;

    /**
     * Declaration de l'attribut height qui represente la hauteur de l'image
     */
    private int height;

    /**
     * Declaration de l'attribut scale qui represente l'echelle
     */
    private double scale;

    /**
     * Declaration de l'attribut focusX
     */
    private double focusX;

    /**
     * Declaration de l'attribut focusY
     */
    private double focusY;

    /**
     * Declaration de l'attribut suite qui est le nom de la suite que l'on veut representer
     */
    private String suite;

    /**
     * Declaration de l'attribut palette qui est le nom de la palette
     */
    private String palette;

    /**
     * Declaration de l'attribut pathToFile qui est le chemin du dossier ou l'image ou sera sauvegarde
     */
    private String pathToFile;

    /**
     * Declaration de l'attribut iterationsMax qui represente le nombre maximums d'iterations
     */
    private int iterationsMax;

    /**
     * Setter de l'attribut width
     * @param width qui deviendra l'attribut width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Setter de l'attribut height
     * @param height qui deviendra l'attribut Height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Setter de l'attribut scale
     * @param scale qui deviendra l'attribut scale
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

    /**
     * Setter de l'attribut focusX
     * @param focusX qui deviendra l'attribut focusX
     */
    public void setFocusX(double focusX) {
        this.focusX = focusX;
    }

    /**
     * Setter de l'attribut focusY
     * @param focusY qui deviendra l'attribut focusY
     */
    public void setFocusY(double focusY) {
        this.focusY = focusY;
    }

    /**
     * Setter de l'attribut suite
     * @param suite qui deviendra l'attribut suite
     */
    public void setSuite(String suite) {
        this.suite = suite;
    }

    /**
     * setter de l'attribut palette
     * @param palette qui deviendra l'attribut palette
     */
    public void setPalette(String palette) {
        this.palette = palette;
    }

    /**
     * setter de l'attribut pathToFile
     * @param pathToFile qui deviendra l'attribut pathToFile
     */
    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Setter de l'attribut iterationsMax
     * @param iterationsMax qui deviendra iterationsMax
     */
    public void setIterationsMax(int iterationsMax) {
        this.iterationsMax = iterationsMax;
    }

    /**
     * Déclaration de la méthode getResult  qui va générer l'image de la suite
     * @return L'image de la fractal qui va être générer
     * @throws IOException si le fichier ou l'image va être sauvegardé n'est pas trouvé
     */
    public IFractalImage getResult() throws IOException {
        IFractalImage image = new BufferedImageAdapter(height, width);

        Complex center = new Complex(focusX, focusY);
        Plan plan = new Plan(height, width, center);
        SumPlan centeredPlan = new SumPlan(plan, center);
        MultiplyPlan scaledPlan = new MultiplyPlan(scale, centeredPlan);

        IComplex c = new Complex(-0.8,0.156);

        IColor paletteColor;
        if ("magenta".equals(palette)){
            paletteColor = new PaletteMagenta();
        } else if ("orange".equals(palette)){
            paletteColor = new PaletteOrange();
        } else if ("green".equals(palette)){
            paletteColor = new PaletteGreen();
        } else {
            paletteColor = new PaletteGray();
        }


        if (("j".equals(suite)) || ("m".equals(suite)) || ("gj".equals(suite)) || ("gm".equals(suite))){
            for(int x = 0; x<width; x++){
                for(int y = 0; y<height; y++){
                    IComplex point = scaledPlan.asComplex(x, y);

                    SuitesStrategy typeSuite;
                    if ("j".equals(suite)) {
                        typeSuite = new EnsembleJulia(point, c, iterationsMax);
                    } else if ("m".equals(suite)){
                        typeSuite = new EnsembleMandelbrot(point, iterationsMax);
                    } else if ("gj".equals(suite)){
                        typeSuite = new GeneralisationJulia(point, c, iterationsMax, (prev, comp) -> ((prev.multiply(prev).add(prev)).divide(prev.multiply(prev.multiply(prev)).add(comp))));
                    } else if ("gm".equals(suite)) {
                        typeSuite = new GeneralisationMandelbrot(point, iterationsMax, (prev, comp) -> ((prev.multiply(prev).multiply(prev)).add(prev)));
                    } else {
                        typeSuite = new EnsembleJulia(point, c, iterationsMax);
                    }

                    SuiteIterator iterator = (SuiteIterator) typeSuite.iterator();
                    while(iterator.hasNext()){
                        iterator.next();
                    }
                    int nbIteration = iterator.getNbIterations();

                    Color color = paletteColor.getPalette(nbIteration, iterationsMax);

                    Pixel pixel = image.getPixel(x, y);
                    pixel.setColor(color);
                }
            }
        } else if (("j".equals(suite)) || ("j".equals(suite))){
            for(int x = 0; x<width; x++){
                for(int y = 0; y<height; y++){
                    //System.out.println("Base : " + x + " " + y);
                    IComplex point = scaledPlan.asComplex(x, y);
                    //System.out.println("Complexe : " + point.getRealPart() + "   " + point.getImaginaryPart());
                    IPointPlan pointPlan = new IComplexAdapter(point);

                    Pixel test = scaledPlan.asPixel(pointPlan, image);
                    //System.out.println("Test : " + test.getColumn() + " " + test.getRow());

                    //System.out.println(pointPlan.getComplex().getRealPart() + "   " + pointPlan.getComplex().getImaginaryPart());
                    SuitesChaotiqueStrategy typeSuite;
                    if ("cc".equals(suite)) {
                        typeSuite = new SuiteCirculaire(pointPlan, iterationsMax, 100, 0.0001F);
                    } else if ("cf".equals(suite)){
                        typeSuite = new SuiteFeigenbaum(pointPlan, iterationsMax, 100, 0.001F);
                    }  else {
                        typeSuite = new SuiteFeigenbaum(pointPlan, iterationsMax, 100, 0.001F);
                    }

                    SuiteChaotiqueIterator iterator = (SuiteChaotiqueIterator) typeSuite.iterator();
                    while(iterator.hasNext()){
                        iterator.next();

                    }
                    int nbIteration = iterator.getNbIterations();
                    //System.out.println(nbIteration);

                    Color color = paletteColor.getPalette(nbIteration, iterationsMax);

                    IPointPlan precedent = iterator.getPrecedent();

                    double yPixel = precedent.getY();
                    if ((yPixel < height/2) && (yPixel > -height/2)) {
                        //System.out.println(xPixel + " " + yPixel);
                        //System.out.println("oui");
                        Pixel pixel = scaledPlan.asPixel(precedent, image);
                        //System.out.println("Pixel : " + pixel.getColumn() + "  " + pixel.getRow());
                        if (pixel.getRow() > 0 && pixel.getRow() < width && pixel.getColumn() > 0 && pixel.getColumn() < height){
                            pixel.setColor(color);
                        }
                    }
                }
            }
        } else if ("tapis".equals(suite)){
            Sierpinski test = new Sierpinski(width,height);
            test.methode(pathToFile, iterationsMax);
        }
        image.saveAs(pathToFile);
        return image;
    }
}
