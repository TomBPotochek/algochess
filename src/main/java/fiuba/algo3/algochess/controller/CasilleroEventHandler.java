package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.CasillaView;
import fiuba.algo3.algochess.view.ContenedorComprarUnidades;
import fiuba.algo3.algochess.view.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CasilleroEventHandler implements EventHandler<ActionEvent> {

    Main app;
    Posicion posicion;

    public CasilleroEventHandler(Main app, Posicion posicion) {
        this.app = app;
        this.posicion = posicion;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            app.algoChess.comprar(app.contenedorComprarUnidades.obtenerNombreUnidadSeleccionada(), posicion);
            app.contenedorComprarUnidades.agregarAdvertencia(null);
        } catch (CasillaEnemigaException e) {
            app.contenedorComprarUnidades.agregarAdvertencia("No se puede colocar unidades en terreno enemigo");
        } catch (CasillaOcupadaException e) {
            app.contenedorComprarUnidades.agregarAdvertencia("No se puede colocar una unidad en una casilla ocupada");
        } catch (Exception e) {
            e.printStackTrace();
        }
        app.actualizar();
    }
}
