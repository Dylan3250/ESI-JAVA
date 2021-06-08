package esi.atl.g54027.view;

import esi.atl.g54027.model.Drawing;
import esi.atl.g54027.model.Point;
import esi.atl.g54027.model.Shape;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * All methods the displays or asks something at user.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class View {

    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Displays shapes made in the drawing.
     *
     * @param drawing the given drawing
     */
    public void displayAscii(Drawing drawing) {
        StringBuilder result = new StringBuilder("|");
        result.append("-".repeat(drawing.getWidth()));
        result.append("|\n");
        for (int ln = 0; ln < drawing.getHeight(); ln++) {
            result.append("|");
            for (int col = 0; col < drawing.getWidth(); col++) {
                Shape gettedShape = drawing.getShapeAt(new Point(col, ln));
                result.append(gettedShape != null ? gettedShape.getColor() : " ");
            }
            result.append("|\n");
        }
        result.append("|");
        result.append("-".repeat(drawing.getWidth()));
        result.append("|");
        System.out.println(result);
    }

    /**
     * Asks the size of the drawing at user in this format : n(x|X)n where n are
     * positives numbers between 1 and 2000.
     *
     * @return array where the first value is the width and the second value is
     * the height of choosen drawing
     */
    public int[] askDrawing() {
        String maxSize
                = "([1-9]|[1-8]\\d|9\\d|[1-8]\\d{2}|9[0-8]\\d|99\\d|1\\d{3}|2000)";
        keyboard.useDelimiter("\n");

        System.out.println("Veuillez entrer la taille de votre toile (LxH)."
                + " Les dimensions doivent être des entiers entre 1 et 2000. "
                + "Par exemple : 100x200 (largeur : 100 | hauteur : 200) : ");

        while (!keyboard.hasNext(maxSize + "(?i)x" + maxSize)) {
            System.err.println("Les dimensions doivent être des entiers entre 1 et 2000. "
                    + "Par exemple : 100x200 (largeur : 100 | hauteur : 200) : ");
            keyboard.next();
        }
        return Arrays.stream(keyboard.next().split("(?i)x"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * Asks what the player wants to do (makes shapes, show, stop the game, ...)
     *
     * @return array of string with each informations (command, size, color,
     * height, size, coordinates, ...)
     */
    public String[] askTask() {
        // used for get positive number between 0 and 2000
        String positiveNb = "(\\d|[1-9]|[1-8]\\d|9\\d|[1-8]\\d{2}|9[0-8]\\d"
                + "|99\\d|1\\d{3}|2000)";
        // used for get positive number can be float)
        String floatNumber = "(\\d*[1-9]\\d*(\\.\\d+)?|[0]+\\.\\d*[1-9]\\d*)";
        // used for get positive and negative number can be float
        String negPosFloat = "[-+]?" + floatNumber;
        // used for get any symbol
        String anySymbol = "['!@#$%*\\]\\[()=_+{}:\\\";?,.\\/A-Za-z0-9\\s-]";
        // used for command where ask coordinates and size/side/width 
        String multiParams = positiveNb + " " + positiveNb + " " + floatNumber;
        // used to check if given string is a correct possibility
        String pattern = "(?i)((add (circle|square) " + multiParams + " "
                + anySymbol + ")"
                + "|(add rectangle " + multiParams + " " + floatNumber + " "
                + anySymbol + ")"
                + "|(change " + positiveNb + " " + anySymbol + ")"
                + "|(move " + positiveNb + " " + negPosFloat + " "
                + negPosFloat + ")"
                + "|(delete " + positiveNb + ")"
                + "|(show)"
                + "|(list)"
                + "|(help)"
                + "|(stop))";

        keyboard.useDelimiter("\n");
        System.out.println("Veuillez choisir une tâche à effectuer (\"help\" "
                + "pour plus d'informations) :");

        while (!keyboard.hasNext(pattern)) {
            System.err.println("Votre commande (" + keyboard.next() + ") ne "
                    + "correspond pas à ce qui est demandé, merci de réessayer "
                    + "(\"help\" pour plus d'informations).");
        }

        /*0 : the task (add|show|list|stop|delete|move)
        * 1 : the shape (circle|rectangle|square) or the id
        * 2 : the (delta) x coordinate (positive number between 0 and 2000)
        * 3 : the (delta) y coordinate (positive number between 0 and 2000)
        * 4 : if (square|circle) the (side|rayon) (positive number can be float)
        *     otherwise the width of rectangle
        * 5: if (square|circle) the color (any symbol, but only one)
        *     otherwise the height of rectangle
        * 6: if rectangle the color (any symbol, but only one) */
        return keyboard.next().split(" ");
    }

    public void displayList(List<Shape> shapes) {
        int sizeShape = shapes.size();
        if (sizeShape > 0) {
            for (int i = 0; i < sizeShape; i++) {
                Shape shape = shapes.get(i);
                System.out.println("N°" + i + " : " + shape.getName() + " en ("
                        + shape.getPoint().getX() + ", " + shape.getPoint().getY()
                        + ") dessiné avec le symbol \"" + shape.getColor() + "\"");
            }
        } else {
            System.err.println("Il n'y a pas encore de forme dessinée.");
        }
    }

    public void displayHelp() {
        System.out.println("Toutes les coordonnées doivent être des nombres "
                + "entier, ne doivent pas dépasser 2000, le reste peut être à "
                + "virgules et la couleur doit être un caractère.\n");

        // start of possible command
        System.out.println("- add circle <x> <y> <rayon> <couleur>\n\t => "
                + "Crée un cercle à la position <x>,<y> de rayon <rayon> "
                + "avec le caractère <couleur>.");
        System.out.println("- add rectangle <x> <y> <largeur> <hauteur> "
                + "<couleur>\n\t => Crée un rectangle à la position <x>,<y> "
                + "de taille <largeur>x<hauteur> avec le caractère <couleur>.");
        System.out.println("- add square <x> <y> <côté> <couleur>\n\t => Crée un "
                + "carré à la position <x>,<y> de taille <coté> avec le "
                + "caractère <couleur>.");
        System.out.println("- change <id> <nouvelle couleur>\n\t => Défini une "
                + "nouvelle couleur (symbole). L'<id> de la forme est "
                + "trouvé grâce à la commande \"list\"");
        System.out.println("- move <id> <dela x> <delta y>\n\t => Déplace la "
                + "forme de <delta x> et <delta y>. L'<id> de la forme est "
                + "trouvé grâce à la commande \"list\"");
        System.out.println("- delete <id>\n\t => Supprime la forme indiquée. "
                + "L'<id> de la forme est trouvé grâce à la commande \"list\"");
        System.out.println("- show\n\t => Affiche la toile.");
        System.out.println("- list\n\t => Affiche la liste des formes dessinées.");
        System.out.println("- stop\n\t => Arrête le dessin et l'affiche.\n");
    }

    /**
     * Dispalys the success message when action is completed.
     *
     * @param tasks the given array with the command send (show, add rectangle,
     * coordinates, size, ...).
     * @throws IllegalArgumentException the given task is unknowned
     */
    public void displaySuccess(String[] tasks) {
        if (tasks[0].equalsIgnoreCase("add")) {
            System.out.println("Le " + tasks[1] + " a correctement été ajouté en "
                    + "(" + tasks[2] + ", " + tasks[3] + ") !");
        } else if (tasks[0].equalsIgnoreCase("move")) {
            System.out.println("La forme n°" + tasks[1] + " a correctement été "
                    + "déplacée !");
        } else if (tasks[0].equalsIgnoreCase("delete")) {
            System.out.println("La forme n°" + tasks[1] + " a correctement été "
                    + "supprimée !");
        } else if (tasks[0].equalsIgnoreCase("change")) {
            System.out.println("La couleur (symbole) de la forme n°" + tasks[1]
                    + " a correctement été changée !");
        } else {
            throw new IllegalArgumentException("Given task is unknowned : "
                    + tasks[0]);
        }
    }

    /**
     * Displays the erreur when there are a problem somewhere in user's choose.
     *
     * @param msg the given catch message
     */
    public void displayError(String msg) {
        System.err.println("Une erreur est survenue (" + msg + "), "
                + "veuillez réessayer (\"help\" pour plus d'informations) !");
    }
}
