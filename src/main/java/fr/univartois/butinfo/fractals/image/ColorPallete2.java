package fr.univartois.butinfo.fractals.image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorPallete2 implements IColorStrategy{
    private List<Color> listColor=new ArrayList<>();

    public ColorPallete2(){
        this.listColor.add(Color.BLUE);
        this.listColor.add(Color.RED);
        this.listColor.add(Color.YELLOW);
        this.listColor.add(Color.BLACK);
        this.listColor.add(Color.GRAY);
        this.listColor.add(Color.GREEN);
        this.listColor.add(Color.ORANGE);
        this.listColor.add(Color.DARK_GRAY);
        this.listColor.add(Color.PINK);
        this.listColor.add(new Color(90,8,30));
    }

    @Override
    public Color getColor(int nbIteration) {
        return listColor.get(nbIteration%listColor.size());
    }
}
