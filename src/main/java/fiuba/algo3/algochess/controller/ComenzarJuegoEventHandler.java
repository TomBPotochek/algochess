package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.view.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private Main app;

    public ComenzarJuegoEventHandler(Main app) {
        this.app = app;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        app.comenzarJuegoPrincipal();
    }
}
