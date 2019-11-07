package fiuba.algo3.algochess;

import java.util.HashSet;
import java.util.Set;

public class Jugador {
	
	private int puntos;
	private Set<Unidad> unidades;

	public Jugador() {
		puntos = 20;
		unidades = new HashSet<>();
	}

	private boolean tienePuntosSuficientes(int costo) {
		return puntos >= costo;
	}

	public void guardarUnidad(Tablero tablero, Unidad unidad, Posicion posicion) {
		if(!this.tienePuntosSuficientes(unidad.obtenerCosto())) throw new PuntosInsuficientesException();
		puntos -= unidad.obtenerCosto();
		unidades.add(unidad);
		tablero.colocarUnidad(unidad, posicion);
	}

	public void comprarSoldado(Tablero tablero, Posicion posicion) {
		Soldado soldado = new Soldado(posicion);
		this.guardarUnidad(tablero, soldado, posicion);
	}

	public void comprarJinete(Tablero tablero, Posicion posicion) {
		Jinete jinete = new Jinete(posicion);
		this.guardarUnidad(tablero, jinete, posicion);
	}

	public void comprarCurandero(Tablero tablero, Posicion posicion) {
		Curandero curandero = new Curandero(posicion);
		this.guardarUnidad(tablero, curandero, posicion);
	}

	public void comprarCatapulta(Tablero tablero, Posicion posicion) {
		Catapulta catapulta = new Catapulta(posicion);
		this.guardarUnidad(tablero, catapulta, posicion);
	}



}
