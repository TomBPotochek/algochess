package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public abstract class UnidadAtacante extends Unidad implements Atacante {
    UnidadAtacante(Posicion posicionInicial, Equipo equipo) {
        super(posicionInicial, equipo);
    }

    public abstract void atacarADistanciaCorta(Unidad unaUnidad);
    public abstract void atacarADistanciaMedia(Unidad unaUnidad);
    public abstract void atacarADistanciaLarga(Unidad unaUnidad);
}
