package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.view.ContenedorComprarUnidades;
import fiuba.algo3.algochess.view.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarUnidadEventHandler implements EventHandler<ActionEvent> {

    private Controller controller;
    private String nombreUnidad;
    private AlgoChess algochess;

    public ComprarUnidadEventHandler(AlgoChess algochess, String nombreUnidad) {
        this.algochess = algochess;
        this.nombreUnidad = nombreUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            algochess.comprar(nombreUnidad, controller.getPosicionSeleccionada());
            controller.agregarAdvertencia(null);
        } catch (CasillaEnemigaException e) {
            controller.agregarAdvertencia("No se puede colocar unidades en terreno enemigo");
        } catch (CasillaOcupadaException e) {
            controller.agregarAdvertencia("No se puede colocar una unidad en una casilla ocupada");
        } catch (PuntosInsuficientesException e){
            controller.agregarAdvertencia("No podes comprar mas unidades, te quedaste sin puntos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller.actualizar();
    }
}
