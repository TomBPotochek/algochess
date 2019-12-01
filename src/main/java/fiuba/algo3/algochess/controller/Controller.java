package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.*;

public class Controller {

    public AlgoChess algoChess;
    private ContenedorGlobal contenedorGlobal;
    private SeleccionEquiposController escenaInicial;
    private Posicion posicionSeleccionada;

    public Controller(ContenedorGlobal contenedorGlobal) {
        this.contenedorGlobal = contenedorGlobal ;
    }

    public void escenaInicial() {
    	
    	this.nuevaEscena(escenaInicial);
    }
    private void nuevaEscena(SeleccionEquiposController escenaInicial2) {
		// TODO Auto-generated method stub
		
	}


    public void comenzarJuegoPrincipal() {
//            contenedorGlobal.set(new ContenedorControlesJuego(this), new ContenedorTablero(this, algoChess));
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
