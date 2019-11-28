package fiuba.algo3.algochess.model.juego;

import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

import java.util.LinkedList;
import java.util.Queue;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class AlgoChess {

	private Tablero tablero;
	Queue<Jugador> jugadores;

	public AlgoChess(String nombreEquipo1, String nombreEquipo2) {

		Equipo equipo1 = new Equipo(nombreEquipo1);
		Equipo equipo2 = new Equipo(nombreEquipo2);
		jugadores = new LinkedList<Jugador>();

		jugadores.add(new Jugador(equipo1));
		jugadores.add(new Jugador(equipo2));
		this.tablero = new Tablero(TAMANIO_TABLERO, equipo1, equipo2);
	}

	public void comprar(String nombreUnidad, Posicion posicion) throws Exception {
		switch (nombreUnidad) {
			case "Soldado":
				jugadores.peek().comprarSoldado(tablero, posicion);
				break;
			case "Jinete":
				jugadores.peek().comprarJinete(tablero, posicion);
				break;
			case "Catapulta":
				jugadores.peek().comprarCatapulta(tablero, posicion);
				break;
			case "Curandero":
				jugadores.peek().comprarCurandero(tablero, posicion);
				break;
		}

		this.turnoSiguiente();
	}

	public String obtenerEquipoTurnoActual() {
		return jugadores.peek().obtenerNombreDeEquipo();
	}
	
	public int obtenerPuntosTurnoActual() {
		
		return jugadores.peek().obtenerPuntosRestantes();
	}

	private void turnoSiguiente() {
		jugadores.add(jugadores.remove());
	}
}
