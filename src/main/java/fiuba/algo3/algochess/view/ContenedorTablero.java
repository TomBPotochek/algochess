package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class ContenedorTablero {

    private GridPane contenedor;
    private Main app;
    private Tablero tablero;

    public ContenedorTablero(Main app, Tablero tablero) {

        this.app = app;
        this.contenedor = new GridPane();
        this.tablero = tablero;
        Posicion posicion;

        contenedor.setMaxWidth(600);
        contenedor.setMaxHeight(600);

        this.actualizar();
    }

    public GridPane construir() {
        return contenedor;
    }

    public void actualizar() {
        Posicion posicion;
        for(int i = 1; i <= TAMANIO_TABLERO; i++) {
            for(int j = 1; j <= TAMANIO_TABLERO; j++) {
                posicion = new Posicion(i,j);
                CasillaView casilla = new CasillaView(tablero.obtenerCasilla(posicion), posicion);
                contenedor.add(casilla.construir(app) , i, j);
            }
        }
    }
}
