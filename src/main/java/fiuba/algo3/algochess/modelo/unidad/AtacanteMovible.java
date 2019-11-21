package fiuba.algo3.algochess.modelo.unidad;

import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Posicion;

abstract class AtacanteMovible extends UnidadMovible implements Atacante{

    AtacanteMovible(Posicion posicionInicial, Equipo equipo) {
        super(posicionInicial, equipo);
    }
}
