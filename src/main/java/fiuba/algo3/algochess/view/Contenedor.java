package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.scene.layout.Pane;

public abstract class Contenedor {
    protected Pane contenedor;

    public Pane dibujar() {
        return contenedor;
    }

    public abstract void actualizar(AlgoChess algoChess);
}
