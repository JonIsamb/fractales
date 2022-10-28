# Autour des Fractales

## Description

Ce projet fournit une implantation de base pour votre projet de SAÉ S3.A.01.
Pour pouvoir développer votre propre implantation de ce projet, vous devez
en créer une **divergence** en cliquant sur le bouton `Fork` en haut à droite
de cette page.

Lorsque ce sera fait, vous pourrez inviter les membres de votre groupe en tant
que *Developer* pour vous permettre de travailler ensemble sur ce projet.

## Exécution

Pour exécuter l'application, vous pouvez exécuter la tâche `run` de *Gradle*.
Afin de vous permettre de facilement contrôler la création des fractales depuis
la ligne de commande, la classe `fr.univartois.butinfo.fractals.Fractals` (qui
définit la méthode `main`) gère déjà pour vous les arguments de cette ligne
de commande (les options données sont stockées dans les attributs de cette
classe).
Vous pouvez en particulier l'exécuter à l'aide des options suivantes :

```
-f,--fractal-name  <name>      Spécifie le nom de la fractale à générer.
-h,--height        <pixels>    Spécifie la hauteur de l'image à générer.
-n,--nb-iterations <integer>   Spécifie le nombre d'itérations à appliquer pour générer la fractale.
-o,--output        <file>      Spécifie le nom du fichier dans lequel la fractale doit être sauvegardée.
-p,--palette-name  <name>      Spécifie le nom de la palette de couleurs à appliquer lors de la génération.
-s,--scale         <ratio>     Spécifie l'échelle à appliquer sur l'image.
-w,--width         <pixels>    Spécifie la largeur de l'image à générer.
-x,--focus-x       <real>      Spécifie le point central de l'image sur l'axe des abscisses.
-y,--focus-y       <real>      Spécifie le point central de l'image sur l'axe des ordonnées.
```

Évidemment, vous devrez compléter la classe `Fractals` pour qu'il se passe
quelque chose lors de l'exécution !

## JAR exécutable

Vous avez également la possibilité de générer un JAR à l'aide de *Gradle*, en
exécutant la tâche `jar`.
Ce JAR constitue un exécutable que vous pouvez facilement distribuer, et que
vous pouvez exécuter de la manière suivante :

```bash
java -jar build/libs/sae-2022-2023.jar --help
```

Les options acceptées par ce JAR sont les mêmes que celles décrites dans la
section précédente.


# UML 

```plantuml


@startuml

class BufferedImageAdapter {
+ getHeight(): int
+ setColor(int, int, Color): void
+ saveAs(String): void
+ getWidth(): int
+ getPixel(int, int): Pixel
  }
  class Complex {
+ divide(IComplex): IComplex
+ hashCode(): int
+ toString(): String
+ equals(Object): boolean
+ multiply(double): IComplex
+ subtract(IComplex): IComplex
+ negate(): IComplex
+ add(IComplex): IComplex
+ multiply(IComplex): IComplex
+ getRealPart(): double
+ getImaginaryPart(): double
+ abs(): double
+ conjugate(): IComplex
  }
  class EnsembleJulia {
+ iterator(): Iterator<IComplex>
+ calculateNextTerm(IComplex): IComplex
  }
  class EnsembleMandelbrot {
+ calculateNextTerm(IComplex): IComplex
+ iterator(): Iterator<IComplex>
  }
  class Fractals {
- parseCliArguments(String[]): void
+ buildFractal(): void
+ main(String[]): void
+ usage(): void
  }
  class GeneralisationJulia {
+ calculateNextTerm(IComplex): IComplex
+ iterator(): Iterator<IComplex>
  }
  class GeneralisationMandelbrot {
+ calculateNextTerm(IComplex): IComplex
+ iterator(): Iterator<IComplex>
  }
  interface IComplex << interface >> {
+ conjugate(): IComplex
+ abs(): double
+ multiply(double): IComplex
+ subtract(IComplex): IComplex
+ multiply(IComplex): IComplex
+ negate(): IComplex
+ getImaginaryPart(): double
+ getRealPart(): double
+ add(IComplex): IComplex
+ divide(IComplex): IComplex
  }
  class IComplexAdapter {
+ getX(): double
+ distancePoint(IPointPlan): double
+ getY(): double
+ getComplex(): IComplex
+ pointPlanToComplex(IPointPlan): IComplex
  }
  class IComplexTest {
  ~ testFigure(): void
  ~ testGetImaginaryPart(): void
  ~ testNegate(): void
  ~ testAdd(): void
  ~ testDivide(): void
  ~ testEqualsObject(): void
- createComplex(double, double): IComplex
  ~ testConjugate(): void
  ~ testMultiplyDouble(): void
  ~ testAbs(): void
  ~ testHashCode(): void
  ~ testSubtract(): void
  ~ testGetRealPart(): void
  ~ testToString(): void
  ~ testMultiplyIComplex(): void
  }
  interface IFractalImage << interface >> {
+ getHeight(): int
+ getWidth(): int
+ getPixel(int, int): Pixel
+ saveAs(String): void
+ setColor(int, int, Color): void
  }
  interface IPlan << interface >> {
+ asComplex(int, int): IComplex
+ asPixel(IPointPlan, IFractalImage): Pixel
+ asPixel(IComplex, IFractalImage): Pixel
  }
  interface IPointPlan << interface >> {
+ getY(): double
+ pointPlanToComplex(IPointPlan): IComplex
+ distancePoint(IPointPlan): double
+ getX(): double
+ getComplex(): IComplex
  }
  class ImageBuilder {
+ setWidth(int): void
+ setIterationsMax(int): void
+ getResult(): IFractalImage
+ setScale(double): void
+ setSuite(String): void
+ setPathToFile(String): void
+ setFocusY(double): void
+ setFocusX(double): void
+ setHeight(int): void
+ setPalette(String): void
  }
  class MultiplyPlan {
+ asPixel(IComplex, IFractalImage): Pixel
+ asPixel(IPointPlan, IFractalImage): Pixel
+ asComplex(int, int): IComplex
  }
  class Pixel {
+ getImage(): IFractalImage
+ getRow(): int
+ setColor(Color): void
+ getColumn(): int
  }
  class Plan {
+ asPixel(IComplex, IFractalImage): Pixel
+ asComplex(int, int): IComplex
+ getWidth(): int
+ getHeight(): int
+ asPixel(IPointPlan, IFractalImage): Pixel
  }
  class SuiteChaotique {
+ iterator(): Iterator<IPointPlan>
+ getNext(IPointPlan): double
  }
  class SuiteChaotiqueIterator {
- distanceConvergente(): boolean
+ getPrecedent(): IPointPlan
+ getNbIterations(): int
+ hasNext(): boolean
+ getYPrecedent(): double
+ next(): IPointPlan
  }
  class SuiteCirculaire {
+ getNext(IPointPlan): double
+ iterator(): Iterator<IPointPlan>
  }
  class SuiteFeigenbaum {
+ iterator(): Iterator<IPointPlan>
+ getNext(IPointPlan): double
  }
  class SuiteIterator {
+ getNbIterations(): int
+ forEachRemaining(Consumer<IComplex>): void
+ hasNext(): boolean
+ next(): IComplex
+ remove(): void
  }
  interface SuitesChaotiqueStrategy << interface >> {
+ getNext(IPointPlan): double
  }
  interface SuitesStrategy << interface >> {
+ calculateNextTerm(IComplex): IComplex
  }
  class SumPlan {
+ asComplex(int, int): IComplex
+ asPixel(IComplex, IFractalImage): Pixel
+ asPixel(IPointPlan, IFractalImage): Pixel
  }

ImageBuilder              -[#000082,plain]-o EnsembleJulia
ImageBuilder              -[#000082,plain]-o EnsembleMandelbrot
ImageBuilder              -[#000082,plain]-o GeneralisationJulia
ImageBuilder              -[#000082,plain]-o GeneralisationMandelbrot
ImageBuilder              -[#000082,plain]-o SuiteCirculaire
ImageBuilder              -[#000082,plain]-o SuiteFeigenBaum
BufferedImageAdapter      -[#008200,dashed]-^  IFractalImage                              
Complex                   -[#008200,dashed]-^  IComplex                 
EnsembleJulia             -[#008200,dashed]-^  SuitesStrategy           
EnsembleMandelbrot        -[#008200,dashed]-^  SuitesStrategy                           
GeneralisationJulia       -[#008200,dashed]-^  SuitesStrategy           
GeneralisationMandelbrot  -[#008200,dashed]-^  SuitesStrategy           
IComplexAdapter           -[#008200,dashed]-^  IPointPlan                        
MultiplyPlan              -[#008200,dashed]-^  IPlan                               
SuiteChaotique            -[#008200,dashed]-^  SuitesChaotiqueStrategy  
SuiteCirculaire           -[#000082,plain]-^  SuiteChaotique           
SuiteCirculaire           -[#008200,dashed]-^  SuitesChaotiqueStrategy  
SuiteFeigenbaum           -[#000082,plain]-^  SuiteChaotique           
SuiteFeigenbaum           -[#008200,dashed]-^  SuitesChaotiqueStrategy  
SumPlan                   -[#008200,dashed]-^  IPlan                    
@enduml
```

```plantuml


@startuml

  class Circle {
+ repr(): String
+ getPos(): IComplex
  }
  class ColorDecorator {
+ getColor(): Color
+ masque(): Color
+ getPalette(int, int): Color
  }
  class FigureComposite {
+ repr(): String
+ getPos(): IComplex
+ add(IFigure): void
+ remove(IFigure): void
  }
  class FigureDecorator {
+ scale(String, int): String
+ translation(String, IComplex): String
+ Rotate(String, int): String
  }
  class FigureMethode {
+ header(PrintWriter): PrintWriter
+ methode(String, int): void
+ footer(PrintWriter): PrintWriter
+ figure(PrintWriter, int): PrintWriter
+ create(String): PrintWriter
+ flush(PrintWriter): PrintWriter
+ getHeight(): int
+ getWidth(): int
  }
  interface IColor << interface >> {
+ masque(): Color
+ getPalette(int, int): Color
  }
  interface IFigure << interface >> {
+ repr(): String
+ getPos(): IComplex
  }
  class Line {
+ repr(): String
+ getPos(): IComplex
+ getPosy(): IComplex
  }
  class MasqueBlueDecorator {
+ getPalette(int, int): Color
+ masque(): Color
  }
  class MasqueGreenDecorator {
+ getPalette(int, int): Color
+ masque(): Color
  }
  class MasqueRedDecorator {
+ getPalette(int, int): Color
+ masque(): Color
  }
  class PaletteGray {
+ masque(): Color
+ getPalette(int, int): Color
  }
  class PaletteGreen {
+ masque(): Color
+ getPalette(int, int): Color
  }
  class PaletteMagenta {
+ getPalette(int, int): Color
+ masque(): Color
  }
  class PaletteOrange {
+ getPalette(int, int): Color
+ masque(): Color
  }
  class Rectangle {
+ getPos(): IComplex
+ repr(): String
  }
  class Sierpinski {
+ loop(PrintWriter, Plan, Color, int): PrintWriter
+ figure(PrintWriter, int): PrintWriter
+ draw(PrintWriter, double, double, Color, IFigure, int, int, IComplex, double): void
  }
  class Triangle {
+ getPosy(): IComplex
+ getPosz(): IComplex
+ getPos(): IComplex
+ repr(): String
+ getPosx(): IComplex
  }

Circle                    -[#008200,dashed]-^  IFigure                  
ColorDecorator            -[#008200,dashed]-^  IColor                   
FigureComposite           -[#008200,dashed]-^  IFigure                                
Line                      -[#008200,dashed]-^  IFigure                  
MasqueBlueDecorator       -[#000082,plain]-^  ColorDecorator           
MasqueGreenDecorator      -[#000082,plain]-^  ColorDecorator           
MasqueRedDecorator        -[#000082,plain]-^  ColorDecorator                             
PaletteGray               -[#008200,dashed]-^  IColor                   
PaletteGreen              -[#008200,dashed]-^  IColor                   
PaletteMagenta            -[#008200,dashed]-^  IColor                   
PaletteOrange             -[#008200,dashed]-^  IColor                                     
Rectangle                 -[#008200,dashed]-^  IFigure                                    
Triangle                  -[#008200,dashed]-^  IFigure
@enduml
```