package fr.univartois.butinfo.fractals.image;


import fr.univartois.butinfo.fractals.color.IColor;
import fr.univartois.butinfo.fractals.color.PaletteMagenta;
import fr.univartois.butinfo.fractals.color.PaletteOrange;
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

public class ImageBuilder {

    private int width;

    private int height;

    private double scale;

    private double focusX;

    private double focusY;

    private String suite;

    private String palette;

    private String pathToFile;

    private int iterationsMax;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setFocusX(double focusX) {
        this.focusX = focusX;
    }

    public void setFocusY(double focusY) {
        this.focusY = focusY;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setPalette(String palette) {
        this.palette = palette;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setIterationsMax(int iterationsMax) {
        this.iterationsMax = iterationsMax;
    }

    public IFractalImage getResult() throws IOException {
        IFractalImage image = new BufferedImageAdapter(height, width);
        Plan plan = new Plan(height, width);
        MultiplyPlan scaledPlan = new MultiplyPlan(scale, plan, height, width);
        IComplex c = new Complex(-0.4,0.6);

        IColor paletteColor;
        if ("magenta".equals(palette)){
            paletteColor = new PaletteMagenta();
        } else if ("orange".equals(palette)){
            paletteColor = new PaletteOrange();
        } else {
            paletteColor = new PaletteMagenta();
        }

        List<String> nomSuite = new ArrayList<String>();
        nomSuite.add("j");
        nomSuite.add("m");
        nomSuite.add("gj");
        nomSuite.add("gm");
        if (nomSuite.contains(suite)){
            for(int x = 0; x<width; x++){
                for(int y = 0; y<height; y++){
                    IComplex point = scaledPlan.asComplex(x, y);

                    SuitesStrategy typeSuite;
                    if ("j".equals(suite)) {
                        typeSuite = new EnsembleJulia(point, c, iterationsMax);
                    } else if ("m".equals(suite)){
                        typeSuite = new EnsembleMandelbrot(point, iterationsMax);
                    } else if ("gj".equals(suite)){
                        typeSuite = new GeneralisationJulia(point, c, iterationsMax, (prev, comp) -> (prev.divide(comp)));
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
        } else {
            for(int x = 0; x<width; x++){
                for(int y = 0; y<height; y++){
                    IComplex point = scaledPlan.asComplex(x, y);
                    IPointPlan pointPlan = new IComplexAdapter(point);

                    ISuitesChaotique typeSuite;
                    if ("cc".equals(suite)) {
                        typeSuite = new SuiteCirculaire(pointPlan, iterationsMax);
                    } else {
                        typeSuite = new SuiteFeigenbaum(pointPlan, iterationsMax);
                    }

                    SuiteChaotiqueIterator iterator = (SuiteChaotiqueIterator) typeSuite.iterator();
                    while(iterator.hasNext()){
                        iterator.next();
                    }
                    int nbIteration = iterator.getNbIterations();

                    Color color = paletteColor.getPalette(nbIteration, iterationsMax);
                    Pixel pixel = image.getPixel(x, y);
                    pixel.setColor(color);
                }
            }
        }


        image.saveAs(pathToFile);
        return image;
    }
}
