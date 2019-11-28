package fiuba.algo3.algochess.model.juego;

import fiuba.algo3.algochess.model.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.unidad.Catapulta;
import fiuba.algo3.algochess.model.unidad.Curandero;
import fiuba.algo3.algochess.model.unidad.Jinete;
import fiuba.algo3.algochess.model.unidad.Soldado;
import fiuba.algo3.algochess.model.unidad.Unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.PUNTOS_INICIALES;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Jugador {
	
	private Equipo equipo;
	private int puntos;
	private Set<Unidad> unidades;

	public Jugador(Equipo equipo) {
		puntos = PUNTOS_INICIALES;
		unidades = new HashSet<>();
		this.equipo = equipo;
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
		Soldado soldado = new Soldado(posicion, this.equipo);
		this.guardarUnidad(tablero, soldado, posicion);
	}

	public void comprarJinete(Tablero tablero, Posicion posicion) {
		Jinete jinete = new Jinete(posicion, this.equipo);
		this.guardarUnidad(tablero, jinete, posicion);
	}

	public void comprarCurandero(Tablero tablero, Posicion posicion) {
		Curandero curandero = new Curandero(posicion, this.equipo);
		this.guardarUnidad(tablero, curandero, posicion);
	}

	public void comprarCatapulta(Tablero tablero, Posicion posicion) {
		Catapulta catapulta = new Catapulta(posicion, this.equipo);
		this.guardarUnidad(tablero, catapulta, posicion);
	}
	
	public void limpiarUnidadesMuertas() {

		Iterator<Unidad> iter = unidades.iterator();
		Unidad unidad;

		while(iter.hasNext()) {
			unidad = (Unidad) iter.next();
			if(unidad.estaMuerto()) {
				iter.remove();
			}
		}
	 }
	
	public boolean esPerdedor() {

		return unidades.isEmpty();
	}

    public String obtenerNombreDeEquipo() {
		return equipo.obtenerNombre();
    }
}
