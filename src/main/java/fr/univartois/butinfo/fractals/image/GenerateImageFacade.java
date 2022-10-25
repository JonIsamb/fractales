package fr.univartois.butinfo.fractals.image;


import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.Plan;
import fr.univartois.butinfo.fractals.suites.EnsembleJulia;
import fr.univartois.butinfo.fractals.suites.SuitesStrategy;

public class GenerateImageFacade {
    public void generateImage(int width, int height, int scale, int focusX, int focusY, String format, String color, String file, int nbIteration){
        IFractalImage image = new BufferedImageAdapter(width,height);
        Plan plan = new Plan(height,width);
        IComplex c = new Complex(-0.4,0.6);

        for(int x = 0;x<width;x++){
            for(int y=0;y<height;y++){
                IComplex point = plan.asComplex(x,y);
                SuitesStrategy suite = new EnsembleJulia(point,c,nbIteration);

                Pixel pixel = image.getPixel(x,y);
                pixel.setColor();
            }
        }

    }
}
