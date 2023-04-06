# Rapport SAE3.01
## Développement d'une application
### Membres du groupe :
- Jonathan Isambourg
- Axel Poteau
- Amaury Bonsigne  

### Explication des patrons de conception  
- **Question 5 et 6** : On a utilisé un Décorateur afin d'affecter dynamiquement le plan.
- **Question 7** : Une stratégie a été utilisée pour pouvoir représenter
les différentes suites qui avaient la même base.
- **Question 8** : Nous avons choisi d'utiliser un itérateur afin
  d'accéder à tous les éléments de la suite.
- **Question 13** : Afin de représenter les différentes palettes de couleurs, nous utilisons une stratégie, car chaque palette posséde les mêmes méthodes que les autres.
- **Question 14** : Pour mieux représenter les "masques" de couleurs, nous avons créé un 
décorateur.
- **Question 15** : Afin de représenter un complexe en point du plan, nous avons opté
pour un adaptateur qui adaptera un complexe en Point du plan.
- **Question 24** : Nous avons aussi opté pour un adaptateur pour créer une IFractalImage
à l'aide de BufferedImage.
- **Question 26** : Pour créer un objet avec un grand nombre de paramètres comme pour la 
génération d'images, nous avons utilisé un builder afin de faciliter la création.
- **Question 29** : Un Décorateur a été mis en place afin de faciliter la transformation
d'une figure géométrique existante en changeant ses paramètres.
- **Question 30** : Après concertation, nous avons décidé d'utiliser un composite pour réaliser des
figures composées d'autres figures, car ce dernier permet d’agencer les objets dans des arborescences afin de 
pouvoir traiter celles-ci comme des objets individuels
- **Question 31** : Nous avons choisi un patron méthode pour cette question, car
cela permet de mettre le squelette d’un algorithme dans la classe mère, 
mais laisse les sous-classes redéfinir certaines étapes de l’algorithme sans changer sa structure.

### Répartition des tâches :

- ***Jonathan*** :
  - Suites Complexes et leurs implémentations
  - Généralisations de Julia et Mandelbrot
  - Générations des images (Builder)
  - Script de lancement en Bash
  - Fix des palettes de couleurs ainsi que des suites chaotiques
- ***Axel*** :
  - Nombres complexes et leur implémentation
  - Représentation des figures géométriques
  - Tapis de Sierpinski
  - Générations des images (svg)
- ***Amaury***
  - Suites Chaotiques
  - Diagramme de bifurcation
  - Création d'images
  - Choix Couleur
  - Documentation

### A savoir :

Vous pouvez retrouver des images de fractales dans le dossier ./imagesDemandees.
Elles ont été générées avec les paramètres selon nous "optimaux" pour améliorer le rendu.

Le diagramme de classe se trouve dans le fichier README.md à la racine du projet.

Pour utiliser les scripts, vous devez d'abord lancer la tâche jar de Gradle.
Ensuite, vous pourrez lancer les scripts depuis le répertoire scripts.
Tous les scripts (hormis pour le tapis de Sierpinski) prennent 3 paramètres : le focus en X, le focus en Y et le nom de la palette de couleur que vous souhaitez utiliser.

Les palettes disponibles sont :
- Gris 'gray'
- Magenta 'magenta'
- Vert 'green'
- Orange 'orange'

Voici un exemple d'utilisation :
<code> bash ./julia.sh -x 0 -y 0 -p 'green'</code>

Pour le tapis de Sierpinski, le script prend la hauteur de l'image souhaitée, la largeur, ainsi que le nombre d'itérations (doit être < 6 pour ne pas générer d'images trop lourdes)

Voici un exemple d'utilisation :
<code> bash ./tapis.sh -h 1000 -w 1000 -n 4 </code>
