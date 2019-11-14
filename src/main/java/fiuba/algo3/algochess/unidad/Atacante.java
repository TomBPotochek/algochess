package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.tablero.Tablero;

public interface Atacante {

	void atacar(Unidad unaUnidad, Tablero tablero);

	void atacarADistanciaCorta(Unidad unaUnidad);
	void atacarADistanciaMedia(Unidad unaUnidad);
	void atacarADistanciaLarga(Unidad unaUnidad);
}
