package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.Controller;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class ContenedorTablero extends Contenedor {

    private GridPane contenedor;
    private Tablero tablero;

    public ContenedorTablero(Tablero tablero) {

    	this.tablero = tablero;
    	this.contenedor = new GridPane();

        contenedor.setMaxWidth(600);
        contenedor.setMaxHeight(600);

        this.actualizar();
    }

    public void actualizar() {
        Posicion posicion;
        for(int i = 1; i <= TAMANIO_TABLERO; i++) {
            for(int j = 1; j <= TAMANIO_TABLERO; j++) {
                posicion = new Posicion(i,j);
                CasillaView casilla = new CasillaView(tablero.obtenerCasilla(posicion), posicion);
           //     ((GridPane)contenedor).add(casilla.construir(this.controller) , i, j);
            }
        }
    }

}
