package fiuba.algo3.algochess.model.juego;

import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

import java.util.ArrayList;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class AlgoChess {

	private Tablero tablero;
	ArrayList<Jugador> jugadores;
	int turno;

	public AlgoChess(String nombreEquipo1, String nombreEquipo2) {

		Equipo equipo1 = new Equipo(nombreEquipo1);
		Equipo equipo2 = new Equipo(nombreEquipo2);
		jugadores = new ArrayList<>();

		jugadores.add(new Jugador(equipo1));
		jugadores.add(new Jugador(equipo2));
		this.tablero = new Tablero(TAMANIO_TABLERO, equipo1, equipo2);
	}

	public void comprar(String nombreUnidad, Posicion posicion) throws Exception {
		switch (nombreUnidad) {
			case "Soldado":
				this.comprarSoldado(jugadores.get(turno), posicion);
				break;
			case "Jinete":
				this.comprarJinete(jugadores.get(turno), posicion);
				break;
			case "Catapulta":
				this.comprarCatapulta(jugadores.get(turno), posicion);
				break;
			case "Curandero":
				this.comprarCurandero(jugadores.get(turno), posicion);
				break;
		}
		turno = 1 - turno;
	}

	public String obtenerTurno() {
		return jugadores.get(turno).obtenerNombreDeEquipo();
	}

	public void comprarSoldado(Jugador jugador, Posicion posicion) {
		jugador.comprarSoldado(tablero, posicion);
	}
	public void comprarJinete(Jugador jugador, Posicion posicion) {
		jugador.comprarJinete(tablero, posicion);
	}
	public void comprarCatapulta(Jugador jugador, Posicion posicion) { jugador.comprarCatapulta(tablero, posicion); }
	public void comprarCurandero(Jugador jugador, Posicion posicion) { jugador.comprarCurandero(tablero, posicion); }

}
