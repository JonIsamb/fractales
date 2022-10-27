package fr.univartois.butinfo.fractals.figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class FigureMethode {

    public FigureMethode(){}
    public  PrintWriter create(String filepath){
        PrintWriter writter = null;
        try{
            writter = new PrintWriter(new File(filepath));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return writter;

    }
    public PrintWriter header(PrintWriter write, int height, int width){

        write.write("<svg width='"+width+"' height='"+height+"' xmlns=\"http://www.w3.org/2000/svg\">");
        return write;
    }

    public PrintWriter footer(PrintWriter write){
        write.write("</svg>");
        return write;
    }
    public abstract PrintWriter figure(PrintWriter write, int iterate);

    public PrintWriter flush(PrintWriter writter){
        writter.flush();
        writter.close();
        return writter;
    }
    public void methode(String file,int iterate,int height, int width){
        PrintWriter writer = create(file);
        writer=header(writer,height,width);
        for(int x =0;x<iterate;x++){
            writer = figure(writer,iterate);

        }
        writer = footer(writer);
        writer = flush(writer);

    }



}
