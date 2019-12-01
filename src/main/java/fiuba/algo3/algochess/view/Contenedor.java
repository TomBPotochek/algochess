package fiuba.algo3.algochess.view;

import javafx.scene.layout.Pane;

public abstract class Contenedor {
    protected Pane contenedor;

    public Pane dibujar() {
        return contenedor;
    }
}
