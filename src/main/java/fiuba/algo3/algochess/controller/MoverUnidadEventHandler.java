package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.BatallaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private Direccion direccion;
    private BatallaView vista;
    private TurnoActual turnoActual;

    public MoverUnidadEventHandler(TurnoActual turnoActual, BatallaView vista, Direccion direccion) {
        this.turnoActual = turnoActual;
        this.vista = vista;
        this.direccion = direccion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        vista.pintarTablero();

        vista.onCasillaClick(e -> {

            Posicion posicion = (Posicion) ((Node) e.getSource()).getUserData();

            try {
                turnoActual.mover(posicion, this.direccion);

            } catch (Exception ex) {
                vista.mostrarError(ex.getMessage());
            }
        });
    }
}
