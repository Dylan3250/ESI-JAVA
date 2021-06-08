# Projet AsciiPaint en JAVA

### Fonctionnement :
L'utilisateur choisit une taille de toile dans laquelle il pourra dessiner des formes. Plusieurs formes sont disponibles telles que le rectangle, le carré ou encore le cercle. Il pourra donner des coordonnées où dessiner la forme ainsi que sa taille. Il est possible de l'afficher, de la supprimer, d'afficher une liste de forme, de changer le symbole qui différencie la forme, de la déplacer ou encore d'arrêter le jeu. Quelles que soient les actions, si une erreur est rentrée, l'utilisateur peut réessayer jusqu'à ce que son entrée soit conforme.

### Comment l'utiliser :
Il suffit d'aller dans le dossier AsciiPaint et de lancer la commande `java -jar AsciiPaint.jar` (JAR compilé avec JAVA 11). Il est possible de connaître toutes les commandes avec `help` une fois le JAR lancé.

### Contenu du projet :
```
asciipaint
├── AsciiPaint.jar
├── README.md
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── esi
    │           └── atl
    │               └── g54027
    │                   ├── Main.java
    │                   ├── controller
    │                   │   └── Application.java
    │                   ├── model
    │                   │   ├── AsciiPaint.java
    │                   │   ├── Circle.java
    │                   │   ├── ColoredShape.java
    │                   │   ├── Drawing.java
    │                   │   ├── Point.java
    │                   │   ├── Rectangle.java
    │                   │   ├── Shape.java
    │                   │   └── Square.java
    │                   └── view
    │                       └── View.java
    └── test
        └── java
            └── esi
                └── atl
                    └── g54027
                        └── model
                            ├── AsciiPaintTest.java
                            ├── CircleTest.java
                            ├── DrawingTest.java
                            ├── PointTest.java
                            └── RectangleTest.java
```
### Image du jeu :
![AsciiPaint](https://nsa40.casimages.com/img/2020/10/05/201005023731177436.png)
