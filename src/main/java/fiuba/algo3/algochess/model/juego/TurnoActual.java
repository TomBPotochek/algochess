package fiuba.algo3.algochess.model.juego;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
 
public class TurnoActual extends Observable{

	private Queue<Jugador> jugadores;
	private Tablero tablero;

	public TurnoActual(List<Jugador> jugadores, Tablero tablero) {
		
		this.tablero = tablero;
		this.jugadores = new LinkedList<Jugador>(jugadores);
	}

	public Equipo getEquipo() {
		
		return obtenerJugador().getEquipo();
	}

	public void comprar(String nombreUnidad, Posicion posicion) throws Exception {
		switch (nombreUnidad) {
			case "Soldado":
				obtenerJugador().comprarSoldado(tablero, posicion);
				break;
			case "Jinete":
				obtenerJugador().comprarJinete(tablero, posicion);
				break;
			case "Catapulta":
				obtenerJugador().comprarCatapulta(tablero, posicion);
				break;
			case "Curandero":
				obtenerJugador().comprarCurandero(tablero, posicion);
				break;
		}

		this.turnoSiguiente();
	}

	public int obtenerPuntos() {
		
		return obtenerJugador().obtenerPuntosRestantes();
	}

	private void turnoSiguiente() {

		jugadores.add(jugadores.remove());		
		
		this.notifyObservers();
	}

	private Jugador obtenerJugador() {
		
		return jugadores.peek();
	}

}
