package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

public class FigureDecorator{

    public static String translation(String x, IComplex co){
        x="<g transform=\"translate("+co.getRealPart()+","+co.getImaginaryPart()+")\" >"+x+"</g>";
        return x;
    }
    public static String Rotate(String x, int degree){
        x = "<g transform=\"rotate("+degree+")\" >"+x+"</g>";
        return x;
    }
    public static String scale(String x, int scale){
        x = "<g transform=\"scale("+scale+")\" >"+x+"</g>";
        return x;
    }


}
