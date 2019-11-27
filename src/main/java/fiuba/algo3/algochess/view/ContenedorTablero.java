package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class ContenedorTablero {

    GridPane contenedor;

    public ContenedorTablero(Tablero tablero) {

        contenedor = new GridPane();

        for(int i = 1; i <= TAMANIO_TABLERO; i++) {
            for(int j = 1; j <= TAMANIO_TABLERO; j++) {
                CasillaView casilla = new CasillaView(tablero.obtenerCasilla(new Posicion(i,j)));
                contenedor.add(casilla.construir() , i, j);
            }
        }
    }

    public GridPane construir() {
        return contenedor;
    }
}
