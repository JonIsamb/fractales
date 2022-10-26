package fr.univartois.butinfo.fractals.figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class FigureMethode {
    public  void createWriterFigure(String filepath){
        PrintWriter  writter = null;
        try{
            writter = new PrintWriter(new File(filepath));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    public PrintWriter header(PrintWriter write, int height, int width){

        write.write("<svg width="+width+" height="+height+">");
        return write;
    }

    public PrintWriter footer(PrintWriter write){
        write.write("</svg>");
        return write;
    }
    public abstract PrintWriter figure(PrintWriter write, int iterate);

    public PrintWriter flush(PrintWriter writter){
        writter.flush();
        return writter;
    }



}
