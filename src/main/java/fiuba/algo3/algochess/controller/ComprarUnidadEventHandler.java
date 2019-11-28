package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.view.ContenedorComprarUnidades;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarUnidadEventHandler  implements EventHandler<ActionEvent> {

    private ContenedorComprarUnidades contenedorComprarUnidades;
    private String nombreUnidad;

    public ComprarUnidadEventHandler(ContenedorComprarUnidades contenedorComprarUnidades, String nombreUnidad) {
        this.contenedorComprarUnidades = contenedorComprarUnidades;
        this.nombreUnidad = nombreUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorComprarUnidades.setNombreUnidadSeleccionada(nombreUnidad);
    }
}
