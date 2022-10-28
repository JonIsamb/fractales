# Rapport SAE3.01
## Développement d'une application
### Membre du groupe :
- Jonathan Isambourg
- Axel Poteau
- Amaury Bonsigne  

### Explication des patrons de conception  
- **Question 5 et 6** : On a utlisé un Décorateur afin d'affecter dynamiquement le plan
- **Question 7** : Une stratégie a était utilisé pour pouvoir representer
les différentes suites qui avaient la même base.
- **Question 8** : Nous avons choisi d'utiliser un itérateur afin
  d'accéder a tout les élèments de la suite.
- **Question 13** : Afin de representer les différentes palettes de couleurs.
, nous utilisons une stratégie car chaque palette possédes les mêmes méthodes que les autres
- **Question 14** : Pour mieux representer les "masques" de couleurs, nous avons crée un 
décorateur.
- **Question 15** : Afin de representer un Complexe en point du plan, nous avons opté
pour un adaptateur qui adaptera un Complexe en Point du plan.
- **Question 24** : Nous avons aussi opté pour un adaptateur pour crée une IFractalImage
à l'aide de BufferedImage.
- **Question 26** : Pour créer un objet avec un grand nombre de paramètre comme pour la 
génération d'images, nous avons utilisé un builder afin de faciliter la création.
- **Question 29** : Un Décorateur a était mis en place afin de faciliter la transformation
d'une figure géometrique existante juste en changeant ses paramètres.
- **Question 30** : Après concertation, nous avons décidé d'utiliser un composite pour réaliser des *
figures composés d'autres figures car ce dernier permet d’agencer les objets dans des arborescences afin de 
pouvoir traiter celles-ci comme des objets individuels
- **Question 31** : Nous avons choisi un patron méthode pour cette question car
elle permet de mettre le squelette d’un algorithme dans la classe mère, 
mais laisse les sous-classes redéfinir certaines étapes de l’algorithme sans changer sa structure.

### Repartition des tâches :

- ***Jonathan*** :
  - Suites Complexes et leur implémentation
  - Julia , Mandelbrot et leurs Généralisations
  - Générations des images 
  - Script lançement en Bash
- ***Axel*** :
  - Nombres Complexes et leur implémentation
  - Répresentation des figures
  - Représentation de quelques fractales
  - Tapis de Sierpinski
  - Générations images
- ***Amaury***
  - Suites Chaotiques
  - Diagramme de bifurcation
  - Création d'images
  - Choix Couleur
  - Documentation