package fiuba.algo3.algochess;

import fiuba.algo3.algochess.juego.Posicion;

public interface Direccion {
    Posicion calcularSiguientePosicion(Posicion posicion);
}
