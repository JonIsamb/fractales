package fr.univartois.butinfo.fractals.figure.formes;

import fr.univartois.butinfo.fractals.complex.points.IComplex;

import java.util.ArrayList;
import java.util.List;

/**
 * Declaration de la FigureComposite qui implemente IFigure qui sert de composite
 * @author Axel Poteau
 */
public class FigureComposite implements IFigure {
    /**
     * Déclaration d'une liste de IFigure nommé figures
     */
    private List<IFigure> figures;

    /**
     * Declaration du constructeur de FigureComposite
     */
    public FigureComposite() {
        this.figures = new ArrayList<>();
    }

    /**
     * Declaration de la methode repr qui renvoie en string la representation des figures
     * @return la representation en String
     */
    @Override
    public String repr() {
        StringBuilder stringbuilder = new StringBuilder();
        for (IFigure figure:figures){
            stringbuilder.append(figure.repr());
        }
        return stringbuilder.toString();
    }

    /**
     * Declaration de la methode getPos qui renvoie null
     * @return null
     */
    @Override
    public IComplex getPos() {
        return null;
    }

    /**
     * Declaration de la méthode add qui ajoute fig a figures
     * @param fig figure a ajouter
     */
    public void add(IFigure fig){
        figures.add(fig);

    }

    /**
     * Declaration de la methode remove qui supprime fig de figures
     * @param fig la figure a supprimer
     */
    public void remove(IFigure fig){
        if(figures.contains(fig)){
            figures.remove(fig);
        }

    }
}
