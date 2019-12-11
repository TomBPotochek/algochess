package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.excepciones.ModelException;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.BatallaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoverUnidadEventHandler implements EventHandler<ActionEvent> {

    private Direccion direccion;
    private BatallaView vista;
    private TurnoActual turnoActual;
	private Posicion posicionUnidad;

    public MoverUnidadEventHandler(TurnoActual turnoActual, BatallaView vista, Direccion direccion, Posicion posicionUnidad) {
        this.turnoActual = turnoActual;
        this.vista = vista;
        this.direccion = direccion;
        this.posicionUnidad = posicionUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        vista.pintarTablero();


        try {
        	vista.onUnidadClick(new UnidadClickEventHandler(vista, turnoActual, null));
            turnoActual.mover(this.posicionUnidad, this.direccion);
            vista.deshabilitarControles();
        } catch (ModelException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}
