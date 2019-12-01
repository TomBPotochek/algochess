package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.CompraDeUnidadesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

    private String nombreUnidad;
    private AlgoChess algochess;
    private CompraDeUnidadesView vista;

    public ComprarUnidadEventHandler(AlgoChess algochess, CompraDeUnidadesView vista, String nombreUnidad) {
        this.algochess = algochess;
        this.nombreUnidad = nombreUnidad;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    	vista.pintarTablero();

    	vista.onCasillaClick(e -> {
    		Posicion posicion = (Posicion) ((Button) e.getSource()).getUserData();
    		
    		try {
    			algochess.comprar(this.nombreUnidad, posicion);

    		} catch (Exception ex) {
    			vista.mostrarError(ex.getMessage());
    		}
    	});
     }
}
