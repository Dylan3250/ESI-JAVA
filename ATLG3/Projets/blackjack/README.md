# Projet Blackjack en JAVA
### Fonctionnement :
Le joueur décide combien d'argent il veut miser lors de la manche. Si ce dernier n'a plus d'argent, la partie s'arrête. Après avoir fait ce choix, deux cartes sont tirées au hasard dans un paquet de cartes. Si leur somme est inférieur à 21, il est possible de tirer une nouvelle carte. Le but est de s'approcher le plus de 21. Dès que le joueur se sent assez proche, l'ordinateur joue à son tour (pioche jusqu'à ce que la somme des cartes soit au moins à 17). Si l'ordinateur n'a pas dépassé 21 et qu'il est plus proche que le joueur, ce dernier perd sa mise. Dans le cas contraire, il la récupère et gagne le même montant de l'ordinateur. Lors d'une égalité, aucune perte de mise n’est prise en compte. Il est possible d'enchaîner les parties tant que le joueur a de l'argent : les cartes sont rassemblées et mélangées.

### Comment jouer :
Il suffit d'aller dans le dossier Blackjack et de lancer la commande ```java -jar Blackjack.jar``` (JAR compilé avec JAVA 11)

### Contenu du projet :
```
blackjack
├── Blackjack.jar
├── README.md
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── esi
    │           └── atl
    │               └── g54027
    │                   ├── blackjack
    │                   │   ├── Main.java
    │                   │   ├── controller
    │                   │   │   └── Controller.java
    │                   │   ├── model
    │                   │   │   ├── Bank.java
    │                   │   │   ├── Game.java
    │                   │   │   ├── Interactor.java
    │                   │   │   ├── Model.java
    │                   │   │   ├── Player.java
    │                   │   │   └── Status.java
    │                   │   └── view
    │                   │       ├── InterfaceView.java
    │                   │       └── View.java
    │                   ├── cards
    │                   │   ├── Card.java
    │                   │   ├── Color.java
    │                   │   ├── Deck.java
    │                   │   └── Value.java
    │                   └── utils
    │                       └── Colors.java
    └── test
        └── java
            └── esi
                └── atl
                    └── g54027
                        ├── blackjack
                        │   └── model
                        │       ├── BankTest.java
                        │       ├── GameTest.java
                        │       ├── InteractorTest.java
                        │       └── PlayerTest.java
                        └── cards
                            ├── CardTest.java
                            └── DeckTest.java
```
### Image du jeu :
![BlackJack](https://nsa40.casimages.com/img/2020/09/25/20092503232515288.jpg)
