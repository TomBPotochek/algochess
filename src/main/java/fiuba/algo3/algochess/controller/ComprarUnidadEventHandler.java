package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.view.ContenedorComprarUnidades;
import fiuba.algo3.algochess.view.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarUnidadEventHandler  implements EventHandler<ActionEvent> {

    private Main app;
    private String nombreUnidad;

    public ComprarUnidadEventHandler(Main app, String nombreUnidad) {
        this.app = app;
        this.nombreUnidad = nombreUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            app.algoChess.comprar(nombreUnidad, app.getPosicionSeleccionada());
            app.contenedorComprarUnidades.agregarAdvertencia(null);
        } catch (CasillaEnemigaException e) {
            app.contenedorComprarUnidades.agregarAdvertencia("No se puede colocar unidades en terreno enemigo");
        } catch (CasillaOcupadaException e) {
            app.contenedorComprarUnidades.agregarAdvertencia("No se puede colocar una unidad en una casilla ocupada");
        } catch (PuntosInsuficientesException e){
            app.contenedorComprarUnidades.agregarAdvertencia("No podes comprar mas unidades, te quedaste sin puntos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        app.actualizar();
    }
}
