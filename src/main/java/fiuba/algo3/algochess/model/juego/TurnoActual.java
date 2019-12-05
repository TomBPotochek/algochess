package fiuba.algo3.algochess.model.juego;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
 
public class TurnoActual extends Observable{

	private Queue<Jugador> colaJugadores;
	private List<Jugador> jugadores;
	private Tablero tablero;
	private boolean jugadoresListos;

	public TurnoActual(List<Jugador> jugadores, Tablero tablero) {
		
		this.tablero = tablero;
		this.jugadores = jugadores;
		this.jugadoresListos = false;
		this.colaJugadores = new LinkedList<Jugador>(jugadores);
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

	public void mover(Posicion pos, Direccion direccion) {

		obtenerJugador().mover(tablero, pos, direccion);
		this.turnoSiguiente();
	}

	public void atacar(Posicion pos, Posicion posEnemigo) {

		obtenerJugador().atacar(pos, posEnemigo, tablero);
		this.turnoSiguiente();
	}

	public int obtenerPuntos() {
		
		return obtenerJugador().obtenerPuntosRestantes();
	}

	private void turnoSiguiente() {

		obtenerJugador().limpiarUnidadesMuertas(tablero);
		colaJugadores.add(colaJugadores.remove());
		obtenerJugador().limpiarUnidadesMuertas(tablero);
		
		this.notifyObservers();
	}

	private Jugador obtenerJugador() {
		
		return colaJugadores.peek();
	}

	public void finalizarCompra() {

		colaJugadores.remove();
		
		if (colaJugadores.isEmpty()) {
			colaJugadores = new LinkedList<Jugador>(jugadores);
			jugadoresListos = true;
		}
		
		this.notifyObservers();
	}

	public boolean jugadoresListos() {

		return jugadoresListos;
	}
	
	public boolean finalizoPartida() {

		boolean finalizo = obtenerJugador().esPerdedor();

		if (finalizo)
			colaJugadores.remove();
		
		return finalizo;
	}
}
