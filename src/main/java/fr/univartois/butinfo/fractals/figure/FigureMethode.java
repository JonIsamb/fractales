package fr.univartois.butinfo.fractals.figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Déclaration de la classe abstract FigureMethode
 * @author Axel Poteau
 */
public abstract class FigureMethode {
    /**
     * Declaration de l'attribut height
     */
    private int height;
    /**
     * Declaration de l'attribut width
     */
    private int width;

    /**
     * Declaration du constructeur de la classe FigureMethode
     * @param height l'attribut height
     * @param width L'attribut width
     */
    public FigureMethode(int height, int width){
        this.height=height;
        this.width=width;
    }

    /**
     * Getter de l'attribut height
     * @return l'attribut height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter de l'attribut width
     * @return l'attribut width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Declaration de la méthode create
     * @param filepath Chemin du fichier
     * @return Renvoie un PrintWritter
     */
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

    /**
     * Declaration de la méthode header
     * @param write instance de PrintWriter
     * @return Un PrintWriter
     */
    public PrintWriter header(PrintWriter write){

        write.write("<svg width='"+width+"' height='"+height+"' xmlns=\"http://www.w3.org/2000/svg\">");
        return write;
    }

    /**
     * Declaration de la méthode footer
     * @param write Instance De PrintWriter
     * @return un PrintWriter
     */
    public PrintWriter footer(PrintWriter write){
        write.write("</svg>");
        return write;
    }

    /**
     * Declaration de la méthode abstraite figure
     * @param write Instance PrintWriter
     * @param iterate nombre d'iterations
     * @return un PrintWriter
     */
    public abstract PrintWriter figure(PrintWriter write, int iterate);

    /**
     * Declaration de la methode flush
     * @param writter Instance de PrintWriter
     * @return un PrintWriter
     */
    public PrintWriter flush(PrintWriter writter){
        writter.flush();
        writter.close();
        return writter;
    }

    /**
     * Declaration de la methode methode
     * @param file chemin du fichier
     * @param iterate nombre d'iterations
     */
    public void methode(String file,int iterate){
        PrintWriter writer = create(file);
        writer=header(writer);
        writer = figure(writer,iterate);
        writer = footer(writer);
        writer = flush(writer);

    }



}
