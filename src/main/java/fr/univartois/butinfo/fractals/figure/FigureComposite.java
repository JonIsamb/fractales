package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.IComplex;

import java.util.ArrayList;
import java.util.List;

public class FigureComposite implements IFigure{
    private List<IFigure> figures;

    public FigureComposite() {
        this.figures = new ArrayList<>();
    }

    @Override
    public String repr() {
        StringBuilder stringbuilder = new StringBuilder();
        for (IFigure figure:figures){
            stringbuilder.append(figure.repr());
        }
        return stringbuilder.toString();
    }

    @Override
    public IComplex getPos() {
        return null;
    }

    public void add(IFigure fig){
        figures.add(fig);

    }
    public void remove(IFigure fig){
        if(figures.contains(fig)){
            figures.remove(fig);
        }

    }
}
