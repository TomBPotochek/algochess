package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.CasillaView;
import fiuba.algo3.algochess.view.ContenedorComprarUnidades;
import fiuba.algo3.algochess.view.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class CasilleroEventHandler implements EventHandler<ActionEvent> {

    Main app;
    Posicion posicion;

    public CasilleroEventHandler(Main app, Posicion posicion) {
        this.app = app;
        this.posicion = posicion;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        app.setPosicionSeleccionada(posicion);
        ((Button) actionEvent.getSource()).setStyle("-fx-background-color: #4AB43F");
    }
}
