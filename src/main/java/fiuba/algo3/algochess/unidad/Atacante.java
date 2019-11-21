package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.UnidadDestruidaException;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

public interface Atacante {

	default void atacar(Unidad unaUnidad, Tablero tablero) {
		Distancia distancia = this.obtenerPosicion().calcularDistancia(unaUnidad.obtenerPosicion());
		try {
			distancia.atacar(this, unaUnidad);
		} catch (UnidadDestruidaException e) {
			tablero.quitarUnidad(unaUnidad);
		}
	}

	Posicion obtenerPosicion();
	void atacarADistanciaCorta(Unidad unaUnidad);
	void atacarADistanciaMedia(Unidad unaUnidad);
	void atacarADistanciaLarga(Unidad unaUnidad);
}
