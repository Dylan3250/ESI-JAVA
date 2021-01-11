package esi.atl.g54027.td06;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class GraphDisplayHandler
        implements EventHandler<MouseEvent> {

    private final String text;

    public GraphDisplayHandler(String component) {
        this.text = component;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(text);
    }
}
