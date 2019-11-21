package fiuba.algo3.algochess.modelo.unidad;

import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Posicion;

public abstract class UnidadAtacante extends Unidad implements Atacante {
    UnidadAtacante(Posicion posicionInicial, Equipo equipo) {
        super(posicionInicial, equipo);
    }

    public abstract void atacarADistanciaCorta(Unidad unaUnidad);
    public abstract void atacarADistanciaMedia(Unidad unaUnidad);
    public abstract void atacarADistanciaLarga(Unidad unaUnidad);
}
