package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.view.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FlechaEventHandler implements EventHandler<ActionEvent> {

    Direccion direccion;
    Main app;

    public FlechaEventHandler(Main app, Direccion direccion) {
        this.app = app;
        this.direccion = direccion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
//        app.algoChess.atacar();
    }
}
