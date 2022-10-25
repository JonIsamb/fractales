package fr.univartois.butinfo.fractals.image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorPallete1 implements IColorStrategy{
    private List<Color> listColor=new ArrayList<>();

    public ColorPallete1(){
        this.listColor.add(new Color(120,8,190));
        this.listColor.add(new Color(90,120,30));
        this.listColor.add(new Color(7,8,70));
        this.listColor.add(new Color(191,120,30));
        this.listColor.add(new Color(120,180,190));
        this.listColor.add(new Color(190,120,130));
        this.listColor.add(new Color(0,180,190));
        this.listColor.add(new Color(90,120,90));
        this.listColor.add(new Color(220,160,140));
        this.listColor.add(new Color(220,220,30));
    }


    @Override
    public Color getColor(int nbIteration) {
        return listColor.get(nbIteration % listColor.size());
    }
}
