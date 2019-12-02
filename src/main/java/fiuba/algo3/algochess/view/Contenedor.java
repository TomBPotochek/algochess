package fiuba.algo3.algochess.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class Contenedor {
    protected Pane contenedor;

    public Contenedor() {
    	
    	this.contenedor = new GridPane();
    }
    public Pane dibujar() {
        return contenedor;
    }
}
