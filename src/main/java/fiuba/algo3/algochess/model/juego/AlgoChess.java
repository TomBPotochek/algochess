package fiuba.algo3.algochess.model.juego;

import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

public class AlgoChess {

	private Tablero tablero;
	private TurnoActual turnoActual;

	public AlgoChess(String nombreEquipo1, String nombreEquipo2) {

		Equipo equipo1 = new Equipo(nombreEquipo1);
		Equipo equipo2 = new Equipo(nombreEquipo2);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador(equipo1));
		jugadores.add(new Jugador(equipo2));

		this.tablero = new Tablero(TAMANIO_TABLERO, equipo1, equipo2);
		this.turnoActual = new TurnoActual(jugadores, tablero);
	}


	public Tablero obtenerTablero() {
		return tablero;
	}

	public TurnoActual getTurnoActual() {
		
		return turnoActual;
	}
}
