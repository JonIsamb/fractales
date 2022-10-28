package fr.univartois.butinfo.fractals.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Déclaration de la classe BufferedImageAdapter qui implemente IFractalImage et sui sert s'adaptateur
 * @author Amaury Bonsigne
 */
public class BufferedImageAdapter implements IFractalImage{
    /**
     * Déclare une instance de BufferedImage qui s'appele image
     */
    private BufferedImage image;

    /**
     * Déclaration du constructeur de la classe BufferedImageAdapter qui va créer une image a partir des paramètres
     * @param height Represente la hauteur de l'image
     * @param width Represente la largeur de l'image
     */
    public BufferedImageAdapter(int height, int width){
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    }

    /**
     * Getter de l'attribut Height
     * @return L'attribut height
     */
    @Override
    public int getHeight() {
        return image.getHeight();
    }

    /**
     * Getter de l'attribut width
     * @return l'attribut width
     */
    @Override
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * Getter d'un pixel en fonction des paramètres
     * @param row La ligne où se trouve le pixel.
     * @param column La colonne où se trouve le pixel.
     *
     * @return une Instance de pixel en fonction paramètres
     */
    @Override
    public Pixel getPixel(int row, int column) {
        return new Pixel(this,row,column);
    }

    /**
     * Setter qui permet de changer la couleur d'un pixel en fonction des parametre
     * @param row La ligne du pixel à mettre à jour.
     * @param column La couleur du pixel à mettre à jour.
     * @param color La nouvelle couleur du pixel.
     */
    @Override
    public void setColor(int row, int column, Color color) {
        image.setRGB(row,column,color.getRGB());
    }

    /**
     * Declaration de la méthode SaveAs qui permet de sauvegarder l'image
     * @param path Le chemin du fichier où sauvegarder l'image.
     *
     * @throws IOException si le fichier n'est pas trouver
     */
    @Override
    public void saveAs(String path) throws IOException {
        try{
            String[] splitted = path.split("\\.");
            String formatName = splitted[splitted.length - 1];
            ImageIO.write(image, formatName, new File(path));
        }catch (IOException e){
            throw e;
        }

    }
}
