package esi.atl.g54027.mvc;

import esi.atl.g54027.mvc.controller.Controller;
import esi.atl.g54027.mvc.model.Model;
import esi.atl.g54027.mvc.view.View;
import esi.atl.g54027.mvc.view.ViewBinary;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author jlc
 */
public class Main extends Application {
    /**
     * Entry points to the <code> Lotto </code> application..
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Main() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("DEBUG | MAIN       | Début du programme");
        
        Model model = new Model();
        View view = new View(stage);
        ViewBinary viewBinary = new ViewBinary(stage);
        // Passer le même stage ou en faire un nouveau ?

        Controller controller = new Controller(model, view, viewBinary);
        System.out.println("");
        
        controller.addObserver();
        view.addHandlerButton(controller);
        System.out.println("");
        
        controller.initialize();
        System.out.println("");
    }

}
