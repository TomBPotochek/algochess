package fiuba.algo3.algochess.view;


import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class ContenedorTablero extends Contenedor {

    private Tablero tablero;
    private List<CasillaView> casillaViews;
    private TurnoActual turnoActual;

    public ContenedorTablero(Tablero tablero, TurnoActual turnoActual) {

    	super();
    	this.tablero = tablero;
    	this.turnoActual = turnoActual;
    	this.casillaViews = new ArrayList<CasillaView>();

        contenedor.setMaxWidth(600);
        contenedor.setMaxHeight(600);

        // TODO: observar a tablero
        this.actualizar();
    }

    public void actualizar() {
        Posicion posicion;
        for(int i = 1; i <= TAMANIO_TABLERO; i++) {
            for(int j = 1; j <= TAMANIO_TABLERO; j++) {
                posicion = new Posicion(i,j);
                CasillaView casilla = new CasillaView(this.turnoActual, tablero.obtenerCasilla(posicion), posicion);
                casillaViews.add(casilla);
                ((GridPane)contenedor).add(casilla.construir() , i, j);
            }
        }
    }

	public void onCasillaClick(EventHandler<ActionEvent> e) {
		for (CasillaView casillaView : casillaViews) {
			casillaView.onClick(e);
		}
	}

}
