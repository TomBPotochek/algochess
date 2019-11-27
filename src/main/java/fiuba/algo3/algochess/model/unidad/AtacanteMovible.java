package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

abstract class AtacanteMovible extends UnidadMovible implements Atacante{

    AtacanteMovible(Posicion posicionInicial, Equipo equipo) {
        super(posicionInicial, equipo);
    }
}
