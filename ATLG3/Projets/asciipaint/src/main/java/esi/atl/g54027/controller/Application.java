package esi.atl.g54027.controller;

import esi.atl.g54027.model.AsciiPaint;
import esi.atl.g54027.view.View;

/**
 * The controller class between View and AsciiPaint can makes shapes and print
 * the view of the user.
 *
 * @author Dylan Bricar (54027) <54027@etu.he2b.be>
 */
public class Application {

    private AsciiPaint paint;
    private final View view;

    /**
     * Constructor to initialise the view of the application
     */
    public Application() {
        view = new View();
    }

    /**
     * Starts the application and asks to player what he wants to do (makes
     * shapes, show shapes, stop the application, etc).
     */
    public void start() {
        int[] size = view.askDrawing();
        paint = new AsciiPaint(size[0], size[1]);
        String[] tasks = view.askTask();
        while (!tasks[0].equalsIgnoreCase("stop")) {
            if (tasks[0].equalsIgnoreCase("list")) {
                view.displayList(paint.getShapes());
            } else if (tasks[0].equalsIgnoreCase("help")) {
                view.displayHelp();
            } else if (tasks[0].equalsIgnoreCase("show")) {
                view.displayAscii(paint.getDrawing());
            } else {
                chooseTasks(tasks);
            }
            tasks = view.askTask();
        }
        view.displayAscii(paint.getDrawing());
    }

    /**
     * Calls tasks asked like move, delete or change the color of shape.
     *
     * @param tasks the array of information given by user to delete the shape
     */
    private void chooseTasks(String[] tasks) {
        try {
            if (tasks[0].equalsIgnoreCase("move")) {
                paint.moveShape(tasks);
            } else if (tasks[0].equalsIgnoreCase("delete")) {
                paint.deleteShape(tasks);
            } else if (tasks[0].equalsIgnoreCase("change")) {
                paint.changeColorShape(tasks);
            } else if (tasks[0].equalsIgnoreCase("add")) {
                paint.makeShape(tasks);
            }
            view.displaySuccess(tasks);
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
}
