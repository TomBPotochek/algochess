package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.*;

public class Controller {

    public AlgoChess algoChess;
    private ContenedorGlobal contenedorGlobal;
    private Posicion posicionSeleccionada;

    public Controller(ContenedorGlobal contenedorGlobal) {
        this.contenedorGlobal = contenedorGlobal ;
    }

    public void comenzarSeleccionEquipos() {
        contenedorGlobal.set(new ComienzoJuegoView(this));
    }

    public void comenzarArmadoJuego(String nombreEquipo1, String nombreEquipo2) {
        algoChess = new AlgoChess(nombreEquipo1, nombreEquipo2);
        try {
            contenedorGlobal.set(new ContenedorComprarUnidades(this), new ContenedorTablero(this, algoChess));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setPosicionSeleccionada(Posicion posicion) {
        this.posicionSeleccionada = posicion;
    }

    public Posicion getPosicionSeleccionada() {
        return this.posicionSeleccionada;
    }

    public void agregarAdvertencia(String advertencia) {
        contenedorGlobal.agregarAdvertencia(advertencia);
    }

    public void actualizar() {
        contenedorGlobal.actualizar(algoChess);
    }
}
