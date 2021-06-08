package esi.atl.g54027.mvp;

import esi.atl.g54027.mvp.model.Model;
import esi.atl.g54027.mvp.presenter.Presenter;
import esi.atl.g54027.mvp.view.View;
import esi.atl.g54027.mvp.view.ViewBinary;
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

        Presenter presenter = new Presenter(model, view, viewBinary);
        System.out.println("");

        System.out.println("DEBUG | MAIN       | Ajoute le lien observateur-observé entre le presenter et le modèle");
        model.addObserver(presenter);
        view.addHandlerButton(presenter);
        System.out.println("");

        presenter.initialize();
        System.out.println("");
    }

}
