# Projet BMR en JAVA
### Fonctionnement :
Il est possible de connaître les besoins énergétiques indispensables à l’organisme d'une personne en remplissant certaines informations (poids, âge et taille) = BMR. De plus, en multipliant le BMR par un facteur défini en fonction de l'activité de la vie on peut connaître les besoins caloriques quotidiens d'une personne.
De manière plus visuelle, 3 graphiques sont générés avec la possibilité de voir différents BMR, taille et poids indiqués.
### Comment lancer le programme :
##### JAVA 8 et moins :
Il suffit d'aller dans ce dossier, de le compiler avec Java8 et de faire "```java -jar BMR-Java8.jar```" qui lancera le programme compilé en Java 8.
Si vous avez plusieurs versions de Java, il faudra chercher "java.exe" dans les dossiers. Par exemple : "```"C:\Program Files\Java\jre1.8.0_261\bin\java.exe"```"
##### Après JAVA 8 :
Les versions plus récentes (à savoir que le BMR.jar est compilé avec JAVA 11) ne contiennent pas JavaFX, il faudra télécharger JavaFX SDK (https://gluonhq.com/products/javafx/) et lancer la commande : 
```java
java --module-path "chemin-vers-dossier-lib-du-sdk" --add-modules=javafx.controls -jar BMR.jar
```
Exemple chez moi (Windows 10):
```java
java --module-path "java --module-path "C:\Program Files\Java\jdk-11.0.8\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls -jar BMR.jar
```
Après avoir compilé le programme en Java 11+.
### Contenu du projet :
```
bmr
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── esi
    │   │       └── atl
    │   │           └── g54027
    │   │               └── bmr
    │   │                   ├── Main.java
    │   │                   ├── controller
    │   │                   │   └── Controller.java
    │   │                   ├── model
    │   │                   │   ├── LifeStyle.java
    │   │                   │   ├── Model.java
    │   │                   │   └── Person.java
    │   │                   └── view
    │   │                       ├── View.java
    │   │                       └── components
    │   │                           ├── DataSide.java
    │   │                           ├── LCHeightBMR.java
    │   │                           ├── LCWeightBMR.java
    │   │                           ├── LCWeightCalories.java
    │   │                           └── ResultsSide.java
    │   └── resources
    │       ├── icon.png
    │       └── styles.css
    └── test
        └── java
            └── esi
                └── atl
                    └── g54027
                        └── bmr
                            └── model
                                └── ModelTest.java
```
### Image du programme :
![BMR](https://zupimages.net/up/20/44/7qgw.png)
