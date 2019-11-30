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

    Controller controller;
    Posicion posicion;

    public CasilleroEventHandler(Controller controller, Posicion posicion) {
        this.controller = controller;
        this.posicion = posicion;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        controller.setPosicionSeleccionada(posicion);
        controller.actualizar();
    }
}
