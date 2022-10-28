package fr.univartois.butinfo.fractals.complex;

import java.util.Objects;

/**
 * Declaration de la classe Complex qui implements IComplex servant a representer des complexes
 * @author Axel Poteau
 */
public class Complex implements IComplex{
    /**
     * Attribut double re servant a représenter la partie réelle d'un complexe
     */
    private double re;
    /**
     * Attribut double im servant a représenter la partie imaginaire d'un complexe
     */
    private double im;

    /**
     * Declaration du Constructeur de Complex
     * @param re Double representant la partie réelle
     * @param im double representant la partie imaginaire
     */
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * Declarations de la méthode equals qui sert a verifier si deux complexs sont égaux
     * @param o Objet avec lequel on veut verifier l'egaliter
     * @return True si les objets sont égaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return this.subtract((Complex) o).abs()<0.0001;
    }

    /**
     * Declaration de la methode hashCode
     * @return le hash des attributs
     */
    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    /**
     * Declarationde la méthode toString
     * @return les attributs en string
     */
    @Override
    public String toString() {
        return re +
                " + " + im + "i";
    }

    /**
     * Getter de l'attribut re
     * @return l'attribut re
     */
    @Override
    public double getRealPart() {
        return this.re;
    }

    /**
     * Getter de l'attribut im
     * @return l'attribut im
     */
    @Override
    public double getImaginaryPart() {
        return this.im;
    }


    /**
     * Declaration de la méthode abs qui calcule le module
     * @return le module du complex
     */
    @Override
    public double abs() {
        double sum = this.getRealPart()*this.getRealPart()+this.getImaginaryPart()*this.getImaginaryPart();
        return Math.sqrt(sum);
    }

    /**
     * Declaration de la methode negate qui renvoie l'inverse
     * @return l'inverse d'un complex
     */
    @Override
    public IComplex negate() {
        IComplex result = this.multiply(-1);
        return result;
    }

    /**
     * Déclaration de la méthode conjugate qui renvoie le conjugé
     * @return le conjugue d'un complex
     */
    @Override
    public IComplex conjugate() {
        double im = this.getImaginaryPart()*-1;
        Complex result = new Complex(this.getRealPart(),im);
        return result;
    }

    /**
     * Declaration de la méthode add
     * @param other Le nombre complexe à ajouter à ce nombre.
     *
     * @return l'addition de deux complex
     */
    @Override
    public IComplex add(IComplex other) {
        double re = other.getRealPart()+this.getRealPart();
        double im = other.getImaginaryPart()+this.getImaginaryPart();
        Complex result = new Complex(re,im);
        return result;
    }

    /**
     * Declaration de la méthode substract
     * @param other Le nombre complexe à soustraire de ce nombre.
     *
     * @return la soustraction par other
     */
    @Override
    public IComplex subtract(IComplex other) {
        double re = this.getRealPart()-other.getRealPart();
        double im = this.getImaginaryPart()-other.getImaginaryPart();
        Complex result = new Complex(re,im);
        return result;
    }

    /**
     * Declaration de la méthode multiply
     * @param value La valeur par laquelle multiplier ce nombre.
     *
     * @return le resultat du produit du complex par valye
     */
    @Override
    public IComplex multiply(double value) {
        double re = value*this.getRealPart();
        double im = value*this.getImaginaryPart();
        Complex result = new Complex(re,im);
        return result;
    }

    /**
     * Declaration de la méthode multiply par un complexe
     * @param other Le nombre complexe à mulitplier par ce nombre.
     *
     * @return le produit des deux complexes
     */
    @Override
    public IComplex multiply(IComplex other) {
        double re = this.getRealPart()* other.getRealPart()-this.getImaginaryPart()*other.getImaginaryPart();
        double im = this.getRealPart()*other.getImaginaryPart()+this.getImaginaryPart()*other.getRealPart();
        Complex result = new Complex(re,im);
        return result;
    }

    /**
     * Declaration de la méthode divide par un complexe
     * @param other Le nombre complexe qui divise ce nombre.
     *
     * @return la division du complex par other
     */
    @Override
    public IComplex divide(IComplex other) {
        double quotien = other.getRealPart()*other.getRealPart()+other.getImaginaryPart()*other.getImaginaryPart();
        double re = this.getRealPart()*other.getRealPart() + this.getImaginaryPart()*other.getImaginaryPart();
        double im = this.getImaginaryPart()*other.getRealPart() - this.getRealPart()*other.getImaginaryPart();
        re = re/quotien;
        im = im/quotien;

        Complex result = new Complex(re,im);
        return result;
    }
}

