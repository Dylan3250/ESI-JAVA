# Projet 2048 en JAVA

### Fonctionnement :
Un tableau de case est affiché dans lequel aléatoirement se positionne un 2 ou un 4. Il est possible de déplacer toutes les cases déjà présentes vers le haut, la droite, le bas ou la gauche. Après un déplacement, les cases avec les mêmes valeurs fusionnent. Le jeu est terminé/perdu quand plus aucune case adjacente n'a la même valeur. Le but du jeu est d'atteindre une case avec affiché 2048. 

### Comment l'utiliser :
Il suffit d'aller dans le dossier game2048/target et de lancer la commande `java -jar game2048.jar` après l'avoir compilé en Java. Deux versions sont disponibles, une avec l'aspect console et la seconde avec une interface graphique créée avec JavaFX.

### Contenu du projet :
```
game2048
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── esi
    │   │       └── atl
    │   │           └── g54027
    │   │               └── game2048
    │   │                   ├── Main.java
    │   │                   ├── MainFX.java
    │   │                   ├── controller
    │   │                   │   ├── Controller.java
    │   │                   │   └── ControllerFX.java
    │   │                   ├── model
    │   │                   │   ├── Board.java
    │   │                   │   ├── Direction.java
    │   │                   │   ├── Game.java
    │   │                   │   ├── GameStatus.java
    │   │                   │   ├── Model.java
    │   │                   │   └── Square.java
    │   │                   └── view
    │   │                       ├── View.java
    │   │                       ├── ViewFX.java
    │   │                       └── components
    │   │                           ├── ActionsList.java
    │   │                           └── Board.java
    │   └── resources
    │       ├── again.png
    │       ├── icon.png
    │       ├── info.png
    │       └── styles.css
    └── test
        └── java
            └── esi
                └── atl
                    └── g54027
                        └── game2048
                            └── model
                                └── ModelTest.java
```
###  Image du jeu console ###
![Game2048Console](https://www.zupimages.net/up/20/44/3j04.png)

### Image du jeu GUI ###
![Game2048GUI](https://nsa40.casimages.com/img/2020/12/12/201212032648570274.png)