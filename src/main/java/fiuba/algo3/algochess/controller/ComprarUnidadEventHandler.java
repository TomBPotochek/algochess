package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.CompraDeUnidadesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;


public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

    private String nombreUnidad;
    private TurnoActual turnoActual;
    private CompraDeUnidadesView vista;

    public ComprarUnidadEventHandler(TurnoActual turnoActual, CompraDeUnidadesView vista, String nombreUnidad) {
        this.turnoActual = turnoActual;
        this.nombreUnidad = nombreUnidad;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    	vista.pintarTablero();

    	vista.onCasillaClick(e -> {
    		Posicion posicion = (Posicion) ((Node) e.getSource()).getUserData();

    		try {
    			turnoActual.comprar(this.nombreUnidad, posicion);

    		} catch (Exception ex) {
    			vista.mostrarError(ex.getMessage());
    		}
    	});
     }
}
