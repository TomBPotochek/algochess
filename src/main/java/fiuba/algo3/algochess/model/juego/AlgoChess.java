package fiuba.algo3.algochess.model.juego;

import fiuba.algo3.algochess.model.tablero.Tablero;
import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO; 

public class AlgoChess {

	private Tablero tablero;
	private Jugador jugador1;
	private Jugador jugador2;
	
	public AlgoChess(String nombreEquipo1, String nombreEquipo2) {
		
		Equipo equipo1 = new Equipo(nombreEquipo1);
		Equipo equipo2 = new Equipo(nombreEquipo2);

		this.jugador1 = new Jugador(equipo1);
		this.jugador2 = new Jugador(equipo2);
		this.tablero = new Tablero(TAMANIO_TABLERO, equipo1, equipo2);
	}
}
