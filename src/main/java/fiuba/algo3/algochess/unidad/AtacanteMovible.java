package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

public abstract class AtacanteMovible extends UnidadMovible implements Atacante{

    AtacanteMovible(Posicion posicionInicial, Equipo equipo) {
        super(posicionInicial, equipo);
    }

    public void atacar(Unidad unaUnidad, Tablero tablero) {
        Distancia distancia = this.obtenerPosicion().calcularDistancia(unaUnidad.obtenerPosicion());
        distancia.atacar(this, unaUnidad);
    }
}
