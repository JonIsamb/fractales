package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.IPlan;
import fr.univartois.butinfo.fractals.complex.Plan;

import java.awt.*;
import java.io.PrintWriter;


/**
 * Creation du tapis de sierpinski
 * @author Axel Poteau
 */
public class Sierpinski extends FigureMethode {
    /**
     * Declaration du constructeur de la classe Sierpinski appelant celui de FigureMethode
     * @param width
     * @param height
     */
    public Sierpinski(int width, int height){
        super(height,width);
    }

    /**
     * Fonction principale servant a dessiner le tapis, celle ci dessine le premier carrer au centre et appel draw qui dessinera les autres
     * @param writer Instance de PrintWriter
     * @param plan Instance de plan
     * @param color Instance de color
     * @param nb_max nombre max d'instance du tapis
     * @return renvoi le printwriter afin de le fermer et afficher le svg
     */
    public PrintWriter loop(PrintWriter writer, Plan plan, Color color, int nb_max){
        double height = plan.getHeight();
        double width = plan.getWidth();
        IComplex pos = new Complex(width/3,height/3);
        IFigure carre = new Rectangle(color,pos,width/3,height/3);
        writer.write(carre.repr());

        color = color.darker();
        IComplex origin = new Complex(0,0);
        draw(writer, height/3, width/3,color, carre, nb_max,0, origin, width);
        return writer;

    }

    /**
     *
     * @param writer Instance de PrintWriter
     * @param height Hauteur du carre
     * @param width Largeur du carre
     * @param color Instance de color pour colorier les carra
     * @param carre Instance de Rectangle, Carre centrale autour du quel l'on va dessiner les autres
     * @param nb_max Nb max d'instance du tapis
     * @param cons Constente suivant le nombre d'instance du tapis
     * @param origin Instance de complex, point d'origine a utiliser pour placer les carres
     * @param taille Taille a utiliser pour changer le complex origin
     */
    public void draw(PrintWriter writer, double height, double width, Color color, IFigure carre, int nb_max, int cons, IComplex origin, double taille) {
        if (cons < nb_max){
            height = height/3;
            width = width/3;
            IComplex pos1 = new Complex(height+origin.getRealPart(),height+ origin.getImaginaryPart());
            IFigure carre1 = new Rectangle(color, pos1, width, height);

            IComplex pos2 = new Complex(height + carre.getPos().getRealPart(), width+ origin.getImaginaryPart());
            IFigure carre2 = new Rectangle(color, pos2, width, height);

            IComplex pos3 = new Complex(height + carre.getPos().getRealPart()*2-origin.getRealPart(), width+ origin.getImaginaryPart());
            IFigure carre3 = new Rectangle(color, pos3, width, height);

            IComplex pos4 = new Complex(height + carre.getPos().getRealPart()*2-origin.getRealPart(), width + carre.getPos().getImaginaryPart());
            IFigure carre4 = new Rectangle(color, pos4, width, height);

            IComplex pos5 = new Complex(height + carre.getPos().getRealPart()*2-origin.getRealPart(), width + carre.getPos().getImaginaryPart()*2- origin.getImaginaryPart());
            IFigure carre5 = new Rectangle(color, pos5, width, height);

            IComplex pos6 = new Complex(height + carre.getPos().getRealPart(), width + carre.getPos().getImaginaryPart()*2- origin.getImaginaryPart());
            IFigure carre6 = new Rectangle(color, pos6, width, height);

            IComplex pos7 = new Complex(height+origin.getRealPart(), width + carre.getPos().getImaginaryPart()*2- origin.getImaginaryPart());
            IFigure carre7 = new Rectangle(color, pos7, width, height);

            IComplex pos8 = new Complex(height+origin.getRealPart(), width + carre.getPos().getImaginaryPart());
            IFigure carre8 = new Rectangle(color, pos8, width, height);

            FigureComposite liste = new FigureComposite();
            liste.add(carre1);
            liste.add(carre2);
            liste.add(carre3);
            liste.add(carre4);
            liste.add(carre5);
            liste.add(carre6);
            liste.add(carre7);
            liste.add(carre8);
            writer.write(liste.repr());
            color=color.darker();



            IComplex origin1 = new Complex(origin.getRealPart(),origin.getImaginaryPart());
            IComplex origin2 = new Complex(origin.getRealPart()+taille/3,origin.getImaginaryPart());
            IComplex origin3 = new Complex(origin.getRealPart()+2*taille/3,origin.getImaginaryPart());
            IComplex origin4 = new Complex(origin.getRealPart()+2*taille/3,origin.getImaginaryPart()+taille/3);
            IComplex origin5 = new Complex(origin.getRealPart()+2*taille/3,origin.getImaginaryPart()+2*taille/3);
            IComplex origin6 = new Complex(origin.getRealPart()+taille/3,origin.getImaginaryPart()+2*taille/3);
            IComplex origin7 = new Complex(origin.getRealPart(),origin.getImaginaryPart()+2*taille/3);
            IComplex origin8 = new Complex(origin.getRealPart(),origin.getImaginaryPart()+taille/3);

            /**
             * recursivité des draw
             */

            draw(writer, height, width, color, carre1,nb_max,cons+1,origin1,taille/3);
            draw(writer, height, width, color, carre2,nb_max,cons+1,origin2,taille/3);
            draw(writer, height, width, color, carre3,nb_max,cons+1,origin3,taille/3);
            draw(writer, height, width, color, carre4,nb_max,cons+1,origin4,taille/3);
            draw(writer, height, width, color, carre5,nb_max,cons+1,origin5,taille/3);
            draw(writer, height, width, color, carre6,nb_max,cons+1,origin6,taille/3);
            draw(writer, height, width, color, carre7,nb_max,cons+1,origin7,taille/3);
            draw(writer, height, width, color, carre8,nb_max,cons+1,origin8,taille/3);
        }



    }

    /**
     *
     * @param write Instance PrintWriter
     * @param iterate nombre d'iterations
     * @return write afin d'afficher le tapis dessiner
     */
    @Override
    public PrintWriter figure(PrintWriter write, int iterate) {
        Color color = Color.white;

        Plan plan = new Plan(super.getHeight(),super.getWidth(), new Complex(1, 1));
        write = loop(write,plan,color,iterate);

        return write;
    }
}
